package core.constructor;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ToggleSwitch {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\


    private void serviceToggle(String toggle) {
        $x("//*[normalize-space(text())='"+toggle+"']/..").should(Condition.enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Переключатели в конструкторе резюме ===
     * @param toggle - Имя переключателя
     */
    @Step(value = "Активируем/Деативируем переключатель {toggle}")
    public ToggleSwitch switchToggle(String toggle) {
        serviceToggle(toggle);
        return this;
    }
}
