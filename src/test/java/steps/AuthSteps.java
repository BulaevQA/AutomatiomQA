package steps;

import io.qameta.allure.Step;
import methods.TextValidator;
import org.openqa.selenium.Keys;
import owner.OwnerData;

import static com.codeborne.selenide.Selenide.$x;

public class AuthSteps {
    OwnerData ownerData = new OwnerData();
    TextValidator textValidator = new TextValidator();
    /*
    Авторизация под соискателем
    */
    @Step(value = "Клик войти")
    public AuthSteps buttonLogin() {
        $x("//span[@class='mega-menu__user-handler']").click();
        return this;
    }
    @Step(value = "Авторизация через ЕСИА")
    public AuthSteps buttonEsiaAuth() {
        $x("//div[@class='mb-3 row']").click();
        return this;
    }
    @Step(value = "Ввод логина")
    public AuthSteps fieldLogin() {
        $x("//input[@id='login']").setValue(System.getProperty("login","admin"));
        return this;
    }
    @Step(value = "Ввод пароля")
    public AuthSteps fieldPassword() {
        $x("//input[@id='password']").setValue((System.getProperty("password","admin")))
                .sendKeys(Keys.ENTER);
        return this;
    }
    @Step(value = "Выбор соискателя")
    public AuthSteps clickCv() {
        $x("//button[@id='individual_button']").click();
        return this;
    }
    @Step(value = "Проверка главной страницы")
    public AuthSteps myСabinetCheck(){
        textValidator.checkText("//h1[@class='content__title']", "Мой кабинет");
        return this;
    }
    @Step(value = "Закрыть уведомление")
    public AuthSteps buttonCloseCookie(){
        $x("//div[@class='col-12 col-md-3 col-lg-2']").click();
        return this;
    }
}