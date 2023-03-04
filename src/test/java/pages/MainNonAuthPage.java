package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainNonAuthPage {

    private static SelenideElement LOGIN = $x("//span[@class='mega-menu__user-handler']");

    @Step(value = "Переход на портал РВР")
    public void openUrl(String url){
        Selenide.open(url);
    }
    @Step(value = "Клик войти")
    public void buttonLogin() {
        LOGIN.click();
    }
}
