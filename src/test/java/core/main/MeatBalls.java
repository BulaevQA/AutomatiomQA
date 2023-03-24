package core.main;

import com.codeborne.selenide.SelenideElement;

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
     * @param milliseconds - таймер ожидания перед кликом на митбол(для стабильности теста)
     */
    public void serviceMeatBalls(int milliseconds) {
        sleep(milliseconds);
        meatBalls.click();
        switchTo().activeElement();
    }
}
