package HelpDesk;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getConfig("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    Integer TICKETID = readConfig().getInt("ticketId");
    String TITLE = readConfig().getString("ticketParams.title");
    String BODY = readConfig().getString("ticketParams.body");
    String EMAIL = readConfig().getString("ticketParams.email");
}
