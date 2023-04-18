package api.soap.dictionaryservice.getalllanguages.model.response;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement(name = "Element")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElementResponse {
	
	@XmlElement(name = "Id")
	private String id;
	
	@XmlElement(name = "Name")
	private String name;
	
}
