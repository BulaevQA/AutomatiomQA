package core.main;

import com.codeborne.selenide.SelenideElement;
import helpers.collections.ElementCollections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class Click {

    private final SelenideElement meatBalls = $x("//div[@class='row row_middle']//button[@aria-expanded='false']");

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceClickButton(String button) {
        $x("//*[text()[normalize-space() = '"+button+"']]").should(visible, enabled).click();
    }

    private void serviceClickButton(String button, String index) {
        $x("(//*[text()[normalize-space() = '"+button+"']])["+index+"]").should(visible, enabled).click();
    }

    private void serviceCheckBox(String checkbox) {
        $x("//*[text()[normalize-space() = '"+checkbox+"']]/ancestor::label[@class='checkbox']").should(visible, enabled).click();
    }

    private void serviceClickCheckboxes(String titleName) {
        $x("//*[text()[normalize-space() = '"+titleName+"']]").should(exist, visible);
        new ElementCollections().elementsCollectionsClick($$x("//*[normalize-space(text())='"+titleName+"']" +
                "/following-sibling::div//label"));
    }

    private void serviceRadioButton(String radioButton) {
        $x("//*[text()[normalize-space() = '"+radioButton+"']]/ancestor::label[@class='radio']").should(visible, enabled).click();
    }

    private void serviceToggle(String toggle) {
        $x("//*[normalize-space(text())='"+toggle+"']/..").should(visible, enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку \"{button}\"")
    public Click clickButton(String button) {
        serviceClickButton(button);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку \"{button}\"")
    public Click clickButton(String button, String index) {
        serviceClickButton(button, index);
        return this;
    }

    /**
     * === Активируем/деактивируем чек бокс ===
     * @param checkbox - Наименование чекбокса
     */
    @Step(value = "Клик на чекбокс \"{checkbox}\"")
    public Click clickCheckbox(String checkbox) {
        serviceCheckBox(checkbox);
        return this;
    }

    /**
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     */
    @Step(value = "Клик на коллекцию чекбоксов")
    public Click clickCheckboxes(String titleName) {
        serviceClickCheckboxes(titleName);
        return this;
    }

    /**
     * === Активация радиобаттона ===
     * @param radioButton - Наименование радиобаттона
     */
    @Step(value = "Активация радиобаттона \"{radioButton}\"")
    public Click clickRadioButton(String radioButton) {
        serviceRadioButton(radioButton);
        return this;
    }

    /**
     === Метод клика на митбол ===
     */
    @Step(value = "Клик на кнопку \"митбол\"")
    public Click clickMeatBalls() {
        sleep(1500);
        meatBalls.should(visible, enabled).click();
        return this;
    }

    /**
     * === Переключатели в конструкторе резюме ===
     * @param toggle - Имя переключателя
     */
    @Step(value = "Активируем/Деативируем переключатель \"{toggle}\"")
    public Click clickToggle(String toggle) {
        serviceToggle(toggle);
        return this;
    }
}
