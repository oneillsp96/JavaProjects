
package com.swcguild.datastructures;

import java.util.Iterator;


public class ArrayQueue implements Queue{
   
    
    private static int DEFAULT_INITIAL_SIZE = 4;
    private Object items[];
    private int numItems;
    private int totalItems;
    private int head;
    private int tail;

    public ArrayQueue(int size) {
        items = new Object[size];
    }

    public ArrayQueue() {
        this(DEFAULT_INITIAL_SIZE);
    }

    @Override
    public void enqueue(Object item) {
        // double size of array if necessary and recopy to front of array
        if (numItems == items.length) {
            resize(2 * items.length);   // double size of array if necessary
        }
        items[tail++] = item;                        // add item
        if (tail == items.length) {
            tail = 0;          // wrap-around
        }
        numItems++;
    }

    @Override
    public Object dequeue() {
        
        if (numItems == 0) {
            return null;
        }

        Object item = items[head];
        items[head] = null;                            
        numItems--;
        head++;
        if (head == items.length) {
            head = 0;           // wrap-around
        }        // shrink size of array if necessary

//        if (numItems > 0 && numItems == items.length / 4) {
//            resize(items.length / 2);
//        }

        return item;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    private void resize(int newSize) {
        Object[] temp = new Object[newSize];
        for (int i = 0; i < numItems; i++) {
            temp[i] = items[i];
        }
        items = temp;
        head = 0;
        tail  = numItems;
    }

    @Override
    public Iterator iterator() {
        return new InOrderArrayIterator();
    }

    private class InOrderArrayIterator implements Iterator {

        private int i = numItems;

        @Override
        public boolean hasNext() {
            return i < items.length;
        }

        @Override
        public Object next() {
            return items[i++];
        }

    }

}
