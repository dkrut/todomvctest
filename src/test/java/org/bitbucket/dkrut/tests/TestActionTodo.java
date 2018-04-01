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

public class TestActionTodo {
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
    public void testMarkTodo(){
        t.newTodo(1);
        t.clickCheckboxTodo(1);
        t.checkboxTodo(1).shouldBe(selected);
    }

    @Test
    public void testUnmarkTodo(){
        t.newTodo(1);
        t.clickCheckboxTodo(1);
        t.clickCheckboxTodo(1);
        t.checkboxTodo(1).shouldNotBe(selected);
    }

    @Test
    public void testEditTodo(){
        t.newTodo(1);
        t.lineTodo(1).doubleClick();
        t.lineTodo(1).shouldNotBe(readonly);
    }

    @Test
    public void testShowDeleteButtonTodo(){
        t.newTodo(1);
        t.lineTodo(1).hover();
        t.deleteButton(1).shouldBe(visible);
    }
}