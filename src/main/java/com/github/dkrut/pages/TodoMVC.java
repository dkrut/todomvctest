package com.github.dkrut.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Denis Krutikov on 31.03.2018.
 */

public class TodoMVC {
    public SelenideElement header = $(".header h1");
    public SelenideElement newTodo = $(".new-todo");
    public ElementsCollection todoList = $$(".todo-list li");
    public ElementsCollection todoListActive = $$(".todo-list li.active"); //empty class("") in a page code. Waiting for the class name to be added
    public ElementsCollection todoListCompleted = $$(".todo-list li.completed");
    SelenideElement toggleAllCompleted =  $(By.xpath("//*[@class=\"main\"]/label"));
    SelenideElement buttonAll = $("[href=\"\\#\\/\"]");
    SelenideElement buttonActive = $("[href=\"\\#\\/active\"]");
    SelenideElement buttonCompleted = $("[href=\"\\#\\/completed\"]");
    public SelenideElement buttonClearCompleted = $(".clear-completed");
    public SelenideElement todoCount = $(".todo-count");
    public SelenideElement footer = $(".footer");

    public void newTodo(int numberOfTodo){
        for (int i = 1; i <= numberOfTodo; i++) newTodo.setValue("New ToDo " + i).pressEnter();
    }

    public String nameTodo(int lineNumber){
        return "New Todo " + lineNumber;
    }

    public SelenideElement checkboxTodo(int lineNumber){
        return $(".todo-list li:nth-child(" + lineNumber + ") .toggle");
    }

    public void clickCheckboxTodo(int todoNumber){
        checkboxTodo(todoNumber).click();
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

    public void clickButtonAll(){
        buttonAll.click();
    }

    public void clickClearCompleted(){
        buttonClearCompleted.click();
    }

    public SelenideElement lineTodo(int lineNumber){
      return  $(".todo-list li:nth-child(" + lineNumber + ")");
    }

    private SelenideElement editTodo(int lineNumber, String newValue){
        lineTodo(lineNumber).doubleClick().find(".todo-list li:nth-child(" + lineNumber + ") .edit").sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        $(".todo-list li:nth-child(" + lineNumber + ") .edit").sendKeys(newValue);
        return $(".todo-list li:nth-child(" + lineNumber + ") .edit").shouldBe(Condition.exist);
    }

    public void editTodoByEnter(int lineNumber, String newValue){
        editTodo(lineNumber, newValue).pressEnter();
    }

    public void editTodoByBlur(int lineNumber, String newValue){
        editTodo(lineNumber, newValue);
        footer.click();
    }

    public void cancelEditingTodo(int lineNumber, String newValue){
        lineTodo(lineNumber).doubleClick().find(".todo-list li:nth-child(" + lineNumber + ") .edit").sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        $(".todo-list li:nth-child(" + lineNumber + ") .edit").sendKeys(newValue);
        $(".todo-list li:nth-child(" + lineNumber + ") .edit").sendKeys(Keys.ESCAPE);
    }

    public SelenideElement deleteButton(int lineNumber){
        return $(".todo-list li:nth-child(" + lineNumber +") .destroy");
    }

    public void deleteTodo(int lineNumber){
        lineTodo(lineNumber).hover();
        deleteButton(lineNumber).click();
    }
}