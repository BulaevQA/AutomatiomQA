package api.soap.utils.models.request;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Setter
@Getter

@XmlRootElement(name = "invocationContext")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvocationContextRequest {
	
	@XmlElement(name = "login")
	private String login;
	
	@XmlElement(name = "password")
	private String password;
	
	
}
