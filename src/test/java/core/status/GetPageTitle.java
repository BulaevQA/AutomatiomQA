package core.status;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GetPageTitle {

    public boolean pageTitleIsVisible(String header) {
        return $x("//h1[@class][text()[normalize-space() = '" + header + "']]")
                .should(exist, visible).getText().trim().equals(header);
    }
}
