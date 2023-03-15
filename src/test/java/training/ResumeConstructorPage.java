//package training;
//
//import com.codeborne.selenide.ElementsCollection;
//import com.codeborne.selenide.SelenideElement;
//import helpers.ElementCollectionsHelper;
//import io.qameta.allure.Step;
//import pages.MyResumePage;
//
//import java.io.File;
//
//import static com.codeborne.selenide.Selenide.$$x;
//import static com.codeborne.selenide.Selenide.$x;
//
//public class ResumeConstructorPage {
//
//    /** Блок "Основная информация" */
//    private final SelenideElement photoIcon = $x("//span[contains(text(),'Загрузить')]/..");
//    private final SelenideElement importPhoto = $x("//*[text()='Выбрать файл']/..//input");
//    private final SelenideElement uploadPhoto = $x("//*[text()='Загрузить']");
//    private final SelenideElement positionName = $x("//*[text()='Желаемая должность']/..//input");
//    private final SelenideElement profession = $x("//*[text()='Профессия']/..//button[@data-id]");
//    private final SelenideElement workSphereField = $x("//*[text()='Сфера деятельности']/..//button");
//    private final SelenideElement salary = $x("//input[@name='salary']");
//    private final SelenideElement readyToWorkDate = $x("//*[text()='Готов приступить к работе с']/..//input");
//
//    /** Блок "Контактные данные" */
//    private final SelenideElement city = $x("//*[text()='Населенный пункт']/..//button");
//    private final SelenideElement phone = $x("//*[text()='Телефон']/..//input[@class]");
//    private final SelenideElement preferEmail = $x("//*[text()='Лучше написать мне письмо']/../..");
//    private final SelenideElement preferPhone = $x("//*[text()='Лучше звонить мне по телефону']/../..");
//    private final SelenideElement socialMedia = $x("//*[text()='Социальная сеть']/ancestor::button");
//    private final SelenideElement socialMediaLink = $x("//div[@id='block-socialNetwork']//input");
//    private final SelenideElement addSocialMedia = $x("//div[@id='block-socialNetwork']/following-sibling::button[1]");
//    private final SelenideElement removeSocialMedia = $x("//div[@id='block-socialNetwork']//div/following-sibling::div[2]//p//button");
//    private final SelenideElement messenger = $x("//*[text()='Мессенджеры']/following-sibling::button");
//    private final SelenideElement addMessenger = $x("//div[@id='block-socialNetwork']/following-sibling::button[2]");
//    private final SelenideElement removeMessenger = $x("//div[@id='block-messengers']//div/following-sibling::div//p//button");
//    private final SelenideElement skillsNetToggle = $x("//*[text()= 'Отображать мой профиль Skillsnet в резюме']/../..");
//
//    /** Блок "Опыт работы" */
//    private final SelenideElement hasWorkExperienceToggle = $x("//span[contains(text(),'Есть опыт работы')]");
//    private final SelenideElement organizationName = $x("//*[text()='Организация']/..//input");
//    private final SelenideElement candidatePosition = $x("//*[text()='Должность']/..//input");
//    private final SelenideElement relevantWorkExperience = $x("//*[text()='Опыт работы является релевантным']/..");
//    private final SelenideElement startDatePreviousWork = $x("//*[text()='Начало работы']/..//button");
//
//    /** Заполнение выподающего списка
//     * dropDownMenuInputValue - вводим значение в поиск выпадающего списка
//     * dropDownConfirmValue - если нужно выбрать первый самый подходящий вариант
//     * dropDownClearField - очищение заполненого поля кнопкой "Крестик"
//     * dropDownConfirmValueRandom - если нужно выбрать случайный элемент из списка коллеции
//     */
//    private final SelenideElement dropDownMenuInputValue = $x("//div[@class='dropdown-menu show']//input");
//    private final SelenideElement dropDownConfirmValue = $x("//div[@class='dropdown-menu show']//a");
//    private final SelenideElement dropDownClearField = $x("//div[@class='dropdown-menu show']//div//button");
//    private final ElementsCollection dropDownConfirmValueRandom = $$x("//div[@class='dropdown-menu show']//a[not(contains(@class, 'active'))]");
//
//    /** Функциональыне кнопки */
//    private final SelenideElement saveAndPublishResume = $x("//*[text()='Сохранить и опубликовать']");
//    private final SelenideElement saveResume = $x("//*[text()='Сохранить без публикации']");
//    private final SelenideElement previewResume = $x("//*[text()='Предпросмотр']");
//    private final SelenideElement cansel = $x("//a[text()='Отмена']");
//
//    private final ElementsCollection schedule = $$x("//*[text()='График работы']/..//label//input[not(contains(@checked, 'check'))]/..");
//    private final ElementsCollection additionalBlocks = $$x("//div[@class='row mb-2']//div[@id]");
//    private final ElementsCollection navigationList = $$x("//div[@class='navigation__list']//a[@href]");
//
//    @Step(value = "Активация дополнительных блоков")
//    public ResumeConstructorPage activateAdditionalBlocks() {
//        new ElementCollectionsHelper().elementsCollectionsClick(additionalBlocks);
//        return this;
//    }
//    @Step(value = "Проверка блока навигации")
//    public ResumeConstructorPage navigationList() {
//        new ElementCollectionsHelper().elementsCollectionsClick(navigationList);
//        return this;
//    }
//
//    @Step(value = "Загрузка фото соискателя")
//    public ResumeConstructorPage uploadResumePhoto() {
//        File cvPhoto = new File("src/test/resources/cvPhoto.jpg");
//        photoIcon.click();
//        importPhoto.uploadFile(cvPhoto);
//        uploadPhoto.click();
//        return this;
//    }
//
//    @Step(value = "Поле желаемая должность")
//    public ResumeConstructorPage fieldPositionName(String value) {
//        positionName.setValue(value);
//        return this;
//    }
//
//    @Step(value = "Поле профессия")
//    public ResumeConstructorPage fieldProfessionName(String value) {
//        profession.click();
//        dropDownMenuInputValue.setValue(value);
//        dropDownConfirmValue.click();
//        return this;
//    }
//
//    @Step(value = "Заполнение сферы деятельности")
//    public ResumeConstructorPage fieldSphere() {
//        workSphereField.click();
//        new ElementCollectionsHelper().randomElementCollectionClick(dropDownConfirmValueRandom);
//        return this;
//    }
//
//    @Step(value = "Заполнение з/п")
//    public ResumeConstructorPage fieldSalary(String salaryValue) {
//        salary.setValue(salaryValue);
//        return this;
//    }
//    @Step(value = "Заполнение поля готов к переезду")
//    public ResumeConstructorPage fieldReadyToWorkDate(String value) {
//        readyToWorkDate.setValue(value);
//        return this;
//    }
//
//    @Step(value = "Деактивация блока опыта работы")
//    public ResumeConstructorPage workExperienceDisable() {
//        workExperience.click();
//        return this;
//    }
//
//    @Step(value = "Сохранить и опубликовать")
//    public MyResumePage buttonPublish() {
//        saveAndPublishResume.click();
//        return new MyResumePage();
//    }
//}
