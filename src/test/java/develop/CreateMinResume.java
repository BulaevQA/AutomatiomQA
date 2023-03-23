//package develop;
//
//import helpers.HashMaps;
//import org.junit.jupiter.api.*;
//import base.BrowserConfig;
//import pages.trudvsem.mainPrr.MainPage;
//import pages.trudvsem.myResume.MyResumePage;
//import test.auth.AuthTestCv;
//
//public class CreateMinResume extends BrowserConfig {
//
//    AuthTestCv authTest = new AuthTestCv();
//    MainPage mainPage = new MainPage();
//    HashMaps hashMaps = new HashMaps();
//    MyResumePage myResumePage = new MyResumePage();
//
////    @Test
//    @Tag("Full test")
//    @DisplayName("Тест создания резюме(минимальное заполнение)")
//    public void createResumeTest() {
//        authTest
//                .authTest();
//        mainPage
//                .buttonCreateResume()
//                .inputValueField("Желаемая должность", "Автотест")
//                .selectDropDown("Сфера деятельности", "Домашний персонал")
//                .inputValueField("Заработная плата (руб.)", "30000")
//                .switchToggle("Есть опыт работы")
//                .clickButton("Сохранить и опубликовать");
//        Assertions
//                .assertEquals(hashMaps.expectedMinResume(), myResumePage.actualAttributes());
//        myResumePage
//                .deleteResume(1000);
//    }
//}
