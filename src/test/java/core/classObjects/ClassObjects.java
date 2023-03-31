package core.classObjects;

import core.fields.DropDown;
import core.fields.Input;
import core.constructor.ToggleSwitch;
import core.main.*;
import core.status.InfoBlockHealth;
import hashMaps.hashKeys.HashKeys;
import hashMaps.actualHashMaps.auth.ActualAuth;
import hashMaps.expectedHashMaps.resume.ExpectedResume;
import hashMaps.expectedHashMaps.vacancy.ExpectedVacancy;
import hashMaps.actualHashMaps.resume.ActualResume;
import hashMaps.expectedHashMaps.auth.ExpectedAuth;
import hashMaps.actualHashMaps.vacancy.ActualVacancy;
import helpers.other.ElementCollections;
import pages.admPages.MainAdmPage;
import pages.trudvsemPages.mainPrrPage.MainPage;
import pages.trudvsemPages.megaMenu.analytics.analyticsInformationPage.AnalyticInformationPage;
import pages.trudvsemPages.megaMenu.analytics.professionGuide.ProfessionGuidePage;
import pages.trudvsemPages.megaMenu.analytics.regionRatingPage.RegionRatingPage;
import pages.trudvsemPages.megaMenu.articles.ArticlesPage;
import pages.trudvsemPages.megaMenu.calendar.CalendarPage;
import pages.trudvsemPages.megaMenu.educationPrograms.EducationProgramsPage;
import pages.trudvsemPages.megaMenu.ekd.EkdPage;
import pages.trudvsemPages.megaMenu.foreignWork.tadzhikistanPage.TadzhikistanPage;
import pages.trudvsemPages.megaMenu.foreignWork.uzbekistanPage.UzbekistanPage;
import pages.trudvsemPages.megaMenu.guideInformation.abilympiksPage.AbilympiksPage;
import pages.trudvsemPages.megaMenu.guideInformation.aboutPortalPage.AboutPortalPage;
import pages.trudvsemPages.megaMenu.guideInformation.aboutWorkWithoutBordersPage.AboutWorkWithoutBordersPage;
import pages.trudvsemPages.megaMenu.guideInformation.cvWithExperiencePage.CvWithExperiencePage;
import pages.trudvsemPages.megaMenu.guideInformation.govermentAgenciesServicesPage.GovernmentAgenciesServicePage;
import pages.trudvsemPages.megaMenu.guideInformation.helpAndSupportPage.HelpAndSupportPage;
import pages.trudvsemPages.megaMenu.guideInformation.newOnPortalPage.NewOnPortalPage;
import pages.trudvsemPages.megaMenu.guideInformation.privateAgenciesPage.PrivateAgenciesPage;
import pages.trudvsemPages.megaMenu.guideInformation.securityPage.SecurityPage;
import pages.trudvsemPages.megaMenu.guideInformation.workForInvalidPage.WorkForInvalidPage;
import pages.trudvsemPages.megaMenu.guideInformation.workForStudentPage.WorkForStudentsPage;
import pages.trudvsemPages.megaMenu.guideInformation.worldskillsPage.WorldskillsPage;
import pages.trudvsemPages.megaMenu.mobileApp.AboutMobilePage;
import pages.trudvsemPages.megaMenu.news.NewsPage;
import pages.trudvsemPages.megaMenu.openData.apiPage.ApiPage;
import pages.trudvsemPages.megaMenu.openData.dataSetsPage.DataSetsPage;
import pages.trudvsemPages.megaMenu.openData.eventsPage.EventsPage;
import pages.trudvsemPages.megaMenu.openData.openDataPage.OpenDataPage;
import pages.trudvsemPages.megaMenu.openData.resourcesPage.ResourcesPage;
import pages.trudvsemPages.megaMenu.openData.widgetsPage.WidgetsPage;
import pages.trudvsemPages.megaMenu.practices.AboutPracticesPage;
import pages.trudvsemPages.megaMenu.surveyAndTests.profOrientationPage.ProfOrientationPage;
import pages.trudvsemPages.megaMenu.surveyAndTests.testForCvPage.TestForCvPage;
import pages.trudvsemPages.megaMenu.surveyAndTests.testForManagerPage.TestForManagerPage;
import pages.trudvsemPages.megaMenu.workWithRelocation.WorkWithRelocationRussiaPage;
import pages.trudvsemPages.resumePage.MyResumePage;
import pages.trudvsemPages.resumePage.ResumeConstructorPage;
import pages.trudvsemPages.resumePage.ResumePage;
import pages.trudvsemPages.vacancyPage.MyVacancyPage;
import pages.trudvsemPages.vacancyPage.VacancyConstructorPage;
import pages.trudvsemPages.vacancyPage.VacancyPage;
import test.authTests.AuthCvTest;
import test.authTests.AuthManagerTest;
import test.testValues.TestValues;

