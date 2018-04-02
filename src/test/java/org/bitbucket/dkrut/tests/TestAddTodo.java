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
        int todo = 2;
        t.newTodo(todo);
        t.todoList.shouldHave(size(todo));
    }

    @Test
    public void testClearInputNewTodo(){
        t.newTodo(1);
        t.newTodo.shouldBe(visible);
        t.newTodo.shouldBe(focused);
        t.newTodo.shouldNotBe(readonly);
    }

    @Test
    public void testSorting(){ //new Todo shoulbe added at the end of list
        t.newTodo(2);
        t.lineTodo(1).shouldHave(text("New ToDo 1"));
        t.lineTodo(2).shouldHave(text("New ToDo 2"));
    }
}