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
 * Created by Denis Krutikov on 24.03.2018.
 */

public class TodoMVCTest {
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
    public void testOneCompletedTask(){
        t.newTodo(2);
        t.clickCheckboxSecondLineTodo();
        t.todoList.shouldHave(size(2));
        t.todoListCompleted.shouldHave(size(1));
        t.checkboxSecondLineTodo.shouldHave(attribute("checked", "true"));
    }

    @Test
    public void testCheckAllTaskCompleted(){
        t.newTodo(2);
        t.clickToggleAllCompleted();
        t.checkboxFirstLineTodo.shouldHave(attribute("checked", "true"));
        t.checkboxSecondLineTodo.shouldHave(attribute("checked", "true"));
    }

    @Test
    public void testChooseActiveTasks(){
        int todo = 2;
        t.newTodo(todo);
        t.clickButtonActive();
        t.todoList.shouldHave(size(todo));
    }

    @Test
    public void testChooseCompletedTasks(){
        t.newTodo(2);
        t.clickCheckboxFirstLineTodo();
        t.clickCheckboxFirstLineTodo();
        t.clickButtonCompleted();
        t.todoList.shouldHave(size(2));
    }

    @Test
    public void testActiveTasksLeft(){
        t.newTodo(3);
        t.clickCheckboxFirstLineTodo();
        t.clickCheckboxThirdLineTodo();
        t.todoCount.shouldHave(attribute("innerText", "1 item left"));
    }

    @Test
    public void testEditTask(){
        t.newTodo(1);
        t.firstLineTodo.doubleClick().find(t.editFirstLineTodo).setValue("Edited task").pressEnter();
        t.firstLineTodo.shouldHave(text("Edited task"));
    }

    @Test
    public void testDeleteTask(){
        t.newTodo(2);
        t.secondLineTodo.hover().find(t.deleteButtonSecondLineTodo).click();
        t.todoList.shouldHave(size(1));
    }

    @Test
    public void testSorting(){
        t.newTodo(3);
        t.firstLineTodo.shouldHave(text("New ToDo 1"));
        t.secondLineTodo.shouldHave(text("New ToDo 2"));
        t.thirdLineTodo.shouldHave(text("New ToDo 3"));
    }

    @Test
    public void testButtonClearAllCompleted(){
        t.newTodo(2);
        t.clickCheckboxSecondLineTodo();
        t.clickClearCopmleted();
        t.todoList.shouldHave(size(1));
        t.firstLineTodo.shouldHave(text("New ToDo 1"));
    }

    @Test
    public void testUnvisibleClearAll(){
        t.buttonClearCompleted.shouldNot(visible);
    }

    @Test
    public void testPlaceholderText(){
        t.newTodo.shouldHave(attribute("placeholder","What needs to be done?"));
    }

    @Test
    public void testHeader(){
        t.header.shouldHave(text("todos"));
    }
}