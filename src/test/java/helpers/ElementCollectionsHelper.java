package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ElementCollectionsHelper {
    /**
     Клик на случайный элемент из коллеции элементов
     * @param elementsCollection - Указываем XPath на оллекцию элементов
     */
    public void randomElementCollectionClick(ElementsCollection elementsCollection) {
        elementsCollection.get(new Random().nextInt(elementsCollection.size())).click();
    }
    /*
    Клик на все эллементы из коллекции
    */
    public void elementsCollectionsClick(ElementsCollection elementsCollection) {
        for(int i = 0; i < elementsCollection.size(); i++) {
            elementsCollection.get(i).click();
        }
    }
    /*
    Перебор href ссылок
    */
    public void hrefCollection(ElementsCollection elementsCollection) {
        List<String> selectArray = new ArrayList<>();
        for(int i = 0; i < elementsCollection.size(); i++) {
            selectArray.add(elementsCollection.get(i).getAttribute("href"));
        }
        selectArray.forEach(Selenide::open);
    }
    /*
    Случайная href ссылка
    */
    public void randomHref(ElementsCollection elementsCollection) {
        List<String> selectArray = new ArrayList<>();
        for(int i = 0; i < elementsCollection.size(); i++) {
            selectArray.add(elementsCollection.get(i).getAttribute("href"));
        }
        Selenide.open(selectArray.get(new Random().nextInt(selectArray.size())));
    }
}
