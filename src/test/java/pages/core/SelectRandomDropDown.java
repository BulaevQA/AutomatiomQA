package pages.core;

import com.codeborne.selenide.Condition;
import helpers.ElementCollections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelectRandomDropDown {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

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

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Заполнение уникального поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     */
    @Step(value = "Кликаем на поле {select} и заполняем случайным значением")
    public SelectRandomDropDown selectRandomIntoDropDown(String select) {
        serviceRandomDropDown(select);
        return this;
    }

    /**
     * === Заполнение повторяющегося поля типа "Селект" с выбором случайного значения ===
     * @param select - Наименование поля
     * @param index  - Позиция поля в DOM
     */
    @Step(value = "Заполняем поле {select} с позицией в DOM {index}")
    public SelectRandomDropDown selectRandomIntoDropDown(String select, String index) {
        serviceRandomDropDown(select, index);
        return this;
    }
}
