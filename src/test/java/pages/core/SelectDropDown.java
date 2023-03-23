package pages.core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class SelectDropDown {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

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

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального поля типа "Селект" с выбором конкретного значения ===
     * @param select  - Наименование поля
     * @param options - Имя значения в выпадающем списке
     */
    @Step(value = "Заполняем поле {select} c выбором {options}")
    public SelectDropDown selectDropDown(String select, String options) {
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
    public SelectDropDown selectDropDown(String select, String options, int milliseconds) {
        serviceSelectDropDown(select, options, milliseconds);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором конкретного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} c выбором {options} и позицией в DOM {index}")
    public SelectDropDown selectDropDown(String select, String options, String index) {
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
    public SelectDropDown selectDropDown(String select, String options, int milliseconds, String index) {
        serviceSelectDropDown(select, options, milliseconds, index);
        return this;
    }
}
