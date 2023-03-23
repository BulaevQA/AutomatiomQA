package helpers;

import core.*;
import pages.adm.MainAdmPage;
import pages.trudvsem.mainPrr.MainNonAuthPage;
import pages.trudvsem.mainPrr.MainPage;
import pages.trudvsem.myResume.MyResumePage;
import pages.trudvsem.myVacancy.MyVacancyPage;
import test.auth.AuthTestCv;
import test.auth.AuthTestManager;

public class ClassObjects {


    public static ActualHashMaps actualHashMaps = new ActualHashMaps();
    public static ExpectedHashMaps expectedHashMaps = new ExpectedHashMaps();

    public static InfoBlockHealth infoBlockHealth = new InfoBlockHealth();
    public static GetTitle getTitle = new GetTitle();

    public static AuthTestCv authTestCv = new AuthTestCv();
    public static AuthTestManager authTestManager = new AuthTestManager();

    public static MainNonAuthPage mainNonAuthPage = new MainNonAuthPage();
    public static MainPage mainPage = new MainPage();
    public static MainAdmPage mainAdmPage = new MainAdmPage();

    public static MyResumePage myResumePage = new MyResumePage();
    public static MyVacancyPage myVacancyPage = new MyVacancyPage();
    public static Input input = new Input();
    public static DropDown dropDown = new DropDown();
    public static ToggleSwitch toggleSwitch = new ToggleSwitch();
    public static Click click = new Click();
    public static OpenLink openLink = new OpenLink();
    public static MeatBalls meatBalls = new MeatBalls();
    public static SwitchWindow switchWindow = new SwitchWindow();
}
