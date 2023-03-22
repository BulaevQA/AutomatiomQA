package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElementCollections {
    /**
     Клик на случайный элемент из коллеции элементов
     * @param $$x - Указываем XPath на оллекцию элементов
     */
    public void randomElementCollectionClick(ElementsCollection $$x) {
        $$x.get(new Random().nextInt($$x.size())).click();
    }
    /*
    Клик на все эллементы из коллекции
    */
    public void elementsCollectionsClick(ElementsCollection $$x) {
        for(int i = 0; i < $$x.size(); i++) {
            $$x.get(i).click();
        }
    }
    /*
    Перебор href ссылок
    */
    public void hrefCollection(ElementsCollection $$x) {
        List<String> selectArray = new ArrayList<>();
        for(int i = 0; i < $$x.size(); i++) {
            selectArray.add($$x.get(i).getAttribute("href"));
        }
        selectArray.forEach(Selenide::open);
    }
    /*
    Случайная href ссылка
    */
    public void randomHref(ElementsCollection $$x) {
        List<String> selectArray = new ArrayList<>();
        for(int i = 0; i < $$x.size(); i++) {
            selectArray.add($$x.get(i).getAttribute("href"));
        }
        Selenide.open(selectArray.get(new Random().nextInt(selectArray.size())));
    }
}
