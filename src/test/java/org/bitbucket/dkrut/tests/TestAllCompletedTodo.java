package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.selected;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestAllCompletedTodo extends Settings {

    @Test
    public void testCheckAllTodoCompleted(){
        todo.newTodo(2);
        todo.clickToggleAllCompleted();
        todo.checkboxTodo(1).shouldBe(selected);
        todo.checkboxTodo(2).shouldBe(selected);
    }

    @Test
    public void testUncheckAllTodoCompleted(){
        todo.newTodo(2);
        todo.clickToggleAllCompleted();
        todo.clickToggleAllCompleted();
        todo.checkboxTodo(1).shouldNotBe(selected);
        todo.checkboxTodo(2).shouldNotBe(selected);
    }
}