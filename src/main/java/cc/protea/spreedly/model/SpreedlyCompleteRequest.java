
package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;


@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyCompleteRequest
{
	public Map<String, Object> context;

	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}
}
