package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class GoogleTest {
    @Test
    public void googleTest(){
        Selenide.open("https://www.google.com/");
    }
}
