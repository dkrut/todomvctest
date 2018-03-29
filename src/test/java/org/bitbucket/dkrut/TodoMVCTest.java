package org.bitbucket.dkrut;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TodoMVCTest {
    SelenideElement newtodo = $(".new-todo");

    @Before
    public void setUp(){
        Configuration.browser = "chrome";
//        Configuration.reportsFolder = "target/reports/screenshots";
        open("http://todomvc.com/examples/backbone/");
    }

    @After
    public void clearTasks(){
//        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

    @Test
    public void testAddFewTodo() {
        $(".new-todo").setValue("first").pressEnter();
        $(".new-todo").setValue("second").pressEnter();
        $$(".todo-list li").shouldHave(size(2));
    }

    @Test
    public void testOneCompletedTask(){
        newtodo.setValue("Active").pressEnter();
        newtodo.setValue("Completed").pressEnter();
        $(".todo-list li:nth-child(2) .toggle").click();
        $$(".todo-list li.completed").shouldHave(size(1));
    }

    @Test
    public void testCheckAllTaskCompleted(){
        newtodo.setValue("Completed 1").pressEnter();
        newtodo.setValue("Completed 2").pressEnter();
        $(By.xpath("//input[@class=\"toggle-all\"]")).click();
        $$(".todo-list li.completed").shouldHaveSize(2);
    }

    @Test
    public void testChooseActiveTasks(){
        newtodo.setValue("Active 1").pressEnter();
        newtodo.setValue("Active 2").pressEnter();
        $("[href=\"\\#\\/active\"]").click();
        $$(".todo-list li").shouldHave(size(2));
    }

    @Test
    public void testChooseCompletedTasks(){
        newtodo.setValue("It will be completed 1").pressEnter();
        newtodo.setValue("It will be completed 2").pressEnter();
        $(".todo-list li:nth-child(1) .toggle").click();
        $(".todo-list li:nth-child(1) .toggle").click();
        $("[href=\"\\#\\/completed\"]").click();
        $$(".todo-list li").shouldHave(size(2));
    }

    @Test
    public void testActiveTasksLeft(){
        newtodo.setValue("New 1").pressEnter();
        newtodo.setValue("New 2").pressEnter();
        newtodo.setValue("New 3").pressEnter();
        $(".todo-list li:nth-child(1) .toggle").click();
        $(".todo-list li:nth-child(3) .toggle").click();
        $(".todo-count").shouldHave(attribute("innerText", "1 item left"));
    }

    @Test
    public void testEditTask(){
        newtodo.setValue("New task").pressEnter();
        $(".todo-list li").doubleClick().find(".todo-list li .edit").setValue("Edited task").pressEnter();
        $(".todo-list li").shouldHave(text("Edited task"));
    }

    @Test
    public void testDeleteTask(){
        newtodo.setValue("New task").pressEnter();
        newtodo.setValue("Will be deleted").pressEnter();
        $(".todo-list li:nth-child(2)").hover().find(".todo-list li:nth-child(2) .destroy").click();
        $$(".todo-list li").shouldHave(size(1));
    }

    @Test
    public void testPlaceholderText(){
        newtodo.shouldHave(attribute("placeholder","What needs to be done?"));
    }


}