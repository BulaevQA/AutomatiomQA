package helpers.other;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class ElementCollections {

    /**
     Клик на случайный элемент из коллеции элементов
     * @param $$x - Указываем XPath на коллекцию элементов
     */
    public void randomElementCollectionClick(ElementsCollection $$x) {
        List<SelenideElement> list = new ArrayList<>($$x);
        list.get(new Random().nextInt(list.size())).click();
    }

    /**
     Клик на все эллементы из коллекции
     * @param $$x - Указываем XPath на коллекцию элементов
     */
    public void elementsCollectionsClick(ElementsCollection $$x) {
        List<SelenideElement> list = new ArrayList<>($$x);
        list.forEach(SelenideElement::click);

    }

    /**
     Перебор href ссылок
     * @param $$x - Указываем XPath на коллекцию элементов
     */
    public void hrefCollection(ElementsCollection $$x) {
        List<String> list = new ArrayList<>();
        for(SelenideElement element : $$x) {
            list.add(element.getAttribute("href"));
        }
        list.forEach(Selenide::open);
    }

    /**
     Получение ссылок по коллекции элементов
     * @param $$x - Указываем XPath на коллекцию элементов
     */
    public List<String> getListLinks(ElementsCollection $$x) {
        List<String> list = new ArrayList<>();
        for(SelenideElement element : $$x) {
            list.add(element.getAttribute("href"));
        }
        return list;
    }

    /**
     Случайная href ссылка
     * @param $$x - Указываем XPath на коллекцию элементов
     */
    public void randomHref (ElementsCollection $$x) {
        List<String> list = new ArrayList<>();
        for(SelenideElement element : $$x) {
            list.add(element.getAttribute("href"));
        }
        open(list.get(new Random().nextInt(list.size())));
    }
}
