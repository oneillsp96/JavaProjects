package com.swcguild.olympian;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class SkiJumperTest {
    
    public SkiJumperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestSkiJumper() {
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        
        SkiJumper jumper= (SkiJumper)ctx.getBean("superSkiJumper");
        assertEquals(jumper.competeInEvent(),"Ski Jump");
    
    }
}
