package pages.admPages;

import io.qameta.allure.Step;
import pages.trudvsemPages.mainPrrPage.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class MainAdmPage {

    ///////////////// Служебные методы \\\\\\\\\\\\\\\\\\\

    private void serviceModerationObject(String positionName) {
        $x("//*[text()[normalize-space() = '"+positionName+"']]/ancestor::tr//td[@class='action']//button")
                .should(visible, enabled).click();
    }

    private void serviceCheckModerationObject(String positionName) {
        $x("//*[text()[normalize-space() = '"+positionName+"']]").shouldNot(exist, Duration.ofSeconds(6));
    }

///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Клик на кнопку "Модерация" у резюме/вакансии (поиск осуществялется по наименованию вакансии/резюме) ===
     * @param positionName - наименование вакансии/резюме
     */
    @Step(value = "Клик на кнопку Модерация у сущности \"{positionName}\"")
    public MainAdmPage moderationObject(String positionName) {
        serviceModerationObject(positionName);
        return this;
    }

    @Step(value = "Проверка на отсутствие модерируемой сущности")
    public MainAdmPage checkModerationObject(String positionName) {
        serviceCheckModerationObject(positionName);
        return this;
    }
}
