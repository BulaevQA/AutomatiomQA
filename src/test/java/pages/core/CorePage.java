package pages.core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.ElementCollections;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class CorePage {

    ///////////////// Служебные методы (НЕ ТРОЖЬ, УБЬЕТ!!!) \\\\\\\\\\\\\\\\\\\

    private void serviceInputField(String field, String value) {
        $x("//*[text()='" + field + "']/..//input").should(Condition.editable).clear();
        $x("//*[text()='" + field + "']/..//input").setValue(value);
    }

    private void serviceInputField(String field, String value, int milliseconds) {
        sleep(milliseconds);
        $x("//*[text()='" + field + "']/..//input").should(Condition.editable).clear();
        $x("//*[text()='" + field + "']/..//input").setValue(value);
    }

    private void serviceInputField(String field, String value, String index) {
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").should(Condition.editable).clear();
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").setValue(value);
    }

    private void serviceInputField(String field, String value, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").should(Condition.editable).clear();
        $x("(//*[text()='" + field + "']/..//input)[" + index + "]").setValue(value);
    }

    private void serviceInputDropDown(String select, String value, String options) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(1500);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("//span[text()='" + select + "']/..//select").selectOption(options);
        }
    }

    private void serviceInputDropDown(String select, String value, String options, int milliseconds) {
        sleep(milliseconds);
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(milliseconds);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("//span[text()='" + select + "']/..//select").selectOption(options);
        }
    }

    private void serviceInputDropDown(String select, String value, String options, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(1500);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
        }
    }

    private void serviceInputDropDown(String select, String value, String options, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        $x("//div[@class='dropdown-menu show']//input").should(Condition.editable).clear();
        $x("//div[@class='dropdown-menu show']//input").setValue(value);
        sleep(1500);
        if (!serviceCheckDropDownOptions(select, value)) {
            $x("//div[@class='dropdown-menu show']//*[@data-action='add-item']").should(Condition.enabled).click();
        } else {
            $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
        }
    }

    private boolean serviceCheckDropDownOptions(String select, String value) {
        return $x("//*[text()='" + select + "']/..//select[@class='select__control']" +
                "//option[text()='" + value + "']").exists();
    }

    private void serviceSelectDropDown(String select, String options) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.editable).click();
        $x("//span[text()='" + select + "']/..//select").selectOption(options);
    }

    private void serviceSelectDropDown(String select, String options, int milliseconds) {
        sleep(milliseconds);
        $x("//span[text()='" + select + "']/..//button").should(Condition.editable).click();
        $x("//span[text()='" + select + "']/..//select").selectOption(options);
    }

    private void serviceSelectDropDown(String select, String options, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.editable).click();
        $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
    }

    private void serviceSelectDropDown(String select, String options, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.editable).click();
        $x("(//span[text()='" + select + "']/..//select)[" + index + "]").selectOption(options);
    }

    private void serviceRandomDropDown(String select) {
        $x("//span[text()='" + select + "']/..//button").should(Condition.enabled).click();
        new ElementCollections().randomElementCollectionClick(
                $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    private void serviceRandomDropDown(String select, String index) {
        $x("(//span[text()='" + select + "']/..//button)[" + index + "]").should(Condition.enabled).click();
        new ElementCollections().randomElementCollectionClick
                ($$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]"));
    }

    private void serviceDoubleFieldForms(String select, String options, String value) {
        $x("//*[text()='" + select + "']//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(Condition.enabled).click();
        $x("//*[text()='" + select + "']//following-sibling::div//" +
                "select[not(contains(@data-change-block, 'remove-form'))]").selectOption(options);
        $x("//*[text()='" + select + "']//following-sibling::div//" +
                "input[not(contains(@data-change-block, 'remove-form'))]").should(Condition.editable).setValue(value);
    }

    private void serviceDoubleFieldForms(String select, String options, String value, String index) {
        $x("(//*[text()='" + select + "']//following-sibling::div//button" +
                "[not(contains(@data-change-block, 'remove-form'))])[" + index + "]").should(Condition.enabled).click();
        $x("(//*[text()='" + select + "']//following-sibling::div//select" +
                "[not(contains(@data-change-block, 'remove-form'))])[" + index + "]").selectOption(options);
        $x("//*[text()='" + select + "']//following-sibling::div//input" +
                "[not(contains(@data-change-block, 'remove-form'))]").should(Condition.editable).setValue(value);
    }

    private void serviceInputIframe(String field, String value) {
        $x("//*[text()='" + field + "']/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe").should(Condition.exist);
        switchTo().frame($x("//*[text()='" + field + "']/preceding-sibling::div[@class='tox tox-tinymce']" +
                "/descendant::iframe"));
        $x("//body/p").should(Condition.editable).setValue(value);
        switchTo().defaultContent();
    }

    private void serviceSelectLanguages(String language, String options) {
        $x("//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[not(contains(@title, 'Базовый'))]").should(Condition.enabled).click();
        $x("//*[text()='Владение языками']/following-sibling::div//select[not(contains(@class, 'button'))]" +
                "[not(contains(@id, 'know'))]").selectOption(language);
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']").click();
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']" +
                "/..//select").selectOption(options);
    }

    private void serviceSelectLanguages(String language, String options, String index) {
        $x("(//*[text()='Владение языками']/following-sibling::div//button[not(contains(@class, 'button'))]" +
                "[not(contains(@title, 'Базовый'))])[" + index + "]").should(Condition.enabled).click();
        $x("(//*[text()='Владение языками']/following-sibling::div//select[not(contains(@class, 'button'))]" +
                "[not(contains(@id, 'know'))])[not(contains(@name, 'proficiency-level'))]" +
                "[" + index + "]").selectOption(language);
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']").click();
        $x("//*[text()='Владение языками']/following-sibling::div//button[@title='Базовый']" +
                "/..//select").selectOption(options);
    }

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

    private void serviceProficiencyLevel(String value) {
        $x("//*[@data-level='" + value + "']").should(Condition.enabled).click();
    }

    private void serviceProficiencyLevel(String value, String index) {
        $x("(//*[@data-level='" + value + "'])[" + index + "]").should(Condition.enabled).click();
    }

    private void serviceAddOptionalBlock(String block) {
        $x("//button[text()='" + block + "'][@data-change='show-block']").should(Condition.enabled).click();
    }

    private void serviceRemoveOptionalBlock(String block) {
        $x("//h2[text()='" + block + "']/../following-sibling::div//button").should(Condition.enabled).click();
    }

    private void serviceCheckBox(String checkbox) {
        $x("//*[text()='" + checkbox + "']/ancestor::label[@class='checkbox']").should(Condition.enabled).click();
    }

    private void serviceClickCheckboxes(String titleName) {
        new ElementCollections().elementsCollectionsClick($$x("//*[text()='" + titleName + "']/..//div//div//label"));
    }

    private void serviceClickCheckboxes(String titleName, int milliseconds) {
        sleep(milliseconds);
        new ElementCollections().elementsCollectionsClick($$x("//*[text()='" + titleName + "']/..//div//div//label"));
    }

    private void serviceRadioButton(String radioButton) {
        $x("//*[text()='" + radioButton + "']/ancestor::label[@class='radio']").should(Condition.enabled).click();
    }

    private void serviceToggle(String toggle) {
        $x("//*[text()='" + toggle + "']/..").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button) {
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, int milliseconds) {
        sleep(milliseconds);
        $x("//*[text()='" + button + "']").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, String index) {
        $x("(//*[text()='" + button + "'])[" + index + "]").should(Condition.enabled).click();
    }

    private void serviceClickButton(String button, int milliseconds, String index) {
        sleep(milliseconds);
        $x("(//*[text()='" + button + "'])[" + index + "]").should(Condition.enabled).click();
    }

    private String serviceGetLink(String link) {
        return $x("//a[text()='" + link + "']").getAttribute("href");
    }

    private String serviceGetLink(String link, String index) {
        return $x("(//a[text()='" + link + "'])[" + index + "]").getAttribute("href");
    }

    ///////////////// XPath \\\\\\\\\\\\\\\\\\\

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
    public CorePage uploadPhoto(String filePath) {
        File cvPhoto = new File(filePath);
        buttonPhoto.click();
        buttonInputPhoto.uploadFile(cvPhoto);
        decreaseZoom.click();
        buttonUploadPhoto.click();
        return this;
    }

    /**
     * === Заполнение уникального поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public CorePage inputValueField(String field, String value) {
        serviceInputField(field, value);
        return this;
    }

    /**
     * === Заполнение уникального поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public CorePage inputValueField(String field, String value, int milliseconds) {
        serviceInputField(field, value, milliseconds);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} значением {value} с позицией в DOM {index}")
    public CorePage inputValueField(String field, String value, String index) {
        serviceInputField(field, value, index);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля ===
     * @param field - Наименование поля
     * @param value - Заполнение поля желаемым значением
     * @param milliseconds - Ожидание перед началом выполнения метода
     * @param index - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {field} значением {value} с позицией в DOM {index}")
    public CorePage inputValueField(String field, String value, int milliseconds, String index) {
        serviceInputField(field, value, milliseconds, index);
        return this;
    }

    /**
     * === Заполнение уникального поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Заполняем поле этим значением
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {select} значением {value} и выбором значения {options}")
    public CorePage inputValueDropDown(String select, String value, String options) {
        serviceInputDropDown(select, value, options);
        return this;
    }

    /**
     * === Заполнение уникального поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Заполняем поле этим значением
     * @param options - Имя значения в выпадающем списке
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Заполняем поле {select} значением {value} и выбором значения {options}")
    public CorePage inputValueDropDown(String select, String value, String options, int milliseconds) {
        serviceInputDropDown(select, value, options, milliseconds);
        return this;
    }

    /**
     * === Заполнение повторяющееся поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     * @param options - Имя значения в выпадающем списке
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} с выбором {options} и позицией в DOM {index}")
    public CorePage inputValueDropDown(String select, String value, String options, String index) {
        serviceInputDropDown(select, value, options, index);
        return this;
    }

    /**
     * === Заполнение повторяющееся поле типа "Селект" ===
     * @param select  - Наименование поля
     * @param value   - Значение, которым заполяем поле
     * @param options - Имя значения в выпадающем списке
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} с выбором {options} и позицией в DOM {index}")
    public CorePage inputValueDropDown(String select, String value, String options, int milliseconds, String index) {
        serviceInputDropDown(select, value, options, milliseconds, index);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     */
    @Step(value = "Кликаем на поле {select} и заполняем случайным значением")
    public CorePage selectRandomIntoDropDown(String select) {
        serviceRandomDropDown(select);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} с позицией в DOM {index}")
    public CorePage selectRandomIntoDropDown(String select, String index) {
        serviceRandomDropDown(select, index);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором конкретного значения ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {select} c выбором {options}")
    public CorePage selectDropDown(String select, String options) {
        serviceSelectDropDown(select, options);
        return this;
    }

    /**
     * === Заполнение уникального поля типа "Селект" с выбором конкретного значения ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param milliseconds - Ожидаине перед началом выполнения метода
     */
    @Step(value = "Заполняем поле {select} c выбором {options}")
    public CorePage selectDropDown(String select, String options, int milliseconds) {
        serviceSelectDropDown(select, options, milliseconds);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} c выбором {options} и позицией в DOM {index}")
    public CorePage selectDropDown(String select, String options, String index) {
        serviceSelectDropDown(select, options, index);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     * @param milliseconds - Ожидаине перед началом выполнения метода
     */
    @Step(value = "Заполняем поле {select} c выбором {options} и позицией в DOM {index}")
    public CorePage selectDropDown(String select, String options, int milliseconds, String index) {
        serviceSelectDropDown(select, options, milliseconds, index);
        return this;
    }

    /**
     * === Заполнение уникального "двойного поля" (Селект + обычное поле) ===
     * @param select  - select - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {select} значением {value} c выбором {options}")
    public CorePage selectDoubleField(String select, String options, String value) {
        serviceDoubleFieldForms(select, options, value);
        return this;
    }

    /**
     * === Заполнение уникального "двойного поля" (Селект + обычное поле) ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     * @param value   - Значение, которым заполяем поле
     * @param index   - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} значением {value} c выбором {options} и позицией в DOM {index}")
    public CorePage selectDoubleField(String select, String options, String value, String index) {
        serviceDoubleFieldForms(select, options, value, index);
        return this;
    }

    /**
     * === Заполнение HTML поля, путем переклчюения на iframe ===
     * @param field - Наименование поля
     * @param value - Значение, которым заполяем поле
     */
    @Step(value = "Заполняем поле {field} значением {value}")
    public CorePage inputIframeField(String field, String value) {
        serviceInputIframe(field, value);
        return this;
    }

    /**
     * === Выбор уровня владения навыком ===
     * @param lvl - Уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     */
    @Step("Выбор владения навыком на уровне {lvl}")
    public CorePage selectDefinitionLvl(String lvl) {
        serviceProficiencyLevel(serviceLvlDefinition(lvl));
        return this;
    }

    /**
     * === Выбор уровня владения вторым и более навыком ===
     * @param lvl   - Уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     * @param index - Позиция поля в DOM
     */
    @Step("Выбор владения навыком на уровне {lvl}")
    public CorePage selectDefinitionLvl(String lvl, String index) {
        serviceProficiencyLevel(serviceLvlDefinition(lvl), index);
        return this;
    }

    /**
     * === Заполняем поля знания языков ===
     * @param language - Значение, которым заполяем поле
     * @param options  - Имя значения в выпадающем списке
     */
    @Step(value = "Выбираем {value} язык с уровнем владения {options}")
    public CorePage selectLanguage(String language, String options) {
        serviceSelectLanguages(language, options);
        return this;
    }

    @Step(value = "Выбираем {value} язык с уровнем владения {options}")
    public CorePage selectLanguage(String language, String options, String index) {
        serviceSelectLanguages(language, options, index);
        return this;
    }

    /**
     * === Переключатели в конструкторе резюме ===
     * @param toggle - Имя переключателя
     */
    @Step(value = "Активируем/Деативируем переключатель {toggle}")
    public CorePage switchToggle(String toggle) {
        serviceToggle(toggle);
        return this;
    }

    /**
     * === Добавление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Добавление опционального блока {block}")
    public CorePage addOptionalBlock(String block) {
        serviceAddOptionalBlock(block);
        return this;
    }

    /**
     * === Удаление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Удаление опционального блока {block}")
    public CorePage removeOptionalBlock(String block) {
        serviceRemoveOptionalBlock(block);
        return this;
    }

    /**
     * === Активируем/деактивируем чек бокс ===
     * @param checkbox - Наименование чекбокса
     */
    @Step(value = "Активация чекбокса {checkbox}")
    public CorePage clickCheckbox(String checkbox) {
        serviceCheckBox(checkbox);
        return this;
    }

    /**
     * === Активация радиобаттона ===
     * @param radioButton - Наименование радиобаттона
     */
    @Step(value = "Активация радиобаттона {radioButton}")
    public CorePage clickRadioButton(String radioButton) {
        serviceRadioButton(radioButton);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public CorePage clickButton(String button) {
        serviceClickButton(button);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Кликаем на кнопку {button}")
    public CorePage clickButton(String button, int milliseconds) {
        serviceClickButton(button, milliseconds);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     */
    @Step(value = "Кликаем на кнопку {button}")
    public CorePage clickButton(String button, String index) {
        serviceClickButton(button, index);
        return this;
    }

    /**
     * === Основные функциональные кнопки ===
     * @param button - Функциональные кнопки (Сохранить и опубликовать, Предпросмотр и тд...)
     * @param milliseconds - Ожидание перед началом выполнения метода
     */
    @Step(value = "Кликаем на кнопку {button}")
    public CorePage clickButton(String button, int milliseconds, String index) {
        serviceClickButton(button, milliseconds, index);
        return this;
    }

    /**
     === Хард слиппер для ожидания элемента ===
     * @param milliseconds - значение в миллисекундах (1 сек = 1000 мл. сек)
     */
    @Step(value = "Ожидание перед выполнением метода = {milliseconds} миллисекунд")
    public CorePage sleeper(int milliseconds) {
        Selenide.sleep(milliseconds);
        return this;
    }

    /**
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     */
    @Step(value = "Активация чекбоксов по коллекции элементов")
    public CorePage clickCheckboxes(String titleName) {
        serviceClickCheckboxes(titleName);
        return this;
    }

    /**
     === Метод перебора чекбоксов по коллекции элементов ===
     * @param titleName - наименвоание заголовка, в котором находятся чекбоксы
     * @param milliseconds - Ожидание перед зачаном выполнения метода
     */
    @Step(value = "Активация чекбоксов по коллекции элементов с ожиданием {milliseconds} миллисекунд")
    public CorePage clickCheckboxes(String titleName, int milliseconds) {
        serviceClickCheckboxes(titleName, milliseconds);
        return this;
    }

    /**
     === Переключение в модальное/всплывающее окно ===
     */
    @Step(value = "Переключение на модальное окно")
    public CorePage switchToActiveWindow() {
        switchTo().activeElement();
        return this;
    }

    /**
     === Переключение в модальное/всплывающее окно ===
     * @param milliseconds - Ожидание перед зачаном выполнения метода
     */
    @Step(value = "Переключение на модальное окно с ожиданием {milliseconds} миллисекунд")
    public CorePage switchToActiveWindow(int milliseconds) {
        sleep(milliseconds);
        switchTo().activeElement();
        return this;
    }

    /**
     === Переклчюение в стандартную область контента ===
     */
    @Step(value = "Переключение на стандартный контент")
    public CorePage switchToDefaultWindow() {
        switchTo().defaultContent();
        return this;
    }

    /**
     === Открытие ссылки href ===
     * @param link - наименование элемента на странице
     */
    @Step(value = "Переход по ссылке {link}")
    public CorePage openLink(String link) {
        open(serviceGetLink(link));
        return this;
    }

    /**
     === Открытие ссылки href ===
     * @param link - наименование элемента на странице
     * @param index - порзиция жлемента в DOM
     */
    @Step(value = "Переход по ссылке {link} с позицией в DOM {index}")
    public CorePage openLink(String link, String index) {
        open(serviceGetLink(link, index));
        return this;
    }

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     */
    @Step(value = "Открываем {url}")
    public CorePage openUrl (String url){
        open(url);
        return this;
    }

    /**
     === Метод открытия базового URL ===
     * @param url - https ссылка
     * @param milliseconds - Ожидание перед выполнением метода
     */
    @Step(value = "Открываем {url} с задержкой {milliseconds} миллисекунд")
    public CorePage openUrl (String url, int milliseconds){
        sleep(milliseconds);
        open(url);
        return this;
    }
}
