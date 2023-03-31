package pages.trudvsemPages.vacancyPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class VacancyConstructorPage {
    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Создание вакансии']]");

    /**
     === Сравнение заголовка страницы ===
     */
    @Step(value = "Получение заголоска страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }
}
