package cc.protea.spreedly;

import java.util.ArrayList;
import java.util.List;

import cc.protea.spreedly.model.SpreedlyCreditCard;
import cc.protea.spreedly.model.SpreedlyGatewayAccount;
import cc.protea.spreedly.model.SpreedlyGatewayProvider;
import cc.protea.spreedly.model.SpreedlyPaymentMethod;
import cc.protea.spreedly.model.SpreedlyTransactionRequest;
import cc.protea.spreedly.model.SpreedlyTransactionResponse;
import cc.protea.spreedly.model.internal.SpreedlyGatewayAccountResponse;
import cc.protea.spreedly.model.internal.SpreedlyGatewayAccountUpdate;
import cc.protea.spreedly.model.internal.SpreedlyGatewayProviderResponse;
import cc.protea.spreedly.model.internal.SpreedlyPaymentMethodCreateRequest;
import cc.protea.spreedly.model.internal.SpreedlyPaymentMethodListResponse;
import cc.protea.spreedly.model.internal.SpreedlyPaymentMethodUpdate;
import cc.protea.spreedly.model.internal.SpreedlyTransactionListResponse;

public class Spreedly {

	private final SpreedlyUtil util;

	public Spreedly(final String environmentKey, final String apiSecret) {
		util = new SpreedlyUtil(environmentKey, apiSecret);
	}

	// Gateway Providers

	/**
	 * Retrieves a list of the currently supported payment gateway providers, including the necessary credentials to
	 * add that type of gateway to an environment.
	 */
	public List<SpreedlyGatewayProvider> listGatewayProviders() {
		SpreedlyGatewayProviderResponse response = util.options("https://core.spreedly.com/v1/gateways.xml", SpreedlyGatewayProviderResponse.class);
		return response.gateways;
	}

	/**
	 * Retrieves information about a single gateway provider.
	 */
	public SpreedlyGatewayProvider getGatewayProvider(final String name) {
		for (SpreedlyGatewayProvider provider : listGatewayProviders()) {
			if (provider != null && provider.name != null && provider.name.equals(name)) {
				return provider;
			}
		}
		return null;
	}

	// Gateway Accounts

	/**
	 * Retrieve a list of all gateway accounts based on the environment supplied for authentication.
	 */
	public List<SpreedlyGatewayAccount> listGatewayAccounts() {
		List<SpreedlyGatewayAccount> list = new ArrayList<SpreedlyGatewayAccount>();
		String lastToken = null;
		do {
			List<SpreedlyGatewayAccount> page = listGatewayAccounts(lastToken);
			if (page.isEmpty()) {
				lastToken = null;
			} else {
				lastToken = page.get(list.size() - 1).token;
				list.addAll(page);
			}
		} while (lastToken != null);
		return list;
	}

	/**
	 * Retrieve a list of all gateway accounts based on the environment supplied for authentication. This is a paginated list,
	 * for the next page pass in the optional sinceToken parameter
	 * @param sinceToken the last token received in the previous list
	 */
	public List<SpreedlyGatewayAccount> listGatewayAccounts(final String sinceToken) {
		String url = "https://core.spreedly.com/v1/gateways.xml" + sinceToken == null ? "" : ("?since_token=" + sinceToken.trim());
		SpreedlyGatewayAccountResponse response = util.get(url, SpreedlyGatewayAccountResponse.class);
		return response.gateways;
	}

	/**
	 * Retrieve a single gateway account.
	 */
	public SpreedlyGatewayAccount getGatewayAccount(final String token) {
		return util.get("https://core.spreedly.com/v1/gateways/" + token + ".xml", SpreedlyGatewayAccount.class);
	}

	/**
	 * This action allows you to change your credentials for a gateway.
	 */
	public SpreedlyGatewayAccount update(final SpreedlyGatewayAccount account) {
		SpreedlyGatewayAccountUpdate simple = new SpreedlyGatewayAccountUpdate(account);
		return util.put("https://core.spreedly.com/v1/gateways/" + account.token + ".xml", simple, SpreedlyGatewayAccount.class);
	}

	/**
	 * Adds a gateway account to the authenticated environment. One gateway account is required for each set of merchant account
	 * credentials. Spreedly stores and protects the credentials to be used to authenticate with gateway accounts for
	 * transaction processing.
	 */
	public SpreedlyGatewayAccount create(final SpreedlyGatewayAccount account) {
		SpreedlyGatewayAccountUpdate simple = new SpreedlyGatewayAccountUpdate(account);
		return util.post("https://core.spreedly.com/v1/gateways.xml", simple, SpreedlyGatewayAccount.class);
	}

