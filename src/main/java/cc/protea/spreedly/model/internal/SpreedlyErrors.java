package cc.protea.spreedly.model.internal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "errors")
public class SpreedlyErrors {
    @XmlElement(name = "error") public List<SpreedlyError> errors = new ArrayList<SpreedlyError>();
}

