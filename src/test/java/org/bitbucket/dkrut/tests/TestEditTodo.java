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

public class TestEditTodo {
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
    public void testEditTodoByEnter(){
        t.newTodo(1);
        t.editTodoByEnter(1,"Edited task");
        t.lineTodo(1).shouldHave(text("Edited task"));
    }

    @Test
    public void testEditTodoByBlur(){
        t.newTodo(1);
        t.editTodoByBlur(1,"Edited task");
        t.lineTodo(1).shouldHave(text("Edited task"));
    }

    @Test
    public void testCancelEditingTodo(){
        t.newTodo(1);
        t.cancelEditingTodo(1, "Edited task");
        t.lineTodo(1).shouldHave(text("New todo 1"));
    }

    @Test
    public void testTrimTextTodo(){
        t.newTodo.setValue(" Space before and after ").pressEnter();
        t.lineTodo(1).shouldHave(text("Space before and after"));
    }

    @Test
    public void testDeleteEmptyTodo(){
        t.newTodo(2);
        t.editTodoByEnter(2,"");
        t.todoList.shouldHave(size(1));
    }

    @Test
    public void testHideControlsWhileEditing(){
        t.newTodo(1);
        t.lineTodo(1).doubleClick();
        t.checkboxFirstLineTodo.shouldNotBe(visible);
        t.deleteButton(1).shouldNotBe(visible);
    }

    @Test
    public void testDeleteTask(){
        t.newTodo(2);
        t.deleteTodo(2);
        t.todoList.shouldHave(size(1));
    }
}