public class ClassObjects {

    //Экземпляры классов актульных хэш карт
    public static ActualAuth actualAuth = new ActualAuth();
    public static ActualResume actualResume = new ActualResume();
    public static ActualVacancy actualVacancy = new ActualVacancy();

    //Экземпляры классов ожидаемых хэш карт
    public static ExpectedAuth expectedAuth = new ExpectedAuth();
    public static ExpectedResume expectedResume = new ExpectedResume();
    public static ExpectedVacancy expectedVacancy = new ExpectedVacancy();
    public static HashKeys hashKeys = new HashKeys();

    //Экземпляры классов получения информации со страницы
    public static InfoBlockHealth infoBlockHealth = new InfoBlockHealth();
    public static NotificationCheck notificationCheck = new NotificationCheck();

    //Экземпляры классов тестов
    public static AuthCvTest authTestCv = new AuthCvTest();
    public static AuthManagerTest authTestManager = new AuthManagerTest();

    //Экземпляры классов основных страниц
    public static MainPage mainPage = new MainPage();
    public static MainAdmPage mainAdmPage = new MainAdmPage();
    public static MyResumePage myResumePage = new MyResumePage();
    public static ResumeConstructorPage resumeConstructorPage = new ResumeConstructorPage();
    public static ResumePage resumePage = new ResumePage();
    public static MyVacancyPage myVacancyPage = new MyVacancyPage();
    public static VacancyPage vacancyPage = new VacancyPage();
    public static VacancyConstructorPage vacancyConstructorPage = new VacancyConstructorPage();

    //Экземпляры классов страниц мега-меню
    public static AnalyticInformationPage analyticInformationPage = new AnalyticInformationPage();
    public static ProfessionGuidePage professionGuidePage = new ProfessionGuidePage();
    public static RegionRatingPage regionRatingPage = new RegionRatingPage();
    public static ArticlesPage articlesPage = new ArticlesPage();
    public static EkdPage ekdPage = new EkdPage();
    public static EducationProgramsPage educationProgramsPage = new EducationProgramsPage();
    public static TadzhikistanPage tadzhikistanPage = new TadzhikistanPage();
    public static UzbekistanPage uzbekistanPage = new UzbekistanPage();
    public static AbilympiksPage abilympiksPage = new AbilympiksPage();
    public static AboutPortalPage aboutPortalPage = new AboutPortalPage();
    public static AboutWorkWithoutBordersPage aboutWorkWithoutBordersPage = new AboutWorkWithoutBordersPage();
    public static CvWithExperiencePage cvWithExperiencePage = new CvWithExperiencePage();
    public static GovernmentAgenciesServicePage governmentAgenciesServicePage = new GovernmentAgenciesServicePage();
    public static HelpAndSupportPage helpAndSupportPage = new HelpAndSupportPage();
    public static NewOnPortalPage newOnPortalPage = new NewOnPortalPage();
    public static PrivateAgenciesPage privateAgenciesPage = new PrivateAgenciesPage();
    public static SecurityPage securityPage = new SecurityPage();
    public static WorkForInvalidPage workForInvalidPage = new WorkForInvalidPage();
    public static WorkForStudentsPage workForStudentsPage = new WorkForStudentsPage();
    public static WorldskillsPage worldskillsPage = new WorldskillsPage();
    public static AboutMobilePage aboutMobilePage = new AboutMobilePage();
    public static NewsPage newsPage = new NewsPage();
    public static ApiPage apiPage = new ApiPage();
    public static DataSetsPage dataSetsPage = new DataSetsPage();
    public static EventsPage eventsPage = new EventsPage();
    public static OpenDataPage openDataPage = new OpenDataPage();
    public static ResourcesPage resourcesPage = new ResourcesPage();
    public static WidgetsPage widgetsPage = new WidgetsPage();
    public static AboutPracticesPage aboutPracticesPage = new AboutPracticesPage();
    public static ProfOrientationPage profOrientationPage = new ProfOrientationPage();
    public static TestForCvPage testForCvPage = new TestForCvPage();
    public static TestForManagerPage testForManagerPage = new TestForManagerPage();
    public static WorkWithRelocationRussiaPage workWithRelocationRussiaPage = new WorkWithRelocationRussiaPage();
    public static CalendarPage calendarPage = new CalendarPage();

    //Экземпляры классов взаимодействий с порталом
    public static ElementCollections elementCollections = new ElementCollections();
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
