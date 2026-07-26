package tests.examples;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfigExample extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteURL")
    @DefaultValue("https://localhost:4444")
    URL getRemoteURL();
}
