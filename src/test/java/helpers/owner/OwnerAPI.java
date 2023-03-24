package helpers.owner;

import org.aeonbits.owner.Config;
@Config.Sources({"file:./src/test/resources/config.properties"})
public interface OwnerAPI extends Config {
    String loginCV();
    String passwordCV();
    String testUrl();


}
