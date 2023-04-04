package core.main;

import base.BrowserConfig;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MeatBalls extends BrowserConfig {

    /**
     === XPath для клика на митбол ===
     */
    private final SelenideElement meatBalls = $x("//div[@class='col-auto']//button[@data-toggle='dropdown']");

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод клика на митбол ===
     */
    @Step(value = "Клик на кнопку \"митбол\"")
    public void serviceMeatBalls() {
        meatBalls.should(exist, visible, enabled).click();
        switchTo().activeElement();
    }
}
