package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */
@Feature("Action with todo")
@Owner("Denis Krutikov")
public class TestActionTodo extends Settings {

    @Test
    @DisplayName("Mark todo")
    @Description("Test mark todo")
    @Severity(SeverityLevel.CRITICAL)
    public void testMarkTodo(){
        todo.newTodo(1);
        todo.clickCheckboxTodo(1);
        todo.checkboxTodo(1).shouldBe(selected);
    }

    @Test
    @DisplayName("Unmark todo")
    @Description("Test unmark todo")
    public void testUnmarkTodo(){
        todo.newTodo(1);
        todo.clickCheckboxTodo(1);
        todo.clickCheckboxTodo(1);
        todo.checkboxTodo(1).shouldNotBe(selected);
    }

    @Test
    @DisplayName("Edit todo")
    @Description("Test edit initiation")
    public void testEditTodo(){
        todo.newTodo(1);
        todo.lineTodo(1).doubleClick();
        todo.lineTodo(1).shouldNotBe(readonly);
    }

    @Test
    @DisplayName( "Delete button status")
    @Description("Test visibility delete button - button should be visible while it hover at todo")
    public void testShowDeleteButtonTodo(){
        todo.newTodo(1);
        todo.lineTodo(1).hover();
        todo.deleteButton(1).shouldBe(visible);
    }
}