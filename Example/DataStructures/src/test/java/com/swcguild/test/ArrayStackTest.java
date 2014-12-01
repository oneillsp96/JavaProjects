
package com.swcguild.test;

import com.swcguild.datastructures.ArrayStack;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ArrayStackTest {
    
     Stack st;
     
     String a = "a";
     String b = "b";
     String c = "c";
     String d = "d";
     String e = "e";

    public ArrayStackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
       ArrayStack st = new ArrayStack();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isEmptyTest() {
        //TEST EMPTY STACK RETURNS TRUE
        assertTrue(st.isEmpty());
        //TEST NONEMPTY STACK RETURNS FALSE
        st.push(a);
        assertFalse(st.isEmpty());
    }
    
    @Test
    public void sizeTest(){
        //TESTS AN EMPTY STACK HAS SIZE 0
        assertEquals(0,st.size());
        
        //TESTS SIZE AFTER PUSH
        st.push(a);
        assertEquals(1,st.size());
        
        //TESTS SIZE AFTER POP
        st.pop();
        assertEquals(0,st.size());
        
        //TESTS SIZE AFTER POPPING EMPTY STACK
        st.pop();
        assertEquals(0,st.size());
    }
    
    @Test
    public void pushTest() {
        assertEquals(0,st.size());
        //TESTS PUSH ON EMPTY STACK
        st.push(a);
        assertEquals(1,st.size());
        //TESTS PUSH ON OCCUPIED STACK
        st.push(b);
        assertEquals(2,st.size());
        
       //TESTS PUSH AFTER RESIZE()
        st.push(c);
        st.push(d);
        st.push(e);
        assertEquals(5,st.size());
    }
    
    @Test
    public void popTest() {
        assertTrue(st.isEmpty());
        //TESTS POP ON EMPTY STACK RETURNS NULL
        assertNull(st.pop());
        
        //TESTS SINGULAR PUSH AND POP
        st.push(a);
        assertEquals(a,st.pop());
        
        
        //TESTS FILO
        st.push(a);
        st.push(b);
        assertEquals(b,st.pop());
        assertEquals(a,st.pop());
    }

}