	/**
	 * Gateway accounts can't be deleted (since they're permanently associated with any transactions run against them), but the sensitive credential
	 * information in them can be redacted so that they're inactive.
	 */
	public SpreedlyGatewayAccount redact(final SpreedlyGatewayAccount account) {
		return util.put("https://core.spreedly.com/v1/gateways/" + account.token + "/redact.xml", null, SpreedlyGatewayAccount.class);
	}

	/**
	 * If you create a gateway account using a normal authenticated add gateway api call, the gateway is automatically retained. If a gateway account
	 * is created using an unauthenticated channel via the Consumer API, it is kept in a cached state until it is retained or
	 * automatically redacted. This allows your customers to create gateway accounts using their own credentials, but until you retain
	 * it, it cannot be used and you will not be billed for it.
	 */
	public SpreedlyGatewayAccount retain(final SpreedlyGatewayAccount account) {
		return util.put("https://core.spreedly.com/v1/gateways/" + account.token + "/retain.xml", null, SpreedlyGatewayAccount.class);
	}

	// Transactions

	private SpreedlyTransactionResponse gatewayPost(final SpreedlyTransactionRequest request, final String url) {
		return util.post("https://core.spreedly.com/v1/gateways/" + request.gatewayAccountToken + "/" + url, request, SpreedlyTransactionResponse.class);
	}

	private SpreedlyTransactionResponse transactionPost(final SpreedlyTransactionRequest request, final String url) {
		return util.post("https://core.spreedly.com/v1/transactions/" + request.referenceTransactionToken + "/" + url, request, SpreedlyTransactionResponse.class);
	}

	/**
	 * An authorize transaction will present the gateway with the payment method details along with an amount
	 * and currency code. Depending on the criteria chosen by the gateway, it will decide if the the funds
	 * will be allowed to be transferred. It does not take funds at that point, a capture transaction is
	 * required to move the funds.
	 */
	public SpreedlyTransactionResponse authorize(final SpreedlyTransactionRequest request) {
		return gatewayPost(request, "authorize.xml");
	}

	/**
	 * The general_credit action can add funds to a credit card. This is different than credit which refunds
	 * money up to the amount that had been taken during a previous transaction. The general_credit action does
	 * not require a reference transaction. Support for this capability depends on the gateway.
	 */
	public SpreedlyTransactionResponse generalCredit(final SpreedlyTransactionRequest request) {
		return gatewayPost(request, "general_credit.xml");
	}

	/**
	 * A purchase call immediately takes funds from the payment method (assuming the transaction succeeds).
	 */
	public SpreedlyTransactionResponse purchase(final SpreedlyTransactionRequest request) {
		if (request.referenceTransactionToken != null) {
			return purchase(request.referenceTransactionToken, request.amountInCents, request.currencyCode);
		}
		return gatewayPost(request, "purchase.xml");
	}

	/**
	 * The store transaction takes a Spreedly payment method and returns a ThirdPartyToken payment method.
	 * Since tokens are gateway specific, ThirdPartyToken payment methods are locked to the gateway type
	 * they were created against, and you'll receive an error if you try to use them with the wrong gateway.
	 */
	public SpreedlyTransactionResponse store(final SpreedlyTransactionRequest request) {
		return gatewayPost(request, "store.xml");
	}

	/**
	 * Retrieves a paginated list of all transactions for a gateway.
	 * @param sinceToken the last token received in the previous list
	 * @param desc if true, reverse the order to retrieve the most recent first
	 */
	public List<SpreedlyTransactionResponse> listGatewayAccountTransactions(final String gatewayAccountToken, final String sinceToken, final boolean desc) {
		String url = "https://core.spreedly.com/v1/gateways/" + gatewayAccountToken + "/transactions.xml?order=" +
				(desc ? "desc" : "asc") +
				(sinceToken == null ? "" : "&since_token = " + sinceToken.trim());
		SpreedlyTransactionListResponse r = util.get(url, SpreedlyTransactionListResponse.class);
		return r.transactions;
	}

	/**
	 * Ask a gateway if a payment method is in good standing. Use the retain_on_success request parameter to automatically
	 * retain the card if it's successfully verified.
	 */
	public SpreedlyTransactionResponse verify(final SpreedlyTransactionRequest request) {
		return gatewayPost(request, "verify.xml");
	}

	/**
	 * A capture will take the funds previously reserved via an authorization.
	 */
	public SpreedlyTransactionResponse capture(final SpreedlyTransactionRequest request) {
		return transactionPost(request, "capture.xml");
	}

	/**
	 * A credit is like a void, except it actually reverses a charge instead of just canceling a charge that hasn't
	 * yet been made. It can also be called a refund.
	 */
	public SpreedlyTransactionResponse credit(final SpreedlyTransactionRequest request) {
		return transactionPost(request, "credit.xml");
	}

