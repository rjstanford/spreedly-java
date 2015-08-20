package cc.protea.spreedly.model.internal;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

public class SpreedlyInternalKeyValuePairAdapter extends XmlAdapter<Object, SpreedlyInternalKeyValuePair> {

	private DocumentBuilder documentBuilder;
	private JAXBContext jaxbContext;

	public SpreedlyInternalKeyValuePairAdapter() {
	}

	public SpreedlyInternalKeyValuePairAdapter(JAXBContext jaxbContext) {
		this();
		this.jaxbContext = jaxbContext;
	}

	private DocumentBuilder getDocumentBuilder() throws Exception {
		// Lazy load the DocumentBuilder as it is not used for unmarshalling.
		if (null == documentBuilder) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			documentBuilder = dbf.newDocumentBuilder();
		}
		return documentBuilder;
	}

	private JAXBContext getJAXBContext(Class<?> type) throws Exception {
		if (null == jaxbContext) {
			// A JAXBContext was not set, so create a new one based  on the type.
			return JAXBContext.newInstance(type);
		}
		return jaxbContext;
	}

	@Override
	public SpreedlyInternalKeyValuePair unmarshal(Object object) throws Exception {
		if (null == object) {
			return null;
		}

		Element element = (Element) object;

		// 2. Unmarshal the element based on the value's type.
		DOMSource source = new DOMSource(element);
		Unmarshaller unmarshaller = getJAXBContext(String.class).createUnmarshaller();
		JAXBElement jaxbElement = unmarshaller.unmarshal(source, String.class);

		// 3. Build the instance of Parameter
		SpreedlyInternalKeyValuePair keyValuePair = new SpreedlyInternalKeyValuePair();
		keyValuePair.key = element.getLocalName();
		keyValuePair.value = jaxbElement.getValue() == null ? null : jaxbElement.getValue().toString();
		return keyValuePair;
	}

	@Override
	public Object marshal(SpreedlyInternalKeyValuePair keyValuePair) throws Exception {
		if (null == keyValuePair) {
			return null;
		}

		// 1. Build the JAXBElement to wrap the instance of Parameter.
		QName rootElement = new QName(keyValuePair.key);
		JAXBElement jaxbElement = new JAXBElement(rootElement, String.class, keyValuePair.value);

		// 2.  Marshal the JAXBElement to a DOM element.
		Document document = getDocumentBuilder().newDocument();
		Marshaller marshaller = getJAXBContext(String.class).createMarshaller();
//		marshaller.setAdapter(SpreedlyInternalKeyValuePairAdapter);
		marshaller.marshal(jaxbElement, document);

		Element element = document.getDocumentElement();


//		// 3.  Set the type attribute based on the value's type.
//		element.setAttribute("type", type.getName());
		return element;
	}
}
