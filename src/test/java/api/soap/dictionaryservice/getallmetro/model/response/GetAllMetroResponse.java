package api.soap.dictionaryservice.getallmetro.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlRootElement(name = "getAllMetro")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllMetroResponse {
	
	@XmlElement(name = "resultCode")
	private String resultCode;
	@XmlElement(name = "businessMessage")
	private String businessMessage;
	
	@XmlElement(name = "Total")
	private String total;
	
	
	@XmlElement(name = "Count")
	private String count;
	
	
	@XmlElement(name = "MetroStations")
	private MetroStationsResponse metroStations;
	
	
}
