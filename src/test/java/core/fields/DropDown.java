package core.fields;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;
import static core.classObjects.ClassObjects.elementCollections;

public class DropDown {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputDropDown(String select, String value) {
        final SelenideElement optionExist = $x("//div[@class='dropdown-menu show']//div[@class='inner show']" +
                "//a//span[text()='"+value+"']");
        sleep(1000);
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button").should(exist, visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).clear();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(value);
        sleep(1500);
        if(optionExist.exists()) {
            $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+value+"']")
                    .should(exist, editable).click();
        } else {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(exist, visible).click();
        }
    }

    private void serviceInputDropDown(String select, String value, String index) {
        final SelenideElement optionExist = $x("//div[@class='dropdown-menu show']//div[@class='inner show']" +
                "//a//span[text()='"+value+"']");
        sleep(1000);
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button)["+index+"]")
                .should(exist, visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).clear();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(value);
        sleep(1000);
        if(optionExist.exists()) {
            $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+value+"']")
                    .should(exist, editable).click();
        } else {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(exist, visible).click();
        }
    }

    private void serviceSelectDropDown(String select, String value) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button").should(exist, visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+value+"']")
                .should(exist, editable).click();
    }

    private void serviceSelectDropDown(String select, String value, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button)["+index+"]").should(exist, visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+value+"']")
                .should(exist, editable).click();
    }

    private void serviceRandomDropDown(String select) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button")
                .should(exist, visible, enabled).click();
        elementCollections.randomElementCollectionClick(
                $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    private void serviceRandomDropDown(String select, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button)["+index+"]")
                .should(exist, visible, enabled).click();
        elementCollections.randomElementCollectionClick
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
