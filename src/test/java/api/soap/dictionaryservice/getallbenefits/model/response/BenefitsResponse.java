package api.soap.dictionaryservice.getallbenefits.model.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Benefits")
@XmlAccessorType(XmlAccessType.FIELD)

public class BenefitsResponse {
	
	@XmlElement(name = "Element")
	private List<ElementResponse> ElementList;
	
	@XmlElement(name = "Element")
	public List<ElementResponse> getElementList() {
		return ElementList;
	}
}
