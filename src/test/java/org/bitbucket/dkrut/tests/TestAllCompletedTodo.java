package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.selected;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature(value = "Complete todo")
@Owner(value = "Denis Krutikov")
public class TestAllCompletedTodo extends Settings {

    @Test
    @DisplayName(value = "Check all todo completed")
    @Description(value = "Test marking all todo completed")
    public void testCheckAllTodoCompleted(){
        todo.newTodo(2);
        todo.clickToggleAllCompleted();
        todo.checkboxTodo(1).shouldBe(selected);
        todo.checkboxTodo(2).shouldBe(selected);
    }

    @Test
    @DisplayName(value = "Uncheck all todo completed")
    @Description(value = "Test unmarking all todo completed")
    public void testUncheckAllTodoCompleted(){
        todo.newTodo(2);
        todo.clickToggleAllCompleted();
        todo.clickToggleAllCompleted();
        todo.checkboxTodo(1).shouldNotBe(selected);
        todo.checkboxTodo(2).shouldNotBe(selected);
    }
}