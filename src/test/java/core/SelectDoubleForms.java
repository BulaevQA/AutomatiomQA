package core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SelectDoubleForms {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceDoubleFieldForms(String select, String options, String value) {
        $x("//*[text()='" + select + "']//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(Condition.enabled).click();
        $x("//*[text()='" + select + "']//following-sibling::div//" +
                "select[not(contains(@data-change-block, 'remove-form'))]").selectOption(options);
        $x("//*[text()='" + select + "']//following-sibling::div//" +
                "input[not(contains(@data-change-block, 'remove-form'))]").should(Condition.editable).setValue(value);
    }

    private void serviceDoubleFieldForms(String select, String options, String value, String index) {
        $x("(//*[text()='" + select + "']//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))])[" + index + "]").should(Condition.enabled).click();
        $x("(//*[text()='" + select + "']//following-sibling::div//select" +
                "[not(contains(@data-change-block, 'remove-form'))])[" + index + "]").selectOption(options);
        $x("//*[text()='" + select + "']//following-sibling::div//input" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(Condition.editable).setValue(value);
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального "двойного поля" (Селект + обычное поле) ===
     * @param select  - select - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {select} значением {value} c выбором {options}")
    public SelectDoubleForms selectDoubleField(String select, String options, String value) {
        serviceDoubleFieldForms(select, options, value);
        return this;
    }

    /**
     * === Заполнение уникального "двойного поля" (Селект + обычное поле) ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value   - Значение, которым заполяем поле
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} c выбором {options} и позицией в DOM {index}")
    public SelectDoubleForms selectDoubleField(String select, String options, String value, String index) {
        serviceDoubleFieldForms(select, options, value, index);
        return this;
    }
}
