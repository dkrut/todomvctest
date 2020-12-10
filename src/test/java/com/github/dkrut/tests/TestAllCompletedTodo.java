package com.github.dkrut.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Complete todo")
@Owner("Denis Krutikov")
public class TestAllCompletedTodo extends TestBase {

    @Test
    @DisplayName("Check all todo completed")
    @Description("Test marking all todo completed")
    public void testCheckAllTodoCompleted(){
        todo.newTodo(2);
        todo.clickToggleAllCompleted();
        todo.checkboxTodo(1).shouldBe(selected);
        todo.checkboxTodo(2).shouldBe(selected);
    }

    @Test
    @DisplayName("Uncheck all todo completed")
    @Description("Test unmarking all todo completed")
    public void testUncheckAllTodoCompleted(){
        todo.newTodo(2);
        todo.clickToggleAllCompleted();
        todo.clickToggleAllCompleted();
        todo.checkboxTodo(1).shouldNotBe(selected);
        todo.checkboxTodo(2).shouldNotBe(selected);
    }
}