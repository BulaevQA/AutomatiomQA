package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class UserSelectPage {

    private final static SelenideElement CV_CONFIRM = $x("//button[@id='individual_button']");
    @Step(value = "Выбор соискателя")
    public MainCvPage clickCv() {
        CV_CONFIRM.click();
        return new MainCvPage();
    }
}
