package methods;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ElementCollections {
    /*
    Клик на случайный веб-элемент из коллекции эллементов
    */
    public void randomElementCollectionClick(String value){
        ElementsCollection selectList = $$x(value);
        List<WebElement> selects = new ArrayList<>();
        for (SelenideElement x : selectList) {
            selects.add(x.getWrappedElement());
        }
        int randomNumber = new Random().nextInt(selects.size());
        selects.get(randomNumber).click();
    }
    /*
    Переход на случайный href из коллекции эллементов
    */
    public void randomElementCollectionOpen(String value){
        ElementsCollection selectList = $$x(value);
        List<String> selects = new ArrayList<>();
        for (SelenideElement x : selectList) {
            selects.add(x.getAttribute("href"));
        }
        int randomNumber = new Random().nextInt(selects.size());
        Selenide.open(selects.get(randomNumber));
    }
    /*
    Перебор всех элементов с атрибутом href
    */
    public void FullElementsCollection(String value){
        ElementsCollection arraylist = $$x(value);
        List<String> elements = new ArrayList<>();
        for (SelenideElement x : arraylist) {
            elements.add(x.getAttribute("href"));
        }
        elements.forEach(Selenide::open);
        int a = 0;
    }
}
