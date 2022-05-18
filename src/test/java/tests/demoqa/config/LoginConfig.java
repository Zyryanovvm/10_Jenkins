package tests.demoqa.config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/Login.properties")
public interface LoginConfig extends Config {
    String login();
    String password();
}
