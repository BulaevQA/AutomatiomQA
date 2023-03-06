package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.ScreenshotMethod;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainCvPage extends ScreenshotMethod {

    private final static SelenideElement MY_CABINET = $x("//h1");
    private final static SelenideElement CLOSE_COOKIES = $x("//div[@class='col-12 col-md-3 col-lg-2']");
    private final static SelenideElement CREATE_RESUME = $x("//a[@class='button group-container__item']");

    @Step(value = "Проверка главной страницы")
    public MainCvPage mainCandidatePage(String value){
        MY_CABINET.shouldBe(Condition.text(value));
        attachScreenshot();
        return this;
    }
    @Step(value = "Закрыть уведомление")
    public MainCvPage buttonCloseCookie(){
        CLOSE_COOKIES.click();
        return this;
    }
    @Step(value = "Клик создать резюме")
    public ResumeConstructorPage buttonCreateResume(){
        CREATE_RESUME.click();
        return new ResumeConstructorPage();
    }
}
