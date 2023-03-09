package cc.protea.spreedly.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "gateway_specific_fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpreedlyGatewaySpecificFields {

    @XmlElement(name = "borgun") public SpreedlyBorgunSpecificFields spreedlyBorgunSpecificFields;

    public SpreedlyBorgunSpecificFields getSpreedlyBorgunSpecificFields() {
        return spreedlyBorgunSpecificFields;
    }

    public void setSpreedlyBorgunSpecificFields(SpreedlyBorgunSpecificFields spreedlyBorgunSpecificFields) {
        this.spreedlyBorgunSpecificFields = spreedlyBorgunSpecificFields;
    }
}
