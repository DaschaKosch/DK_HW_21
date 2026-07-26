package tests.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxResultComponent {
    private final SelenideElement outputResults = $("#output");

    public TextBoxResultComponent checkResult(String value) {
        outputResults.shouldHave(text(value));
        return this;
    }
}

