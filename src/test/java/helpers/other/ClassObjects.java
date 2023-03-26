package helpers.other;

import core.fields.DropDown;
import core.fields.Input;
import core.constructor.ToggleSwitch;
import core.main.*;
import core.status.GetPageTitle;
import core.status.InfoBlockHealth;
import helpers.hashMaps.ActualHashMaps;
import helpers.hashMaps.ExpectedHashMaps;
import pages.adm.MainAdmPage;
import pages.trudvsem.mainPrr.MainPage;
import pages.trudvsem.resume.MyResumePage;
import pages.trudvsem.resume.ResumePage;
import pages.trudvsem.vacancy.MyVacancyPage;
import pages.trudvsem.vacancy.VacancyPage;
import test.authTests.AuthTestCv;
import test.authTests.AuthTestManager;
import test.testValues.TestValues;

public class ClassObjects {

    //Экземпляры классов хэш карт
    public static ActualHashMaps actualHashMaps = new ActualHashMaps();
    public static ExpectedHashMaps expectedHashMaps = new ExpectedHashMaps();

    //Экземпляры классов получения информации со страницы
    public static InfoBlockHealth infoBlockHealth = new InfoBlockHealth();
    public static GetPageTitle getPageTitle = new GetPageTitle();
    public static NotificationCheck notificationCheck = new NotificationCheck();

    //Экземпляры классов тестов
    public static AuthTestCv authTestCv = new AuthTestCv();
    public static AuthTestManager authTestManager = new AuthTestManager();

    //Экземпляры классов страниц
    public static MainPage mainPage = new MainPage();
    public static MainAdmPage mainAdmPage = new MainAdmPage();

    //Экземпляры классов моих резюме/вакансий
    public static MyResumePage myResumePage = new MyResumePage();
    public static ResumePage resumePage = new ResumePage();
    public static MyVacancyPage myVacancyPage = new MyVacancyPage();
    public static VacancyPage vacancyPage = new VacancyPage();

    //Экземпляры классов взаимодействий с порталом
    public static TestValues testValues = new TestValues();
    public static Search search = new Search();
    public static Input input = new Input();
    public static DropDown dropDown = new DropDown();
    public static ToggleSwitch toggleSwitch = new ToggleSwitch();
    public static Click click = new Click();
    public static OpenLink openLink = new OpenLink();
    public static MeatBalls meatBalls = new MeatBalls();
    public static SwitchWindow switchWindow = new SwitchWindow();
}
