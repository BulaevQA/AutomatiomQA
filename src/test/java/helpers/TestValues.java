package helpers;

import pages.MainCvPage;

public class TestValues {

    public static String URL = System.getProperty("base_url", "http://localhost:8080/");
    public static String LOGIN = System.getProperty("login", "admin");
    public static String PASSWORD = System.getProperty("password", "admin");
    public static String POSITION_NAME = "Автотест";
    public static String SALARY = "35000";
    public static String EXPECTED_CABINET = "Мой кабинет";
    public static String EXPECTED_MY_RESUME = "Мои резюме";
}
