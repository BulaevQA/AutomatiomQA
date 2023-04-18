package api.rest.employerreport.getforms_reports.test;

import api.rest.employerreport.utils.Configuration;
import api.rest.specs.RestPostLoginSpecs;
import com.fasterxml.jackson.core.JsonProcessingException;

import static org.assertj.core.api.Assertions.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetFormReportsPojo {
	
	
	public GetFormReportsPojo getFormReports() throws JsonProcessingException {
		
		
		Configuration configuration = new Configuration();
		
		// no pojo
		given(RestPostLoginSpecs.requestSpec)
				.param("token",configuration.getToken())
				.when()
				.get(configuration.getBaseURI() + configuration.getGetFormReport())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.assertThat()
				.body("success[1].reportCode", equalTo("reportingNewFormProfRehabilitationProc"))
				.statusCode(200);
		
/*		//POJO
		GetFormReportsResponse getFormReportsResponse = given(RestPostLoginSpecs.requestSpec)
				.param(configuration.getToken())
				.when()
				.get(configuration.getBaseURI() + configuration.getGetFormReport())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.extract().as(GetFormReportsResponse.class);
		
		assertThat(getFormReportsResponse
				.getSuccessesList()
				.get(1)
				.getReportName())
				.isEqualTo("Новая форма Информация о профессиональной реабилитации и содействию занятости инвалидов");
		
		assertThat(getFormReportsResponse
				.getSuccessesList())
				.size().isEqualTo(8);
		
		// присваивание значения объекта новой переменной
		String stringRespone = getFormReportsResponse
				.getSuccessesList()
				.get(1)
				.getReportName();
		
		System.out.println(stringRespone);*/
		
		
		return this;
		
	}
	
}
