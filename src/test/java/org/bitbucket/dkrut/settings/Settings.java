package org.bitbucket.dkrut.settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.bitbucket.dkrut.pages.TodoMVC;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Denis Krutikov on 02.04.2018.
 */

public class Settings {
    protected TodoMVC todo;

    @Before
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
//        Configuration.reportsFolder = "target/screenshots";
        todo = open("http://todomvc.com/examples/backbone/", TodoMVC.class);
    }

    @After
    public void clearTasks(){
        clearBrowserLocalStorage();
    }
}
