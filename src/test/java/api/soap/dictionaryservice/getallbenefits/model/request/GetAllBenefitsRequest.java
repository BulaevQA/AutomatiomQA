package api.soap.dictionaryservice.getallbenefits.model.request;

import api.soap.utils.models.request.InvocationContextRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "getAllBenefits", namespace = "com.bft.rusjob.integration.ks")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllBenefitsRequest {
	
	public InvocationContextRequest getInvocationContext() {
		return invocationContextRequest;
	}
	
	public void setInvocationContext(InvocationContextRequest invocationContextRequest) {
		this.invocationContextRequest = invocationContextRequest;
	}
	
	@XmlElement(name = "invocationContext")
	private InvocationContextRequest invocationContextRequest;
	
	
}
