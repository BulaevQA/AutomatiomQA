package core.fields;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;
import static core.classObjects.ClassObjects.elementCollections;

public class DropDown {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputDropDown(String select, String value) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button").should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).clear();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(value);
        $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+value+"']")
                .should(appear).click();
    }

    private void serviceInputDropDown(String select, String value, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button)["+index+"]")
                .should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).clear();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(value);
        $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+value+"']")
                .should(appear).click();
    }

    private void serviceInputNewDropDown(String select, String value) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button").should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).clear();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(value);
        $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(enabled).click();
    }

    private void serviceInputNewDropDown(String select, String value, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label//button)["+index+"]")
                .should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).clear();
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(value);
        $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(enabled).click();
    }

    private void serviceSelectDropDown(String select, String value) {
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label")
                .should(exist, visible, enabled).click();
        $x("//*[text()[normalize-space() = '"+select+"']]/ancestor::label//option" +
                "[text()[normalize-space() = '"+value+"']]").should(exist, enabled).click();
    }

    private void serviceSelectDropDown(String select, String value, String index) {
        $x("(//*[text()[normalize-space() = '"+select+"']]/ancestor::label)["+index+"]")
                .should(exist, visible, enabled).click();
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
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
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
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown inputValueDropDown(String select, String value, String index) {
        serviceInputDropDown(select, value, index);
        return this;
    }

    /**
     === Добабление нового значения селекта в справочник ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     */
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown inputNewValueDropDown(String select, String value) {
        serviceInputNewDropDown(select, value);
        return this;
    }

    /**
     === Добабление нового значения селекта в справочник ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown inputNewValueDropDown(String select, String value, String index) {
        serviceInputNewDropDown(select, value, index);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором конкретного значения ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown selectDropDown(String select, String options) {
        serviceSelectDropDown(select, options);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown selectDropDown(String select, String options, String index) {
        serviceSelectDropDown(select, options, index);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     */
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown selectRandomIntoDropDown(String select) {
        serviceRandomDropDown(select);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Выбираем в селекте \"{select}\" значение \"{value}\"")
    public DropDown selectRandomIntoDropDown(String select, String index) {
        serviceRandomDropDown(select, index);
        return this;
    }
}
