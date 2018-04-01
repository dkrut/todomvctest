package org.bitbucket.dkrut.tests;

import com.codeborne.selenide.Configuration;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestAddTodo {
    private TodoMVC t;

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.reportsFolder = "target/reports/screenshots";
        t = open("http://todomvc.com/examples/backbone/", TodoMVC.class);
    }

    @After
    public void clearTasks(){
//        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

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