package api.rest.employerreport.tokencheck.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse {
	
	
	@JsonProperty("isTokenValid")
	private Boolean isTokenValid;

}
