package pages.core;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class OpenUrl {

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     */
    @Step(value = "Открываем {url}")
    public OpenUrl openUrl (String url){
        open(url);
        return this;
    }

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     * @param milliseconds - Ожидание перед выполнением метода
     */
    @Step(value = "Открываем {url} с задержкой {milliseconds} миллисекунд")
    public OpenUrl openUrl (String url, int milliseconds){
        sleep(milliseconds);
        open(url);
        return this;
    }
}
