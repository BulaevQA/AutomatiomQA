package steps;

import com.codeborne.selenide.SelenideElement;
import faker.FakerData;
import io.qameta.allure.Step;
import methods.ElementCollections;
import methods.Validators;

import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeSteps {

    ElementCollections randomArrayElement = new ElementCollections();
    FakerData fakerData = new FakerData();
    Validators validators = new Validators();

    @Step(value = "Клик создать резюме")
    public ResumeSteps buttonCreateResume(){
        $x("//a[@class='button group-container__item']").click();
        return this;
    }
    @Step(value = "Клик на кнопку загрузить фото")
    public ResumeSteps clickPhotoIcon(){
        $x("//*[@id='photo-block']/button").click();
        return this;
    }
    @Step(value = "Импорт фото из файла")
    public ResumeSteps importPhoto(){
        File cvPhoto = new File("src/test/resources/cvPhoto.jpg");
        $x("//input[@class='upload__control']").uploadFile(cvPhoto);
        return this;
    }
    @Step(value = "Загрузка фото")
    public ResumeSteps uploadPhoto(){
        $x("//button[@class='group-container__item button']").click();
        return this;
    }
    @Step(value = "Поле желаемая должность")
    public ResumeSteps fieldPositionName(){
        $x("//input[@name='positionName']").setValue("Автотест");
        return this;
    }
    @Step(value = "Селект сфера деятельности")
    public ResumeSteps fieldSphere(){
        $x("//*[@data-id='professionSphereId']").click();
        return this;
    }
    @Step(value = "Ввод сферы деятельности")
    public ResumeSteps randomSphere(){
        randomArrayElement.randomElementCollectionClick("//select[@id='professionSphereId']//option[@value]");
        return this;
    }
    @Step(value = "Заполнение з/п")
    public ResumeSteps fieldSalary(){
        $x("//input[@name='salary']").setValue(fakerData.salary);
        return this;
    }
    @Step(value = "Селект изменение региона")
    public ResumeSteps fieldRegion(){
        $x("//button[@data-id='nationalityId']").click();
        return this;
    }
    @Step(value = "Изменение региона")
    public ResumeSteps region(){
        randomArrayElement.randomElementCollectionClick("//select[@id='nationalityId']//option[@value]");
        return this;
    }
    @Step(value = "Предпочтительный способ связи email")
    public ResumeSteps radioButtonMail(){
        $x("//span[contains(text(),'Лучше написать мне письмо')]").click();
        return this;
    }
    @Step(value = "Деактивация блока опыта работы")
    public ResumeSteps workExperience(){
        $x("//span[contains(text(),'Есть опыт работы')]").click();
        return this;
    }
    @Step(value = "Сохранить и опубликовать")
    public ResumeSteps buttonPublish(){
        $x("//button[@class='button group-container__item']").click();
        return this;
    }
    @Step(value = "Проверка страницы мои резюме")
    public ResumeSteps myResumeCheck(){
        validators.checkText("//h1[@class='content__title']", "Мои резюме");
        return this;
    }
}
