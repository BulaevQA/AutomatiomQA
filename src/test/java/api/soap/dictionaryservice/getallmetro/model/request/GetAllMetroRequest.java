package api.soap.dictionaryservice.getallmetro.model.request;

import api.soap.utils.models.request.InvocationContextRequest;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter

@XmlRootElement(name = "getAllMetro", namespace = "com.bft.rusjob.integration.ks")

@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllMetroRequest {
	
	@XmlElement(name = "invocationContext")
	private InvocationContextRequest invocationContext;
	
}
