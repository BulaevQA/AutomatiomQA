package api.soap.dictionaryservice.getallmetro.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement(name = "Metro")
@XmlAccessorType(XmlAccessType.FIELD)
public class MetroResponse {
	
	@XmlElement(name = "Id")
	private String id;
	
	@XmlElement(name = "Name")
	private String name;
	
	@XmlElement(name = "CityAddressCode")
	private String cityAddressCode;
	
	@XmlElement(name = "CityAddressName")
	private String cityAddressName;
	
}
