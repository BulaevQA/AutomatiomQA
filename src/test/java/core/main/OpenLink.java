package core.main;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class OpenLink {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private String serviceGetLink(String link) {
        return $x("//a[text()[normalize-space() = '"+link+"']]").getAttribute("href");
    }

    private String serviceGetLink(String link, String index) {
        return $x("(//a[text()[normalize-space() = '"+link+"']])["+index+"]").getAttribute("href");
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

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     */
    @Step(value = "Открываем {url}")
    public OpenLink openUrl (String url){
        open(url);
        return this;
    }

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     * @param milliseconds - Ожидание перед выполнением метода
     */
    @Step(value = "Открываем {url} с задержкой {milliseconds} миллисекунд")
    public OpenLink openUrl (String url, int milliseconds){
        sleep(milliseconds);
        open(url);
        return this;
    }
}
