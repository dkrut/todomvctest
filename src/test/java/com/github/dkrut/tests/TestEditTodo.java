package com.github.dkrut.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Edit todo")
@Owner("Denis Krutikov")
public class TestEditTodo extends TestBase {

    @Test
    @DisplayName("Apply changes by enter")
    @Description("Test applying changes by enter")
    @Severity(SeverityLevel.CRITICAL)
    public void testEditTodoByEnter(){
        String newValue = "Edited task";
        todo.newTodo(1);
        todo.editTodoByEnter(1,newValue);
        todo.lineTodo(1).shouldHave(text(newValue));
    }

    @Test
    @DisplayName("Apply changes by blur")
    @Description("Test applying changes by blur")
    public void testEditTodoByBlur(){
        String newValue = "Edited task";
        todo.newTodo(1);
        todo.editTodoByBlur(1,newValue);
        todo.lineTodo(1).shouldHave(text(newValue));
    }

    @Test
    @DisplayName("Cancel editing todo")
    @Description("Test cancel editing todo")
    public void testCancelEditingTodo(){
        todo.newTodo(1);
        todo.cancelEditingTodo(1, "Edited task");
        todo.lineTodo(1).shouldHave(text("New todo 1"));
    }

    @Test
    @DisplayName("Removing spaces")
    @Description("Test removing spaces before and after todo")
    public void testTrimTextTodo(){
        todo.newTodo.setValue(" Space before and after ").pressEnter();
        todo.lineTodo(1).shouldHave(text("Space before and after"));
    }

    @Test
    @DisplayName("Autodeleting empty todo")
    @Description("Test deleting empty todo after editing")
    public void testDeleteEmptyTodo(){
        todo.newTodo(2);
        todo.editTodoByEnter(2,"");
        todo.todoList.shouldHave(size(1));
    }

    @Test
    @DisplayName("Hide controls")
    @Description("Test hide controls while editing")
    public void testHideControlsWhileEditing(){
        todo.newTodo(1);
        todo.lineTodo(1).doubleClick();
        todo.checkboxTodo(1).shouldNotBe(visible);
        todo.deleteButton(1).shouldNotBe(visible);
    }

    @Test
    @DisplayName("Delete todo")
    @Description("Test deleting todo")
    public void testDeleteTodo(){
        todo.newTodo(2);
        todo.deleteTodo(2);
        todo.todoList.shouldHave(size(1));
    }
}