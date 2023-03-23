package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ClickButton {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceClickButton(String button) {
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, int milliseconds) {
        sleep(milliseconds);
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, String index) {
        $x("(//*[text()='" + button + "'])[" + index + "]").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//*[text()='" + button + "'])[" + index + "]").should(Condition.enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public ClickButton clickButton(String button) {
        serviceClickButton(button);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Кликаем на кнопку {button}")
    public ClickButton clickButton(String button, int milliseconds) {
        serviceClickButton(button, milliseconds);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public ClickButton clickButton(String button, String index) {
        serviceClickButton(button, index);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Кликаем на кнопку {button}")
    public ClickButton clickButton(String button, int milliseconds, String index) {
        serviceClickButton(button, milliseconds, index);
        return this;
    }
}
