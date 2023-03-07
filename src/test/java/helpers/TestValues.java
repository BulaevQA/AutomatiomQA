package helpers;

import com.github.javafaker.Faker;

public class TestValues {

//    public static String URL = System.getProperty("base_url", "http://localhost:8080/");
//    public static String LOGIN = System.getProperty("login", "admin");
//    public static String PASSWORD = System.getProperty("password", "admin");
    public static String POSITION_NAME = new Faker().bothify("Автотест####");
    public static String SALARY = "35000";
    public static String EXPECTED_CABINET = "Мой кабинет";
    public static String EXPECTED_MY_RESUME = "Мои резюме";
    public static String URL = "https://web-hotfix-test02.k8s.trudvsem.ru/";
    public static String LOGIN = "89674407691";
    public static String PASSWORD = "Ex3t8yh96mj!";
}
