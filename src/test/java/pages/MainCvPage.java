package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainCvPage {

    private final SelenideElement myCabinet = $x("//h1");
    private final SelenideElement buttonCreateResume = $x("//*[text()='Создать резюме']");

    @Step(value = "Проверка главной страницы")
    public String mainCandidatePage(){
        return myCabinet.getText();
    }

    @Step(value = "Клик на кнопку {buttonName}")
    public ResumeConstructorPage buttonCreateResume() {
        buttonCreateResume.click();
        return new ResumeConstructorPage();
    }
}
