package training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrainingTest extends TrainingConfig {

    @Test
    public void trainingTest() {
        new MainTrainingPage()
                .openWebPage("https://rtportal.show.pbs.bftcom.com/");
        Assertions.assertEquals(new MainTrainingPage().firstValue(), new MainTrainingPage().secondValue());
    }
}
