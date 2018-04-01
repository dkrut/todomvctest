package org.bitbucket.dkrut.tests;

import com.codeborne.selenide.Configuration;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestAllCompletedTodo {
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
    public void testCheckAllTaskCompleted(){
        t.newTodo(2);
        t.clickToggleAllCompleted();
        t.checkboxFirstLineTodo.shouldBe(selected);
        t.checkboxSecondLineTodo.shouldBe(selected);
    }

    @Test
    public void testUncheckAllTaskCompleted(){
        t.newTodo(2);
        t.clickToggleAllCompleted();
        t.clickToggleAllCompleted();
        t.checkboxFirstLineTodo.shouldNotBe(selected);
        t.checkboxSecondLineTodo.shouldNotBe(selected);
    }
}