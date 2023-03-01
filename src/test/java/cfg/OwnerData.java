package cfg;

import org.aeonbits.owner.ConfigFactory;

public class OwnerData {

    OwnerAPI configProperties = ConfigFactory.create(OwnerAPI.class);

    public String authLoginCv() {
        return configProperties.loginCV();
    }
    public String authPassCv() {
        return configProperties.passwordCV();
    }
    public String baseUrl(){
        return configProperties.testUrl();
    }
    public String loginCv = authLoginCv();
    public String passCv = authPassCv();
    public String mainUrl = baseUrl();

}
