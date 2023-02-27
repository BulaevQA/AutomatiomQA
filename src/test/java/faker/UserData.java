package faker;

import static faker.FakerData.*;
public class UserData {
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String fullAddress;
    public String salary;
    public String rgnSphere;

    public UserData (){
        this.firstName = randomFirstName();
        this.lastName = randomLastName();
        this.email = randomEmail();
        this.phone = randomPhone();
        this.fullAddress = randomFullAddress();
        this.salary = randomSalary();
        this.rgnSphere = randomSphere();
    }
}
