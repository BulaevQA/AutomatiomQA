package faker;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class FakerData {

    static Faker faker = new Faker(new Locale("ru"));
    static Random random = new Random();

    public static String randomFirstName() {
        return faker.name().firstName();
    }
    public static String randomLastName() {
        return faker.name().lastName();
    }
    public static String randomEmail() {
        return faker.bothify("??????@pbs.bftcom.com");
    }
    public static String randomPhone() {
        return faker.bothify("8921#######");
    }
    public static String randomFullAddress() {
        return faker.address().fullAddress();
    }
    public static String randomSalary() {
        return faker.bothify("3####");
    }
    public static String randomSphere() {
        String[] arraySphere = {"Высший менеджмент", "Домашний персонал", "Искусство и культура"};
                return arraySphere[random.nextInt(arraySphere.length)];
    }
}
