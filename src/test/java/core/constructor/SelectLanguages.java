package core.constructor;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class SelectLanguages {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceSelectLanguages(String language, String lvl) {
        $x("//div[@*='languages']//fieldset//button[not(contains(@title, 'Базовый'))]").should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(language);
        $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+language+"']")
                .should(exist, editable).click();
        $x("//div[@*='languages']//fieldset//button[contains(@title, 'Базовый')]").should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//span[text()='"+lvl+"']").should(exist, visible).click();
    }

    private void serviceSelectLanguages(String language, String lvl, String index) {
        $x("(//div[@*='languages']//fieldset//button[not(contains(@title, 'Базовый'))])["+index+"]")
                .should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//input").should(visible, editable).setValue(language);
        $x("//div[@class='dropdown-menu show']//div[@class='inner show']//a//span[text()='"+language+"']")
                .should(exist, editable).click();
        $x("//div[@*='languages']//fieldset//button[contains(@title, 'Базовый')]["+index+"]")
                .should(visible, enabled).click();
        $x("//div[@class='dropdown-menu show']").should(exist, visible);
        $x("//div[@class='dropdown-menu show']//span[text()='"+lvl+"']").should(exist, visible).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполняем поля знания языков ===
     * @param language - Значение, которым заполяем поле
     * @param options  - Имя значения в выпадающем списке
     */
    @Step(value = "Выбираем {value} язык с уровнем владения {options}")
    public SelectLanguages selectLanguage(String language, String options) {
        serviceSelectLanguages(language, options);
        return this;
    }

    /**
     * === Заполняем поля знания языков ===
     * @param language - Значение, которым заполяем поле
     * @param options  - Имя значения в выпадающем списке
     * @param index - Позиция элемента в DOM
     */
    @Step(value = "Выбираем {value} язык с уровнем владения {options}")
    public SelectLanguages selectLanguage(String language, String options, String index) {
        serviceSelectLanguages(language, options, index);
        return this;
    }
}
