package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static helpers.ScreenshotMethod.attachScreenshot;

public class MyResumePage {

    private final static SelenideElement MY_RESUME = $x("//div[@class='ib-cv-review']//h1");
    private final static SelenideElement UPDATE_RESUME = $x("//button[@data-action='republish']");

    @Step(value = "Проверка страницы Мои резюме")
    public MyResumePage myResumeCheck(String value){
        MY_RESUME.shouldBe(Condition.text(value));
        attachScreenshot();
        return this;
    }
    @Step(value = "Обновление резюме")
    public MyResumePage updateResume(){
        UPDATE_RESUME.click();
        return this;
    }
}
