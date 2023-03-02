package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

@Tag("UISec")
public class UiTestsSeconds {

    @BeforeAll
    public static void setUp(){
        Configuration.headless = true;
    }

    @BeforeEach
    public void openPage(){
        Selenide.open("https://www.google.com/");
    }

    private void assertAnswer(String value){
        $x("//input[@name='q']").sendKeys(value + "=" + Keys.ENTER);
        String answer = $x("//span[@id='cwos']").getText();
        Assertions.assertEquals("4", answer);
    }

    @Test
    public void calcPlusTest() {
        assertAnswer("2+4");
    }

    @Test
    public void calcPlusTest2() {
        assertAnswer("1+5");
    }


    @Test
    public void calcMinusTest() {
        assertAnswer("3-2");
    }

    @Test
    public void calcMultipyTest() {
        assertAnswer("3*2");
    }

    @Test
    public void calcDevideTest() {
        assertAnswer("4/2");
    }
}


