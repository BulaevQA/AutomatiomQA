package pages.trudvsem.mainPrr;

import com.codeborne.selenide.SelenideElement;
import helpers.HashMaps;
import pages.core.InfoBlockHealth;
import io.qameta.allure.Step;
import pages.core.ImportPhoto;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    private final SelenideElement myCabinet = $x("//h1");
    private final SelenideElement megaMenuUser = $x("//button[@id='megaMenuDropdownUser']");

    private final SelenideElement buttonCreateResume = $x("//*[text()='Создать резюме']");
    private final SelenideElement myName = $x("//span[@class='mega-menu__user-name']");

    private final SelenideElement buttonCreateVacancy = $x("//h2[text()='Уведомления и события']/..//*[text()='Добавить вакансию']");
    private final SelenideElement myCompanyName = $x("//span[@class='mega-menu__user-text']");

    /**
     === hashmap для соискателя ===
     */
    public Map<String, Object> actualAttributesCv() {
        return new HashMap<String, Object>() {{
            put(HashMaps.infoBlockError, new InfoBlockHealth().errorInfoBlock());
            put(HashMaps.myCabinetTitle, mainPageTitle());
            put(HashMaps.myName, myNameCheck());
        }};
    }

    /**
     === hashmap для работодателя ===
     */
    public Map<String, Object> actualAttributesManager() {
        return new HashMap<String, Object>() {{
            put(HashMaps.infoBlockError, new InfoBlockHealth().errorInfoBlock());
            put(HashMaps.myCabinetTitle, mainPageTitle());
            put(HashMaps.companyName, myCompanyCheck());
        }};
    }

    ///////////////// Методы взаимодействя со страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Получения заголовка страницы ===
     */
    @Step(value = "Получение заголовка главной страницы")
    private String mainPageTitle() {
        return myCabinet.getText();
    }

    /**
     === Получение имени соискателя ===
     */
    @Step(value = "Проверка имени соискателя")
    private String myNameCheck() {
        megaMenuUser.click();
        switchTo().activeElement();
        sleep(1500);
        return myName.getText();
    }

    /**
     === Получение наименования компании ===
     */
    @Step(value = "Проверка наименования организации")
    private String myCompanyCheck() {
        megaMenuUser.click();
        switchTo().activeElement();
        sleep(1500);
        return myCompanyName.getText();
    }

    /**
     === Клик на кнопку Создать резюме ===
     */
    @Step(value = "Клик на кнопку Создать резюме")
    public ImportPhoto buttonCreateResume() {
        buttonCreateResume.click();
        return new ImportPhoto();
    }

    /**
     === Клик на кнопку Создать вакансию ===
     */
    @Step(value = "Клик на кнопку Создать вакансию")
    public ImportPhoto buttonCreateVacancy() {
        buttonCreateVacancy.click();
        return new ImportPhoto();
    }
}
