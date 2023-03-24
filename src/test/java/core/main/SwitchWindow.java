package core.main;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.sleep;
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
     === Переключение в модальное/всплывающее окно ===
     * @param milliseconds - Ожидание перед зачаном выполнения метода
     */
    @Step(value = "Переключение на модальное окно с ожиданием {milliseconds} миллисекунд")
    public SwitchWindow switchToActiveWindow(int milliseconds) {
        sleep(milliseconds);
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
}
