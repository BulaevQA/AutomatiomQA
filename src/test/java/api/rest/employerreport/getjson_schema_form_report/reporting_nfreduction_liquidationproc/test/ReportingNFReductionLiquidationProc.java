package api.rest.employerreport.getjson_schema_form_report.reporting_nfreduction_liquidationproc.test;

import api.rest.employerreport.utils.Configuration;
import api.rest.specs.RestPostLoginSpecs;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

;

public class ReportingNFReductionLiquidationProc {
	
		public ReportingNFReductionLiquidationProc reportingNFReductionLiquidationProc() throws JsonProcessingException {
		
		Configuration configuration = new Configuration();
		
		given(RestPostLoginSpecs.requestSpec)
				.param("reportCode", "reportingNFReductionLiquidationProc")
				.param("token", configuration.getToken())
				.when()
				.get(configuration.getBaseURI() + configuration.getPathGetJsonSchemaFormReport())
				.then()
				.spec(RestPostLoginSpecs.responseSpec)
				.assertThat()
				.body(matchesJsonSchema( new File("src/test/java/api/rest/demoservice/employerreport/" +
						"getjson_schema_form_report/reporting_nfreduction_liquidationproc/jsonschema/reportingNFReductionLiquidationProc.json")))
				.body("success.reportCode", equalTo("reportingNFReductionLiquidationProc"));

//		String value = getFormReportsResponse2.jsonPath().getString("success[2].reportCode");
//
//		assertThat(value).isEqualTo("reportingNFIdleModeProc");
//
//		System.out.println(value);
		
		
		return this;
		
	}
	
}
