package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import settings.RandomArrayElement;
import java.io.File;
import static com.codeborne.selenide.Selenide.$x;
public class ResumeSteps extends RandomArrayElement {

    @Step(value = "Закрыть всплывающее уведомление")
    public ResumeSteps buttonCloseCookie(){
        $x("//div[@class='col-12 col-md-3 col-lg-2']").click();
        return this;
    }
    @Step(value = "Клик создать резюме")
    public ResumeSteps buttonCV(){
        $x("//a[@class='button group-container__item']").click();
        return this;
    }
    @Step(value = "Клик на кнопку загрузить фото")
    public ResumeSteps clickPhoto(){
        $x("//*[@id='photo-block']/button").click();
        return this;
    }
    @Step(value = "Импорт фото из файла")
    public ResumeSteps importPhoto(){
        File cvPhoto = new File("src/test/resources/config/cvPhoto.jpg");
        $x("//input[@class='upload__control']").uploadFile(cvPhoto);
        return this;
    }
    @Step(value = "Подтвеждение фото")
    public ResumeSteps uploadPhoto(){
        $x("//button[@class='group-container__item button']").click();
        return this;
    }
    @Step(value = "Поле желаемая должность")
    public ResumeSteps positionName(){
        $x("//input[@name='positionName']").setValue("Автотест");
        return this;
    }
    @Step(value = "Селект сфера деятельности")
    public ResumeSteps clickSphere(){
        $x("//*[@data-id='professionSphereId']").click();
        return this;
    }
    @Step(value = "Ввод сферы деятельности")
    public ResumeSteps randomSphere(){
        selectArray("//select[@id='professionSphereId']//option[@value]");
        return this;
    }
    @Step(value = "Заполнение З/П")
    public ResumeSteps salary(String value){
        $x("//input[@name='salary']").setValue(value);
        return this;
    }
    @Step(value = "Селект изменение региона")
    public ResumeSteps clickRegion(){
        $x("//button[@data-id='nationalityId']").click();
        return this;
    }
    @Step(value = "Изменение региона")
    public ResumeSteps region(){
        selectArray("//select[@id='nationalityId']//option[@value]");
        return this;
    }
    @Step(value = "Предпочтительный способ связи email")
    public ResumeSteps favoriteMail(){
        $x("//span[contains(text(),'Лучше написать мне письмо')]").click();
        return this;
    }
    @Step(value = "Деактивация блока опыта работы")
    public ResumeSteps lvlWork(){
        $x("//span[contains(text(),'Есть опыт работы')]").click();
        return this;
    }
    @Step(value = "Сохранить и опубликовать")
    public ResumeSteps buttonSaveResume(){
        $x("//button[@class='button group-container__item']").click();
        return this;
    }
    @Step(value = "Проверка перехода на страницу Мои резюме")
    public void pageMyResume(){
        $x("//span//span[@itemprop='name']").should(Condition.text("Мои резюме"));
    }
}
