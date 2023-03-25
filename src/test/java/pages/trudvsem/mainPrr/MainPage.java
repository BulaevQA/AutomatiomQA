package pages.trudvsem.mainPrr;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import core.constructor.ImportFile;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement
            myCabinet = $x("//h1"),
            megaMenuUser = $x("//button[@id='megaMenuDropdownUser']"),
            buttonCreateResume = $x("//*[text()='Создать резюме']"),
            myName = $x("//span[@class='mega-menu__user-name']"),
            buttonCreateVacancy = $x("//h2[text()='Уведомления и события']/..//*[text()='Добавить вакансию']"),
            myCompanyName = $x("//span[@class='mega-menu__user-text']");

    ///////////////// Методы взаимодействя со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Получения заголовка страницы ===
     */
    @Step(value = "Получение заголовка главной страницы")
    public String mainPageTitle() {
        return myCabinet.getText();
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

    /**
     === Клик на кнопку Создать резюме ===
     */
    @Step(value = "Клик на кнопку Создать резюме")
    public ImportFile buttonCreateResume() {
        buttonCreateResume.click();
        return new ImportFile();
    }

    /**
     === Клик на кнопку Создать вакансию ===
     */
    @Step(value = "Клик на кнопку Создать вакансию")
    public ImportFile buttonCreateVacancy() {
        buttonCreateVacancy.click();
        return new ImportFile();
    }
}
