package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class InputValueDropDown {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputDropDown(String select, String value, String options) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(1500);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("//span[text()='" + select + "']/..//select").selectOption(options);
        }
    }

    private void serviceInputDropDown(String select, String value, String options, int milliseconds) {
        sleep(milliseconds);
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(milliseconds);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("//span[text()='" + select + "']/..//select").selectOption(options);
        }
    }

    private void serviceInputDropDown(String select, String value, String options, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(1500);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
        }
    }

    private void serviceInputDropDown(String select, String value, String options, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(1500);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
        }
    }

    private boolean serviceCheckDropDownOptions(String select, String value) {
        return $x("//*[text()='" + select + "']/..//select[@class='select__control']" +
                "//option[text()='" + value + "']").exists();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Заполняем поле этим значением
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {select} значением {value} и выбором значения {options}")
    public InputValueDropDown inputValueDropDown(String select, String value, String options) {
        serviceInputDropDown(select, value, options);
        return this;
    }

    /**
     * === Заполнение уникального поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Заполняем поле этим значением
     * @param options - Имя значения в выпадающем списке
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Заполняем поле {select} значением {value} и выбором значения {options}")
    public InputValueDropDown inputValueDropDown(String select, String value, String options, int milliseconds) {
        serviceInputDropDown(select, value, options, milliseconds);
        return this;
    }

    /**
     * === Заполнение повторяющееся поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     * @param options - Имя значения в выпадающем списке
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} с выбором {options} и позицией в DOM {index}")
    public InputValueDropDown inputValueDropDown(String select, String value, String options, String index) {
        serviceInputDropDown(select, value, options, index);
        return this;
    }

    /**
     * === Заполнение повторяющееся поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     * @param options - Имя значения в выпадающем списке
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} с выбором {options} и позицией в DOM {index}")
    public InputValueDropDown inputValueDropDown(String select, String value, String options, int milliseconds, String index) {
        serviceInputDropDown(select, value, options, milliseconds, index);
        return this;
    }
}
