package methods;

import com.codeborne.selenide.WebDriverRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlComparator {
    /*
    В value указываем url который ожидаем увидеть
     */
    public UrlComparator urlCompare(String value){
        String currentUrl = WebDriverRunner.getAndCheckWebDriver().getCurrentUrl();
        assertEquals(currentUrl, value);
        return this;
    }
}
