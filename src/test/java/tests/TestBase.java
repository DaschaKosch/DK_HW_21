package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import tests.helpers.Attach;
import tests.pages.TextBoxPage;
import tests.utils.SelenideSetup;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeEach
    void setUp() {
        SelenideSetup.applyConfig();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }


    @AfterEach
    void addAttachments() {
        try {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        } finally {
            closeWebDriver();
        }
    }
}

