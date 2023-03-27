package core.constructor;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ImportFile {

    private final SelenideElement
            buttonPhoto = $x("//button[@class='photo__button']"),
            buttonInputPhoto = $x("//*[normalize-space(text())='Выбрать файл']/..//input"),
            decreaseZoom = $x("//button[@data-zoom='minus']"),
            buttonUploadPhoto = $x("//*[normalize-space(text())='Загрузить']/..//button");

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Загрузка фото соискателя в конструктор ===
     * @File - Задаем путь имя переменной для файла
     */
    @Step(value = "Загружаем файл")
    public ImportFile uploadPhoto(String filePath) {
        File cvPhoto = new File(filePath);
        buttonPhoto.should(visible, enabled).click();
        buttonInputPhoto.should(visible, enabled).uploadFile(cvPhoto);
        decreaseZoom.should(visible, enabled).click();
        buttonUploadPhoto.should(visible, enabled).click();
        return this;
    }
}