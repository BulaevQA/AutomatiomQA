package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ClickRadioButton {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceRadioButton(String radioButton) {
        $x("//*[text()='" + radioButton + "']/ancestor::label[@class='radio']").should(Condition.enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Активация радиобаттона ===
     * @param radioButton - Наименование радиобаттона
     */
    @Step(value = "Активация радиобаттона {radioButton}")
    public ClickRadioButton clickRadioButton(String radioButton) {
        serviceRadioButton(radioButton);
        return this;
    }
}
