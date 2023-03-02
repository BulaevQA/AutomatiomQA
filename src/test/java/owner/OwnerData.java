package owner;

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
    public static String gUrl(){
        return configProperties.googleUrl();
    }
    public String loginCv = authLoginCv();
    public String passCv = authPassCv();
    public static String mainUrl = baseUrl();
    public static String googleUrl = gUrl();
}
