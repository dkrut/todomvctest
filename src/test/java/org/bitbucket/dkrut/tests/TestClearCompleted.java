package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestClearCompleted extends Settings {

    @Test
    public void testUnvisibleClearCompleted(){
        t.newTodo(1);
        t.buttonClearCompleted.shouldNot(visible);
    }

    @Test
    public void testButtonClearAllCompleted(){
        t.newTodo(2);
        t.clickCheckboxTodo(2);
        t.clickClearCopmleted();
        t.todoList.shouldHave(size(1));
        t.lineTodo(1).shouldHave(text("New ToDo 1"));
    }
}