
package com.swcguild.datastructures;

public class ArrayStackDriver {
    
    public static void main(String[] args) {
        Stack st = new LinkedListStack();  //we program to stack interface, so this can be arrayStack or LinkedListStack
        String a="a";
        String b="b";
        String c="c";
        String d="d";
        
        System.out.println("Pushing " + a);
        st.push(a);
        System.out.println("Pushing " + b);
        st.push(b);
        System.out.println("Pushing " + c);
        st.push(c);
        System.out.println("Pushing " + d);
        st.push(d);
    
        for (Object o: st){
            System.out.println((String) o);  //cast o to string
        }
    
    
    }
    
}
