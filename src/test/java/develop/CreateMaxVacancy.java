package develop;

import base.BrowserConfig;
import helpers.HashMaps;
import helpers.MeatBalls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.core.CorePage;
import pages.trudvsem.mainPrr.MainNonAuthPage;
import pages.trudvsem.myVacancy.MyVacancyPage;

public class CreateMaxVacancy extends BrowserConfig {

    CorePage corePage = new CorePage();
    MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();
    HashMaps hashMaps = new HashMaps();
    MyVacancyPage myVacancyPage = new MyVacancyPage();

//    @Test
    @Tag("Full test")
    @DisplayName("Тест создания вакансии(максимальное заполнение)")
    public void createVacancyTest() {
        corePage
                .openUrl(url);
        mainNonAuthPage
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(login, password)
                .selectUser("Индивидуальный предприниматель")
                .buttonCreateVacancy()
                .inputValueDropDown("Название вакансии", "Учитель", "Учитель")
                .inputValueDropDown("Профессия", "Учитель", "Учитель")
                .selectDropDown("Сфера деятельности", "Высший менеджмент")
                .inputValueField("от", "30000")
                .inputValueField("до", "40000")
                .inputValueDropDown("Адрес места работы", "г. Москва", "г. Москва, Арбат улица")
                .inputValueField("Дом", "23")
                .selectDropDown("Метро", "Авиамоторная")
                .selectDropDown("Тип вакансии", "Общественная работа")
                .selectDropDown("Центр занятости населения", "\"Отдел \"Марьино\"")
                .inputIframeField("Обязанности", "тЕКСТ1")
                .inputIframeField("Требования", "тЕЦУКЦУК")
                .inputValueField("Квалификация", "Автотест1")
                .inputValueField("Опыт работы", "3")
                .clickCheckbox("Предпочтительны кандидаты со стажем от 30 лет, «Опытные кадры»")
                .selectDropDown("Образование", "Высшее")
                .selectDropDown("Специальность по образованию", "Реклама")
                .selectDropDown("Ученая степень", "Кандидат наук")
                .selectLanguage("Английский", "Свободный")
                .clickButton("Добавить язык")
                .selectLanguage("Немецкий", "Свободный", "2")
                .inputValueDropDown("Выберите навыки", "умение", "умение работать в команде")
                .inputValueDropDown("Выберите навыки", "умение", "Умение обучать", "2")
                .selectDropDown("Медицинская книжка", "Требуется")
                .selectDropDown("Водительское удостоверение", "B")
                .clickCheckbox("Принимать отклики только с видеоинтервью")
                .inputValueField("c", "12:12")
                .inputValueField("по", "14:15")
                .selectDropDown("Тип занятости", "Временная")
                .inputValueField("Количество рабочих мест", "3")
                .inputIframeField("Дополнительные сведения по вакансии", "текст132")
                .selectDropDown("Возможность работы для социально незащищённых групп", "Инвалиды")
                .clickCheckbox("Квотируемое рабочее место для инвалидов")
                .clickCheckbox("Участвует в программе повышения трудовой мобильности")
                .clickCheckbox("Есть возможность предоставления отсрочки от призыва на военную службу по мобилизации")
                .selectDropDown("Вид премии ", "Ежегодная премия")
                .selectDoubleField("Размер премии", "руб.", "3000")
                .selectDropDown("Бонусы", "ДМС")
                .selectDropDown("Предоставление жилья при переезде", "Жилье предоставляется")
                .selectDropDown("Тип жилья", "Квартира")
                .selectDropDown("Транспортные льготы", "Оплата проезда")
                .selectDropDown("Переобучение", "Переобучение есть")
                .selectDropDown("Стипендия", "Есть стипендия")
                .inputValueField("Размер стипендии в месяц (руб.)", "5000")
                .inputIframeField("Условия обучения", "Тектс123")
                .inputValueField("Контактное лицо", "Булаев Денис")
                .inputValueField("Телефон", "9674407692")
                .inputValueField("Мобильный телефон", "9674407692")
                .inputValueField("Email", "test@pbs.bftcom.com")
                .inputValueField("Skype", "test132")
                .inputValueField("Другое", "test321")
                .clickRadioButton("Только зарегистрированные пользователи портала")
                .clickCheckbox("Алеся Прокофева (czn_321774600790221_119@mail.ru)")
                .clickButton("Сохранить и опубликовать");
        Assertions
                .assertEquals(hashMaps.expectedVacancy(), myVacancyPage.actualAttributes());
        myVacancyPage
                .deleteVacancy(1000);
    }
}
