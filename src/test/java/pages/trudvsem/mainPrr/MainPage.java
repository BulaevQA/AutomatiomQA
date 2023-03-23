package pages.trudvsem.mainPrr;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import core.ImportFile;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement myCabinet = $x("//h1");
    private final SelenideElement megaMenuUser = $x("//button[@id='megaMenuDropdownUser']");

    private final SelenideElement buttonCreateResume = $x("//*[text()='Создать резюме']");
    private final SelenideElement myName = $x("//span[@class='mega-menu__user-name']");

    private final SelenideElement buttonCreateVacancy = $x("//h2[text()='Уведомления и события']/..//*[text()='Добавить вакансию']");
    private final SelenideElement myCompanyName = $x("//span[@class='mega-menu__user-text']");

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
        megaMenuUser.click();
        switchTo().activeElement();
        sleep(1500);
        return myName.getText();
    }

    /**
     === Получение наименования компании ===
     */
    @Step(value = "Проверка наименования организации")
    public String myCompanyCheck() {
        megaMenuUser.click();
        switchTo().activeElement();
        sleep(1500);
        return myCompanyName.getText();
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
