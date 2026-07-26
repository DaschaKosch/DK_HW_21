package tests.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfigOld {
    public String getBaseUrl() {
        //зачитываем значение из настроек
        String baseUrl = System.getProperty("baseUrl");
        // проверяем дефолтное значение
        if (Objects.isNull(baseUrl)) {
        baseUrl = "https://github.com";
        }
        //возвращаем результат
        return baseUrl;
    }
    public Browser getBrowser() {
        //зачитываем значение из настроек
       String browser = System.getProperty("browser");
        // проверяем дефолтное значение
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        //возвращаем результат с приведением типов
        return Browser.valueOf(browser);
    }
    public URL getRemoteURl() {
        //зачитываем значение из настроек
        String remoteURl = System.getProperty("remoteURl");
        // проверяем дефолтное значение
        if (Objects.isNull(remoteURl)) {
            remoteURl = "https://localhost:4444";
        }
        //возвращаем результат
        try {
            return new URL(remoteURl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
