package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import owner.OwnerData;
import settings.PrepareStep;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static settings.PrepareStep.siteUrl;

public class GoogleTest {

    PrepareStep prepareStep = new PrepareStep();
    OwnerData ownerData = new OwnerData();

    @Test
    @Tag("GoogleTest")
    public void googleTest(){
        prepareStep.browserConfig(); // Конфигурация браузера
    }
}
