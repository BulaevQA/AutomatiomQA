package api.rest.employerreport.tokencheck.test;

import api.rest.employerreport.tokencheck.model.request.TokenRequest;
import api.rest.employerreport.utils.Configuration;
import api.rest.specs.RestPostLoginSpecs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TokenRequestCheckCode {
	
	

	 public TokenRequestCheckCode employerReportTokenCheckCode() throws JsonProcessingException {
		
		
		Configuration configuration = new Configuration();
		
		TokenRequest tokenRequest = new TokenRequest();
		tokenRequest.setToken(configuration.getToken());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tokenRequest);

		given(RestPostLoginSpecs.requestSpec)
				.body(json)
				.when()
				//.config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("*/*", ContentType.TEXT)))
				.post(configuration.getBaseURI()+configuration.getPathTokenRequest())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.assertThat()
				.body("isTokenValid", equalTo(true))
				.statusCode(200);
		
		return this;
				
	}

}
