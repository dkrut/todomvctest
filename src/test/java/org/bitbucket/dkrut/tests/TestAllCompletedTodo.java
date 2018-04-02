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
        t.newTodo(2);
        t.clickToggleAllCompleted();
        t.checkboxTodo(1).shouldBe(selected);
        t.checkboxTodo(2).shouldBe(selected);
    }

    @Test
    public void testUncheckAllTodoCompleted(){
        t.newTodo(2);
        t.clickToggleAllCompleted();
        t.clickToggleAllCompleted();
        t.checkboxTodo(1).shouldNotBe(selected);
        t.checkboxTodo(2).shouldNotBe(selected);
    }
}