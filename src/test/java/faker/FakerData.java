package faker;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class FakerData {

    private static Random random = new Random();
    private static Faker faker = new Faker(new Locale("ru"));
    private static String salary = faker.bothify("3####");
    private static String firstName = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String email = faker.bothify("??????@gmail.com");
    private static String phone = faker.bothify("8921#######");
    private static String addres = faker.address().fullAddress();
    private static String[] workSphere = {"Высший менеджмент", "Домашний персонал", "Искусство и культура"};

    /*
    Генерируем случайные данные для переменных
    */
    public static String randomFirstName() {
        return firstName;
    }
    public static String randomLastName() {
        return lastName;
    }
    public static String randomEmail() {
        return email;
    }
    public static String randomPhone() {
        return phone;
    }
    public static String randomFullAddress() {
        return addres;
    }
    public String randomSalary() {
        return salary;
    }
    public static String randomSphere() {
        return workSphere[random.nextInt(workSphere.length)];
    }
}
