package core.status;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationCheck {

    private final SelenideElement notification = $x("//div[@class='notifications__card-title-one']");

    /**
     * === Метод проверки отображения уведомления
     */
    @Step(value = "Проверка всплывающего уведомления")
    public SelenideElement notification() {
        return notification.should(appear, visible, disappear);
    }

}
