package api.soap.dictionaryservice.getalllanguages.test;

import api.soap.utils.models.request.HeaderRequest;
import api.soap.utils.models.request.InvocationContextRequest;

import api.soap.dictionaryservice.getalllanguages.model.response.EnvelopeResponse;
import api.soap.dictionaryservice.getalllanguages.model.request.BodyRequest;
import api.soap.dictionaryservice.getalllanguages.model.request.EnvelopeRequest;
import api.soap.dictionaryservice.getalllanguages.model.request.GetAllLanguagesRequest;
import api.soap.utils.specs.SoapSpecs;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllLanguagesPojo {
	
	
	@Step("getAllLanguagesPojo")
	public GetAllLanguagesPojo getAllLanguagesPojo() throws JAXBException {
		
		
		// Создаем объекты классов начиная с дочернего уровня, устанавливаем дочерний объект класса в родительский
		// Создаем объект InvocationContext
		InvocationContextRequest invocationContextRequest = new InvocationContextRequest();
		invocationContextRequest.setLogin("kadrovoe@pbs.bftcom.com");
		invocationContextRequest.setPassword("Qwerty123");
		
		// Создаем объект GetAllLanguagesRequest и устанавливаем в него invocationContext
		GetAllLanguagesRequest getAllLanguagesRequest = new GetAllLanguagesRequest();
		getAllLanguagesRequest.setInvocationContext(invocationContextRequest);
		
		// Создаем объект Body и устанавливаем в него getAllLanguagesRequest
		BodyRequest bodyRequest = new BodyRequest();
		bodyRequest.setGetAllLanguagesRequest(getAllLanguagesRequest);
		
		
		// Создаем объект Envelope и устанавливаем в него body и header
		HeaderRequest headerRequest = new HeaderRequest();
		
		EnvelopeRequest envelopeRequest = new EnvelopeRequest();
		envelopeRequest.setHeaderRequest(headerRequest);
		envelopeRequest.setBodyRequest(bodyRequest);
		
		
		// С помощью JAXB преобразовываем объект Envelope в XML-документ
		JAXBContext jaxbContext = JAXBContext.newInstance(EnvelopeRequest.class,
				BodyRequest.class,
				GetAllLanguagesRequest.class,
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
		
		// Десериализация объекта
		JAXBContext jaxbContextResponse = JAXBContext.newInstance(EnvelopeResponse.class);
		
		Unmarshaller unmarshaller = jaxbContextResponse.createUnmarshaller();
		StringReader reader = new StringReader(response.getBody().asString());
		EnvelopeResponse envelopeResponse = (EnvelopeResponse) unmarshaller.unmarshal(reader);
		//EnvelopeResponse envelopeResponse = (EnvelopeResponse) unmarshaller.unmarshal(new StringReader(response.asString()));

		
		
		System.out.println(
				envelopeResponse
						.getBodyResponse()
						.getGetAllLanguagesResponseResponse()
						.getGetAllLanguagesResponse()
						.getLanguages()
						.getElementList()
						.get(1)
						.getId());
		
		//AssertJ assertions
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllLanguagesResponseResponse()
				.getGetAllLanguagesResponse()
				.getLanguages()
				.getElementList()
				.get(1)
				.getName())
				.isEqualTo("Английский");
		
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllLanguagesResponseResponse()
				.getGetAllLanguagesResponse()
				.getLanguages()
				.getElementList()
				.get(1)
				.getId())
				.isEqualTo("016");
		
		assertThat(envelopeResponse
				.getBodyResponse()
				.getGetAllLanguagesResponseResponse()
				.getGetAllLanguagesResponse()
				.getLanguages()
				.getElementList()
				.size())
				.isEqualTo(299);
		
		return this;
	}
	
}
