package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestActionTodo extends Settings {

    @Test
    public void testMarkTodo(){
        t.newTodo(1);
        t.clickCheckboxTodo(1);
        t.checkboxTodo(1).shouldBe(selected);
    }

    @Test
    public void testUnmarkTodo(){
        t.newTodo(1);
        t.clickCheckboxTodo(1);
        t.clickCheckboxTodo(1);
        t.checkboxTodo(1).shouldNotBe(selected);
    }

    @Test
    public void testEditTodo(){
        t.newTodo(1);
        t.lineTodo(1).doubleClick();
        t.lineTodo(1).shouldNotBe(readonly);
    }

    @Test
    public void testShowDeleteButtonTodo(){
        t.newTodo(1);
        t.lineTodo(1).hover();
        t.deleteButton(1).shouldBe(visible);
    }
}