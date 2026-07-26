package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;


public class TextBoxTests extends TestBase {
    tests.testdata.TestData data = new tests.testdata.TestData();
    @Test
    @DisplayName("Successful FormFill")
    void successfulFormFillTestWithFaker() {
        step("Open textBoxPage", () ->
                textBoxPage.openPage());
        step("Fill textBoxPage", () -> {
        textBoxPage.typeUserName(data.userName)
                .typeUserEmail(data.userEmail)
                .typeCurrentAddress(data.currentAddress)
                .typePermanentAddress(data.permanentAddress)
                .submitForm();
        });
        step("Check textBoxPage results", () -> {
        textBoxPage.outputShouldBeVisible()
                .getResult()
                .checkResult(data.userName)
                .checkResult(data.userEmail)
                .checkResult(data.currentAddress)
                .checkResult(data.permanentAddress);
        });

    }

    @Test
    @DisplayName("Invalid email format")
    void  invalidEmailFormatTestWithFaker() {
        step("Open textBoxPage", () ->
                textBoxPage.openPage());
        step("Fill textBoxPage", () -> {
        textBoxPage.typeUserName(data.userName)
                .typeUserEmail(data.negativeUserEmail)
                .typeCurrentAddress(data.currentAddress)
                .typePermanentAddress(data.permanentAddress)
                .submitForm();
        });
        step("Check textBoxPage results", () -> {
        textBoxPage.outputShouldNotBeVisible();
        });
    }

}