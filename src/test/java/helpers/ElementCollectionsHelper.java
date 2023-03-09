package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ElementCollectionsHelper {
    /*
    Клик на случайный веб-элемент из коллекции эллементов
    */
    public void randomElementCollectionClick(String xpath) {
        ElementsCollection selectList = $$x(xpath);
        selectList.get(new Random().nextInt(selectList.size())).click();
    }
    /*
    Клик на все эллементы из коллекции
    */
    public void elementsCollectionsClick(String xpath) {
        ElementsCollection selectList = $$x(xpath);
        for(int i = 0; i < selectList.size(); i++) {
            selectList.get(i).click();
        }
    }
    /*
    Перебор href ссылок
    */
    public void hrefCollection(String xpath) {
        ElementsCollection selectList = $$x(xpath);
        List<String> selectArray = new ArrayList<>();
        for(int i = 0; i < selectList.size(); i++) {
            selectArray.add(selectList.get(i).getAttribute("href"));
        }
        selectArray.forEach(Selenide::open);
    }
    /*
    Случайная href ссылка
    */
    public void randomHref(String xpath) {
        ElementsCollection selectList = $$x(xpath);
        List<String> selectArray = new ArrayList<>();
        for(int i = 0; i < selectList.size(); i++) {
            selectArray.add(selectList.get(i).getAttribute("href"));
        }
        Selenide.open(selectArray.get(new Random().nextInt(selectArray.size())));
    }
}
