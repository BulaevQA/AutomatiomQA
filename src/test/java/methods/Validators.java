package methods;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;

public class Validators {
    /*
    Получаем текст по xpas и сравниваем с ожидаемым текстом
    */
    public Validators checkText(String xpass, String text){
        $x(xpass).getText().equals(text);
        return this;
    }
    /*
    Сравниваем текущий url с ожидаемым url
    */
    public Validators urlCompare(String url){
        String currentUrl = WebDriverRunner.getAndCheckWebDriver().getCurrentUrl();
        currentUrl.equals(url);
        return this;
    }
    /*
    Смотрим отображается ли элемент на странице true/false
    */
    public boolean visibleElement(String xpass){
        return $x(xpass).isDisplayed();
    }
}
