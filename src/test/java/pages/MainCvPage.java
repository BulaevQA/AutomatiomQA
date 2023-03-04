package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainCvPage {

    private final static SelenideElement MY_CABINET = $x("//h1[@class='content__title']");
    private final static SelenideElement CLOSE_COOKIES = $x("//div[@class='col-12 col-md-3 col-lg-2']");

    @Step(value = "Проверка главной страницы")
    public String myСabinetCheck(){
        return MY_CABINET.getText();
    }
    @Step(value = "Закрыть уведомление")
    public void buttonCloseCookie(){
        CLOSE_COOKIES.click();
    }
}
