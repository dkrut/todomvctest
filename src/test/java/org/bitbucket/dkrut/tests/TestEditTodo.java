package org.bitbucket.dkrut.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature(value = "Edit todo")
@Owner(value = "Denis Krutikov")
public class TestEditTodo extends Settings {

    @Test
    @DisplayName(value = "Apply changes by enter")
    @Description(value = "Test applying changes by enter")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testEditTodoByEnter(){
        String newValue = "Edited task";
        todo.newTodo(1);
        todo.editTodoByEnter(1,newValue);
        todo.lineTodo(1).shouldHave(text(newValue));
    }

    @Test
    @DisplayName(value = "Apply changes by blur")
    @Description(value = "Test applying changes by blur")
    public void testEditTodoByBlur(){
        String newValue = "Edited task";
        todo.newTodo(1);
        todo.editTodoByBlur(1,newValue);
        todo.lineTodo(1).shouldHave(text(newValue));
    }

    @Test
    @DisplayName(value = "Cancel editing todo")
    @Description(value = "Test cancel editing todo")
    public void testCancelEditingTodo(){
        todo.newTodo(1);
        todo.cancelEditingTodo(1, "Edited task");
        todo.lineTodo(1).shouldHave(text("New todo 1"));
    }

    @Test
    @DisplayName(value = "Removing spaces")
    @Description(value = "Test removing spaces before and after todo")
    public void testTrimTextTodo(){
        todo.newTodo.setValue(" Space before and after ").pressEnter();
        todo.lineTodo(1).shouldHave(text("Space before and after"));
    }

    @Test
    @DisplayName(value = "Autodeleting empty todo")
    @Description(value = "Test deleting empty todo after editing")
    public void testDeleteEmptyTodo(){
        todo.newTodo(2);
        todo.editTodoByEnter(2,"");
        todo.todoList.shouldHave(size(1));
    }

    @Test
    @DisplayName(value = "Hide controls")
    @Description(value = "Test hide controls while editing")
    public void testHideControlsWhileEditing(){
        todo.newTodo(1);
        todo.lineTodo(1).doubleClick();
        todo.checkboxTodo(1).shouldNotBe(visible);
        todo.deleteButton(1).shouldNotBe(visible);
    }

    @Test
    @DisplayName(value = "Delete todo")
    @Description(value = "Test deleting todo")
    public void testDeleteTodo(){
        todo.newTodo(2);
        todo.deleteTodo(2);
        todo.todoList.shouldHave(size(1));
    }
}