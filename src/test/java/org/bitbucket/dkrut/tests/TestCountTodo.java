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
        t.newTodo(1);
        t.todoCount.shouldHave(text("1 item left"));
    }

    @Test
    public void testActiveTodoLeft(){
        t.newTodo(3);
        t.clickCheckboxTodo(1);
        t.clickCheckboxTodo(3);
        t.todoCount.shouldHave(text("1 item left"));
    }
}