package api.rest.employerreport.getjson_schema_form_report.reporting_newform_empl_disabledproc.test;

import api.rest.employerreport.utils.Configuration;
import api.rest.specs.RestPostLoginSpecs;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReportingNewFormEmplDisabledProcTest {
	
		public ReportingNewFormEmplDisabledProcTest reportingNewFormEmplDisabledProc() throws JsonProcessingException {
		
		Configuration configuration = new Configuration();
		
		given(RestPostLoginSpecs.requestSpec)
				.param("reportCode", "reportingNewFormEmplDisabledProc")
				.param("token", configuration.getToken())
				.when()
				.get(configuration.getBaseURI() + configuration.getPathGetJsonSchemaFormReport())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.assertThat()
				//.body(matchesJsonSchemaInClasspath("emploerreportjsonvalidation/reportingNewFormEmplDisabledProc.json")) - cмотрит в корень resources
				.body(matchesJsonSchema( new File("src/test/java/api/rest/demoservice/employerreport/" +
						"getjson_schema_form_report/reporting_newform_empl_disabledproc/jsonschema/reportingNewFormEmplDisabledProc.json")))
				.body("success.reportCode", equalTo("reportingNewFormEmplDisabledProc"));

//		String value = getFormReportsResponse2.jsonPath().getString("success[2].reportCode");
//
//		assertThat(value).isEqualTo("reportingNFIdleModeProc");
//
//		System.out.println(value);
		
		
		return this;
		
	}
	
}
