package pages.trudvsemPages.megaMenu.educationPrograms;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class EducationProgramsPage {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Образовательные программы в г Москва']]");

    /**
     === Провека заголовка страницы ===
     */
    @Step(value = "Проверка заголовка страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }
}
