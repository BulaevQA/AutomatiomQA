package helpers;

import com.github.javafaker.Faker;

import java.io.File;

public class TestValues {

    private final String URL = System.getProperty("base_url", "http://localhost:8080/");
    private final String LOGIN = System.getProperty("login", "admin");
    private final String PASSWORD = System.getProperty("password", "admin");
    private final String POSITION_NAME = new Faker().bothify("Автотест####");
    private final String SALARY = "35000";
    private final String EXPECTED_CABINET = "Мой кабинет";
    private final String EXPECTED_MY_RESUME = "Мои резюме";
    private final File cvPhoto = new File("src/test/resources/cvPhoto.jpg");

    public String getURL() {
        return URL;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getPOSITION_NAME() {
        return POSITION_NAME;
    }

    public String getSALARY() {
        return SALARY;
    }

    public String getEXPECTED_CABINET() {
        return EXPECTED_CABINET;
    }

    public String getEXPECTED_MY_RESUME() {
        return EXPECTED_MY_RESUME;
    }

    public File getCvPhoto() {
        return cvPhoto;
    }
}
