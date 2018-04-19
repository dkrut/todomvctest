package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestCountTodo extends Settings {

    @Test
    public void testCountNewTodo(){
        todo.newTodo(1);
        todo.todoCount.shouldHave(text("1 item left"));
    }

    @Test
    public void testActiveTodoLeft(){
        todo.newTodo(3);
        todo.clickCheckboxTodo(1);
        todo.clickCheckboxTodo(3);
        todo.todoCount.shouldHave(text("1 item left"));
    }
}