	/**
	 * Retrieves a paginated list of all transactions.
	 * @param sinceToken the last token received in the previous list
	 * @param desc if true, reverse the order to retrieve the most recent first
	 */
	public List<SpreedlyTransactionResponse> listTransactions(final String sinceToken, final boolean desc) {
		String url = "https://core.spreedly.com/v1/transactions.xml?order=" +
				(desc ? "desc" : "asc") +
				(sinceToken == null ? "" : "&since_token = " + sinceToken.trim());
		SpreedlyTransactionListResponse r = util.get(url, SpreedlyTransactionListResponse.class);
		return r.transactions;
	}

	/**
	 * Execute a reference purchase using the payment method utilized in a previous transaction.
	 */
	public SpreedlyTransactionResponse purchase(final String referenceTransactionToken, final Integer amountInCents, final String currencyCode) {
		final SpreedlyTransactionRequest request = new SpreedlyTransactionRequest();
		request.referenceTransactionToken = referenceTransactionToken;
		request.amountInCents = amountInCents;
		request.currencyCode = currencyCode;
		return transactionPost(request, "purchase.xml");
	}

	/**
	 * Retrieve a single transaction.
	 */
	public SpreedlyTransactionResponse getTransaction(final String token) {
		return util.get("https://core.spreedly.com/v1/transactions/" + token + ".xml", SpreedlyTransactionResponse.class);
	}

	/**
	 * Retrieve the transcript for a single transaction.
	 */
	public String getTranscript(final String token) {
		return util.get("https://core.spreedly.com/v1/transactions/" + token + "/transcript", String.class);
	}

	/**
	 * Void is used to cancel out authorizations and, with some gateways, to cancel actual payment transactions within the
	 * first 24 hours (credits are used after that).
	 */
	public SpreedlyTransactionResponse voidTransaction(final SpreedlyTransactionRequest request) {
		return transactionPost(request, "void.xml");
	}

	// Payment Methods

	/**
	 * This way of adding a payment method requires being authenticated. Therefore you will only add payment methods in this manner
	 * from your own servers because you will not want to reveal you access secret to your customers. It is important to know that
	 * transmitting sensitive data through your servers significantly increases your PCI compliance requirements.
	 */
	public SpreedlyTransactionResponse create(final SpreedlyCreditCard creditCard) {
		SpreedlyPaymentMethodCreateRequest request = new SpreedlyPaymentMethodCreateRequest();
		request.creditCard = creditCard;
		request.data = creditCard.data;
		request.email = creditCard.email;
		return util.post("https://core.spreedly.com/v1/payment_methods.xml", request, SpreedlyTransactionResponse.class);
	}

	/**
	 * Retrieve a list of all payment methods based on the environment supplied for authentication. This is a paginated list,
	 * for the next page pass in the optional sinceToken parameter
	 * @param sinceToken the last token received in the previous list
	 */
	public List<SpreedlyPaymentMethod> listPaymentMethods(final String sinceToken, final boolean desc) {
		String url = "https://core.spreedly.com/v1/payment_methods.xml?order=" +
				(desc ? "desc" : "asc") +
				(sinceToken == null ? "" : "&since_token = " + sinceToken.trim());
		SpreedlyPaymentMethodListResponse r = util.get(url, SpreedlyPaymentMethodListResponse.class);
		return r.paymentMethods;
	}

	/**
	 * There are some parts of a payment method that Spreedly cannot retain, e.g. the CVV of a credit card. In some cases,
	 * it may be advantageous to re-supply that information to be used for a transaction that's about to be run. For these
	 * cases Spreedly provides the ability to re-cache sensitive data for an existing payment method so that you do not
	 * have to recollect the whole payment method. Only sensitive fields can be re-cached (currently the verificationValue
	 * for credit cards), and any already vaulted data will be ignored.
	 */
	public SpreedlyTransactionResponse recache(final String paymentMethodToken, final String verificationValue) {
		SpreedlyPaymentMethod request = new SpreedlyPaymentMethod();
		request.verificationValue = verificationValue;
		request.token = paymentMethodToken;
		return recache(request);
	}

	/**
	 * There are some parts of a payment method that Spreedly cannot retain, e.g. the CVV of a credit card. In some cases,
	 * it may be advantageous to re-supply that information to be used for a transaction that's about to be run. For these
	 * cases Spreedly provides the ability to re-cache sensitive data for an existing payment method so that you do not
	 * have to recollect the whole payment method. Only sensitive fields can be re-cached (currently the verificationValue
	 * for credit cards), and any already vaulted data will be ignored.
	 */
	public SpreedlyTransactionResponse recache(final SpreedlyPaymentMethod paymentMethod) {
		return util.post("https://core.spreedly.com/v1/payment_methods/" + paymentMethod.token + "/recache.xml", paymentMethod, SpreedlyTransactionResponse.class);
	}

