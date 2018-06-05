package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */
@Feature(value = "Action with todo")
@Owner(value = "Denis Krutikov")
public class TestActionTodo extends Settings {

    @Test
    @DisplayName(value = "Mark todo")
    @Description(value = "Test mark todo")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testMarkTodo(){
        todo.newTodo(1);
        todo.clickCheckboxTodo(1);
        todo.checkboxTodo(1).shouldBe(selected);
    }

    @Test
    @DisplayName(value = "Unmark todo")
    @Description(value = "Test unmark todo")
    public void testUnmarkTodo(){
        todo.newTodo(1);
        todo.clickCheckboxTodo(1);
        todo.clickCheckboxTodo(1);
        todo.checkboxTodo(1).shouldNotBe(selected);
    }

    @Test
    @DisplayName(value = "Edit todo")
    @Description(value = "Test edit initiation")
    public void testEditTodo(){
        todo.newTodo(1);
        todo.lineTodo(1).doubleClick();
        todo.lineTodo(1).shouldNotBe(readonly);
    }

    @Test
    @DisplayName(value = "Delete button status")
    @Description(value = "Test visibility delete button - button should be visible while it hover at todo")
    public void testShowDeleteButtonTodo(){
        todo.newTodo(1);
        todo.lineTodo(1).hover();
        todo.deleteButton(1).shouldBe(visible);
    }
}