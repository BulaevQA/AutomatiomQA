package core;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class GetTitle {

    private final SelenideElement title = $x("//h1[@class='content__title']");

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод получения заголовска страницы ===
     */
    @Step(value = "Получение заголовка стрницы")
    public String getTitle() {
        return title.getText();
    }
}
