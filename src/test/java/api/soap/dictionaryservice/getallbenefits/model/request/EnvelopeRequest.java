package api.soap.dictionaryservice.getallbenefits.model.request;

import api.soap.utils.models.request.HeaderRequest;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Setter
@Getter
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvelopeRequest {
	
	@XmlElement(name = "Header", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
	private HeaderRequest headerRequest;
	
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
	private BodyRequest bodyRequest;
	
	
}