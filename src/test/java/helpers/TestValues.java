package helpers;

import com.github.javafaker.Faker;

import java.io.File;

public class TestValues {

    private static final String URL = System.getProperty("base_url", "http://localhost:8080/");
    private static final String LOGIN = System.getProperty("login", "admin");
    private static final String PASSWORD = System.getProperty("password", "admin");
    private static final String POSITION_NAME = new Faker().bothify("Автотест####");
    private static final String SALARY = "35000";
    private static final String EXPECTED_CABINET = "Мой кабинет";
    private static final String EXPECTED_MY_RESUME = "Мои резюме";
    private static final File cvPhoto = new File("src/test/resources/cvPhoto.jpg");

    public static String getURL() {
        return URL;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getPOSITION_NAME() {
        return POSITION_NAME;
    }

    public static String getSALARY() {
        return SALARY;
    }

    public static String getEXPECTED_CABINET() {
        return EXPECTED_CABINET;
    }

    public static String getEXPECTED_MY_RESUME() {
        return EXPECTED_MY_RESUME;
    }

    public static File getCvPhoto() {
        return cvPhoto;
    }
}
