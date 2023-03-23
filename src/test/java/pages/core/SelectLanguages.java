package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SelectLanguages {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceSelectLanguages(String language, String options) {
        $x("//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[not(contains(@title, 'Базовый'))]").should(Condition.enabled).click();
        $x("//*[text()='Владение языками']/following-sibling::div//select[not(contains(@class, 'button'))]" +
                "[not(contains(@id, 'know'))]").selectOption(language);
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']").click();
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']" +
                "/..//select").selectOption(options);
    }

    private void serviceSelectLanguages(String language, String options, String index) {
        $x("(//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[not(contains(@title, 'Базовый'))])[" + index + "]").should(Condition.enabled).click();
        $x("(//*[text()='Владение языками']/following-sibling::div//select[not(contains(@class, 'button'))]" +
                "[not(contains(@id, 'know'))])[not(contains(@name, 'proficiency-level'))]" +
                "[" + index + "]").selectOption(language);
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']").click();
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']" +
                "/..//select").selectOption(options);
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
