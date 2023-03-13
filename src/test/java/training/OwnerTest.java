package training;

import com.codeborne.selenide.Selenide;
import helpers.OwnerData;
import helpers.TestValues;
import org.junit.jupiter.api.Test;
import pages.MainNonAuthPage;

public class OwnerTest {

    OwnerData ownerData = new OwnerData();
    @Test

    public void ownerTest () {
        new MainNonAuthPage()
                .openUrl("https://rtportal.show.pbs.bftcom.com/")
                .buttonLogin()
                .buttonEsiaAuth()
                .authForm(ownerData.authLoginCv(), ownerData.authPassCv());
    }
}
