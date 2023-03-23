package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class InputValueField {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceInputField(String field, String value) {
        $x("//*[text()='" + field + "']/..//input").should(Condition.editable).clear();
        $x("//*[text()='" + field + "']/..//input").setValue(value);
    }

    private void serviceInputField(String field, String value, int milliseconds) {
        sleep(milliseconds);
        $x("//*[text()='" + field + "']/..//input").should(Condition.editable).clear();
        $x("//*[text()='" + field + "']/..//input").setValue(value);
    }

    private void serviceInputField(String field, String value, String index) {
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").should(Condition.editable).clear();
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").setValue(value);
    }

    private void serviceInputField(String field, String value, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").should(Condition.editable).clear();
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").setValue(value);
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public InputValueField inputValueField(String field, String value) {
        serviceInputField(field, value);
        return this;
    }

    /**
     * === Заполнение уникального поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public InputValueField inputValueField(String field, String value, int milliseconds) {
        serviceInputField(field, value, milliseconds);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} значением {value} с позицией в DOM {index}")
    public InputValueField inputValueField(String field, String value, String index) {
        serviceInputField(field, value, index);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param milliseconds - Ожидание перед началом выполнения метода
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} значением {value} с позицией в DOM {index}")
    public InputValueField inputValueField(String field, String value, int milliseconds, String index) {
        serviceInputField(field, value, milliseconds, index);
        return this;
    }
}
