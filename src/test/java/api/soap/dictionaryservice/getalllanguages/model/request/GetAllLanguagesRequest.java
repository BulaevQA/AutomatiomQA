package api.soap.dictionaryservice.getalllanguages.model.request;

import api.soap.utils.models.request.InvocationContextRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "getAllLanguages", namespace = "com.bft.rusjob.integration.ks")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllLanguagesRequest {
	
	public InvocationContextRequest getInvocationContext() {
		return invocationContextRequest;
	}
	
	public void setInvocationContext(InvocationContextRequest invocationContextRequest) {
		this.invocationContextRequest = invocationContextRequest;
	}
	
	@XmlElement(name = "invocationContext")
	private InvocationContextRequest invocationContextRequest;
	
	
}
