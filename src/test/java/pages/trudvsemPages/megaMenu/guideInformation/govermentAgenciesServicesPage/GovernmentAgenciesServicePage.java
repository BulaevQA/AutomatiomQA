package pages.trudvsemPages.megaMenu.guideInformation.govermentAgenciesServicesPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GovernmentAgenciesServicePage {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Органы государственной службы занятости населения']]");

    /**
     === Получение заголовка страницы ===
     */
    @Step(value = "Получение заголовка страницы")
    public boolean checkPageTitle() {
        return pageTitle.should(visible).exists();
    }
}
