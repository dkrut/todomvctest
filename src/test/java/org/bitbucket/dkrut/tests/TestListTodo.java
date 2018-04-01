package org.bitbucket.dkrut.tests;

import com.codeborne.selenide.Configuration;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestListTodo {
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
    public void testChooseCompletedTodo(){
        t.newTodo(2);
        t.clickCheckboxFirstLineTodo();
//        t.clickCheckboxFirstLineTodo();
        t.clickButtonCompleted();
        t.todoListCompleted.shouldHave(size(1));
    }

    @Ignore("Test needs to edit cause empty selector for todoListActive")
    @Test
    public void testChooseActiveTodo(){
        t.newTodo(2);
        t.clickCheckboxFirstLineTodo();
        t.clickButtonActive();
        t.todoListActive.shouldHave(size(1));
    }

    @Test
    public void testChooseAllTodo(){
        t.newTodo(2);
        t.checkboxFirstLineTodo.click();
        t.clickButtonAll();
        t.todoList.shouldHave(size(2));
    }
}
