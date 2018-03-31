package org.bitbucket.dkrut.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 24.03.2018.
 */

public class TodoMVCTest {
    private TodoMVC t;
    SelenideElement newtodoo = $(".new-todo");

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
        t.newTodo("first", "second");
        t.todoList.shouldHave(size(2));
    }

    @Test
    public void testOneCompletedTask(){
        t.newTodo("Active", "Completed");
        t.clickCheckboxSecondLineTodo();
        t.todoList.shouldHave(size(2));
        t.todoListCompleted.shouldHave(size(1));
        t.checkboxSecondLineTodo.shouldHave(attribute("checked", "true"));
    }

    @Test
    public void testCheckAllTaskCompleted(){
        t.newTodo("Completed 1", "Completed 2");
        t.clickToggleAllCompleted();
        t.checkboxFirstLineTodo.shouldHave(attribute("checked", "true"));
        t.checkboxSecondLineTodo.shouldHave(attribute("checked", "true"));
    }

    @Test
    public void testChooseActiveTasks(){
        t.newTodo("Active 1", "Active 2");
        t.clickButtonActive();
        t.todoList.shouldHave(size(2));
    }

    @Test
    public void testChooseCompletedTasks(){
        t.newTodo("It will be completed 1", "It will be completed 2");
        t.clickCheckboxFirstLineTodo();
        t.clickCheckboxFirstLineTodo();
        t.clickButtonCompleted();
        t.todoList.shouldHave(size(2));
    }

    @Test
    public void testActiveTasksLeft(){
        t.newTodo("New 1", "New 2", "New 3");
        t.clickCheckboxFirstLineTodo();
        t.clickCheckboxThirdLineTodo();
        t.todoCount.shouldHave(attribute("innerText", "1 item left"));
    }

    @Test
    public void testEditTask(){
        t.newTodo("New task");
        t.firstLineTodo.doubleClick().find(t.editFirstLineTodo).setValue("Edited task").pressEnter();
        t.firstLineTodo.shouldHave(text("Edited task"));
    }

    @Test
    public void testDeleteTask(){
        t.newTodo("New task", "This task will be deleted");
        t.secondLineTodo.hover().find(t.deleteButtonSecondLineTodo).click();
        t.todoList.shouldHave(size(1));
    }

    @Test
    public void testPlaceholderText(){
        newtodoo.shouldHave(attribute("placeholder","What needs to be done?"));
    }
}