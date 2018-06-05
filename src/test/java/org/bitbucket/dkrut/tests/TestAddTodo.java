package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature(value = "Add new todo")
@Owner(value = "Denis Krutikov")
public class TestAddTodo extends Settings {

    @Test
    @DisplayName(value = "Add few todo")
    @Description(value = "Test add few todo")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testAddFewTodo(){
        int count = 2;
        todo.newTodo(count);
        todo.todoList.shouldHave(size(count));
    }

    @Test
    @DisplayName(value = "Clearing input field")
    @Description(value = "Test clearing input field after adding todo. Input field should be focused and editable")
    public void testClearInputNewTodo(){
        todo.newTodo(1);
        todo.newTodo.shouldBe(visible);
        todo.newTodo.shouldBe(focused);
        todo.newTodo.shouldNotBe(readonly);
    }

    @Test
    @DisplayName(value = "Sorting added todo")
    @Description(value = "Test sorting added todo. New Todo shoulbe added at the end of list")
    public void testSorting(){
        todo.newTodo(2);
        todo.lineTodo(1).shouldHave(text(todo.nameTodo(1)));
        todo.lineTodo(2).shouldHave(text(todo.nameTodo(2)));
    }
}