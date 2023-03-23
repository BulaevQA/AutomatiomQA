package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class InputIframe {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputIframe(String field, String value) {
        $x("//*[text()='" + field + "']/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe").should(Condition.exist);
        switchTo().frame($x("//*[text()='" + field + "']/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe"));
        $x("//body/p").should(Condition.editable).setValue(value);
        switchTo().defaultContent();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение HTML поля, путем переклчюения на iframe ===
     * @param field - Наименование поля
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public InputIframe inputIframeField(String field, String value) {
        serviceInputIframe(field, value);
        return this;
    }
}
