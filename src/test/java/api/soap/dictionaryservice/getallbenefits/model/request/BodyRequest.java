package api.soap.dictionaryservice.getallbenefits.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter

@XmlRootElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class BodyRequest {

	@XmlElement(name = "getAllBenefits", namespace = "com.bft.rusjob.integration.ks")
	private GetAllBenefitsRequest getAllBenefitsRequest;


}
