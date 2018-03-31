package org.bitbucket.dkrut.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

/**
 * Created by Denis Krutikov on 31.03.2018.
 */

public class TodoMVC {
    SelenideElement header = $(".header h1");
    SelenideElement newTodo = $(".new-todo");
    public ElementsCollection todoList = $$(".todo-list li");
    public ElementsCollection todoListCompleted = $$(".todo-list li.completed");
    SelenideElement toggleAllCompleted =  $(By.xpath("//input[@class=\"toggle-all\"]"));
    SelenideElement buttonAll = $("[href=\"\\#\\/\"]");
    SelenideElement buttonActive = $("[href=\"\\#\\/active\"]");
    SelenideElement buttonCompleted = $("[href=\"\\#\\/completed\"]");
    SelenideElement buttonClearCompleted = $(".clear-completed0");
    public SelenideElement firstLineTodo = $(".todo-list li:nth-child(1)");
    public SelenideElement secondLineTodo = $(".todo-list li:nth-child(2)");
    public SelenideElement thirdLineTodo = $(".todo-list li:nth-child(3)");
    public SelenideElement checkboxFirstLineTodo = $(".todo-list li:nth-child(1) .toggle");
    public SelenideElement checkboxSecondLineTodo = $(".todo-list li:nth-child(2) .toggle");
    SelenideElement checkboxThirdLineTodo = $(".todo-list li:nth-child(3) .toggle");
    public By deleteButtonFirstLineTodo = cssSelector(".todo-list li:nth-child(1) .destroy");
    public By deleteButtonSecondLineTodo = cssSelector(".todo-list li:nth-child(2) .destroy");
    public By deleteButtonThirdLineTodo = cssSelector(".todo-list li:nth-child(3) .destroy");
    public By editFirstLineTodo = cssSelector(".todo-list li:nth-child(1) .edit");
    public By editSecondLineTodo = cssSelector(".todo-list li:nth-child(2) .edit");
    public By editThirdLineTodo = cssSelector(".todo-list li:nth-child(3) .edit");
    public SelenideElement todoCount = $(".todo-count");

    public void newTodo(String value){
        newTodo.setValue(value).pressEnter();
    }

    public void newTodo(String value1, String value2){
        newTodo.setValue(value1).pressEnter();
        newTodo.setValue(value2).pressEnter();
    }

    public void newTodo(String value1, String value2, String value3){
        newTodo.setValue(value1).pressEnter();
        newTodo.setValue(value2).pressEnter();
        newTodo.setValue(value3).pressEnter();
    }

    public void clickCheckboxFirstLineTodo(){
        checkboxFirstLineTodo.click();
    }

    public void clickCheckboxSecondLineTodo(){
        checkboxSecondLineTodo.click();
    }

    public void clickCheckboxThirdLineTodo(){
        checkboxThirdLineTodo.click();
    }

    public void clickToggleAllCompleted(){
        toggleAllCompleted.click();
    }

    public void clickButtonActive(){
        buttonActive.click();
    }

    public void clickButtonCompleted(){
        buttonCompleted.click();
    }
}