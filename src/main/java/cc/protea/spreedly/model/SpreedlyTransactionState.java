package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum SpreedlyTransactionState {

	/**
	 * The transaction has succeeded and funds have been received.
	 */
	@XmlEnumValue("succeeded") SUCCEEDED,
	/**
	 * The transaction has been accepted. Funds have not yet been received.
	 */
	@XmlEnumValue("processing") PROCESSING,
	/**
	 *  The transaction needs further processing which typically involves redirecting the
	 *  customer to a redirect_url to allow them to specify a payment method.
	 */
	@XmlEnumValue("pending") PENDING,
	/**
	 * The transaction failed. This could be caused by a number of things such as the payment method
	 * not being valid, the payment method being redacted, etc.
	 */
	@XmlEnumValue("failed") FAILED,
	/**
	 * The transaction failed because the attempt to setup the transaction on the offsite gateway failed.
	 */
	@XmlEnumValue("gateway_setup_failed") GATEWAY_SETUP_FAILED,
	/**
	 * The transaction failed because the gateway declined the charge for some reason.
	 */
	@XmlEnumValue("gateway_processing_failed") GATEWAY_PROCESSING_FAILED,
	/**
	 * We had difficulty communicating with the service and we're unsure what the result
	 * of the operation was. (timeouts, connection errors, etc).
	 */
	@XmlEnumValue("gateway_processing_result_unknown") GATEWAY_PROCESSING_RESULT_UNKNOWN

}
