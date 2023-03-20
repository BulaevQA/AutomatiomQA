package pages.main;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.constructors.ConstructorPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement myCabinet = $x("//h1");
    private final SelenideElement buttonCreateResume = $x("//*[text()='Создать резюме']");
    private final SelenideElement buttonCreateVacancy = $x("//h2[text()='Уведомления и события']/..//*[text()='Добавить вакансию']");
    private final SelenideElement search = $x("//a[@class='mega-menu__link'][contains(text(),'Поиск работы')]");

    @Step(value = "Проверка главной страницы")
    public String mainPageCheck() {
        return myCabinet.getText();
    }

    @Step(value = "Клик на кнопку {buttonName}")
    public ConstructorPage buttonCreateResume() {
        buttonCreateResume.click();
        return new ConstructorPage();
    }

    public ConstructorPage buttonCreateVacancy() {
        buttonCreateVacancy.click();
        return new ConstructorPage();
    }

    public ConstructorPage test() {
        search.click();
        return new ConstructorPage();
    }
}
