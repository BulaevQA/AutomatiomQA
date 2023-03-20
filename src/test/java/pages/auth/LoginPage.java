package pages.auth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.constructors.ConstructorPage;
import pages.main.MainPage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    /**
     === Xpath для табов перекочбения между соискателем и работодателем ===
     */
    private final SelenideElement tabManager = $x("//button[@data-target='#employer']");
    private final SelenideElement tabCandidate = $x("//button[@data-target='#laborer']");

    /**
     === Xpath для заполнения полей email/пароль ===
     */
    private final SelenideElement emailField = $x("//input[@name='login']");
    private final SelenideElement passwordField = $x("//input[@name='password']");

    /**
     === Xpath для основных кнопок ===
     */
    private final SelenideElement authByEsia = $x("//*[text()='«Госуслуги»']");
    private final SelenideElement loginButton = $x("//button[text()='Войти']");
    private final SelenideElement registrationButton = $x("//a[@class='button button_plain'][text()='Зарегистрироваться']");

    ///////////////// Логика взаимодействия со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод авторизации через ЕСИА ===
     */
    @Step(value = "Авторизация через ЕСИА")
    public EsiaAuthFormPage buttonEsiaAuth() {
        authByEsia.click();
        return new EsiaAuthFormPage();
    }

    /**
     === Метод для переключения таба на работодателя ===
     */
    @Step(value = "Переход на таб работодателя")
    public LoginPage tabManager() {
        tabManager.click();
        return this;
    }

    /**
     === Метод для переключения таба на соискателя ===
     */
    @Step(value = "Переход на таб соискателя")
    public LoginPage tabCandidate() {
        tabCandidate.click();
        return this;
    }

    /**
     === Метод авторизации по упрощенной форме (через логин/пароль)
     * @param email - email работодателя для авторизации
     * @param password - пароль для авторизации работодаеля
     */
    public MainPage simpleAuthForm(String email, String password) {
        emailField.should(Condition.enabled).setValue(email);
        passwordField.should(Condition.enabled).setValue(password).sendKeys(Keys.ENTER);
        return new MainPage();
    }

    /**
     === Метод для перехода на страницу регистрации работодателя через логин/пароль ===
     */
    public ConstructorPage managerRegistration() {
        registrationButton.click();
        return new ConstructorPage();
    }

}
