package com.flaregames.task.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.flaregames.task.test.cases.PokerManagerTest;
import com.flaregames.task.test.cases.CardTest;
import com.flaregames.task.test.cases.DeckTest;
import com.flaregames.task.test.cases.HandTest;
import com.flaregames.task.test.cases.PokerUtilTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author tms-mustafa
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CardTest.class, DeckTest.class, HandTest.class, PokerManagerTest.class, PokerUtilTest.class})
public class PokerHandTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
