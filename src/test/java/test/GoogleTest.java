package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import conf.PrepareStep;

public class GoogleTest {

    PrepareStep prepareStep = new PrepareStep();

    @Test
    @Tag("GoogleTest")
    public void googleTest(){
        prepareStep.browserConfig(); // Конфигурация браузера
    }
}
