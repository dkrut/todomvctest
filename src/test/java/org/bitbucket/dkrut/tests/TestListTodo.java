package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestListTodo extends Settings {

    @Test
    public void testChooseCompletedTodo(){
        todo.newTodo(2);
        todo.clickCheckboxTodo(1);
        todo.clickButtonCompleted();
        todo.todoListCompleted.shouldHave(size(1));
    }

    @Ignore("Test needs to edit cause empty selector for todoListActive")
    @Test
    public void testChooseActiveTodo(){
        todo.newTodo(2);
        todo.clickCheckboxTodo(1);
        todo.clickButtonActive();
        todo.todoListActive.shouldHave(size(1));
    }

    @Test
    public void testChooseAllTodo(){
        todo.newTodo(2);
        todo.checkboxTodo(1).click();
        todo.clickButtonAll();
        todo.todoList.shouldHave(size(2));
    }
}