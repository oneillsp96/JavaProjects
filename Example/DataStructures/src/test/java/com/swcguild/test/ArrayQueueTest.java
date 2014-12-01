
package com.swcguild.test;

import com.swcguild.datastructures.LinkedListQueue;
import com.swcguild.datastructures.Queue;


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
public class ArrayQueueTest {
    
    Queue q;

    String a = "a";
    String b = "b";
    String c = "c";
    String d = "d";
    String e = "e";

    public ArrayQueueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
      q = new LinkedListQueue();

    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void isEmptyTest() {
        //TEST EMPTY QUEUE RETURNS TRUE
        assertTrue(q.isEmpty());
        //TEST NONEMPTY QUEUE RETURNS FALSE
        q.enqueue(a);
        assertFalse(q.isEmpty());
    }
    
    @Test
    public void sizeTest(){
        //TESTS AN EMPTY QUEUE HAS SIZE 0
        assertEquals(0,q.size());
        
        //TESTS SIZE AFTER ENQUEUE
        q.enqueue(a);
        assertEquals(1,q.size());
        
        //TESTS SIZE AFTER DEQUEUE
        q.dequeue();
        assertEquals(0,q.size());
        
        //TESTS SIZE AFTER DEQUEUING EMPTY STACK
        q.dequeue();
        assertEquals(0,q.size());
    }
    
    @Test
    public void enqueueTest(){
        assertTrue(q.isEmpty());
        
        //TEST ENQUEUE ON EMPTY QUEUE
        q.enqueue(a);
        assertEquals(1,q.size());
        
        //TESTS ENQUEUE ON OCCUPIED QUEUE
        q.enqueue(b);
        assertEquals(2,q.size());
        
        //TESTS ENQUEUE AFTER RESIZE
        q.enqueue(c);
        q.enqueue(d);
        q.enqueue(e);
        assertEquals(5,q.size());
    }
    
    @Test
    public void dequeueTest(){
        assertTrue(q.isEmpty());
        //TESTS DEQUEUE ON EMPTY QUEUE RETURNS NULL
        assertNull(q.dequeue());
        
        //TESTS SINGULAR ENQUEUE AND DEQUEUE
        q.enqueue(a);
        q.dequeue();
        assertTrue(q.isEmpty());
        
        //TESTS FIFO
        q.enqueue(a);
        q.enqueue(b);
        assertEquals(a, q.dequeue());
        assertEquals(b, q.dequeue());
        
        //TESTS "WRAPAROUND"
        assertTrue(q.isEmpty());
        
        //  A _ _ _ 
        q.enqueue(a);
        
        //  A B _ _
        q.enqueue(b);
        
        //  A B C _
        q.enqueue(c);
        
        //  _ B C _
        assertEquals(a, q.dequeue());
        
        //  _ _ C _
        assertEquals(b, q.dequeue());
        
        //  _ _ C D
        q.enqueue(d);
       
      
        //  E _ C D
        q.enqueue(e);
        
        
        //DEQUEUING THREE TIMES SHOULD GIVE C, D, E
        assertEquals(c, q.dequeue());
        assertEquals(d, q.dequeue());
        assertEquals(e, q.dequeue());
    }

}