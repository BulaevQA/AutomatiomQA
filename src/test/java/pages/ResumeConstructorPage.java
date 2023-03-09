package pages;

import com.codeborne.selenide.SelenideElement;
import helpers.ElementCollectionsHelper;
import io.qameta.allure.Step;

import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class ResumeConstructorPage {

    private final SelenideElement PHOTO_ICON = $x("//*[@id='photo-block']/button");
    private final SelenideElement IMPORT_PHOTO = $x("//input[@class='upload__control']");
    private final SelenideElement UPLOAD_PHOTO = $x("//button[@data-action='save_img']");
    private final SelenideElement POSITION_NAME = $x("//input[@name='positionName']");
    private final SelenideElement WORK_SPHERE_FIELD = $x("//*[@data-id='professionSphereId']");
    private final SelenideElement SALARY = $x("//input[@name='salary']");
    private final SelenideElement REGION = $x("//button[@data-id='nationalityId']");
    private final SelenideElement WORK_EXPERIENCE = $x("//span[contains(text(),'Есть опыт работы')]");
    private final SelenideElement PUBLISH = $x("//button[@class='button group-container__item']");
    private final String SCHEDULE = "//*[text()='График работы']/..//label//input[not(contains(@checked, 'checked'))]/..";
    private final String RANDOM_WORK_SPHERE = "//*[@id='professionSphereId']//option[position()>2]";
    private final String RANDOM_REGION = "//select[@id='nationalityId']//option[position()>1]";

    @Step(value = "Загрузка фото соискателя")
    public ResumeConstructorPage uploadResumePhoto(File photo) {
        PHOTO_ICON.click();
        IMPORT_PHOTO.uploadFile(photo);
        UPLOAD_PHOTO.click();
        return this;
    }

    @Step(value = "Поле желаемая должность")
    public ResumeConstructorPage fieldPositionName(String value) {
        POSITION_NAME.setValue(value);
        return this;
    }

    @Step(value = "Заполнение селекта сферы деятельности")
    public ResumeConstructorPage fieldSphere() {
        WORK_SPHERE_FIELD.click();
        new ElementCollectionsHelper().randomElementCollectionClick(RANDOM_WORK_SPHERE);
        return this;
    }

    @Step(value = "Заполнение з/п")
    public ResumeConstructorPage fieldSalary(String salary) {
        SALARY.setValue(salary);
        return this;
    }

    @Step(value = "Изменение гражданства")
    public ResumeConstructorPage fieldRegion() {
        REGION.click();
        new ElementCollectionsHelper().randomElementCollectionClick(RANDOM_REGION);
        return this;
    }

    @Step(value = "Деактивация блока опыта работы")
    public ResumeConstructorPage workExperienceDisable() {
        WORK_EXPERIENCE.click();
        return this;
    }

    @Step(value = "Сохранить и опубликовать")
    public MyResumePage buttonPublish() {
        PUBLISH.click();
        return new MyResumePage();
    }
}
