package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */

public class TestOpenCleanPageInterface extends Settings {

    @Test
    public void testPlaceholderText(){
        t.newTodo.shouldHave(attribute("placeholder","What needs to be done?"));
    }

    @Test
    public void testFocusAtTheLine(){
        t.newTodo.shouldBe(focused);
    }

    @Test
    public void testHeader(){
        t.header.shouldHave(text("todos"));
    }

    @Test
    public void testFooter(){
        t.footer.shouldNotBe(visible);
    }
}
