package settings;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;

public class RandomArrayElement {
    public void selectArray(String value){
        ElementsCollection selectList = $$x(value);
        Random random = new Random();
        List<WebElement> selects = new ArrayList<>();
        selectList.forEach(x->selects.add(x.getWrappedElement()));
        int randomNumber = random.nextInt(selects.size());
        selects.get(randomNumber).click();
    }
}
