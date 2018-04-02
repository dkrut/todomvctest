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
        t.newTodo(1);
        refresh();
        t.todoList.shouldHave(size(1));
    }

    @Test
    public void testOpenInNewTab(){
        t.newTodo(1);
        executeJavaScript("window.open('http://todomvc.com/examples/backbone/','_blank')");
        switchTo().window(1);
        t.todoList.shouldHave(size(1));
    }
}