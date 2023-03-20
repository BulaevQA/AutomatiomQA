package pages.constructors;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.ElementCollectionsHelper;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class ConstructorPage {

    ///////////////// Методы \\\\\\\\\\\\\\\\\\\

    /**
     === Метод заполнения уникального поля со свободным заполнением ===
     * @param field - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     */
    private void serviceInputField(String field, String value) {
        $x("//*[text()='" + field + "']/..//input").should(Condition.editable);
        $x("//*[text()='" + field + "']/..//input").setValue(value);
    }

    /**
     === Метод заполнения повторяющегося поля со свободным заполнением ===
     * @param field - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     * @param index - Позиция элемента в DOM
     */
    private void serviceInputField(String field, String value, String index) {
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").should(Condition.editable);
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").setValue(value);
    }

    /**
     === Раскрытие уникального поля типа "Селект" ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     * @param options - Имя значения в выпадающем списке
     */
    private void serviceInputDropDown(String select, String value, String options) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        $x("//span[text()='" + select + "']/..//select").selectOption(options);
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     * @param options - Имя значения в выпадающем списке
     * @param index - Позиция элемента в DOM
     */
    private void serviceInputDropDown(String select, String value, String options , String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
    }

    /**
     === Добавление нового(своего) значения в уникальное поле типа "Селект"
     * @param select - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     */
    private void serviceInputNewDropDown(String select, String value) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
    }
    /**
     === Добавление нового(своего) значения в повторяющееся поле типа "Селект"
     * @param select - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     * @param index - Позиция элемента в DOM
     */
    private void serviceInputNewDropDown(String select, String value, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
    }

    /**
     === Функциональный метод для преобразования XPath в корректное значение
     * @param lvl - Желаемый уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     */
    private String serviceLvlDefinition(String lvl) {
        switch (lvl) {
            case "Начальный":
                return "BEGINNER";
            case "Средний":
                return "MIDDLE";
            case "Продвинутый":
                return "ADVANCED";
            case "Эксперт":
                return "EXPERT";
        }
        return lvl;
    }

    /**
     === Выбираем уровень владения навыком ===
     * @param value - Желаемый уровень владения навыком, преобразующийся на результате метода serviceLvlDefinition
     */
    private void serviceProficiencyLevel(String value) {
        $x("//*[@data-level='" + value + "']").should(Condition.enabled).click();
    }

    /**
     === Выбираем уровень владения навыком ===
     * @param value - Желаемый уровень владения навыком, преобразующийся на результате метода serviceLvlDefinition
     * @param index - Позиция элемента в DOM
     */
    private void serviceProficiencyLevel(String value, String index) {
        $x("(//*[@data-level='" + value + "'])[" + index + "]").should(Condition.enabled).click();
    }

    /**
     === Добавление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    private void serviceAddOptionalBlock(String block) {
        $x("//button[text()='" + block + "'][@data-change='show-block']").should(Condition.enabled).click();
    }

    /**
     === Удаление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    private void serviceRemoveOptionalBlock(String block) {
        $x("//h2[text()='" + block + "']/../following-sibling::div//button").should(Condition.enabled).click();
    }

    /**
     === Раскрытие уникального поля типа "Селект" с выбором первого значения ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param options - Имя значения в выпадающем списке
     */
    private void serviceSelectDropDown(String select, String options) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.editable).click();
        $x("//span[text()='" + select + "']/..//select").selectOption(options);
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" с выбором первого значения ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param options - Имя значения в выпадающем списке
     * @param index - Позиция элемента в DOM
     */
    private void serviceSelectDropDown(String select, String options, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.editable).click();
        $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
    }

    /**
     === Раскрытие уникального поля типа "Селект" с заполнением случайным значением ===
     * @param select - Наименвоание поля, к которому ображаемся
     */
    private void serviceRandomDropDown(String select) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        new ElementCollectionsHelper().randomElementCollectionClick(
                $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    /**
     === Раскрытие повторяющегося поля типа "Селект" с заполнением случайным значением ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param index - Позиция элемента в DOM
     */
    private void serviceRandomDropDown(String select, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        new ElementCollectionsHelper().randomElementCollectionClick
                ($$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    /**
     === Заполнение "двойных полей" (селект + обычное поле) ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполняем поле
     */
    private void serviceDoubleFieldForms(String select, String options, String value) {
        $x("//*[text()='" + select + "']//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(Condition.enabled).click();
        $x("//*[text()='" + select + "']//following-sibling::div//" +
                "select[not(contains(@data-change-block, 'remove-form'))]").selectOption(options);
        $x("//*[text()='" + select + "']//following-sibling::div//" +
                "input[not(contains(@data-change-block, 'remove-form'))]").should(Condition.editable).setValue(value);
    }

    /**
     === Заполнение "двойных полей" (селект + обычное поле) ===
     * @param select - Наименвоание поля, к которому ображаемся
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполняем поле
     * @param index - Позиция элемента в DOM
     */
    private void serviceDoubleFieldForms(String select, String options, String value ,String index) {
        $x("(//*[text()='" + select + "']//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))])[" + index + "]").should(Condition.enabled).click();
        $x("(//*[text()='" + select + "']//following-sibling::div//select" +
                "[not(contains(@data-change-block, 'remove-form'))])[" + index + "]").selectOption(options);
        $x("//*[text()='" + select + "']//following-sibling::div//input" +
                        "[not(contains(@data-change-block, 'remove-form'))]").should(Condition.editable).setValue(value);
    }

    /**
     === Заполнение HTML форм ===
     * @param field - Наименвоание поля, к которому ображаемся
     * @param value - Значение, которым заполняем поле
     */
    private void serviceInputIframe(String field ,String value) {
        $x("//*[text()='"+ field +"']/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe").should(Condition.exist);
        switchTo().frame($x("//*[text()='"+ field +"']/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe"));
        $x("//body/p").should(Condition.editable).setValue(value);
        switchTo().defaultContent();
    }

    /**
     === Заполняем блок Владения языками ===
     * @param field - Значение, которым заполняем поле
     * @param options - Имя значения в выпадающем списке
     */
    private void serviceSelectLanguages(String field, String options) {
        $x("//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[not(contains(@title, 'Базовый'))]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).setValue(field);
        $x("//*[text()='Владение языками']/following-sibling::div//select[not(contains(@class, 'button'))]" +
                "[not(contains(@id, 'know'))]").selectOption(field);
        $x("//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[contains(@title, 'Базовый')]").should(Condition.enabled).click();
        $x("//*[text()='Владение языками']/following-sibling::div//select[contains(@id, " +
                "'knowledge')]").selectOption(options);
    }

    /**
     === Заполняем блок владение языками ===
     * @param field - Значение, которым заполняем поле
     * @param options - Имя значения в выпадающем списке
     * @param index - Позиция элемента в DOM
     */
    private void serviceSelectLanguages(String field, String options, String index) {
        $x("(//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[not(contains(@title, 'Базовый'))])[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).setValue(field);
        $x("(//*[text()='Владение языками']/following-sibling::div//select[not(contains(@class, 'button'))]" +
                "[not(contains(@id, 'know'))])[" + index + "]").selectOption(field);
        $x("(//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[contains(@title, 'Базовый')])[" + index + "]").should(Condition.editable).click();
        $x("(//*[text()='Владение языками']/following-sibling::div//select[contains(@id, " +
                "'knowledge')])[" + index + "]").selectOption(options);
    }

    /**
     === Активация чекбокса ===
     * @param checkbox - Имя чекбокса
     */
    private void serviceCheckBox(String checkbox) {
        $x("//*[text()='" + checkbox + "']/ancestor::label[@class='checkbox']").should(Condition.enabled).click();
    }

    /**
     * Активация чекбокса ===
     * @param radioButton - Имя радиобаттона
     */
    private void serviceRadioButton(String radioButton) {
        $x("//*[text()='" + radioButton + "']/ancestor::label[@class='radio']").should(Condition.enabled).click();
    }

    /**
     === Активация/Деактиавция переключателя ===
     * @param toggle - Наименование переключателя
     */
    private void serviceToggle(String toggle) {
        $x("//*[text()='" + toggle + "']/..").should(Condition.enabled).click();
    }

    /**
     === Клик на кнопку ===
     * @param button - Наименование кнопки
     */
    private void serviceClickButton(String button) {
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

    /**
     === XPath для импорта фото ===
     @buttonAddPhoto - Открываем модальное окно импорта фото
     @buttonImportPhoto - Загружаем фото в конструктор
     @decreaseZoom - Корректирвока позиции фото (без этого действия загрузка фото крайне нестабильна)
     @buttonUploadPhoto - Подтверждаем загрузку фото
     */
    private final SelenideElement buttonPhoto = $x("//button[@class='photo__button']");
    private final SelenideElement buttonInputPhoto = $x("//*[text()='Выбрать файл']/..//input");
    private final SelenideElement decreaseZoom = $x("//button[@data-zoom='minus']");
    private final SelenideElement buttonUploadPhoto = $x("//*[text()='Загрузить']/..//button");

    ///////////////// Логика взаимодействия с конструктором \\\\\\\\\\\\\\\\\\\

    /**
     === Загрузка фото соискателя в конструктор ===
     * @File - Задаем путь имя переменной для файла
     */
    @Step(value = "Загружаем фото")
    public ConstructorPage uploadPhoto(String filePath) {
        File cvPhoto = new File(filePath);
        buttonPhoto.click();
        buttonInputPhoto.uploadFile(cvPhoto);
        decreaseZoom.click();
        buttonUploadPhoto.click();
        return this;
    }

    /**
     === Заполнение уникального поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public ConstructorPage inputValueField(String field, String value) {
        serviceInputField(field, value);
        return this;
    }

    /**
     === Заполнение повторяющегося поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} значением {value} с позицией в DOM {index}")
    public ConstructorPage inputValueField(String field, String value, String index) {
        serviceInputField(field, value, index);
        return this;
    }

    /**
     === Заполнение уникального поле типа "Селект" ===
     * @param select - Наименование поля
     * @param value - Заполняем поле этим значением
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {field} значением {value} и выбором значения {options}")
    public ConstructorPage inputValueDropDown(String select, String value, String options) {
        serviceInputDropDown(select, value, options);
        return this;
    }

    /**
     === Заполнение повторяющееся поле типа "Селект" ===
     * @param select - Наименование поля
     * @param value - Значение, которым заполяем поле
     * @param options - Имя значения в выпадающем списке
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} значением {value} с выбором {options} и позицией в DOM {index}")
    public ConstructorPage inputValueDropDown(String select, String value, String options, String index) {
        serviceInputDropDown(select, value, options ,index);
        return this;
    }

    /**
     === Заполнение уникального поля типа "Селект" с добавлением нового значения ===
     * @param select - Наименование поля
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {field} с добавлением нового значения {value} ")
    public ConstructorPage inputNewValueDropDown(String select, String value) {
        serviceInputNewDropDown(select, value);
        return this;
    }

    /**
     === Заполнение повторяющегося поля типа "Селект" с добавлением нового значения ===
     * @param select - Наименование поля
     * @param value - Значение, которым заполяем поле
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} с добавлением нового значения {value} и позицией в DOM {index}")
    public ConstructorPage inputNewValueDropDown(String select, String value, String index) {
        serviceInputNewDropDown(select, value, index);
        return this;
    }

    /**
     === Заполнение уникального поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     */
    @Step(value = "Кликаем на поле {select} и заполняем случайным значением")
    public ConstructorPage selectRandomIntoDropDown(String select) {
        serviceRandomDropDown(select);
        return this;
    }

    /**
     === Заполнение повторяющегося поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} с позицией в DOM {index}")
    public ConstructorPage selectRandomIntoDropDown(String select, String index) {
        serviceRandomDropDown(select, index);
        return this;
    }

    /**
     === Заполнение уникального поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {select} c выбором {options}")
    public ConstructorPage selectValueDropDownField(String select, String options) {
        serviceSelectDropDown(select, options);
        return this;
    }

    /**
     === Заполнение повторяющегося поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} c выбором {options} и позицией в DOM {index}")
    public ConstructorPage selectValueDropDownField(String select, String options, String index) {
        serviceSelectDropDown(select, options, index);
        return this;
    }

    /**
     === Заполнение уникального "двойного поля" (Селект + обычное поле) ===
     * @param select - select - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {select} значением {value} c выбором {options}")
    public ConstructorPage selectDoubleField(String select, String options, String value) {
        serviceDoubleFieldForms(select, options, value);
        return this;
    }

    /**
     === Заполнение уникального "двойного поля" (Селект + обычное поле) ===
     * @param select - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполяем поле
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} c выбором {options} и позицией в DOM {index}")
    public ConstructorPage selectDoubleField(String select, String options, String value, String index) {
        serviceDoubleFieldForms(select, options, value ,index);
        return this;
    }

    /**
     === Заполнение HTML поля, путем переклчюения на iframe ===
     * @param field - Наименование поля
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public ConstructorPage inputIframeField(String field, String value) {
        serviceInputIframe(field, value);
        return this;
    }

    /**
     === Выбор уровня владения навыком ===
     * @param lvl - Уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     */
    public ConstructorPage selectDefinitionLvl(String lvl) {
        serviceProficiencyLevel(serviceLvlDefinition(lvl));
        return this;
    }

    /**
     === Выбор уровня владения вторым и более навыком ===
     * @param lvl - Уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     * @param index - Позиция поля в DOM
     */
    public ConstructorPage selectDefinitionLvl(String lvl, String index) {
        serviceProficiencyLevel(serviceLvlDefinition(lvl), index);
        return this;
    }

    /**
     === Заполняем поля знания языков ===
     * @param value - Значение, которым заполяем поле
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Выбираем {value} язык с уровнем владения {options}")
    public ConstructorPage selectLanguage(String value, String options) {
        serviceSelectLanguages(value, options);
        return this;
    }

    /**
     === Переключатели в конструкторе резюме ===
     * @param toggle - Имя переключателя
     */
    @Step(value = "Активируем/Деативируем переключатель {toggle}")
    public ConstructorPage switchToggle(String toggle) {
        serviceToggle(toggle);
        return this;
    }

    /**
     === Добавление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Добавление опционального блока {block}")
    public ConstructorPage addOptionalBlock(String block) {
        serviceAddOptionalBlock(block);
        return this;
    }

    /**
     === Удаление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Удаление опционального блока {block}")
    public ConstructorPage removeOptionalBlock(String block) {
        serviceRemoveOptionalBlock(block);
        return this;
    }

    /**
     === Активируем/деактивируем чек бокс ===
     * @param checkbox - Наименование чекбокса
     */
    public ConstructorPage clickCheckbox(String checkbox) {
        serviceCheckBox(checkbox);
        return this;
    }

    /**
     === Активация радиобаттона ===
     * @param radioButton - Наименование радиобаттона
     */
    public ConstructorPage clickRadioButton(String radioButton) {
        serviceRadioButton(radioButton);
        return this;
    }

    /**
     === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public ConstructorPage clickButton(String button) {
        serviceClickButton(button);
        return this;
    }
}
