package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature(value = "Default interface")
@Owner(value = "Denis Krutikov")
public class TestOpenCleanPageInterface extends Settings {

    @Test
    @DisplayName(value = "Placeholder text")
    @Description(value = "Test placeholder text - \"What needs to be done?\"")
    @Severity(value = SeverityLevel.MINOR)
    public void testPlaceholderText(){
        todo.newTodo.shouldHave(attribute("placeholder","What needs to be done?"));
    }

    @Test
    @DisplayName(value = "Focus at input field")
    @Description(value = "Test input field for a new todo - field should be focused")
    @Severity(value = SeverityLevel.MINOR)
    public void testFocusAtTheLine(){
        todo.newTodo.shouldBe(focused);
    }

    @Test
    @DisplayName(value = "Header")
    @Description(value = "Test header text - \"todos\"")
    @Severity(value = SeverityLevel.MINOR)
    public void testHeader(){
        todo.header.shouldHave(text("todos"));
    }

    @Test
    @DisplayName(value = "Footer")
    @Description(value = "Test footer status - it shouldn't be visible")
    @Severity(value = SeverityLevel.MINOR)
    public void testFooter(){
        todo.footer.shouldNotBe(visible);
    }
}
