package pages.admPages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainAdmPage {

    ///////////////// Служебные методы \\\\\\\\\\\\\\\\\\\

    /**
     === Клик на кнопку "Модерация" у резюме/вакансии (поиск осуществялется по наименованию вакансии/резюме) ===
     * @param positionName - наименование вакансии/резюме
     */
    private void serviceModerationObject(String positionName) {
        $x("//*[text()='"+positionName+"']/ancestor::tr//td[@class='action']//button").should(visible, enabled).click();
    }

///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Клик на кнопку "Модерация" у резюме/вакансии (поиск осуществялется по наименованию вакансии/резюме) ===
     * @param positionName - наименование вакансии/резюме
     */
    @Step(value = "Клик на кнопку Модерация с поиском по наименованию сущности")
    public MainAdmPage moderationObject(String positionName) {
        serviceModerationObject(positionName);
        return this;
    }
}
