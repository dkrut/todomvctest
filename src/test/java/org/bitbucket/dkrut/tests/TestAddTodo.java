package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestAddTodo extends Settings {

    @Test
    public void testAddFewTodo(){
        int count = 2;
        todo.newTodo(count);
        todo.todoList.shouldHave(size(count));
    }

    @Test
    public void testClearInputNewTodo(){
        todo.newTodo(1);
        todo.newTodo.shouldBe(visible);
        todo.newTodo.shouldBe(focused);
        todo.newTodo.shouldNotBe(readonly);
    }

    @Test
    public void testSorting(){ //new Todo shoulbe added at the end of list
        todo.newTodo(2);
        todo.lineTodo(1).shouldHave(text(todo.nameTodo(1)));
        todo.lineTodo(2).shouldHave(text(todo.nameTodo(2)));
    }
}