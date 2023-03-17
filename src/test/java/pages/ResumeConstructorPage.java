package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.ElementCollectionsHelper;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeConstructorPage {

    ///////////////// Методы \\\\\\\\\\\\\\\\\\\

    /**
     === Метод заполнения уникального поля со свободным заполнением ===
     * @param fieldName - Наименвоание поля, к которому ображаемся
     * @param fieldValue - Значение, которым заполняем поле
     */
    private void inputIntoField(String fieldName, String fieldValue) {
        $x("//span[text()='" + fieldName + "']/..//input").isEnabled();
        $x("//span[text()='" + fieldName + "']/..//input").clear();
        $x("//span[text()='" + fieldName + "']/..//input").setValue(fieldValue);
    }

    /**
     === Метод заполнения повторяющегося поля со свободным заполнением ===
     * @param fieldName - Наименвоание поля, к которому ображаемся
     * @param fieldValue - Значение, которым заполняем поле
     * @param position - Позиция элемента в DOM
     */
    private void inputIntoField(String fieldName, String fieldValue, String position) {
        $x("(//span[text()='" + fieldName + "']/..//input)[" + position + "]").isEnabled();
        $x("(//span[text()='" + fieldName + "']/..//input)[" + position + "]").clear();
        $x("(//span[text()='" + fieldName + "']/..//input)[" + position + "]").setValue(fieldValue);
    }

    /**
     === Раскрытие уникального поля типа "Селект" ===
     * @param selectName - Наименвоание поля, к которому ображаемся
     * @param fieldValue - Значение, которым заполняем поле
     */
    private void inputIntoDropDownField(String selectName, String fieldValue) {
        $x("//span[text()='" + selectName + "']/..//button").isEnabled();
        $x("//span[text()='" + selectName + "']/..//button").click();
        $x("//div[@class='dropdown-menu show']//input").clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(fieldValue);
        $x("//span[text()='" + selectName + "']/..//select").selectOption(1);
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" ===
     * @param selectName - Наименвоание поля, к которому ображаемся
     * @param fieldValue - Значение, которым заполняем поле
     * @param position - Позиция элемента в DOM
     */
    private void inputIntoDropDownField(String selectName, String fieldValue, String position) {
        $x("(//span[text()='" + selectName + "']/..//button)[" + position + "]").isEnabled();
        $x("(//span[text()='" + selectName + "']/..//button)[" + position + "]").click();
        $x("//div[@class='dropdown-menu show']//input").clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(fieldValue);
        $x("(//span[text()='" + selectName + "']/..//select)[" + position + "]").selectOption(1);
    }

    /**
     === Раскрытие уникального поля типа "Селект" с выбором первого значения ===
     * @param selectName - Наименвоание поля, к которому ображаемся
     */
    private void selectValueDropDownField(String selectName) {
        $x("//span[text()='" + selectName + "']/..//button").isEnabled();
        $x("//span[text()='" + selectName + "']/..//button").click();
        $x("//span[text()='" + selectName + "']/..//select").selectOption(1);
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" с выбором первого значения ===
     * @param selectName - Наименвоание поля, к которому ображаемся
     * @param position - Позиция элемента в DOM
     */
    private void selectValueDropDownField(String selectName, String position) {
        $x("(//span[text()='" + selectName + "']/..//button)[" + position + "]").isEnabled();
        $x("(//span[text()='" + selectName + "']/..//button)[" + position + "]").click();
        $x("(//span[text()='" + selectName + "']/..//select)[" + position + "]").selectOption(1);
    }

    /**
     === Раскрытие уникального поля типа "Селект" с заполнением случайным значением ===
     * @param selectName - Наименвоание поля, к которому ображаемся
     */
    private void randomDropDownValue(String selectName) {
        $x("//span[text()='" + selectName + "']/..//button").isEnabled();
        $x("//span[text()='" + selectName + "']/..//button").click();
        new ElementCollectionsHelper().randomElementCollectionClick(
                $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" с заполнением случайным значением ===
     * @param selectName - Наименвоание поля, к которому ображаемся
     * @param position - Позиция элемента в DOM
     */
    private void randomDropDownValue(String selectName, String position) {
        $x("(//span[text()='" + selectName + "']/..//button)[" + position + "]").isEnabled();
        $x("(//span[text()='" + selectName + "']/..//button)[" + position + "]").click();
        new ElementCollectionsHelper().randomElementCollectionClick
                ($$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    /**
     === Активация/Деактиавция переключателя ===
     * @param toggleName - Наименование переключателя
     */
    private void switcher(String toggleName) {
        $x("//*[text()='" + toggleName + "']/..").click();
    }

    /**
     === Клик на кнопку ===
     * @param buttonName - Наименование кнопки
     */
    private void clickOnButton(String buttonName) {
        $x("//button[text()='" + buttonName + "']").click();
    }

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    /**
     === XPath для импорта фото ===
     @buttonAddPhoto - Открываем модальное окно импорта фото
     @buttonImportPhoto - Загружаем фото в конструктор
     @decreaseZoom - Корректирвока позиции фото
     @buttonUploadPhoto - Подтверждаем загрузку фото
     */
    private final SelenideElement buttonPhoto = $x("//button[@class='photo__button']");
    private final SelenideElement buttonInputPhoto = $x("//*[text()='Выбрать файл']/..//input");
    private final SelenideElement decreaseZoom = $x("//button[@data-zoom='minus']");
    private final SelenideElement buttonUploadPhoto = $x("//*[text()='Загрузить']/..//button");

    ///////////////// Логика взаимодействия с конструктором резюме \\\\\\\\\\\\\\\\\\\

    /**
     === Загрузка фото соискателя в конструктор ===
     * @File - Задаем путь имя переменной для файла
     */
    @Step(value = "Загружаем фото")
    public ResumeConstructorPage uploadPhoto() {
        File cvPhoto = new File("src/test/resources/cvPhoto.png");
        buttonPhoto.click();
        buttonInputPhoto.uploadFile(cvPhoto);
        decreaseZoom.click();
        buttonUploadPhoto.click();
        return this;
    }

    /**
     === Заполнение уникального поля ===
     * @param fieldName - Наименование поля
     * @param fieldValue - Заполнение поля желаемым значением
     */
    @Step(value = "Заполняем поле {fieldName} значением {fieldValue}")
    public ResumeConstructorPage inputValueIntoField(String fieldName, String fieldValue) {
        inputIntoField(fieldName, fieldValue);
        return this;
    }

    /**
     === Заполнение повторяющегося поля ===
     * @param fieldName - Наименование поля
     * @param fieldValue - Заполнение поля желаемым значением
     * @param position - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {fieldName} значением {fieldValue} с позицией в DOM {position}")
    public ResumeConstructorPage inputValueIntoField(String fieldName, String fieldValue, String position) {
        inputIntoField(fieldName, fieldValue, position);
        return this;
    }

    /**
     === Заполнение уникального поле типа "Селект" ===
     * @param selectName - Наименование поля
     * @param fieldValue - Заполняем поле этим значением
     */
    @Step(value = "Заполняем поле {fieldName} значением {fieldValue}")
    public ResumeConstructorPage inputValueIntoDropDown(String selectName, String fieldValue) {
        inputIntoDropDownField(selectName, fieldValue);
        return this;
    }

    /**
     === Заполнение повторяющееся поле типа "Селект" с заполением поля ===
     * @param selectName - Наименование поля
     * @param fieldValue - Значение, которым заполяем поле
     * @param position - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {fieldName} значением {fieldValue} с позицией в DOM {position}")
    public ResumeConstructorPage inputValueIntoDropDown(String selectName, String fieldValue, String position) {
        inputIntoDropDownField(selectName, fieldValue, position);
        return this;
    }

    /**
     === Клик на уникальное поле типа "Селект" с выбором случайного значения ===
     * @param selectName - Наименование поля
     */
    @Step(value = "Кликаем на поле {fieldName} и заполняем случайным значением")
    public ResumeConstructorPage selectRandomIntoDropDown(String selectName) {
        randomDropDownValue(selectName);
        return this;
    }

    /**
     === Клик на повторяющееся поле типа "Селект" с выбором случайного значения ===
     * @param selectName - Наименование поля
     * @param position - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {fieldName} с позицией в DOM {position}")
    public ResumeConstructorPage selectRandomIntoDropDown(String selectName, String position) {
        randomDropDownValue(selectName, position);
        return this;
    }

    /**
     === Раскрытие уникального поля типа "Селект" с выбором первого значения ===
     * @param selectName - Наименование поля
     */
    @Step(value = "Заполняем поле {fieldName} с позицией в DOM {position}")
    public ResumeConstructorPage selectFirstValueDropDownField(String selectName) {
        selectValueDropDownField(selectName);
        return this;
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" с выбором первого значения ===
     * @param selectName - Наименование поля
     * @param position - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {fieldName} с позицией в DOM {position}")
    public ResumeConstructorPage selectFirstValueDropDownField(String selectName, String position) {
        selectValueDropDownField(selectName, position);
        return this;
    }
    /**
     === Переключатели в конструкторе резюме
     * @param toggleName - Имя переключателя
     */
    @Step(value = "Активируем/Деативируем переключатель {toggleName}")
    public ResumeConstructorPage resumeConstructorToggle(String toggleName) {
        switcher(toggleName);
        return this;
    }

    /**
     === Основные функциональные кнопки ===
     * @param buttonName - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {buttonName}")
    public MyResumePage functionButtons(String buttonName) {
        clickOnButton(buttonName);
        return new MyResumePage();
    }
}
