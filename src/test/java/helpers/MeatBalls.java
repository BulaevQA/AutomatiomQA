package helpers;

import com.codeborne.selenide.SelenideElement;
import pages.core.CorePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class MeatBalls {

    CorePage corePage = new CorePage();

    /**
     === XPath для клика на митбол ===
     */
    private final SelenideElement meatBalls = $x("(//div[@class='row row_middle']//div[@class='col-auto']" +
            "//button[@data-toggle='dropdown'])[last()]");

    /**
     === Метод клика на митбол ===
     * @param milliseconds - таймер ожидания перед кликом на митбол(для стабильности теста)
     */
    public void serviceMeatBalls(int milliseconds) {
        corePage.sleeper(milliseconds);
        meatBalls.click();
        switchTo().activeElement();
    }
}
