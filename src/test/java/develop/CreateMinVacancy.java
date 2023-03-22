package develop;

import helpers.HashMaps;
import org.junit.jupiter.api.*;
import base.BrowserConfig;
import pages.core.CorePage;
import pages.trudvsem.mainPrr.MainNonAuthPage;
import pages.trudvsem.myVacancy.MyVacancyPage;

public class CreateMinVacancy extends BrowserConfig {

    CorePage corePage = new CorePage();
    MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();
    HashMaps hashMaps = new HashMaps();
    MyVacancyPage myVacancyPage = new MyVacancyPage();

//    @Test
    @Tag("Full test")
    @DisplayName("Тест создания вакансии(минимальное заполнение)")
    public void createVacancyTest() {
        corePage
                .openUrl(url);
        mainNonAuthPage
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Индивидуальный предприниматель")
                .buttonCreateVacancy()
                .inputValueDropDown("Название вакансии", "Автотест", "Автотест")
                .inputValueDropDown("Профессия", "Учитель", "Учитель")
                .selectDropDown("Сфера деятельности", "Высший менеджмент")
                .inputIframeField("Обязанности", "тЕКСТ1")
                .inputIframeField("Требования", "тЕЦУКЦУК")
                .inputValueField("Контактное лицо", "Булаев Денис")
                .clickButton("Сохранить и опубликовать");
        Assertions
                .assertEquals(hashMaps.expectedVacancy(), myVacancyPage.actualAttributes());
        myVacancyPage
                .deleteVacancy(1000);
    }
}
