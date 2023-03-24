package helpers.owner;

import helpers.owner.OwnerAPI;
import org.aeonbits.owner.ConfigFactory;

public class OwnerData {

    static OwnerAPI configProperties = ConfigFactory.create(OwnerAPI.class);

    public String authLoginCv() {
        return configProperties.loginCV();
    }
    public String authPassCv() {
        return configProperties.passwordCV();
    }
    public String baseUrl(){
        return configProperties.testUrl();
    }
}
