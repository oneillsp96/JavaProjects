
package com.swcguild.datastructures;

import java.util.Iterator;



public class GenArrayStack<Item> implements GenStack<Item> {
    
    private static final int DEFAULT_INITIAL_SIZE=4;
    private Item[] items;
    private int numItems;
    
    public GenArrayStack(){
    this(DEFAULT_INITIAL_SIZE);
        }
    
    public GenArrayStack(int size){
    //cast into item array, create new Object array
        items=(Item[]) new Object[size];
            
    }

    @Override
    public boolean isEmpty() {
        return numItems==0;
    }

    @Override
    public int size() {
       return numItems;
    }

    @Override
    public void push(Item item) {
        if (numItems == items.length) {  //if this is true, we need to resize to make more space
            resize(2 * items.length);   //we decided to just make it twice as big--could have done this differently (it's an art)
        }

        items[numItems++] = item; 
    }

    @Override
    public Item pop() {
        
        //need to make sure array is empty--can't pop from empty array
        if (numItems == 0) {
            return null;
        }

        //take item out of the array
        Item item = items[--numItems];
       //set that slot to null
        items[numItems] = null;  //gets rid of reference, makes it eligible for garbage collection

//check if we need to resize--if it's 25% full, add space
        if (numItems > 0 && numItems == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }
    
    private void resize(int newSize){
    //cast to Item array
      Item[] temp = (Item[]) new Object[newSize];
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
    
    private class ReverseArrayIterator<Item> implements Iterator<Item> {
        
        private int i=numItems;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            //cast to Item
            return (Item) items[--i];
        }
    
    }

}