package core.main;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class Open {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private String serviceGetLink(String link) {
        return $x("//a[text()[normalize-space() = '"+link+"']]")
                .should(exist, visible).getAttribute("href");
    }

    private String serviceGetLink(String link, String index) {
        return $x("(//a[text()[normalize-space() = '"+link+"']])["+index+"]")
                .should(exist, visible).getAttribute("href");
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Открытие ссылки href ===
     * @param link - наименование элемента на странице
     */
    @Step(value = "Переход по ссылке \"{link}\"")
    public Open openLink(String link) {
        open(serviceGetLink(link));
        return this;
    }

    /**
     === Открытие ссылки href ===
     * @param link - наименование элемента на странице
     * @param index - позиция элемента в DOM
     */
    @Step(value = "Переход по ссылке \"{link}\"")
    public Open openLink(String link, String index) {
        open(serviceGetLink(link, index));
        return this;
    }

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     */
    @Step(value = "Открываем \"{url}\"")
    public Open openUrl (String url){
        open(url);
        return this;
    }
}
