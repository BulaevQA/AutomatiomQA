package methods;

import static com.codeborne.selenide.Selenide.$x;

public class TextValidator {
    public TextValidator checkText(String xpass, String text){
        $x(xpass).getText().equals(text);
        return this;
    }
}
