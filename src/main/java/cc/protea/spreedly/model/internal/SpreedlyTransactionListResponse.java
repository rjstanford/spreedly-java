package cc.protea.spreedly.model.internal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cc.protea.spreedly.model.SpreedlyTransactionResponse;

@XmlRootElement(name = "transactions")
public class SpreedlyTransactionListResponse {

	@XmlElement(name = "transaction")
	public List<SpreedlyTransactionResponse> transactions = new ArrayList<SpreedlyTransactionResponse>();

}