package core.fields;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.other.ElementCollections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class DropDown {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputDropDown(String select, String value) {
        sleep(1000);
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button[@aria-expanded='false']")
                .should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(visible).clear();
        $x("//div[@class='dropdown-menu show']//input").should(editable).setValue(value);
        sleep(1000);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(visible, enabled).click();
        } else {
            $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//select").should(exist).selectOption(value);
        }
    }

    private void serviceInputDropDown(String select, String value, String index) {
        sleep(1000);
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button[@aria-expanded='false'])["+index+"]")
                .should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(visible).clear();
        $x("//div[@class='dropdown-menu show']//input").should(editable).setValue(value);
        sleep(1000);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(visible, enabled).click();
        } else {
            $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//select)["+index+"]")
                    .should(exist).selectOption(value);
        }
    }

    private boolean serviceCheckDropDownOptions(String select, String value) {
       return  $x("//*[text()[normalize-space() = '"+select+"']]/..//select[@class='select__control']" +
               "//option[text()[normalize-space() = '"+value+"']]").exists();
    }

    private void serviceSelectDropDown(String select, String options) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button[@aria-expanded='false']")
                .should(visible, enabled).click();
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//select").should(exist).selectOption(options);
    }

    private void serviceSelectDropDown(String select, String options, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button[@aria-expanded='false'])["+index+"]")
                .should(visible, enabled).click();
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//select)["+index+"]")
                .should(exist).selectOption(options);
    }

    private void serviceRandomDropDown(String select) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button[@aria-expanded='false']")
                .should(visible, enabled).click();
        new ElementCollections().randomElementCollectionClick(
                $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    private void serviceRandomDropDown(String select, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button[@aria-expanded='false'])["+index+"]")
                .should(visible, enabled).click();
        new ElementCollections().randomElementCollectionClick
                ($$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Заполняем поле этим значением
     */
    @Step(value = "Заполняем поле {select} значением {value} и выбором значения {options}")
    public DropDown inputValueDropDown(String select, String value) {
        serviceInputDropDown(select, value);
        return this;
    }

    /**
     * === Заполнение повторяющееся поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} с выбором {options} и позицией в DOM {index}")
    public DropDown inputValueDropDown(String select, String value, String index) {
        serviceInputDropDown(select, value, index);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором конкретного значения ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {select} c выбором {options}")
    public DropDown selectDropDown(String select, String options) {
        serviceSelectDropDown(select, options);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} c выбором {options} и позицией в DOM {index}")
    public DropDown selectDropDown(String select, String options, String index) {
        serviceSelectDropDown(select, options, index);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     */
    @Step(value = "Кликаем на поле {select} и заполняем случайным значением")
    public DropDown selectRandomIntoDropDown(String select) {
        serviceRandomDropDown(select);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} с позицией в DOM {index}")
    public DropDown selectRandomIntoDropDown(String select, String index) {
        serviceRandomDropDown(select, index);
        return this;
    }
}
