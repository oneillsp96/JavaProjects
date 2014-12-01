package com.swcguild.datastructures;

import java.util.Iterator;

public class GenArrayStackDriver {

    public static void main(String[] args) {
        // GenArrayStack/ GenLinkedListStack
        GenStack<String> st = new GenLinkedListStack<>();

        st.push("Joe");
        st.push("Steve");
        st.push("Sally");
        st.push("Frank");
        st.push("Larry");

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

        Iterator<String> iter = st.iterator();
        
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        
        
        for(String s: st){
            System.out.println(s);
        }

     
    }

}
