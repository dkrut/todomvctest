package com.github.dkrut.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature("Saving data")
@Owner("Denis Krutikov")
public class TestSavingData extends TestBase {

    @Test
    @DisplayName("Refresh page")
    @Description("Test refreshing page - data shouldn't lost after it")
    public void testRefreshPage(){
        todo.newTodo(1);
        refresh();
        todo.todoList.shouldHave(size(1));
    }

    @Test
    @DisplayName("Open in a new tab")
    @Description("Test opening page in a new tab - data shouldn't lost after it")
    public void testOpenInNewTab(){
        todo.newTodo(1);
        executeJavaScript("window.open('http://todomvc.com/examples/backbone/','_blank')");
        switchTo().window(1);
        todo.todoList.shouldHave(size(1));
    }
}