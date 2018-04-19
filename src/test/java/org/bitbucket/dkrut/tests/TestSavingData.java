package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestSavingData extends Settings {

    @Test
    public void testRefreshPage(){
        todo.newTodo(1);
        refresh();
        todo.todoList.shouldHave(size(1));
    }

    @Test
    public void testOpenInNewTab(){
        todo.newTodo(1);
        executeJavaScript("window.open('http://todomvc.com/examples/backbone/','_blank')");
        switchTo().window(1);
        todo.todoList.shouldHave(size(1));
    }
}