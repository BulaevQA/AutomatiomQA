package api.soap.utils.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class SoapSpecs {
	

	public static RequestSpecification requestSpec = with()
				.log().uri()
				.log().headers()
				.log().body()
				.filter(new AllureRestAssured()) //CustomApiListener.withCustomTemplates()
				.header("Content-Type","text/xml;charset=UTF-8");
				//.contentType(ContentType.XML);
	
	public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
			.log(STATUS)
			.log(BODY)
			.expectContentType(ContentType.XML)
			.build();
	
	
}
