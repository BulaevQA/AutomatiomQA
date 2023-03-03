package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import owner.OwnerData;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPrr extends OwnerData {
    /*
    Авторизация под соискателем
    */
    @Step(value = "Клик войти")
    public AuthPrr clickLogIn() {
        $x("//span[@class='mega-menu__user-handler']").click();
        return this;
    }
    @Step(value = "Авторизация через ЕСИА")
    public AuthPrr clickEsia() {
        $x("//div[@class='mb-3 row']").click();
        return this;
    }
    @Step(value = "Ввод логина")
    public AuthPrr setLogin() {
        $x("//input[@id='login']").setValue(System.getProperty("login","admin"));
        return this;
    }
    @Step(value = "Ввод пароля")
    public AuthPrr setPassword() {
        $x("//input[@id='password']").setValue((System.getProperty("password","admin")))
                .sendKeys(Keys.ENTER);
        return this;
    }
    @Step(value = "Выбор соискателя")
    public void clickCV() {
        $x("//button[@id='individual_button']").click();
    }
}