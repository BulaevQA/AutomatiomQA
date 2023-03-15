package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.ElementCollectionsHelper;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeConstructorPage {

    /**
     === Универсальные xpath для всех поляей типа "Селект" ===
     * dropDownMenuInputValue - Заполнение поиска
     * dropDownConfirmValue - Выбор значение с наибольшим совпадением
     * dropDownClearField - Очищение поля в выпадающем спсике кликом на Крестик
     * dropDownConfirmValueCollection - Коллекия элементов для методов из класса ElementCollectionsHelper
     */
    private final SelenideElement dropDownMenuInputValue = $x("//div[@class='dropdown-menu show']//input");
    private final SelenideElement dropDownConfirmValue = $x("//div[@class='dropdown-menu show']//a");
    private final SelenideElement dropDownClearField = $x("//div[@class='dropdown-menu show']//div//button");
    private final SelenideElement dropDownAddNewValue = $x("(//button[contains(text(), 'Добавить')])[last()]");
    private final SelenideElement checkFieldStatus = $x("//*[text()='Нет результатов']");
    private final ElementsCollection dropDownConfirmValueCollection = $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]");
    /**
     === Метод заполнения уникального поля ===
     * @param fieldName - Наименование поля
     * @param fieldValue - Заполнение поля желаемым значением
     */
    @Step(value = "Заполняем поле {fieldName} значением {fieldValue}")
    public ResumeConstructorPage inputFieldValue(String fieldName, String fieldValue) {
        $x("//span[text()='" + fieldName + "']/..//input").setValue(fieldValue);
        return this;
    }
    /**
     === Метод заполнения повторяющегося поля ===
     * @param fieldName - Наименование поля
     * @param fieldValue - Заполнение поля желаемым значением
     * @param position - Позиция поля в доме
     */
    @Step(value = "Заполняем поле {fieldName} с позицией в конструкторе {position} значением {fieldValue}")
    public ResumeConstructorPage inputFieldValue(String fieldName, String fieldValue, String position) {
        $x("(//span[text()='" + fieldName + "']/..//input)[" + position + "]").setValue(fieldValue);
        return this;
    }
    /**
     === Клик на уникальное поле типа "Селект" ===
     * @param fieldName - Наименование поля
     */
    @Step(value = "Кликаем на поле {fieldName} и заполняем случайным значением")
    public ResumeConstructorPage dropDownField(String fieldName) {
        $x("//span[text()='" + fieldName + "']/..//button").click();
        new ElementCollectionsHelper().randomElementCollectionClick(dropDownConfirmValueCollection);
        return this;
    }
    /**
     === Клик на повторяющееся поле типа "Селект" ===
     * @param fieldName - Наименование поля
     * @param position - Позиция поля в доме
     */
    @Step(value = "Заполняем поле {fieldName} с позицией в конструкторе {position}")
    public ResumeConstructorPage dropDownField(String fieldName, String position) {
        $x("(//span[text()='" + fieldName + "']/..//button)[" + position + "]").click();
        new ElementCollectionsHelper().randomElementCollectionClick(dropDownConfirmValueCollection);
        return this;
    }

    /**
     === Клик на повторяющееся поле типа "Селект" с проверкой, что результат был найден ===
     * @param fieldName - Наименование поля
     */
    @Step(value = "Заполняем поле {fieldName} значением {fieldValue} с позицией в конструкторе {position}")
    public ResumeConstructorPage dropDownField(String fieldName, String fieldValue, String position) {
        $x("(//span[text()='" + fieldName + "']/..//button)[" + position + "]").click();
        dropDownMenuInputValue.setValue(fieldValue);
        if (checkFieldStatus.getText().equals("Нет результатов")) {
            dropDownAddNewValue.click();
        } else {
            dropDownConfirmValue.click();
        }
        return this;
    }

    /**
     === Переключатели в конструкторе резюме
     * @param toggleName - Имя переключателя
     */
    @Step(value = "Активируем/Деативируем переключатель {toggleName}")
    public ResumeConstructorPage resumeConstructorToggle(String toggleName) {
        $x("//*[text()='" + toggleName + "']/..").click();
        return this;
    }
    /**
     === Основные функциональные кнопки ===
     * @param buttonName - Функциональные кнопки (Сохранить и опубликовать, Сохранить без публикации,
     *                   Предпросмотр, Отмена)
     */
    @Step(value = "Кликаем на кнопку {buttonName}")
    public MyResumePage functionalButtons(String buttonName) {
        $x("//*[text()='" + buttonName + "']").click();
        return new MyResumePage();
    }
}
