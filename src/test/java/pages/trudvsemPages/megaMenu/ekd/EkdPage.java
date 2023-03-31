package pages.trudvsemPages.megaMenu.ekd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EkdPage {

    private final SelenideElement pageTitle = $x("//h1[@class][text()[normalize-space()='Информация об " +
            "Электронном кадровом документообороте на портале «Работа в России»']]");

    /**
     === Получение заголовка страницы ===
     */
    @Step(value = "Получение заголовка страницы")
    public boolean checkPageTitle() {
        return pageTitle.should(visible).exists();
    }
}
