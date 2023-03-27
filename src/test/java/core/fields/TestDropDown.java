package core.fields;

import base.BrowserConfig;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static helpers.other.ClassObjects.*;

public class TestDropDown extends BrowserConfig {

    @Test
    public void test() {
        openLink.openUrl("https://web-stable-test01.k8s.trudvsem.ru/vacancy/search");
        click.clickButton("Да");
        dropDown.selectDropDown("График работы", "Гибкий график");
        dropDown.selectRandomIntoDropDown("Тип занятости");
        dropDown.inputValueDropDown("г. Москва", "г. Байконур");
        click.clickButton("Все фильтры");
        switchWindow.switchToActiveWindow();
        dropDown.inputValueDropDown("Регион", "Архангельская область");
        dropDown.selectDropDown("Сфера деятельности", "Высший менеджмент");
        dropDown.selectDropDown("Трудоустройство социально незащищенных групп населения", "Сирота");
        dropDown.selectDropDown("Источник вакансии", "Вакансия работодателя");
    }
}
