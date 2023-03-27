package core.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MeatBalls {

    /**
     === XPath для клика на митбол ===
     */
    private final SelenideElement meatBalls = $x("(//div[@class='row row_middle']//div[@class='col-auto']" +
            "//button[@data-toggle='dropdown'])[last()]");

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод клика на митбол ===
     */
    public void serviceMeatBalls() {
        meatBalls.should(exist, visible, enabled).click();
        switchTo().activeElement();
    }
}
