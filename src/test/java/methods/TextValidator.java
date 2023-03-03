package methods;

import static com.codeborne.selenide.Selenide.$x;

public class TextValidator {
    /*
    Получаем текст по xpas и сравниваем с ожидаемым текстом
    */
    public TextValidator checkText(String xpas, String text){
        $x(xpas).getText().equals(text);
        return this;
    }
}
