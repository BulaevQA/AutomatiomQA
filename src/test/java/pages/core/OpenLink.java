package pages.core;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class OpenLink {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private String serviceGetLink(String link) {
        return $x("//a[text()='" + link + "']").getAttribute("href");
    }

    private String serviceGetLink(String link, String index) {
        return $x("(//a[text()='" + link + "'])[" + index + "]").getAttribute("href");
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Открытие ссылки href ===
     * @param link - наименование элемента на странице
     */
    @Step(value = "Переход по ссылке {link}")
    public OpenLink openLink(String link) {
        open(serviceGetLink(link));
        return this;
    }

    /**
     === Открытие ссылки href ===
     * @param link - наименование элемента на странице
     * @param index - порзиция жлемента в DOM
     */
    @Step(value = "Переход по ссылке {link} с позицией в DOM {index}")
    public OpenLink openLink(String link, String index) {
        open(serviceGetLink(link, index));
        return this;
    }

}
