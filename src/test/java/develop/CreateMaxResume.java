package develop;

import helpers.HashMaps;
import org.junit.jupiter.api.*;
import base.BrowserConfig;
import pages.trudvsem.mainPrr.MainPage;
import pages.trudvsem.myResume.MyResumePage;
import test.auth.AuthTestCv;

public class CreateMaxResume extends BrowserConfig {

    AuthTestCv authTest = new AuthTestCv();
    MainPage mainPage = new MainPage();
    HashMaps hashMaps = new HashMaps();
    MyResumePage myResumePage = new MyResumePage();

//    @Test
    @Tag("Full test")
    @DisplayName("Тест создания резюме(максимальное заполнение)")
    public void createResumeTest() {
        authTest
                .authTest();
        mainPage
                .buttonCreateResume()
                .addOptionalBlock("Дополнительное образование")
                .addOptionalBlock("Свидетельства и сертификаты")
                .addOptionalBlock("Иные документы")
                .addOptionalBlock("Переезд")
                .addOptionalBlock("Рекомендации")
                .addOptionalBlock("Социальное положение")
                .addOptionalBlock("Конкурсы и движения")
                .uploadPhoto("src/test/resources/cvPhoto.png")
                .inputValueField("Желаемая должность", "Автотест")
                .selectDropDown("Сфера деятельности", "Домашний персонал")
                .inputValueDropDown("Профессия", "Учитель", "Учитель")
                .inputValueField("Заработная плата (руб.)", "30000")
                .inputValueField("Готов приступить к работе с", "01.01.2024")
                .selectDropDown("Гражданство", "Луганская Народная Республика")
                .selectDropDown("Основание для работы", "Патент")
                .selectDropDown("Регион", "Архангельская область")
                .inputValueDropDown("Населенный пункт", "г. Архангельск", "Архангельская область, г. Вельск")
                .inputValueField("Телефон", "9674449988")
                .clickRadioButton("Лучше звонить мне по телефону")
                .inputValueField("Email", "123@bftcom.com")
                .clickRadioButton("Лучше написать мне письмо")
                .selectDoubleField("Социальные сети", "ВКонтакте", "google.com")
                .selectDoubleField("Мессенджеры", "Skype", "google.com")
                .switchToggle("Отображать мой профиль Skillsnet в резюме")
                .inputValueField("Организация", "ООО \"БФТ\"")
                .inputValueField("Должность", "Тестировщик")
                .clickCheckbox("Опыт работы является релевантным")
                .selectDoubleField("Начало работы", "март", "2020")
                .clickCheckbox("по настоящее время")
                .inputIframeField("Обязанности", "Текст1234")
                .inputIframeField("Достижения", "Текст123")
                .inputValueDropDown("Выберите навыки", "умение", "умение расставлять приоритеты")
                .selectDefinitionLvl("Продвинутый")
                .inputValueDropDown("Выберите навыки", "умение", "Умение проводить совещания", "2")
                .selectDropDown("Образование", "Высшее")
                .selectDropDown("Ученая степень", "Кандидат наук")
                .inputValueDropDown("Учебное заведение", "университет", "Гуманитарный университет")
                .inputValueField("Факультет", "Факультет12")
                .inputValueField("Год окончания обучения", "2016")
                .inputValueField("Название дипломной работы", "Диплом12")
                .inputValueField("Квалификация по диплому", "Квалификация13")
                .selectDropDown("Специальность по диплому", "Регионоведение")
                .inputValueField("Серия диплома", "111111")
                .inputValueField("Номер диплома", "1111111")
                .inputValueField("Дата выдачи диплома", "01.01.2017")
                .clickCheckbox("Сменный график")
                .clickRadioButton("Удаленная")
                .clickCheckbox("Готов к переобучению")
                .clickCheckbox("Готов к командировкам")
                .selectLanguage("Английский", "Свободный")
                .clickButton("Добавить язык")
                .selectLanguage("Немецкий", "Способен пройти собеседование", "2")
                .inputValueField("Название курса", "Курс12")
                .inputValueField("Учебное заведение", "Учебное заведение")
                .inputValueField("Год окончания", "2019")
                .clickCheckbox("Свидетельство о независимой оценке квалификации")
                .inputValueField("Регистрационный номер", "12312313")
                .inputValueField("Дата выдачи", "12.01.2022")
                .selectDropDown("Медицинская книжка", "Есть")
                .selectDropDown("Водительское удостоверение", "C")
                .inputIframeField("Сертификаты, удостоверения, звания", "Текст123")
                .selectDropDown("Семейное положение", "В браке")
                .selectDropDown("Наличие детей", "есть дети")
                .selectDropDown("Наличие жилья", "нужно жилье")
                .selectDropDown("Социально-незащищенная группа", "Лица, освобождаемые из мест лишения свободы")
                .selectDropDown("Регион переезда", "Алтайский край")
                .inputValueDropDown("Населенный пункт", "город", "Алтайский край, г. Белокуриха", "2")
                .clickCheckbox("Необходимо жилье")
                .inputValueField("Заработная плата (руб.)", "34000", "2")
                .inputIframeField("Условия переезда", "123123")
                .clickCheckbox("Подтверждаю, что я получил(а) согласие от рекомендателей на обработку их персональных данных.")
                .inputValueField("ФИО", "Булаев Денис Сергеевич")
                .inputValueField("Должность", "Должность тестироващика", "2")
                .inputValueField("Служебный телефон", "9674440404", "3")
                .clickCheckbox("Участник движения Абилимпикс")
                .clickCheckbox("Участник движения WorldSkills")
                .selectDropDown("Компетенция из международного справочника", "Агрономия")
                .clickCheckbox("Участник ЕИС «DOBRO.RU»")
                .clickButton("Сохранить и опубликовать");
        Assertions
                .assertEquals(hashMaps.expectedMaxResume(), myResumePage.actualAttributes());
        myResumePage
                .deleteResume(1000);
    }
}