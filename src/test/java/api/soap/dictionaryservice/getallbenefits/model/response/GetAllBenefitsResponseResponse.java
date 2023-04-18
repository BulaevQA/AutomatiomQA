package api.soap.dictionaryservice.getallbenefits.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement(name = "getAllBenefitsResponse", namespace = "com.bft.rusjob.integration.ks")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllBenefitsResponseResponse {
	
	@XmlElement(name = "getAllBenefits")
	private ResponseGetAllBenefits responseGetAllBenefits;
	
	
}
