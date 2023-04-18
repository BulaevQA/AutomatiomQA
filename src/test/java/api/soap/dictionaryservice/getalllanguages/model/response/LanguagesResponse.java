package api.soap.dictionaryservice.getalllanguages.model.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Languages")
@XmlAccessorType(XmlAccessType.FIELD)

public class LanguagesResponse {
	
	@XmlElement(name = "Element")
	private List<ElementResponse> ElementList;
	
	@XmlElement(name = "Element")
	public List<ElementResponse> getElementList() {
		return ElementList;
	}
}
