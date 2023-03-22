package helpers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class InfoBlockHealth {

    /**
     === XPath для проверки наличия "Кранов" на странице
     */
    private final SelenideElement errorInfoBlock = $x("//div[@class='ib-error']");

    /**
     === Метот поиска кранов на странице ===
     */
    @Step(value = "Проверка наличия упавших инфоблоков на странице")
    public boolean errorInfoBlock() {
        return errorInfoBlock.exists();
    }
}
