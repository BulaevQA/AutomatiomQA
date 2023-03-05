package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainCvPage {

    private final static SelenideElement MY_CABINET = $x("//h1[@class='content__title']");
    private final static SelenideElement CLOSE_COOKIES = $x("//div[@class='col-12 col-md-3 col-lg-2']");
    private final static SelenideElement CREATE_RESUME = $x("//a[@class='button group-container__item']");

    @Step(value = "Проверка главной страницы")
    public MainCvPage myСabinetCheck(){
        MY_CABINET.getText();
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
