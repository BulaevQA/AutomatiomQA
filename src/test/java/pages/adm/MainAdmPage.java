package pages.adm;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainAdmPage {

    ///////////////// Служебные методы \\\\\\\\\\\\\\\\\\\

    /**
     === Клик на функциональные кнопки в АРМ АДМ ===
     * @param index - позиция элемента в DOM
     */
    private void serviceModerationButtons(String index) {
        $x("(//div[@id='block-buttons']//button)[" + index + "]").should(Condition.enabled).click();
    }

    /**
     === Клик на кнопку "Модерация" у резюме/вакансии (поиск осуществялется по наименованию вакансии/резюме) ===
     * @param positionName - наименование вакансии/резюме
     */
    private void serviceModerationObject(String positionName) {
        $x("//*[text()='" + positionName + "']/ancestor::tr//td[@class='action']//button").should(Condition.enabled)
                .click();
    }

///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Клик на функциональные кнопки в АРМ АДМ ===
     * @param index - позиция элемента в DOM
     */
    @Step(value = "Клик на фукнциональную кнопку с номером {index}")
    public MainAdmPage moderationButtons(String index) {
        serviceModerationButtons(index);
        return this;
    }

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
