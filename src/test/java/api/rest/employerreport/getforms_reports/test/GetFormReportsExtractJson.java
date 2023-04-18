package api.rest.employerreport.getforms_reports.test;

import api.rest.employerreport.utils.Configuration;
import api.rest.specs.RestPostLoginSpecs;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetFormReportsExtractJson {
	
	
	public GetFormReportsExtractJson getFormReportsExtractJson() throws JsonProcessingException {
		
		Configuration configuration = new Configuration();
		
		Response getFormReportsResponse2 = given(RestPostLoginSpecs.requestSpec)
				.param("token",configuration.getToken())
				.when()
				.get(configuration.getBaseURI() + configuration.getGetFormReport())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.extract()
				.response();
		
		String value = getFormReportsResponse2.jsonPath().getString("success[2].reportCode");
		
		assertThat(value).isEqualTo("reportingNFIdleModeProc");
		
		System.out.println(value);
		
		
		return this;
		
	}
	
}
