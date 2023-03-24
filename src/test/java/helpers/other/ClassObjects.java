package helpers.other;

import core.fields.DropDown;
import core.fields.Input;
import core.constructor.ToggleSwitch;
import core.main.*;
import core.status.GetTitle;
import core.status.InfoBlockHealth;
import helpers.hashMaps.ActualHashMaps;
import helpers.hashMaps.ExpectedHashMaps;
import pages.adm.MainAdmPage;
import pages.trudvsem.mainPrr.MainNonAuthPage;
import pages.trudvsem.mainPrr.MainPage;
import pages.trudvsem.myResume.MyResumePage;
import pages.trudvsem.myVacancy.MyVacancyPage;
import test.authTests.AuthTestCv;
import test.authTests.AuthTestManager;

public class ClassObjects {

    //Экземпляры классов хэш карт
    public static ActualHashMaps actualHashMaps = new ActualHashMaps();
    public static ExpectedHashMaps expectedHashMaps = new ExpectedHashMaps();

    //Экземпляры классов получения информации со страницы
    public static InfoBlockHealth infoBlockHealth = new InfoBlockHealth();
    public static GetTitle getTitle = new GetTitle();

    //Экземпляры классов тестов
    public static AuthTestCv authTestCv = new AuthTestCv();
    public static AuthTestManager authTestManager = new AuthTestManager();

    //Экземпляры классов главных страниц
    public static MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();
    public static MainPage mainPage = new MainPage();
    public static MainAdmPage mainAdmPage = new MainAdmPage();

    //Экземпляры классов моих резюме/вакансий
    public static MyResumePage myResumePage = new MyResumePage();
    public static MyVacancyPage myVacancyPage = new MyVacancyPage();

    //Экземпляры классов взаимодействий с порталом
    public static Search search = new Search();
    public static Input input = new Input();
    public static DropDown dropDown = new DropDown();
    public static ToggleSwitch toggleSwitch = new ToggleSwitch();
    public static Click click = new Click();
    public static OpenLink openLink = new OpenLink();
    public static MeatBalls meatBalls = new MeatBalls();
    public static SwitchWindow switchWindow = new SwitchWindow();
    public static GetCurrentDate getCurrentDate = new GetCurrentDate();
}
