package pages.myResumePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static helpers.ScreenshotMethod.attachScreenshot;

public class MyResumePage {

    private final SelenideElement myResume = $x("//div[@class='ib-cv-review']//h1");
    private final SelenideElement updateResume = $x("//button[@data-action='republish']");

    @Step(value = "Проверка страницы {value}")
    public MyResumePage myResumeCheck(String value){
        myResume.shouldBe(Condition.text(value));
        attachScreenshot();
        return this;
    }
    @Step(value = "Обновление резюме")
    public MyResumePage updateResume(){
        updateResume.click();
        return this;
    }
}
