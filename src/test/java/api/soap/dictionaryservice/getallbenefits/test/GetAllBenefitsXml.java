package api.soap.dictionaryservice.getallbenefits.test;

import api.soap.dictionaryservice.getallbenefits.model.request.EnvelopeRequest;
import api.soap.utils.models.request.InvocationContextRequest;
import api.soap.dictionaryservice.getallbenefits.model.request.BodyRequest;
import api.soap.utils.models.request.HeaderRequest;
import api.soap.dictionaryservice.getallbenefits.model.request.GetAllBenefitsRequest;
import api.soap.utils.specs.SoapSpecs;
import io.qameta.allure.Step;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAllBenefitsXml {


	@Step("getAllBenefitsXml")
	public GetAllBenefitsXml getAllBenefits() throws JAXBException {

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
		EnvelopeRequest envelopeRequest = new EnvelopeRequest();
		envelopeRequest.setBodyRequest(bodyRequest);
		envelopeRequest.setHeaderRequest(headerRequest);


		// С помощью JAXB преобразовываем объект Envelope в XML-документ
		JAXBContext jaxbContext = JAXBContext.newInstance(EnvelopeRequest.class, BodyRequest.class, GetAllBenefitsRequest.class, InvocationContextRequest.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		QName qName = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");

		JAXBElement<EnvelopeRequest> envelopeElement = new JAXBElement<>(qName, EnvelopeRequest.class, envelopeRequest);

		StringWriter sw = new StringWriter();
		marshaller.marshal(envelopeElement, sw);
		String xml = sw.toString();


		String endpoint = "https://rtintegration.show.pbs.bftcom.com/ks/dictionaryService";


			given()
					.spec(SoapSpecs.requestSpec)
					.body(xml)
					.when()
					.post(endpoint)
					.then()
					.spec(SoapSpecs.responseSpec)
					.assertThat()
					.body(hasXPath("//Id"))
					.body(hasXPath("//Element[1]/Name[1][text()='Путевки в оздоровительные учреждения']"))
					.body(hasXPath("//Name[text()='ДМС']"))
					.body(hasXPath("//Element[1]/Id[1]", containsString("ee681750-81cf-11e4-a6da-9be8de68eaf1")))
					.body(hasXPath("//Benefits/Element[Id='ee67a220-81cf-11e4-a6da-9be8de68eaf1']/Name", equalTo("ДМС")))
					.body(hasXPath("count(//Element)", equalTo("4")))
					.body(hasXPath("//resultCode", equalTo("200")));
					//.statusCode(200);

//Использование разных префиксов для одного и того же URI-адреса пространства имен не изменяет его семантику.
//		Пространства имен помогают избежать конфликта имен между различными элементами в XML-документе.


/*		<ns2:Envelope xmlns:ns2="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns3="com.bft.rusjob.integration.ks">
			<ns2:Header/>
			<ns2:Body>
				<ns3:getAllBenefits>
					<invocationContext>
						<login>kadrovoe@pbs.bftcom.com</login>
						<password>Qwerty123</password>
					</invocationContext>
				</ns3:getAllBenefits>
			</ns2:Body>
		</ns2:Envelope>*/


return this;
	}

}
