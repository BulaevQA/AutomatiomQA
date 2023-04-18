package api.soap.dictionaryservice.getallbenefits.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement(name = "getAllBenefits", namespace = "com.bft.rusjob.integration.ks")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseGetAllBenefits {
	
	@XmlElement(name = "resultCode")
	private String resultCodeResponse;
	
	@XmlElement(name = "businessMessage")
	private String businessMessageResponse;
	
	@XmlElement(name = "Total")
	private String totalResponse;
	
	@XmlElement(name = "Count")
	private String countResponse;
	
	
	@XmlElement(name = "Benefits")
	private BenefitsResponse benefits;
	
}
