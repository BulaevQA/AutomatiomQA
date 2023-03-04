package pages;

import faker.FakerData;
import io.qameta.allure.Step;
import methods.ElementCollections;

import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeConstructorPage {

    ElementCollections randomArrayElement = new ElementCollections();
    FakerData fakerData = new FakerData();
    Validators validators = new Validators();

    @Step(value = "Клик создать резюме")
    public ResumeConstructorPage buttonCreateResume(){
        $x("//a[@class='button group-container__item']").click();
        return this;
    }
    @Step(value = "Клик на кнопку загрузить фото")
    public ResumeConstructorPage clickPhotoIcon(){
        $x("//*[@id='photo-block']/button").click();
        return this;
    }
    @Step(value = "Импорт фото из файла")
    public ResumeConstructorPage importPhoto(){
        File cvPhoto = new File("src/test/resources/cvPhoto.jpg");
        $x("//input[@class='upload__control']").uploadFile(cvPhoto);
        return this;
    }
    @Step(value = "Загрузка фото")
    public ResumeConstructorPage uploadPhoto(){
        $x("//button[@class='group-container__item button']").click();
        return this;
    }
    @Step(value = "Поле желаемая должность")
    public ResumeConstructorPage fieldPositionName(){
        $x("//input[@name='positionName']").setValue("Автотест");
        return this;
    }
    @Step(value = "Селект сфера деятельности")
    public ResumeConstructorPage fieldSphere(){
        $x("//*[@data-id='professionSphereId']").click();
        return this;
    }
    @Step(value = "Ввод сферы деятельности")
    public ResumeConstructorPage randomSphere(){
        randomArrayElement.randomElementCollectionClick("//select[@id='professionSphereId']//option[@value]");
        return this;
    }
    @Step(value = "Заполнение з/п")
    public ResumeConstructorPage fieldSalary(){
        $x("//input[@name='salary']").setValue(fakerData.randomSalary());
        return this;
    }
    @Step(value = "Селект изменение региона")
    public ResumeConstructorPage fieldRegion(){
        $x("//button[@data-id='nationalityId']").click();
        return this;
    }
    @Step(value = "Изменение региона")
    public ResumeConstructorPage region(){
        randomArrayElement.randomElementCollectionClick("//select[@id='nationalityId']//option[@value]");
        return this;
    }
    @Step(value = "Предпочтительный способ связи email")
    public ResumeConstructorPage radioButtonMail(){
        $x("//span[contains(text(),'Лучше написать мне письмо')]").click();
        return this;
    }
    @Step(value = "Деактивация блока опыта работы")
    public ResumeConstructorPage workExperience(){
        $x("//span[contains(text(),'Есть опыт работы')]").click();
        return this;
    }
    @Step(value = "Сохранить и опубликовать")
    public ResumeConstructorPage buttonPublish(){
        $x("//button[@class='button group-container__item']").click();
        return this;
    }
    @Step(value = "Проверка страницы мои резюме")
    public ResumeConstructorPage myResumeCheck(){
        validators.checkText("//h1[@class='content__title']", "Мои резюме");
        return this;
    }
}
