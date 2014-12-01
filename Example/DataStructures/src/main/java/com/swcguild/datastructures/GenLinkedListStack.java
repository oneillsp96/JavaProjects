
package com.swcguild.datastructures;

import java.util.Iterator;


public class GenLinkedListStack<Item> implements GenStack<Item> {
    
    private Node<Item> first;
    private int numItems;
    

    @Override
    public boolean isEmpty() {
       return first==null;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public void push(Item item) {
       //instead of creating new nodes, create nodes that hold items
        
        Node<Item> prevFirst=first;
        first=new Node<Item>();
        first.item=item;
        first.next=prevFirst;
        numItems++;
    }

    @Override
    public Item pop() {
        Item ret=first.item;
        first=first.next;
        numItems--;
        return ret;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator<Item>();
    }
    
    
    private class Node<Item> {
    Item item;
    Node next;
    }
    
    private class LinkedListIterator<Item> implements Iterator<Item>{

        //cast to Item
        Node<Item> current=(Node<Item>) first;
        
                
        @Override
        public boolean hasNext() {
          return current!= null;
        }

        @Override
        public Item next() {
            if (current==null){
            return null;
            } //otherwise get item out and fix up references
            else{
            Item ret=current.item;
            current=current.next;
                return ret;
            }
            
        }
        
        


}
    
    
}
