package pages.trudvsemPages.megaMenu.foreignWork.tadzhikistanPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TadzhikistanPage {

    private final SelenideElement
            pageTitle = $x("//h1[@class]//span[text()[normalize-space()='Республика Таджикистан']]");

    /**
     === Провека заголовка страницы ===
     */
    @Step(value = "Проверка заголовка страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }
}
