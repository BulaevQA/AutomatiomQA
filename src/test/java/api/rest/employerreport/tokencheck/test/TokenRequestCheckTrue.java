package api.rest.employerreport.tokencheck.test;

import api.rest.employerreport.tokencheck.model.request.TokenRequest;
import api.rest.employerreport.tokencheck.model.response.TokenResponse;

import api.rest.employerreport.utils.Configuration;
import api.rest.specs.RestPostLoginSpecs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class TokenRequestCheckTrue {
	
	
	public TokenRequestCheckTrue employerReportTokenCheckTrue() throws JsonProcessingException {
		
		Configuration configuration = new Configuration();
		
		TokenRequest tokenRequest = new TokenRequest();
		tokenRequest.setToken(configuration.getToken());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tokenRequest);

		TokenResponse response = given(RestPostLoginSpecs.requestSpec)
				.body(json)
				.when()
				//.config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("*/*", ContentType.TEXT)))
				.post( configuration.getBaseURI()+configuration.getPathTokenRequest())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.extract().as(TokenResponse.class);
		
		assertThat(response.getIsTokenValid()).isTrue();
		
		return this;
		
	}
}
