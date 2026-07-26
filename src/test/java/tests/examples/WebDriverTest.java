package tests.examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private  WebDriver driver;

    @BeforeEach
    public void startDriver() {
       // driver = getDriver();
        driver = new WebDriverProviderExample().get();
    }

    @Test
    public void testGithub() {
        //WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        //WebDriver driver = getDriver();
        // driver.get("https://github.com");
        String title = driver.getTitle();
        assertEquals("GitHub: Where the world builds software GitHub", title);
       // driver.quit();
    }
    @Test
    public void testGithub2() {
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();

        //Подготовка драйвера
       // WebDriver driver = getDriver();
        //driver.get("https://github.com");

        // Тело выполнения теста
        String title = driver.getTitle();
        assertEquals("GitHub: Where the world builds software GitHub", title);
        //driver.quit();
    }
/*вынос драйвера в конфигурацию
    private WebDriver getDriver(){
        //WebDriverManager.chromedriver().setup(); //здесь можно менять драйвер для всех тестов
        WebDriverManager.firefoxdriver().setup();
       // return new ChromeDriver();
        return new FirefoxDriver();}*/


/* вынос драйвера и урла в конфигурацию
    private WebDriver getDriver(){
        //WebDriverManager.chromedriver().setup(); //здесь можно менять драйвер для всех тестов
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://github.com");
        // return new ChromeDriver();
        return driver;

    }*/
    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}

