
package hashmaplab2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class HashMapLab2 {

    
    public static void main(String[] args) {
        
        
        
        
        
        Capital cap1=new Capital();
        cap1.setName("Columbus");
        cap1.setPopulation(500);
        cap1.setSquareMileage(2000);
        
        Capital cap2=new Capital();
        cap2.setName("Juneau");
        cap2.setPopulation(600);
        cap2.setSquareMileage(7000);
        
        Capital cap3=new Capital();
        cap3.setName("Tallahassee");
        cap3.setPopulation(400);
        cap3.setSquareMileage(99000);
        
        Capital cap4=new Capital();
        cap4.setName("Sacramento");
        cap4.setPopulation(906);
        cap4.setSquareMileage(23000);
        
        Capital cap5=new Capital();
        cap5.setName("Hartford");
        cap5.setPopulation(200);
        cap5.setSquareMileage(254000);
        
        Capital cap6=new Capital();
        cap6.setName("St. Paul");
        cap6.setPopulation(100);
        cap6.setSquareMileage(63000);
        
        
        HashMap<String, Capital> myMap=new HashMap<String, Capital>();
        
        
        myMap.put("Ohio", cap1);            //fills Hashmap with keys and values
        myMap.put("Alaska", cap2);
        myMap.put("Florida", cap3);
        myMap.put("California", cap4);
        myMap.put("Connecticut", cap5);
        myMap.put("Minnesota", cap6);
        
        
        //can use this method if you know what's in your HashMap.  Otherwise use Key Set.
        Capital temp1;
        Capital temp2;
        Capital temp3;
        Capital temp4;
        Capital temp5;
        Capital temp6;
                 
        temp1=myMap.get("Ohio");   
        temp2=myMap.get("Alaska");
        temp3=myMap.get("Florida");
        temp4=myMap.get("California");
        temp5=myMap.get("Connecticut");
        temp6=myMap.get("Minnesota");
        
        
        
        
        
//                            /\\  how do i put in the state name itself (the key)
//        System.out.println(        "Name: " + temp1.name + " | Population: " + temp1.population + " | Area: " + temp1.squareMileage );
//        System.out.println(        "Name: " + temp2.name + " | Population: " + temp2.population + " | Area: " + temp2.squareMileage );
//        System.out.println(        "Name: " + temp3.name + " | Population: " + temp3.population + " | Area: " + temp3.squareMileage );
//        System.out.println(        "Name: " + temp4.name + " | Population: " + temp4.population + " | Area: " + temp4.squareMileage );
//        System.out.println(        "Name: " + temp5.name + " | Population: " + temp5.population + " | Area: " + temp5.squareMileage );
//        System.out.println(        "Name: " + temp6.name + " | Population: " + temp6.population + " | Area: " + temp6.squareMileage );    
//    
        
        
       
        Set myKeys=myMap.keySet();
        Iterator<String> iter1=myKeys.iterator();
        
//        while (iter1.hasNext()){
//        
//            System.out.println(iter1.next());
//        }
        
        
        Collection myValues=myMap.values();
        Iterator<Capital> iter2=myValues.iterator();
//        
//        while (iter2.hasNext()) {
//           Capital currentCap=iter2.next();
//            System.out.println(currentCap.getName());
                 
        
      Scanner sc=new Scanner(System.in);
      System.out.println("Please enter a minimum population cut-off.  Only the info for cities above the minimu will be shown. ");
      int userPop=Integer.parseInt(sc.nextLine());
      
      
      
      
      //this is broken
      
        while(iter1.hasNext() && iter2.hasNext()) {
            
            Capital currentCap=iter2.next();
            
            
            if (currentCap.getPopulation()>userPop) {
            
            System.out.println(iter1.next() + " - " + currentCap.getName() + " | Population: " + currentCap.getPopulation() + " | Area: " + currentCap.getSquareMileage()                  );
            }
        
        
        }
                
        
        
        
        
        
        
        
    
    }
    
}
