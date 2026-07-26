package tests.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.function.Supplier;

public class WebDriverProviderExample implements Supplier<WebDriver> {

    private final WebDriverConfigExample config;

    public WebDriverProviderExample() {
        this.config = ConfigFactory.create(WebDriverConfigExample.class, System.getProperties());
    }

    public WebDriverProviderExample(final WebDriverConfigOld config) {
        this.config = (WebDriverConfigExample) config;
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    public WebDriver createDriver() {
        switch (config.getBrowser()) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default -> {
                throw new RuntimeException("No such driver");
            }
        }

    }
}

