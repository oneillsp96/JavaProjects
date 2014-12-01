
package com.swcguild.datastructures;

import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class LinkedListQueue implements Queue{
    
    private Node first = null;
    private Node last = null;
    private int numItems;
    
    

    @Override
    public void enqueue(Object item) {
       Node current = last;
        last = new Node();
        last.item = item;

        if (numItems++ == 0) {
            first = last;
        }
        else current.next = last;
        
    }

    @Override
    public Object dequeue() {
         if (numItems == 0) {
             return null;
         }
        Object item = first.item;
        first = first.next;
        if (--numItems == 0) {
            last = null;
        }
        return item;
        
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class LinkedListIterator implements Iterator {
        
        Node current = last;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            if (current == null) {
                return null;
            }
            Object ret = current.item;
            current = current.next;
            return ret;
        }
    }
    
    private class Node {
        Object item;
        Node next;
    }
    
}