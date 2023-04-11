package pages.trudvsemPages.resumePage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeConstructorPage {

    private final SelenideElement
            pageTitle = $x("//h1[@class][text()[normalize-space()='Создание резюме']]"),
            buttonPhoto = $x("//button[@class='photo__button']"),
            buttonInputPhoto = $x("//*[normalize-space(text())='Выбрать файл']/..//input"),
            decreaseZoom = $x("//button[@data-zoom='minus']"),
            buttonUploadPhoto = $x("//*[normalize-space(text())='Загрузить']/..//button");

    private void serviceAddOptionalBlock(String block) {
        $x("//button[normalize-space(text())='"+block+"'][@data-change='show-block']")
                .should(visible, enabled).click();
    }

    private void serviceRemoveOptionalBlock(String block) {
        $x("//h2[normalize-space(text())='"+block+"']/../following-sibling::div//button")
                .should(visible, enabled).click();
    }

    /**
     === Провека заголовка страницы ===
     */
    @Step(value = "Проверка заголовка страницы")
    public boolean pageTitle() {
        return pageTitle.should(visible).exists();
    }

    /**
     * === Загрузка фото соискателя в конструктор ===
     * @File - Задаем путь имя переменной для файла
     */
    @Step(value = "Загружаем фото")
    public void uploadPhoto(String filePath) {
        File cvPhoto = new File(filePath);
        buttonPhoto.should(visible, enabled).click();
        buttonInputPhoto.should(visible, enabled).uploadFile(cvPhoto);
        decreaseZoom.should(visible, enabled).click();
        buttonUploadPhoto.should(visible, enabled).click();
    }

    /**
     * === Добавление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Добавление опционального блока \"{block}\"")
    public void addOptionalBlock(String block) {
        serviceAddOptionalBlock(block);
    }

    /**
     * === Удаление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Удаление опционального блока \"{block}\"")
    public void removeOptionalBlock(String block) {
        serviceRemoveOptionalBlock(block);
    }
}
