package pages.trudvsemPages.mainPrrPage;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static core.classObjects.ClassObjects.testValues;

public class MainPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Мой кабинет']]"),
            megaMenuUser = $x("//button[@id='megaMenuDropdownUser']"),
            myName = $x("//span[@class='mega-menu__user-name']"),
            myCompanyName = $x("//span[@class='mega-menu__user-text']");

    private final ElementsCollection actualMegaMenu = $$x("//div[@class='mega-menu__content']//a");

    ///////////////// Методы взаимодействя со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Провека заголовка страницы ===
     */
    @Step(value = "Проверка заголовка страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }

    /**
     === Получение имени соискателя ===
     */
    @Step(value = "Получение имени соискателя")
    public String myNameCheck() {
        megaMenuUser.should(visible, enabled).click();
        switchTo().activeElement();
        return myName.should(exist, visible).getText();
    }

    /**
     === Получение наименования компании ===
     */
    @Step(value = "Получение наименования организации")
    public String myCompanyCheck() {
        megaMenuUser.should(visible, enabled).click();
        switchTo().activeElement();
        return myCompanyName.should(exist, visible).getText();
    }

    /**
     * === Получение актульных ссылок в мегаменю ===
     */
    @Step(value = "Получение актуальных ссылок в мегаменю")
    public ElementsCollection checkMegaMenu() {
        return actualMegaMenu.should(CollectionCondition.texts(testValues.megaMenuList()));
    }
}
