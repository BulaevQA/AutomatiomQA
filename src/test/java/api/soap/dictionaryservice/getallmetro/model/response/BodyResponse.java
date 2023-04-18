package api.soap.dictionaryservice.getallmetro.model.response;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter

@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class BodyResponse {
	
	
	@XmlElement(name = "getAllMetroResponse", namespace = "com.bft.rusjob.integration.ks")
	private GetAllMetroResponseResponse getAllMetroResponseResponse;
	
}
