package api.soap.dictionaryservice.getallmetro.model.response;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "MetroStations")
@XmlAccessorType(XmlAccessType.FIELD)
public class MetroStationsResponse {
	
	
	@XmlElement(name = "Metro")
	private List<MetroResponse> MetrotList;
	
	@XmlElement(name = "Metro")
	public List<MetroResponse> getMetrotList() {
		return MetrotList;
	}
	
}
