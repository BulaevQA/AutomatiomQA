package core.main;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class NotificationCheck {

    private final SelenideElement notification = $x("//div[@class='notifications__card-title']");

    /**
     === Метод проверки отображения уведомления
     */
    @Step(value = "Проверка всплывающего уведомления")
    public boolean notificationCheck() {
        return notification.should(appear, visible).exists();
    }

}
