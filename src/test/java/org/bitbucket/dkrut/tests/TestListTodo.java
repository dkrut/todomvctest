package org.bitbucket.dkrut.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Different todo lists")
@Owner("Denis Krutikov")
public class TestListTodo extends TestBase {

    @Test
    @DisplayName("Choose completed todo")
    @Description("Test click button completed - show list completed todo")
    public void testChooseCompletedTodo(){
        todo.newTodo(2);
        todo.clickCheckboxTodo(1);
        todo.clickButtonCompleted();
        todo.todoListCompleted.shouldHave(size(1));
    }

    @Ignore("Test needs to edit cause empty selector for todoListActive")
    @Test
    @DisplayName("Choose active todo")
    @Description("Test click button active - show list active todo")
    public void testChooseActiveTodo(){
        todo.newTodo(2);
        todo.clickCheckboxTodo(1);
        todo.clickButtonActive();
        todo.todoListActive.shouldHave(size(1));
    }

    @Test
    @DisplayName("Choose all todo")
    @Description("Test click button all - show list all todo")
    public void testChooseAllTodo(){
        todo.newTodo(2);
        todo.checkboxTodo(1).click();
        todo.clickButtonAll();
        todo.todoList.shouldHave(size(2));
    }
}