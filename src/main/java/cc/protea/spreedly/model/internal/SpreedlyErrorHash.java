package cc.protea.spreedly.model.internal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hash")
public class SpreedlyErrorHash {

	public String status;
	public String error;
}
