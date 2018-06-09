package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Default interface")
@Owner("Denis Krutikov")
public class TestOpenCleanPageInterface extends Settings {

    @Test
    @DisplayName("Placeholder text")
    @Description("Test placeholder text - \"What needs to be done?\"")
    @Severity(SeverityLevel.MINOR)
    public void testPlaceholderText(){
        todo.newTodo.shouldHave(attribute("placeholder","What needs to be done?"));
    }

    @Test
    @DisplayName("Focus at input field")
    @Description("Test input field for a new todo - field should be focused")
    @Severity(SeverityLevel.MINOR)
    public void testFocusAtTheLine(){
        todo.newTodo.shouldBe(focused);
    }

    @Test
    @DisplayName("Header")
    @Description("Test header text - \"todos\"")
    @Severity(SeverityLevel.MINOR)
    public void testHeader(){
        todo.header.shouldHave(text("todos"));
    }

    @Test
    @DisplayName("Footer")
    @Description("Test footer status - it shouldn't be visible")
    @Severity(SeverityLevel.MINOR)
    public void testFooter(){
        todo.footer.shouldNotBe(visible);
    }
}
