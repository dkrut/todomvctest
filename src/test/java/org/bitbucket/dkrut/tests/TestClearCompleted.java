package org.bitbucket.dkrut.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature(value = "Clear completed")
@Owner(value = "Denis Krutikov")
public class TestClearCompleted extends Settings {

    @Test
    @DisplayName(value = "Clear completed button status")
    @Description(value = "Test clear completed button status, when there is no completed todo")
    public void testUnvisibleClearCompleted(){
        todo.newTodo(1);
        todo.buttonClearCompleted.shouldNot(visible);
    }

    @Test
    @DisplayName(value = "Click clear completed button")
    @Description(value = "Test clear completed button. After clicking button there is only uncompleted todo in list")
    public void testButtonClearAllCompleted(){
        todo.newTodo(2);
        todo.clickCheckboxTodo(2);
        todo.clickClearCompleted();
        todo.todoList.shouldHave(size(1));
        todo.lineTodo(1).shouldHave(text("New ToDo 1"));
    }
}