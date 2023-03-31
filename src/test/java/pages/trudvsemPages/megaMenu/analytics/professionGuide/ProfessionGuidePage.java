package pages.trudvsemPages.megaMenu.analytics.professionGuide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class ProfessionGuidePage {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Справочник востребованных профессий']]");

    /**
     === Получение заголовка страницы ===
     */
    @Step(value = "Получение заголовка страницы")
    public boolean checkPageTitle() {
        return pageTitle.should(visible).exists();
    }
}
