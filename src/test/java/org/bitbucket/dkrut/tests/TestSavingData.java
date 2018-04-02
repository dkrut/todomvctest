package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.refresh;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestSavingData extends Settings {

    @Test
    public void testRefreshPage(){
        t.newTodo(1);
        refresh();
        t.todoList.shouldHave(size(1));
    }

    @Ignore("Test needs to edit")
    @Test
    public void testOpenInNewTab(){
    }
}