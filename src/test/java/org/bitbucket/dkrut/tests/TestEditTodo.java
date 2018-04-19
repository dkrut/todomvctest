package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestEditTodo extends Settings {

    @Test
    public void testEditTodoByEnter(){
        todo.newTodo(1);
        todo.editTodoByEnter(1,"Edited task");
        todo.lineTodo(1).shouldHave(text("Edited task"));
    }

    @Test
    public void testEditTodoByBlur(){
        todo.newTodo(1);
        todo.editTodoByBlur(1,"Edited task");
        todo.lineTodo(1).shouldHave(text("Edited task"));
    }

    @Test
    public void testCancelEditingTodo(){
        todo.newTodo(1);
        todo.cancelEditingTodo(1, "Edited task");
        todo.lineTodo(1).shouldHave(text("New todo 1"));
    }

    @Test
    public void testTrimTextTodo(){
        todo.newTodo.setValue(" Space before and after ").pressEnter();
        todo.lineTodo(1).shouldHave(text("Space before and after"));
    }

    @Test
    public void testDeleteEmptyTodo(){
        todo.newTodo(2);
        todo.editTodoByEnter(2,"");
        todo.todoList.shouldHave(size(1));
    }

    @Test
    public void testHideControlsWhileEditing(){
        todo.newTodo(1);
        todo.lineTodo(1).doubleClick();
        todo.checkboxTodo(1).shouldNotBe(visible);
        todo.deleteButton(1).shouldNotBe(visible);
    }

    @Test
    public void testDeleteTodo(){
        todo.newTodo(2);
        todo.deleteTodo(2);
        todo.todoList.shouldHave(size(1));
    }
}