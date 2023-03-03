package methods;

import com.codeborne.selenide.WebDriverRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlValidator {
    /*
    В value указываем url который ожидаем увидеть
     */
    public UrlValidator urlCompare(String url){
        String currentUrl = WebDriverRunner.getAndCheckWebDriver().getCurrentUrl();
        currentUrl.equals(url);
        return this;
    }
}
