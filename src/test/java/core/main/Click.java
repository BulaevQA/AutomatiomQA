package core.main;

import helpers.other.ElementCollections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class Click {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceClickButton(String button) {
        $x("//*[text()[normalize-space() = '"+button+"']]").should(visible, enabled).click();
    }

    private void serviceClickButton(String button, String index) {
        $x("(//*[text()[normalize-space() = '"+button+"']])["+index+"]").should(visible, enabled).click();
    }

    private void serviceCheckBox(String checkbox) {
        $x("//*[normalize-space(text())='"+checkbox+"']/ancestor::label[@class='checkbox']").should(visible, enabled).click();
    }

    private void serviceClickCheckboxes(String titleName) {
        $x("//*[normalize-space(text())='"+titleName+"']").should(visible);
        new ElementCollections().elementsCollectionsClick($$x("//*[normalize-space(text())='"+titleName+"']" +
                "/following-sibling::div//label"));
    }

    private void serviceRadioButton(String radioButton) {
        $x("//*[normalize-space(text())='"+radioButton+"']/ancestor::label[@class='radio']").should(visible, enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public Click clickButton(String button) {
        serviceClickButton(button);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public Click clickButton(String button, String index) {
        serviceClickButton(button, index);
        return this;
    }

    /**
     * === Активируем/деактивируем чек бокс ===
     * @param checkbox - Наименование чекбокса
     */
    @Step(value = "Активация чекбокса {checkbox}")
    public Click clickCheckbox(String checkbox) {
        serviceCheckBox(checkbox);
        return this;
    }

    /**
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     */
    @Step(value = "Активация чекбоксов по коллекции элементов")
    public Click clickCheckboxes(String titleName) {
        serviceClickCheckboxes(titleName);
        return this;
    }

    /**
     * === Активация радиобаттона ===
     * @param radioButton - Наименование радиобаттона
     */
    @Step(value = "Активация радиобаттона {radioButton}")
    public Click clickRadioButton(String radioButton) {
        serviceRadioButton(radioButton);
        return this;
    }
}
