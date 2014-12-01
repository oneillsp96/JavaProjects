package com.swcguild.datastructures;

import java.util.Iterator;

public class ArrayStack implements Stack {

    private static final int DEFAULT_INITIAL_SIZE = 4;
    private Object[] items;
    //need to keep track of how many items we have- can't use .size() method
    private int numItems;

    public ArrayStack() {
        this(DEFAULT_INITIAL_SIZE);  //call the other constructor  --this is a "convenience constructor" other one is "real constructor"
    }

    public ArrayStack(int size) {
        items = new Object[size];
        //this updates amount of space but not number of things
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;  //returns true or false
    }

    @Override
    public int size() {
        return numItems;
    }

    //this is where it gets complex
    @Override
    public void push(Object item) {
        //need to check to make sure we have space  
        if (numItems == items.length) {  //if this is true, we need to resize to make more space
            resize(2 * items.length);   //we decided to just make it twice as big--could have done this differently (it's an art)
        }

        items[numItems++] = item;  //increments it after it uses it

    }

    @Override
    public Object pop() {

        //need to make sure array is empty--can't pop from empty array
        if (numItems == 0) {
            return null;
        }

        Object item = items[--numItems];
        items[numItems] = null;  //gets rid of reference, makes it eligible for garbage collection

//if it's 25% full, add space
        if (numItems > 0 && numItems == items.length / 4) {
            resize(items.length / 2);
        }

        return item;

    }

    private void resize(int newSize) {
        Object[] temp = new Object[newSize];
        //stop at numItems, not items.length because items.length can be larger than numItems
        for (int i = 0; i < numItems; i++) {

            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator iterator() {

        return new ReverseArrayIterator();
    }

    //non-static inner class

    private class ReverseArrayIterator implements Iterator {

        private int i = numItems;

        @Override
        public boolean hasNext() {
            return i > 0;   //returns true or false
        }

        @Override
        public Object next() {
            return items[--i];
        }

    }

}
