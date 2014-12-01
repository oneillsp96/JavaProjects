
package lab1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class StateCapitals {
    
    
    public static void main(String[] args) {
        
        HashMap<String, String> myMap= new HashMap<String, String>();
        
        
        myMap.put("Ohio", "Columbus");
        myMap.put("Alaska", "Juneau");
        myMap.put("Florida", "Tallahassee");
        myMap.put("California", "Sacramento");
        myMap.put("Connecticut", "Hartford");
        myMap.put("Minnesota", "St. Paul");
        
        Set myKeys=myMap.keySet();
        Iterator<String> myIter=myKeys.iterator();
        
//        while(myIter.hasNext()) {
//        
//            System.out.println(myIter.next());
//        }
        
        
        
        Collection myValues=myMap.values();
        
       Iterator <String> myIter2=myValues.iterator();
       
//       while(myIter2.hasNext()) {
//           System.out.println(myIter2.next());
//       }
        
        
       //this prints state and capital on same line rather than separately  
       
       while(myIter.hasNext() && myIter2.hasNext()) {
       
           System.out.println("State: " + myIter.next() + "      Capital: " + myIter2.next());
       }
        
        
        
        
        
        
//       String cap1=myMap.get("Ohio");        //get value(Columbus) using key (Ohio) and put it in a string (cap)
//       System.out.println(cap1);             //prints cap
//        
//        String cap2=myMap.get("Alaska");
//        System.out.println(cap2);
//       
//        String cap3=myMap.get("Florida");
//        System.out.println(cap3);
//        
//        String cap4=myMap.get("California");
//        System.out.println(cap4);
//        
//        String cap5=myMap.get("Connecticut");
//        System.out.println(cap5);
//        
//        String cap6=myMap.get("Minnesota");
//        System.out.println(cap6);
//        
//        String state1=myMap.get("");
       
        
                
        
        
        
    }
    
}
