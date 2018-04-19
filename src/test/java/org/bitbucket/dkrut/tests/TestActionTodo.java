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
        todo.newTodo(1);
        todo.clickCheckboxTodo(1);
        todo.checkboxTodo(1).shouldBe(selected);
    }

    @Test
    public void testUnmarkTodo(){
        todo.newTodo(1);
        todo.clickCheckboxTodo(1);
        todo.clickCheckboxTodo(1);
        todo.checkboxTodo(1).shouldNotBe(selected);
    }

    @Test
    public void testEditTodo(){
        todo.newTodo(1);
        todo.lineTodo(1).doubleClick();
        todo.lineTodo(1).shouldNotBe(readonly);
    }

    @Test
    public void testShowDeleteButtonTodo(){
        todo.newTodo(1);
        todo.lineTodo(1).hover();
        todo.deleteButton(1).shouldBe(visible);
    }
}