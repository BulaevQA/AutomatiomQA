package api.rest.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.notNullValue;

public class GetLoginSpecs {
	
	public static RequestSpecification getRequestSpec = with()
				.log().uri()
				.log().headers()
				.log().body()
				//.filter(withCustomTemplates())
				.contentType(ContentType.JSON);
	
	public static ResponseSpecification getResponseSpec = new ResponseSpecBuilder()
			.log(STATUS)
			.log(BODY)
			.expectStatusCode(200)
			.build();
	
	
}
