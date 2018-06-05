package org.bitbucket.dkrut.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

@Feature(value = "Saving data")
@Owner(value = "Denis Krutikov")
public class TestSavingData extends Settings {

    @Test
    @DisplayName(value = "Refresh page")
    @Description(value = "Test refreshing page - data shouldn't lost after it")
    public void testRefreshPage(){
        todo.newTodo(1);
        refresh();
        todo.todoList.shouldHave(size(1));
    }

    @Test
    @DisplayName(value = "Open in a new tab")
    @Description(value = "Test opening page in a new tab - data shouldn't lost after it")
    public void testOpenInNewTab(){
        todo.newTodo(1);
        executeJavaScript("window.open('http://todomvc.com/examples/backbone/','_blank')");
        switchTo().window(1);
        todo.todoList.shouldHave(size(1));
    }
}