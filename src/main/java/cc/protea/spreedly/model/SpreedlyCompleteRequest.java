
package cc.protea.spreedly.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "entry"
})
@XmlRootElement(name = "context")
public class SpreedlyCompleteRequest {

    protected List<SpreedlyCompleteRequest.Entry> entry;


    public List<SpreedlyCompleteRequest.Entry> getEntry() {
        if (entry == null) {
            entry = new ArrayList<SpreedlyCompleteRequest.Entry>();
        }
        return this.entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "key",
            "value"
    })
    public static class Entry {

        @XmlElement(required = true)
        protected String key;
        @XmlElement(required = true)
        protected Object value;

        public String getKey() {
            return key;
        }

        public void setKey(String value) {
            this.key = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

    }

}
