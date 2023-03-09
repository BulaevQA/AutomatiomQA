package test;

import com.codeborne.selenide.Selenide;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$x;

public class GoogleTest {
    @RepeatedIfExceptionsTest(repeats = 10, minSuccess = 1, name = "Retry test attempt {currentRepetition} of {totalRepetitions}")
    @DisplayName("GoogleTest")
    public void googleTest() {
        Selenide.open("https://google.com");
        $x("132").click();
    }
}
