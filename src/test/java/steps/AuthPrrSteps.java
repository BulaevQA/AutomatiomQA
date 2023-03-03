package steps;

import io.qameta.allure.Step;
import methods.TextValidator;
import org.openqa.selenium.Keys;
import owner.OwnerData;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPrrSteps {
    OwnerData ownerData = new OwnerData();
    TextValidator textValidator = new TextValidator();
    /*
    Авторизация под соискателем
    */
    @Step(value = "Клик войти")
    public AuthPrrSteps clickLogIn() {
        $x("//span[@class='mega-menu__user-handler']").click();
        return this;
    }
    @Step(value = "Авторизация через ЕСИА")
    public AuthPrrSteps clickEsia() {
        $x("//div[@class='mb-3 row']").click();
        return this;
    }
    @Step(value = "Ввод логина")
    public AuthPrrSteps setLogin() {
        $x("//input[@id='login']").setValue(System.getProperty("login","admin"));
        return this;
    }
    @Step(value = "Ввод пароля")
    public AuthPrrSteps setPassword() {
        $x("//input[@id='password']").setValue((System.getProperty("password","admin")))
                .sendKeys(Keys.ENTER);
        return this;
    }
    @Step(value = "Выбор соискателя")
    public AuthPrrSteps clickCV() {
        $x("//button[@id='individual_button']").click();
        return this;
    }
    @Step(value = "Проверка главной страницы")
    public AuthPrrSteps myСabinetCheck(){
        textValidator.checkText("//h1[@class='content__title']", "Мой кабинет");
        return this;
    }
}