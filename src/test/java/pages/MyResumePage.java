package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MyResumePage {

    private final static SelenideElement MY_RESUME = $x("//h1");
    private final static SelenideElement UPDATE_RESUME = $x("//button[@data-action='republish']");

    @Step(value = "Проверка страницы Мои резюме")
    public String myResumeCheck(){
        return MY_RESUME.getText();
    }
    public MyResumePage updateResume() {
        UPDATE_RESUME.click();
        return this;
    }
    //button[@data-action='republish']
}
