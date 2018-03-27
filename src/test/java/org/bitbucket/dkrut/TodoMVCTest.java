package org.bitbucket.dkrut;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class TodoMVCTest {
    SelenideElement newtodo = $(".new-todo");

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.reportsFolder = "target/reports/screenshots";
        open("http://todomvc.com/examples/troopjs_require/");
    }

    @After
    public void clearTasks(){
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    public void testAddFewTodo() {
        $(".new-todo").setValue("first");
        sleep(1500);
        $(".new-todo").pressEnter();
        $(".new-todo").setValue("second").pressEnter();
        $$(".todo-list li").shouldHave(size(2));
    }

    @Test
    public void testOneCompletedTask(){
        newtodo.setValue("Active");
        sleep(1500);
        newtodo.pressEnter();
        newtodo.setValue("Completed").pressEnter();
        $(By.xpath("//input[@class=\"toggle\"]")).click();
        $$(".todo-list li.completed").shouldHave(size(1));
    }

    @Test
    public void testCheckAllTaskCompleted(){
        newtodo.setValue("Completed 1");
        sleep(1500);
        newtodo.pressEnter();
        newtodo.setValue("Completed 2").pressEnter();
        $(By.xpath("//input[@class=\"toggle-all\"]")).click();
        $$(".todo-list li.completed").shouldHaveSize(2);
    }
}