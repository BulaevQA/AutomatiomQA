package pages.trudvsem.mainPrr;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            megaMenuUser = $x("//button[@id='megaMenuDropdownUser']"),
            myName = $x("//span[@class='mega-menu__user-name']"),
            myCompanyName = $x("//span[@class='mega-menu__user-text']");

    ///////////////// Методы взаимодействя со страницей \\\\\\\\\\\\\\\\\\\

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
