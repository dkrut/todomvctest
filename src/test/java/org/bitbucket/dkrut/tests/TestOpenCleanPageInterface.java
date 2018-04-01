package org.bitbucket.dkrut.tests;

import com.codeborne.selenide.Configuration;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestOpenCleanPageInterface {
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
    public void testPlaceholderText(){
        t.newTodo.shouldHave(attribute("placeholder","What needs to be done?"));
    }

    @Test
    public void testFocusAtTheLine(){
        t.newTodo.shouldBe(focused);
    }

    @Test
    public void testHeader(){
        t.header.shouldHave(text("todos"));
    }

    @Test
    public void testFooter(){
        t.footer.shouldNotBe(visible);
    }
}
