package com.github.dkrut.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import com.github.dkrut.pages.TodoMVC;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Denis Krutikov on 02.04.2018.
 */

public abstract class TestBase {
    protected TodoMVC todo;

    @BeforeEach
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.browser = "chrome";
        Configuration.reportsFolder = "target/screenshots";
        todo = open("http://todomvc.com/examples/backbone/", TodoMVC.class);
    }

    @AfterEach
    public void clearTasks(){
        clearBrowserLocalStorage();
    }
}