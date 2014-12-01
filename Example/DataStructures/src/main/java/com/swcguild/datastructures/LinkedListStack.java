package com.swcguild.datastructures;

import java.util.Iterator;

public class LinkedListStack implements Stack {

    //if first is null stack is empty
    //if numItems=0 stack is empty
    private Node first;
    private int numItems;

    @Override
    public boolean isEmpty() {
        return first == null; //returns true or false
    }

    @Override
    public int size() {
        return numItems;
    }

    //push and pop from front
    //don't have to worry about resizing
    @Override
    public void push(Object item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        numItems++;
    }

    @Override
    public Object pop() {
        Object ret = first;
        //poin
        if (ret != null) {
            ret = first.item;
            first = first.next;
            numItems--;
        }
        return ret;

    }
    
    
    
    
    
    
    
    
    

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    //different implementation of 
    //as long as we implement iterator, enhanced for-loop will work
    private class LinkedListIterator implements Iterator {

        Node current = first;

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
