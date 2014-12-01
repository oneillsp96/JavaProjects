//this is practice i did on my own---it refers to class Student


package collectionsexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HashMapPractice {
    
    public static void main(String[] args) {
        
        HashMap<String, Student> stMap=new HashMap<String, Student>();
        
        Student stA=new Student();
        Student stB=new Student();
        Student stC=new Student();
        Student temp;
        
        
        
        
        stA.setFirstName("Sean");
        stB.setFirstName("Maxwell");
        stC.setFirstName("Jacob");
       
        stA.setLastName("O'Neill");
        stB.setLastName("Silverhammer");
        stC.setLastName("Astor");
        
        
        stMap.put("Sean", stA);
        stMap.put("Maxwell", stB);
        stMap.put("Jacob", stC);
        
        temp=stMap.get("Sean");
       // System.out.println(temp.getFirstName());
        
        
        Set myKeys=stMap.keySet();
        Iterator<String>iter1=myKeys.iterator();
       while(iter1.hasNext()) {
       
           System.out.println(iter1.next());
       }
        
       Collection myValues=stMap.values();
       Iterator<Student> iter2=myValues.iterator();
       
       while(iter2.hasNext()){
          
           Student currentStudent=new Student();
           currentStudent=iter2.next();
           System.out.println(currentStudent.getLastName());
           
          
       
       }
        
        
        
        
    }
}
