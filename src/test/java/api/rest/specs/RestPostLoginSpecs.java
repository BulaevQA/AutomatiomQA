package api.rest.specs;

import api.allurehelper.CustomApiListener;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.*;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static org.hamcrest.Matchers.notNullValue;

public class RestPostLoginSpecs {
	
	public static RequestSpecification requestSpec = with()
			.log().uri()
			.log().headers()
			.log().body()
			.filter(CustomApiListener.withCustomTemplates())
			.contentType(ContentType.JSON); //custom allure listener
			//.filter(new AllureRestAssured()) - default allure listener
	
	public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
			.log(STATUS)
			.log(HEADERS)
			.log(BODY)
			.expectStatusCode(200)
			//.expectBody("token", notNullValue())
			//.expectBody(notNullValue())
			.build();
	
}
