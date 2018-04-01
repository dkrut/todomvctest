package org.bitbucket.dkrut.tests;

import com.codeborne.selenide.Configuration;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestSavingData {
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
    public void testRefreshPage(){
        t.newTodo(1);
        refresh();
        t.todoList.shouldHave(size(1));
    }

    @Ignore("Test needs to edit")
    @Test
    public void testOpenInNewTab(){
    }
}