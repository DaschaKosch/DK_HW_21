package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.components.TextBoxResultComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


    public class TextBoxPage {

        //===== Components =====
        private final TextBoxResultComponent resultComponent = new TextBoxResultComponent();

        // ===== Elements =====
        private final SelenideElement userNameInput = $("#userName");
        private final SelenideElement userEmailInput = $("#userEmail");
        private final SelenideElement currentAddressInput = $("#currentAddress");
        private final SelenideElement permanentAddressInput = $("#permanentAddress");
        private final SelenideElement submitButton = $("#submit");
        private final SelenideElement outputResults = $("#output");


        // ===== Actions ======
        @Step("Output results should not be visible")
        public void outputShouldNotBeVisible() {
            outputResults.shouldNotBe(visible);
        }

        @Step("Output results should be visible")
        public TextBoxPage outputShouldBeVisible() {
            outputResults.shouldBe(visible);
            return this;
        }
        @Step("Type user name \"{value}\"")
        public TextBoxPage typeUserName(String value) {
            userNameInput.setValue(value);
            return this;
        }
        @Step("Type current address \"{value}\"")
        public TextBoxPage typeCurrentAddress(String value) {
            currentAddressInput.setValue(value);
            return this;
        }
        @Step("Type permanent address \"{value}\"")
        public TextBoxPage typePermanentAddress(String value) {
            permanentAddressInput.setValue(value);
            return this;
        }
        @Step("Type user email \"{value}\"")
        public TextBoxPage typeUserEmail(String value) {
            userEmailInput.setValue(value);
            return this;
        }
        @Step("Open registration page /text-box")
        public TextBoxPage openPage() {
            open("/text-box");
            return this;

        }
        @Step("Submit form")
        public void submitForm() {
            submitButton.scrollTo().click();
        }

        @Step("Get result {resultComponent}")
        public TextBoxResultComponent getResult() {
            return resultComponent;
        }



    }


