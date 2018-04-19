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
        todo.newTodo(1);
        todo.buttonClearCompleted.shouldNot(visible);
    }

    @Test
    public void testButtonClearAllCompleted(){
        todo.newTodo(2);
        todo.clickCheckboxTodo(2);
        todo.clickClearCompleted();
        todo.todoList.shouldHave(size(1));
        todo.lineTodo(1).shouldHave(text("New ToDo 1"));
    }
}