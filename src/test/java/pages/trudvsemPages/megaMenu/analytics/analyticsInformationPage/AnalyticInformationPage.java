package pages.trudvsemPages.megaMenu.analytics.analyticsInformationPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static core.classObjects.ClassObjects.testValues;

public class AnalyticInformationPage {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Аналитическая информация']]");

    /**
     === Получение заголовка страницы ===
     */
    @Step(value = "Получение заголовка страницы")
    public boolean checkPageTitle() {
        return pageTitle.should(visible).exists();
    }
}
