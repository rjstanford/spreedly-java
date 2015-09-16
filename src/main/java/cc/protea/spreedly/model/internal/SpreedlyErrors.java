package cc.protea.spreedly.model.internal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "errors")
static class SpreedlyErrors {
    @XmlElement(name = "error") public List<SpreedlyError> errors = new ArrayList<SpreedlyError>();
}

static class SpreedlyError {
    @XmlValue public String error;
    @XmlAttribute(name = "key") public String key;
    @XmlAttribute(name = "attribute") public String attribute;
}

