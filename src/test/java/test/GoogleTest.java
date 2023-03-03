package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import owner.OwnerData;

import static com.codeborne.selenide.Configuration.baseUrl;

public class GoogleTest extends OwnerData {
    @Test
    @Tag("smoke")
    public void googleTest(){
        Selenide.open(baseUrl);
    }
}
