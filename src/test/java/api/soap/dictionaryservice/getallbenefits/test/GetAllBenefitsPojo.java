package api.soap.dictionaryservice.getallbenefits.test;

import api.soap.dictionaryservice.getallbenefits.model.request.EnvelopeRequest;
import api.soap.utils.models.request.HeaderRequest;
import api.soap.utils.models.request.InvocationContextRequest;
import api.soap.dictionaryservice.getallbenefits.model.response.EnvelopeResponse;
import api.soap.dictionaryservice.getallbenefits.model.request.BodyRequest;
import api.soap.dictionaryservice.getallbenefits.model.request.GetAllBenefitsRequest;

import api.soap.utils.specs.SoapSpecs;

import io.qameta.allure.Step;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllBenefitsPojo {
	
	
	@Step("getAllBenefitsPojo")
	public GetAllBenefitsPojo getAllBenefitsPojo() throws JAXBException {
		
		// смотри вложение resources/request.xml; resources/response.xml

/*	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:com="com.bft.rusjob.integration.ks">
	   <soapenv:Header/>
	   <soapenv:Body>
		  <com:getAllBenefits>
			 <!--Optional:-->
			 <invocationContext>
				<login>kadrovoe@pbs.bftcom.com</login>
				<password>Qwerty123</password>
			 </invocationContext>
		  </com:getAllBenefits>
	   </soapenv:Body>
	</soapenv:Envelope>*/
		
		
		// Создаем объекты классов начиная с дочернего уровня, устанавливаем дочерний объект класса в родительский
		// Создаем объект InvocationContext
		InvocationContextRequest invocationContextRequest = new InvocationContextRequest();
		invocationContextRequest.setLogin("kadrovoe@pbs.bftcom.com");
		invocationContextRequest.setPassword("Qwerty123");
		
		// Создаем объект GetAllBenefits и устанавливаем в него invocationContext
		GetAllBenefitsRequest getAllBenefitsRequest = new GetAllBenefitsRequest();
		getAllBenefitsRequest.setInvocationContext(invocationContextRequest);
		
		
		// Создаем объект Body и устанавливаем в него getAllBenefits
		BodyRequest bodyRequest = new BodyRequest();
		bodyRequest.setGetAllBenefitsRequest(getAllBenefitsRequest);
		
		HeaderRequest headerRequest = new HeaderRequest();
		
		// Создаем объект Envelope и устанавливаем в него body и header
		EnvelopeRequest envelope = new EnvelopeRequest();
		envelope.setBodyRequest(bodyRequest);
		envelope.setHeaderRequest(headerRequest);
		
		
		// С помощью JAXB преобразовываем объект Envelope в XML-документ
		JAXBContext jaxbContext = JAXBContext.newInstance(EnvelopeRequest.class,
				BodyRequest.class,
				GetAllBenefitsRequest.class,
				InvocationContextRequest.class);
		
		// Сериализация объекта
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		QName qName = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
		
		JAXBElement<EnvelopeRequest> envelopeElement = new JAXBElement<>(qName, EnvelopeRequest.class, envelope);
		
		StringWriter sw = new StringWriter();
		marshaller.marshal(envelopeElement, sw);
		String xml = sw.toString();
		
		String endpoint = "https://rtintegration.show.pbs.bftcom.com/ks/dictionaryService";
		
		Response response = given()
				.spec(SoapSpecs.requestSpec)
				.body(xml)
				.when()
				.post(endpoint)
				.then()
				.spec(SoapSpecs.responseSpec)
				.statusCode(200)
				.extract()
				.response();
		//String request = response.xmlPath().prettyPrint().toString().
		
		// Десериализация объекта
		JAXBContext jaxbContextResponse = JAXBContext.newInstance(EnvelopeResponse.class);
		
		Unmarshaller unmarshaller = jaxbContextResponse.createUnmarshaller();
		StringReader reader = new StringReader(response.getBody().asString());
		EnvelopeResponse envelopeResponse = (EnvelopeResponse) unmarshaller.unmarshal(reader);
		//EnvelopeResponse envelopeResponse = (EnvelopeResponse) unmarshaller.unmarshal(new StringReader(response.asString()));


/*		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllBenefitsResponseResponse()
						.getResponseGetAllBenefits().getResultCodeResponse());

		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllBenefitsResponseResponse()
						.getResponseGetAllBenefits().getBusinessMessageResponse());

		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllBenefitsResponseResponse()
						.getResponseGetAllBenefits().getTotalResponse());

		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllBenefitsResponseResponse()
						.getResponseGetAllBenefits().getBenefits().getElementList().get(0).getName()); */
		
		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllBenefitsResponseResponse()
						.getResponseGetAllBenefits()
						.getBenefits()
						.getElementList()
						.get(0).getId());
		
		
		//JU5 assertions
		assertEquals("OK", envelopeResponse.getBodyResponse().getGetAllBenefitsResponseResponse().getResponseGetAllBenefits().getBusinessMessageResponse());
		//AssertJ assertions
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllBenefitsResponseResponse()
				.getResponseGetAllBenefits()
				.getResultCodeResponse())
				.isEqualTo("200");
		
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllBenefitsResponseResponse()
				.getResponseGetAllBenefits()
				.getBenefits()
				.getElementList()
				.get(1).getName())
				.isEqualTo("ДМС");
		
		
		String actualData = envelopeResponse
				.getBodyResponse()
				.getGetAllBenefitsResponseResponse()
				.getResponseGetAllBenefits()
				.getBenefits()
				.getElementList()
				.get(1)
				.getName();
		
		System.out.println(actualData);

/*		public Map<String, Object> actualDataMap() {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("ДМС", actualData);

		}*/
		
		
		return this;
	}
	
}
