package pages.core;

import com.codeborne.selenide.Condition;
import helpers.ElementCollections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ClickCheckbox {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

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

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Активируем/деактивируем чек бокс ===
     * @param checkbox - Наименование чекбокса
     */
    @Step(value = "Активация чекбокса {checkbox}")
    public ClickCheckbox clickCheckbox(String checkbox) {
        serviceCheckBox(checkbox);
        return this;
    }

    /**
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     */
    @Step(value = "Активация чекбоксов по коллекции элементов")
    public ClickCheckbox clickCheckboxes(String titleName) {
        serviceClickCheckboxes(titleName);
        return this;
    }

    /**
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     * @param milliseconds - Ожидание перед зачаном выполнения метода
     */
    @Step(value = "Активация чекбоксов по коллекции элементов с ожиданием {milliseconds} миллисекунд")
    public ClickCheckbox clickCheckboxes(String titleName, int milliseconds) {
        serviceClickCheckboxes(titleName, milliseconds);
        return this;
    }
}
