package com.github.dkrut.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */
@Feature("Action with todo")
@Owner("Denis Krutikov")
public class TestActionTodo extends TestBase {

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