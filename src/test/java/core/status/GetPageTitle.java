package core.status;

import static com.codeborne.selenide.Selenide.$x;

public class GetPageTitle {

    public String pageTitle() {
        return $x("//h1[@class='content__title']").getText();
    }
}
