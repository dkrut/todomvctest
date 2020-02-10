package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Add new todo")
@Owner("Denis Krutikov")
public class TestAddTodo extends TestBase {

    @Test
    @DisplayName("Add few todo")
    @Description("Test add few todo")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddFewTodo(){
        int count = 2;
        todo.newTodo(count);
        todo.todoList.shouldHave(size(count));
    }

    @Test
    @DisplayName("Clearing input field")
    @Description("Test clearing input field after adding todo. Input field should be focused and editable")
    public void testClearInputNewTodo(){
        todo.newTodo(1);
        todo.newTodo.shouldBe(visible);
        todo.newTodo.shouldBe(focused);
        todo.newTodo.shouldNotBe(readonly);
    }

    @Test
    @DisplayName("Sorting added todo")
    @Description("Test sorting added todo. New Todo shoulbe added at the end of list")
    public void testSorting(){
        todo.newTodo(2);
        todo.lineTodo(1).shouldHave(text(todo.nameTodo(1)));
        todo.lineTodo(2).shouldHave(text(todo.nameTodo(2)));
    }
}