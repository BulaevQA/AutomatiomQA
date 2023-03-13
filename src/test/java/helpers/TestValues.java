package helpers;

import com.github.javafaker.Faker;

import java.io.File;

public class TestValues {

    public static final String URL = System.getProperty("base_url", "http://localhost:8080/");
    public static final String LOGIN = System.getProperty("login", "admin");
    public static final String PASSWORD = System.getProperty("password", "admin");
    public static final String POSITION_NAME = new Faker().bothify("Автотест####");
    public static final String SALARY = "35000";
    public static final String EXPECTED_CABINET = "Мой кабинет";
    public static final String EXPECTED_MY_RESUME = "Мои резюме";
    public static final File cvPhoto = new File("src/test/resources/cvPhoto.jpg");
}
