package org.bitbucket.dkrut.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Denis Krutikov on 01.04.2018.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({TestActionTodo.class,
        TestAddTodo.class,
        TestAllCompletedTodo.class,
        TestClearCompleted.class,
        TestCountTodo.class,
        TestEditTodo.class,
        TestListTodo.class,
        TestOpenCleanPageInterface.class,
        TestSavingData.class})
public class TodoTestSuites {
}