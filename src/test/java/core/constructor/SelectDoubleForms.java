package core.constructor;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class SelectDoubleForms {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceDoubleFieldForms(String select, String options, String value) {
        $x("//*[text()[normalize-space() = '"+select+"']]//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(visible, enabled).click();
        $x("//*[text()[normalize-space() = '"+select+"']]//following-sibling::div//" +
                "select[not(contains(@data-change-block, 'remove-form'))]").should(exist).selectOption(options);
        $x("//*[text()[normalize-space() = '"+select+"']]//following-sibling::div//" +
                "input[not(contains(@data-change-block, 'remove-form'))]").should(visible, editable).setValue(value);
    }

    private void serviceDoubleFieldForms(String select, String options, String value, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))])["+index+"]").should(visible, enabled).click();
        $x("(//*[text()[normalize-space() = '"+select+"']]//following-sibling::div//select" +
                "[not(contains(@data-change-block, 'remove-form'))])["+index+"]").should(exist).selectOption(options);
        $x("//*[text()[normalize-space() = '"+select+"']]//following-sibling::div//input" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(editable).setValue(value);
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального "двойного поля" (Селект+обычное поле) ===
     * @param select  - select - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем селект \"{select}\" значением \"{value}\" c выбором \"{options}\"")
    public SelectDoubleForms selectDoubleField(String select, String options, String value) {
        serviceDoubleFieldForms(select, options, value);
        return this;
    }

    /**
     * === Заполнение уникального "двойного поля" (Селект+обычное поле) ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value   - Значение, которым заполяем поле
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем селект \"{select}\" значением \"{value}\" c выбором \"{options}\"")
    public SelectDoubleForms selectDoubleField(String select, String options, String value, String index) {
        serviceDoubleFieldForms(select, options, value, index);
        return this;
    }
}
