package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyApiURLs {

	@XmlElement(name = "callback_conversations") public String callbackConversations;

	public String getCallbackConversations() {
		return callbackConversations;
	}

	public SpreedlyApiURLs setCallbackConversations(final String callbackConversations) {
		this.callbackConversations = callbackConversations;
		return this;
	}

}
