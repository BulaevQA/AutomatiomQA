package test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import owner.OwnerData;

public class GoogleTest extends OwnerData {
    @Test
    public void googleTest(){
        Selenide.open(googleUrl);
    }
}
