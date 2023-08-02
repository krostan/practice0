package org.tutorial.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class UnitTestTutorial {

    @BeforeClass
    public static void checkbeforeClass(){
        System.out.println("Before Class");
    }

    @Before
    public void checkBefor(){
        System.out.println("Before method");
    }

    @After
    public void checkAfter(){
        System.out.println("After method");
    }

    @AfterClass
    public static void checkAfterClass(){
        System.out.println("After Class");
    }
}
