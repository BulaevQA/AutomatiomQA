package api.soap;

import api.soap.dictionaryservice.getallbenefits.test.GetAllBenefitsPojo;
import api.soap.dictionaryservice.getallbenefits.test.GetAllBenefitsXml;
import api.soap.dictionaryservice.getalllanguages.test.GetAllLanguagesPojo;
import api.soap.dictionaryservice.getallmetro.test.GetAllMetroPojo;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;


@Tag("API")
@Feature("integration-hr")
@DisplayName("Кадровый сервис: rusjob-integration-hr")
public class SoapTestMain {
	@Test
	@Tag("integration-hr")
	@Story("DictionaryService")
	@DisplayName("Справочник DictionaryService:getAllBenefitsXml")
	void SoapApiTestXml () throws JAXBException {
		
		GetAllBenefitsXml getAllBenefitsXml = new GetAllBenefitsXml();
		getAllBenefitsXml.getAllBenefits();
		
	}
	
	@Test
	@Tag("integration-hr")
	@Story("DictionaryService")
	@DisplayName("getAllBenefitsPojo")
	void SoapApiTestPojo () throws JAXBException {
		
		GetAllBenefitsPojo getAllBenefitsPojo = new GetAllBenefitsPojo();
		getAllBenefitsPojo.getAllBenefitsPojo();
		
	}
	
	@Test
	@Tag("integration-hr")
	@Story("DictionaryService")
	@DisplayName("getAllLanguagesPojo")
	void GetAllLanguagesPojo () throws JAXBException {
		
		GetAllLanguagesPojo getAllLanguagesPojo = new GetAllLanguagesPojo();
		getAllLanguagesPojo.getAllLanguagesPojo();
		
	}
	
	@Test
	@Tag("integration-hr")
	@Story("DictionaryService")
	@DisplayName("GetAllMetroPojo")
	void GetAllMetroPojo () throws JAXBException {
		
		GetAllMetroPojo getAllMetroPojo = new GetAllMetroPojo();
		getAllMetroPojo.getAllMetroPojo();
		
	}
	
	
}
