package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyResumePage {

    private final static SelenideElement MY_RESUME = $x("//h1[@class='content__title']");

    public MyResumePage myResumeCheck() {
        MY_RESUME.getText();
        return this;
    }
}
