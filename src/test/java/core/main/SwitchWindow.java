package core.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WindowType;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.switchTo;

public class SwitchWindow {

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     === Переключение в модальное/всплывающее окно ===
     */
    @Step(value = "Переключение на модальное окно")
    public SwitchWindow switchToActiveWindow() {
        switchTo().activeElement();
        return this;
    }

    /**
     === Переклчюение в стандартную область контента ===
     */
    @Step(value = "Переключение на стандартный контент")
    public SwitchWindow switchToDefaultWindow() {
        switchTo().defaultContent();
        return this;
    }

    /**
     === Переключение между вкладками ===
     * @param windowType - принимает в себя два значения "TAB" и "WINDOW"
     */
    @Step(value = "Переключение на новый \"{windowType}\"")
    public SwitchWindow openWindowType(WindowType windowType) {
        switchTo().newWindow(windowType);
        return this;
    }

    /**
     === Переключение между вкладками ===
     * @param window - номер открытой вкладки
     */
    @Step(value = "Переключение на новую вкладку")
    public SwitchWindow switchBetweenWindows(int window) {
        switchTo().window(window);
        refresh();
        return this;
    }
}
