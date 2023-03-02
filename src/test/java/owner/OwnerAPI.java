package owner;

import org.aeonbits.owner.Config;
@Config.Sources({"file:./src/test/resources/config/config.properties"})
public interface OwnerAPI extends Config {
    String loginCV();
    String passwordCV();
    String testUrl();
    String googleUrl();
}
