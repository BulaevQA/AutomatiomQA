package pages;

import com.codeborne.selenide.SelenideElement;
import faker.FakerData;
import io.qameta.allure.Step;
import methods.ElementCollections;

import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeConstructorPage {

    ElementCollections randomArrayElement = new ElementCollections();
    FakerData fakerData = new FakerData();

    private final static SelenideElement PHOTO_ICON = $x("//*[@id='photo-block']/button");
    private final static SelenideElement IMPORT_PHOTO = $x("//input[@class='upload__control']");
    private final static SelenideElement UPLOAD_PHOTO = $x("//button[@class='group-container__item button']");
    private final static SelenideElement POSITION_NAME = $x("//input[@name='positionName']");
    private final static SelenideElement WORK_SPHERE_FIELD = $x("//*[@data-id='professionSphereId']");
    private final static String RANDOM_WORK_SPHERE = "//*[@id='professionSphereId']//option[@value]";
    private final static SelenideElement SALARY = $x("//input[@name='salary']");
    private final static SelenideElement REGION = $x("//button[@data-id='nationalityId']");
    private final static String RANDOM_REGION = "//select[@id='nationalityId']//option[@value]";
    private final static SelenideElement WORK_EXPERIENCE = $x("//span[contains(text(),'Есть опыт работы')]");
    private final static SelenideElement PUBLISH = $x("//button[@class='button group-container__item']");

    @Step(value = "Клик на кнопку загрузить фото")
    public ResumeConstructorPage clickPhotoIcon(){
        PHOTO_ICON.click();
        return this;
    }
    @Step(value = "Импорт фото из файла")
    public ResumeConstructorPage importPhoto(){
        File cvPhoto = new File("src/test/resources/cvPhoto.jpg");
        IMPORT_PHOTO.uploadFile(cvPhoto);
        return this;
    }
    @Step(value = "Загрузка фото")
    public ResumeConstructorPage uploadPhoto(){
        UPLOAD_PHOTO.click();
        return this;
    }
    @Step(value = "Поле желаемая должность")
    public ResumeConstructorPage fieldPositionName(String value){
        POSITION_NAME.setValue(value);
        return this;
    }
    @Step(value = "Селект сфера деятельности")
    public ResumeConstructorPage fieldSphere(){
        WORK_SPHERE_FIELD.click();
        return this;
    }
    @Step(value = "Ввод сферы деятельности")
    public ResumeConstructorPage randomSphere(){
        randomArrayElement.randomElementCollectionClick(RANDOM_WORK_SPHERE);
        return this;
    }
    @Step(value = "Заполнение з/п")
    public ResumeConstructorPage fieldSalary(String salary){
        SALARY.setValue(salary);
        return this;
    }
    @Step(value = "Селект изменение региона")
    public ResumeConstructorPage fieldRegion(){
        REGION.click();
        return this;
    }
    @Step(value = "Изменение региона")
    public ResumeConstructorPage randomRegion(){
        randomArrayElement.randomElementCollectionClick(RANDOM_REGION);
        return this;
    }
    @Step(value = "Деактивация блока опыта работы")
    public ResumeConstructorPage workExperience(){
        WORK_EXPERIENCE.click();
        return this;
    }
    @Step(value = "Сохранить и опубликовать")
    public MyResumePage buttonPublish(){
        PUBLISH.click();
        return new MyResumePage();
    }
}
