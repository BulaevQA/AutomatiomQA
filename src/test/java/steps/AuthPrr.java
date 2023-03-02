package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import owner.OwnerData;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPrr extends OwnerData {

    @Step(value = "Клик войти")
    public AuthPrr clickLogIn() {
        $x("//span[@class='mega-menu__user-handler']").click();
        return this;
    }
    @Step(value = "Авторизация через ЕСИА")
    public AuthPrr clickESIA() {
        $x("//div[@class='mb-3 row']").click();
        return this;
    }
    @Step(value = "Ввод логина")
    public AuthPrr setLogin(String value) {
        $x("//input[@id='login']").setValue(value);
        return this;
    }
    @Step(value = "Ввод пароля")
    public AuthPrr setPassword(String value) {
        $x("//input[@id='password']").setValue(value)
                .sendKeys(Keys.ENTER);
        return this;
    }
    @Step(value = "Выбор соискателя")
    public void clickCV() {
        $x("//button[@id='individual_button']").click();
    }
}