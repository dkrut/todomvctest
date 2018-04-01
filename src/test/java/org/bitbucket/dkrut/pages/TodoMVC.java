package org.bitbucket.dkrut.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

/**
 * Created by Denis Krutikov on 31.03.2018.
 */

public class TodoMVC {
    public SelenideElement header = $(".header h1");
    public SelenideElement newTodo = $(".new-todo");
    public ElementsCollection todoList = $$(".todo-list li");
    public ElementsCollection todoListActive = $$(".todo-list li.active");
    public ElementsCollection todoListCompleted = $$(".todo-list li.completed");
    SelenideElement toggleAllCompleted =  $(By.xpath("//input[@class=\"toggle-all\"]"));
    SelenideElement buttonAll = $("[href=\"\\#\\/\"]");
    SelenideElement buttonActive = $("[href=\"\\#\\/active\"]");
    SelenideElement buttonCompleted = $("[href=\"\\#\\/completed\"]");
    public SelenideElement buttonClearCompleted = $(".clear-completed");
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
    public SelenideElement footer = $(".footer");

    public void newTodo(Integer numberOfTodo){
        int i;
        for (i = 1; i <= numberOfTodo; i++) newTodo.setValue("New ToDo " + i).pressEnter();
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

    public void clickButtonAll(){
        buttonAll.click();
    }

    public void clickClearCopmleted(){
        buttonClearCompleted.click();
    }

    public SelenideElement lineTodo(int lineNumber){
      return  $(".todo-list li:nth-child(" + lineNumber + ")"); //вместо   public SelenideElement firstLineTodo, уже заменил в testSorting
    }

    public void editTodoByEnter(Integer lineNumber, String newValue){
        lineTodo(lineNumber).doubleClick().find(".todo-list li:nth-child(" + lineNumber + ") .edit").setValue(newValue).pressEnter();
    }

    public void editTodoByBlur(Integer lineNumber, String newValue){
        lineTodo(lineNumber).doubleClick().find(".todo-list li:nth-child(" + lineNumber + ") .edit").setValue(newValue);
        footer.click();
    }

    public void cancelEditingTodo(Integer lineNumber, String newValue){
        lineTodo(lineNumber).doubleClick().find(".todo-list li:nth-child(" + lineNumber + ") .edit").setValue(newValue).sendKeys(Keys.ESCAPE);
    }



    public SelenideElement deleteButton(Integer lineNumber){ //вместо public By deleteButtonFirstLineTodo
        return $(".todo-list li:nth-child(" + lineNumber +") .destroy");
    }

    public void deleteTodo(Integer lineNumber){
        lineTodo(lineNumber).hover().find(".todo-list li:nth-child(" + lineNumber + ") .destroy").click();
    }

}