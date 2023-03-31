package pages.trudvsemPages.mainPrrPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Мой кабинет']]"),
            megaMenuUser = $x("//button[@id='megaMenuDropdownUser']"),
            myName = $x("//span[@class='mega-menu__user-name']"),
            myCompanyName = $x("//span[@class='mega-menu__user-text']");
    ///////////////// Методы взаимодействя со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Сравнение заголовка страницы ===
     */
    @Step(value = "Получение заголоска страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }

    /**
     === Получение имени соискателя ===
     */
    @Step(value = "Проверка имени соискателя")
    public String myNameCheck() {
        megaMenuUser.should(visible, enabled).click();
        switchTo().activeElement();
        return myName.should(exist, visible).getText();
    }

    /**
     === Получение наименования компании ===
     */
    @Step(value = "Проверка наименования организации")
    public String myCompanyCheck() {
        megaMenuUser.should(visible, enabled).click();
        switchTo().activeElement();
        return myCompanyName.should(exist, visible).getText();
    }
}
