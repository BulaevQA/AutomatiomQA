package api.rest.employerreport;

import api.rest.employerreport.getforms_reports.test.GetFormReportsExtractJson;
import api.rest.employerreport.getforms_reports.test.GetFormReportsPojo;
import api.rest.employerreport.getjson_schema_form_report.reporting_nfpart_timeworkproc.test.ReportingNFPartTimeWorkProc;
import api.rest.employerreport.getjson_schema_form_report.reporting_form_bankrupt_cyprocnf.test.ReportingFormBankruptcyProcNF;
import api.rest.employerreport.getjson_schema_form_report.reporting_newform_empl_disabledproc.test.ReportingNewFormEmplDisabledProcTest;
import api.rest.employerreport.getjson_schema_form_report.reporting_newform_profrehabilitationproc.test.ReportingNewFormProfRehabilitationProc;
import api.rest.employerreport.getjson_schema_form_report.reporting_nfIdlemodeproc.test.ReportingNFIdleModeProc;
import api.rest.employerreport.getjson_schema_form_report.reporting_nfreduction_liquidationproc.test.ReportingNFReductionLiquidationProc;
import api.rest.employerreport.getjson_schema_form_report.reporting_nfremote_workproc.test.ReportingNFRemoteWorkProc;
import api.rest.employerreport.getjson_schema_form_report.reporting_nfvacation_withoutpayproc.test.ReportingNfVacationWithoutPayProc;
import api.rest.employerreport.tokencheck.test.TokenRequestCheckCode;
import api.rest.employerreport.tokencheck.test.TokenRequestCheckTrue;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


@Tag("API")
@DisplayName("DisplayName - Отчетность работодателей из внешних ИС")
@Feature("Feature - Отчетность работодателей из внешних ИС")
@Story("Story - Employer Report")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployerReportMainTest {
	
	@Order(1)
	@Test
	@Tag("EmployerReport")
	@Step("POST -Проверка ранее полученного токена - valid: true")
	@DisplayName("Проверка ранее полученного токена - валидность")
	void tokenRequestCheckTrueTest() throws JsonProcessingException {
		
		TokenRequestCheckTrue tokenRequestCheckTrue = new TokenRequestCheckTrue();
		tokenRequestCheckTrue.employerReportTokenCheckTrue();
	}
	
	@Order(2)
	@Test
	@Tag("EmployerReport")
	@Step("POST - Проверка ранее полученного токена - код")
	@DisplayName("Проверка ранее полученного токена - код")
	void tokenRequestCheckCodeTest() throws JsonProcessingException {
		TokenRequestCheckCode tokenRequestCheckCode = new TokenRequestCheckCode();
		tokenRequestCheckCode.employerReportTokenCheckCode();
	}
	
	@Order(3)
	@Test
	@Tag("EmployerReport")
	@Step("GET - запрос перечня форм отчетности работодателей")
	@DisplayName("Запрос перечня форм отчетности работодателей - POJO")
	void getFormReportsPojoTest() throws JsonProcessingException {
		
		GetFormReportsPojo getFormReportsPojo = new GetFormReportsPojo();
		getFormReportsPojo.getFormReports();
	}
	
	@Order(4)
	@Test
	@Tag("EmployerReport")
	@Step("GET - запрос перечня форм отчетности работодателей")
	@DisplayName("Запрос перечня форм отчетности работодателей - extract JSON")
	void getFormReportsExtractJsonTest() throws JsonProcessingException {
		
		GetFormReportsExtractJson getFormReportsExtractJson = new GetFormReportsExtractJson();
		getFormReportsExtractJson.getFormReportsExtractJson();
	}
	
	@Order(5)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNewFormEmplDisabledProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNewFormEmplDisabledProc")
	void ReportingNewFormEmplDisabledProcTest() throws JsonProcessingException {
		
		ReportingNewFormEmplDisabledProcTest reportingNewFormEmplDisabledProcTest = new ReportingNewFormEmplDisabledProcTest();
		reportingNewFormEmplDisabledProcTest.reportingNewFormEmplDisabledProc();
		
	}
	
	@Order(6)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNewFormProfRehabilitationProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNewFormProfRehabilitationProc")
	void ReportingNewFormProfRehabilitationProcTest() throws JsonProcessingException {
		
		ReportingNewFormProfRehabilitationProc reportingNewFormProfRehabilitationProc = new ReportingNewFormProfRehabilitationProc();
		reportingNewFormProfRehabilitationProc.reportingNewFormProfRehabilitationProc();
		
	}
	
	@Order(7)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNFIdleModeProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNFIdleModeProc")
	void ReportingNFIdleModeProcTest() throws JsonProcessingException {
		
		ReportingNFIdleModeProc reportingNFIdleModeProc = new ReportingNFIdleModeProc();
		reportingNFIdleModeProc.reportingNFIdleModeProc();
		
	}
	
	@Order(8)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNFReductionLiquidationProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNFReductionLiquidationProc")
	void ReportingNFReductionLiquidationProcTest() throws JsonProcessingException {
		
		ReportingNFReductionLiquidationProc reportingNFReductionLiquidationProc = new ReportingNFReductionLiquidationProc();
		reportingNFReductionLiquidationProc.reportingNFReductionLiquidationProc();
		
	}
	
	@Order(8)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNFRemoteWorkProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNFRemoteWorkProc")
	void ReportingNFRemoteWorkProcTest() throws JsonProcessingException {
		
		ReportingNFRemoteWorkProc reportingNFRemoteWorkProc = new ReportingNFRemoteWorkProc();
		reportingNFRemoteWorkProc.reportingNFRemoteWorkProc();
		
		
	}
	
	@Order(9)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNFPartTimeWorkProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNFPartTimeWorkProc")
	void ReportingNFPartTimeWorkProcTest() throws JsonProcessingException {
		
		ReportingNFPartTimeWorkProc reportingNFPartTimeWorkProc = new ReportingNFPartTimeWorkProc();
		reportingNFPartTimeWorkProc.reportingNFPartTimeWorkProc();
		
	}
	
	@Order(10)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingFormBankruptcyProcNF")
	@DisplayName("Запрос шаблона формы отчетности - reportingFormBankruptcyProcNF")
	void ReportingFormBankruptcyProcNfTest() throws JsonProcessingException {
		
		ReportingFormBankruptcyProcNF reportingFormBankruptcyProcNF = new ReportingFormBankruptcyProcNF();
		reportingFormBankruptcyProcNF.reportingFormBankruptcyProcNF();
		
	}
	
	@Order(11)
	@Test
	@Tag("EmployerReport")
	@Step("GET - Запрос шаблона формы отчетности для reportingNFVacationWithoutPayProc")
	@DisplayName("Запрос шаблона формы отчетности - reportingNFVacationWithoutPayProc")
	void ReportingNFVacationWithoutPayProc() throws JsonProcessingException {
		
		ReportingNfVacationWithoutPayProc reportingNFVacationWithoutPayProc = new ReportingNfVacationWithoutPayProc();
		reportingNFVacationWithoutPayProc.reportingNfVacationWithoutPayProc();
		
	}
	
	
}
