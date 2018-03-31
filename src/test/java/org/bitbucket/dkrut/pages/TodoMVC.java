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
    ElementsCollection todoListAll = $$(".todo-list li");
    ElementsCollection todoListCompleted = $$(".todo-list li.completed");
    SelenideElement toggleAllCompleted =  $(By.xpath("//input[@class=\"toggle-all\"]"));
    SelenideElement buttonAll = $("[href=\"\\#\\/\"]");
    SelenideElement buttonActive = $("[href=\"\\#\\/active\"]");
    SelenideElement buttonCompleted = $("[href=\"\\#\\/completed\"]");
    SelenideElement buttonClearCompleted = $(".clear-completed0");
    SelenideElement FirstLineTodo = $(".todo-list li:nth-child(1)");
    SelenideElement SecondLineTodo = $(".todo-list li:nth-child(2)");
    SelenideElement ThirdLineTodo = $(".todo-list li:nth-child(3)");
    SelenideElement checkboxFirstLineTodo = $(".todo-list li:nth-child(1) .toggle");
    SelenideElement checkboxSecondLineTodo = $(".todo-list li:nth-child(2) .toggle");
    SelenideElement checkboxThirdLineTodo = $(".todo-list li:nth-child(3) .toggle");
    By deleteButtonFirstLineTodo = cssSelector(".todo-list li:nth-child(1) .destroy");
    By deleteButtonSecondLineTodo = cssSelector(".todo-list li:nth-child(2) .destroy");
    By deleteButtonThirdLineTodo = cssSelector(".todo-list li:nth-child(3) .destroy");
    By editFirstLineTodo = cssSelector(".todo-list li:nth-child(1) .edit");
    By editSecondLineTodo = cssSelector(".todo-list li:nth-child(2) .edit");
    By editThirdLineTodo = cssSelector(".todo-list li:nth-child(3) .edit");
}
