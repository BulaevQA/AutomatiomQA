package core.main;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class Input {

    private final SelenideElement search = $x("//button[contains(@class, 'd-none')]/preceding-sibling::input");

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputField(String field, String value) {
        $x("//*[text()[normalize-space() = '"+field+"']]/..//input").should(visible, editable).clear();
        $x("//*[text()[normalize-space() = '"+field+"']]/..//input").setValue(value);
    }

    private void serviceInputField(String field, String value, String index) {
        $x("(//*[text()[normalize-space() = '"+field+"']]/..//input)["+index+"]")
                .should(visible, editable).clear();
        $x("(//*[text()[normalize-space() = '"+field+"']]/..//input)["+index+"]").setValue(value);
    }

    private void serviceInputIframe(String field, String value) {
        $x("//*[text()[normalize-space() = '"+field+"']]/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe").should(exist);
        switchTo().frame($x("//*[text()[normalize-space() = '"+field+"']]/preceding-sibling::div" +
                "[@class='tox tox-tinymce']/descendant::iframe"));
        $x("//body/p").should(editable).setValue(value);
        switchTo().defaultContent();
    }

    private void serviceInputTextArea(String field, String value) {
        $x("//*[text()[normalize-space() = '"+field+"']]/..//textarea").should(enabled).click();
        $x("//*[text()[normalize-space() = '"+field+"']]/..//textarea").should(editable).setValue(value);
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     */
    @Step(value = "Заполняем поле \"{field}\" значением \"{value}\"")
    public Input inputStringField(String field, String value) {
        serviceInputField(field, value);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле \"{field}\" значением \"{value}\"")
    public Input inputStringField(String field, String value, String index) {
        serviceInputField(field, value, index);
        return this;
    }

    /**
     * === Заполнение HTML поля, путем переклчюения на iframe ===
     * @param field - Наименование поля
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле \"{field}\" значением \"{value}\"")
    public Input inputIframeField(String field, String value) {
        serviceInputIframe(field, value);
        return this;
    }

    /**
     === Заполнение поле типа textarea ===
     * @param field - Наименование поля
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле \"{field}\" значением \"{value}\"")
    public Input inputTextArea(String field, String value) {
        serviceInputTextArea(field, value);
        return this;
    }

    /**
     === Поисковая строка ===
     * @param value - Искомое значение
     */
    @Step(value = "Поиск значения \"{value}\" в поисковой выдаче")
    public Input searchField(String value) {
        search.should(visible, editable).clear();
        search.should(visible, editable).setValue(value);
        return this;
    }
}
