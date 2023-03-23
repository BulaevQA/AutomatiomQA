package core;

import com.codeborne.selenide.Condition;
import helpers.ElementCollections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class Click {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceClickButton(String button) {
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, int milliseconds) {
        sleep(milliseconds);
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, String index) {
        $x("(//*[text()='" + button + "'])[" + index + "]").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//*[text()='" + button + "'])[" + index + "]").should(Condition.enabled).click();
    }

    private void serviceCheckBox(String checkbox) {
        $x("//*[text()='" + checkbox + "']/ancestor::label[@class='checkbox']").should(Condition.enabled).click();
    }

    private void serviceClickCheckboxes(String titleName) {
        new ElementCollections().elementsCollectionsClick($$x("//*[text()='" + titleName + "']/..//div//div//label"));
    }

    private void serviceClickCheckboxes(String titleName, int milliseconds) {
        sleep(milliseconds);
        new ElementCollections().elementsCollectionsClick($$x("//*[text()='" + titleName + "']/..//div//div//label"));
    }

    private void serviceRadioButton(String radioButton) {
        $x("//*[text()='" + radioButton + "']/ancestor::label[@class='radio']").should(Condition.enabled).click();
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
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Кликаем на кнопку {button}")
    public Click clickButton(String button, int milliseconds) {
        serviceClickButton(button, milliseconds);
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
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Кликаем на кнопку {button}")
    public Click clickButton(String button, int milliseconds, String index) {
        serviceClickButton(button, milliseconds, index);
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
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     * @param milliseconds - Ожидание перед зачаном выполнения метода
     */
    @Step(value = "Активация чекбоксов по коллекции элементов с ожиданием {milliseconds} миллисекунд")
    public Click clickCheckboxes(String titleName, int milliseconds) {
        serviceClickCheckboxes(titleName, milliseconds);
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
