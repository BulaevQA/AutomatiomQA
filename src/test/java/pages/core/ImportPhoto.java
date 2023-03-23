package pages.core;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class ImportPhoto {

    private final SelenideElement buttonPhoto = $x("//button[@class='photo__button']");
    private final SelenideElement buttonInputPhoto = $x("//*[text()='Выбрать файл']/..//input");
    private final SelenideElement decreaseZoom = $x("//button[@data-zoom='minus']");
    private final SelenideElement buttonUploadPhoto = $x("//*[text()='Загрузить']/..//button");

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Загрузка фото соискателя в конструктор ===
     * @File - Задаем путь имя переменной для файла
     */
    @Step(value = "Загружаем фото")
    public ImportPhoto uploadPhoto(String filePath) {
        File cvPhoto = new File(filePath);
        buttonPhoto.click();
        buttonInputPhoto.uploadFile(cvPhoto);
        decreaseZoom.click();
        buttonUploadPhoto.click();
        return this;
    }
}
