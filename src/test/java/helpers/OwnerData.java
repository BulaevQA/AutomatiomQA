package helpers;

import helpers.OwnerAPI;
import org.aeonbits.owner.ConfigFactory;

public class OwnerData {

    static OwnerAPI configProperties = ConfigFactory.create(OwnerAPI.class);

    public String authLoginCv() {
        return configProperties.loginCV();
    }
    public String authPassCv() {
        return configProperties.passwordCV();
    }
    public static String baseUrl(){
        return configProperties.testUrl();
    }
}
