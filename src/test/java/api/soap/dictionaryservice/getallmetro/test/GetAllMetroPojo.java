package api.soap.dictionaryservice.getallmetro.test;

import api.soap.dictionaryservice.getallmetro.model.request.BodyRequest;
import api.soap.dictionaryservice.getallmetro.model.request.EnvelopeRequest;
import api.soap.dictionaryservice.getallmetro.model.request.GetAllMetroRequest;

import api.soap.dictionaryservice.getallmetro.model.response.EnvelopeResponse;

import api.soap.utils.models.request.HeaderRequest;
import api.soap.utils.models.request.InvocationContextRequest;
import api.soap.utils.specs.SoapSpecs;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetAllMetroPojo {
	
	
	@Step("getAllMetroPojo")
	public GetAllMetroPojo getAllMetroPojo() throws JAXBException {
		
		
		// Создаем объекты классов начиная с дочернего уровня, устанавливаем дочерний объект класса в родительский
		// Создаем объект InvocationContext
		InvocationContextRequest invocationContextRequest = new InvocationContextRequest();
		invocationContextRequest.setLogin("kadrovoe@pbs.bftcom.com");
		invocationContextRequest.setPassword("Qwerty123");
		
		// Создаем объект GetAllLanguagesRequest и устанавливаем в него invocationContext
		GetAllMetroRequest getAllMetroRequest = new GetAllMetroRequest();
		getAllMetroRequest.setInvocationContext(invocationContextRequest);
		
		// Создаем объект Body и устанавливаем в него getAllLanguagesRequest
		BodyRequest bodyRequest = new BodyRequest();
		bodyRequest.setGetAllMetroRequest(getAllMetroRequest);
		
		
		// Создаем объект Envelope и устанавливаем в него body и header
		HeaderRequest headerRequest = new HeaderRequest();
		
		EnvelopeRequest envelopeRequest = new EnvelopeRequest();
		envelopeRequest.setHeaderRequest(headerRequest);
		envelopeRequest.setBodyRequest(bodyRequest);
		
		
		// С помощью JAXB преобразовываем объект Envelope в XML-документ
		JAXBContext jaxbContext = JAXBContext.newInstance(EnvelopeRequest.class,
				BodyRequest.class,
				GetAllMetroRequest.class,
				InvocationContextRequest.class);
		
		// Сериализация объекта
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		QName qName = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
		
		JAXBElement<EnvelopeRequest> envelopeElement = new JAXBElement<>(qName, EnvelopeRequest.class, envelopeRequest);
		
		StringWriter sw = new StringWriter();
		marshaller.marshal(envelopeElement, sw);
		String xml = sw.toString();
		
		String endpoint = "https://rtintegration.show.pbs.bftcom.com/ks/dictionaryService";
		
		
			Response response =	given()
						.spec(SoapSpecs.requestSpec)
						.body(xml)
						.when()
						.post(endpoint)
						.then()
						.spec(SoapSpecs.responseSpec)
						.statusCode(200)
						.extract()
						.response();
						//.extract().xmlPath().getString("//Metro[1]/Id");
		
		//String actualData = response.xmlPath().getString("//Metro[1]/Id");
		// assertThat("e1bd9930-81cf-11e4-a6da-9be8de68eaf1").isEqualTo(actualData);
		//System.out.println(response);
		
		// Десериализация объекта
		JAXBContext jaxbContextResponse = JAXBContext.newInstance(EnvelopeResponse.class);
		
		Unmarshaller unmarshaller = jaxbContextResponse.createUnmarshaller();
		StringReader reader = new StringReader(response.getBody().asString());
		EnvelopeResponse envelopeResponse = (EnvelopeResponse) unmarshaller.unmarshal(reader);
		//EnvelopeResponse envelopeResponse = (EnvelopeResponse) unmarshaller.unmarshal(new StringReader(response.asString()));
		
		
		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllMetroResponseResponse()
						.getGetAllMetroResponse()
						.getMetroStations()
						.getMetrotList()
						.get(2)
						.getName());
						
		
		//AssertJ assertions
		assertThat(envelopeResponse
						.getBodyResponse()
						.getGetAllMetroResponseResponse()
						.getGetAllMetroResponse()
						.getMetroStations()
						.getMetrotList()
						.get(2)
						.getName())
				.isEqualTo("Дмитровская");
		
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllMetroResponseResponse()
				.getGetAllMetroResponse()
				.getMetroStations()
				.getMetrotList()
				.get(2)
				.getId())
				.isEqualTo("e182da27-81cf-11e4-a6da-9be8de68eaf1");
		
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllMetroResponseResponse()
				.getGetAllMetroResponse()
				.getMetroStations()
				.getMetrotList()
				.size())
				.isEqualTo(301);
		
		return this;
	}
	
}