	/**
	 * <p>
	 * Redacting a payment method does not delete it. Its transaction history is maintained as your permanent record. However,
	 * all sensitive information (e.g. PAN, CVV) is removed immediately and permanently. A redacted payment method can no longer
	 * be used for transactions since the account information will have been disposed of. Spreedly does not charge storage fees
	 * on redacted payment methods.
	 * </p><p>
	 * Most of the time, simply redacting a payment method will suffice because payment methods are for the most part only stored in
	 * Spreedly. There are times though when a payment method is stored on the gateway and you'd like to notify the gateway that it
	 * can no longer be used. In a case like this, if you just did a redact, then it's true that you'd no longer be able to use that
	 * payment method with Spreedly, but it wouldn't stop you from using it directly through your gateway interface.
	 * </p>
	 */
	public SpreedlyTransactionResponse redact(final String paymentMethodToken, final String gatewayAccountToken) {
		SpreedlyPaymentMethodUpdate request = null;
		if (gatewayAccountToken != null) {
			request = new SpreedlyPaymentMethodUpdate();
			request.gatewayAccountToken = gatewayAccountToken;
		}
		return util.put("https://core.spreedly.com/v1/payment_methods/" + paymentMethodToken + "/redact.xml", request, SpreedlyTransactionResponse.class);
	}

	/**
	 * Redacting a payment method does not delete it. Its transaction history is maintained as your permanent record. However,
	 * all sensitive information (e.g. PAN, CVV) is removed immediately and permanently. A redacted payment method can no longer
	 * be used for transactions since the account information will have been disposed of. Spreedly does not charge storage fees
	 * on redacted payment methods.
	 */
	public SpreedlyTransactionResponse redact(final String paymentMethodToken) {
		return redact(paymentMethodToken, null);
	}

	/**
	 * <p>
	 * Unless specifically instructed to do otherwise, Core purges all of the sensitive data of payment methods it has seen every
	 * few minutes. To keep the sensitive information of a payment method around for later, simply instruct Core to retain it.
	 * </p><p>
	 * Passing the retain_on_success parameter to the purchase, verify, or authorize call can save you from having to make another
	 * API call to do the retain. If the purchase, verify, or authorize succeeds, then the payment method is retained for you.
	 * </p>
	 */
	public SpreedlyTransactionResponse retain(final String paymentMethodToken) {
		return util.put("https://core.spreedly.com/v1/payment_methods/" + paymentMethodToken + "/retain.xml", null, SpreedlyTransactionResponse.class);
	}

	/**
	 * Retrieve a single payment method by supplying the payment method key.
	 */
	public SpreedlyPaymentMethod getPaymentMethod(final String paymentMethodToken) {
		return util.get("https://core.spreedly.com/v1/payment_methods/" + paymentMethodToken + "/retain.xml", SpreedlyPaymentMethod.class);
	}

	/**
	 * Retrieves a paginated list of all transactions for a gateway.
	 * @param sinceToken the last token received in the previous list
	 * @param desc if true, reverse the order to retrieve the most recent first
	 */
	public List<SpreedlyTransactionResponse> listPaymentMethodTransactions(final String paymentMethodToken, final String sinceToken, final boolean desc) {
		String url = "https://core.spreedly.com/v1/payment_methods/" + paymentMethodToken + "/transactions.xml?order=" +
				(desc ? "desc" : "asc") +
				(sinceToken == null ? "" : "&since_token = " + sinceToken.trim());
		SpreedlyTransactionListResponse r = util.get(url, SpreedlyTransactionListResponse.class);
		return r.transactions;
	}

	/**
	 * <p>
	 * There are two ways to update a payment method. If you'd like to change the sensitive information like the credit card number
	 * or the verification value, you'll want to just create and retain a new payment method using the usual transparent redirect approach,
	 * redact the old payment method, and hold onto the token for the new payment method. This is the primary mechanism to use when you want
	 * to give your customer the ability to update their card information. This process is described in detail as part of the Quickstart.
	 * </p><p>
	 * There may be times, though, when you'd like to update a payment method without customer interaction. In this case, we provide an API
	 * call to do so. It's important to note that updating the card number and verification_value is prohibited using this API call.
	 * </p>
	 */
	public SpreedlyTransactionResponse update(final SpreedlyPaymentMethod paymentMethod) {
		return util.put("https://core.spreedly.com/v1/payment_methods/" + paymentMethod.token + ".xml", paymentMethod, SpreedlyTransactionResponse.class);
	}

}
