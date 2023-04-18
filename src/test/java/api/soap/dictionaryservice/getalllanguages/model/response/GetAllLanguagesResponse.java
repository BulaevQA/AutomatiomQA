package api.soap.dictionaryservice.getalllanguages.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement(name = "getAllLanguages")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllLanguagesResponse {
	
	@XmlElement(name = "resultCode")
	private String resultCodeResponse;
	
	@XmlElement(name = "businessMessage")
	private String businessMessageResponse;
	
	@XmlElement(name = "Total")
	private String totalResponse;
	
	@XmlElement(name = "Count")
	private String countResponse;
	
	
	@XmlElement(name = "Languages")
	private LanguagesResponse languages;
	
}
