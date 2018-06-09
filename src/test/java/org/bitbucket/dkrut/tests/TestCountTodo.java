package org.bitbucket.dkrut.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Count todo")
@Owner("Denis Krutikov")
public class TestCountTodo extends Settings {

    @Test
    @DisplayName("Count new todo")
    @Description("Test count added todo")
    public void testCountNewTodo(){
        todo.newTodo(1);
        todo.todoCount.shouldHave(text("1 item left"));
    }

    @Test
    @DisplayName("Count uncompleted todo")
    @Description("Test count uncompleted todo")
    public void testActiveTodoLeft(){
        todo.newTodo(3);
        todo.clickCheckboxTodo(1);
        todo.clickCheckboxTodo(3);
        todo.todoCount.shouldHave(text("1 item left"));
    }
}