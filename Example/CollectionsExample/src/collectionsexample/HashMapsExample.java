//references class Student




//hashMap is like an arraylist but with no order (uses keys instead)
//put method takes string and gives back 
package collectionsexample;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapsExample {

    public static void main(String[] args) {

        //have to tell it what the key is and what values are
        //keys are typically strings
        HashMap<String, Student> studentMap = new HashMap<>();
        Student st1 = new Student();
        st1.setFirstName("John");
        st1.setLastName("Doe");

        Student st2 = new Student();
        st2.setFirstName("Jane");
        st2.setLastName("Smith");

        Student st3 = new Student();
        st3.setFirstName("Bill");
        st3.setLastName("Gates");
        
        Student temp;

        
        // don't understand this part
        temp = studentMap.put("Doe", st1);
        if (temp == null) {
            System.out.println("No mapping for Doe");
        }
        temp = studentMap.put("Doe", st2);

        if (temp != null) {
            System.out.println(temp.getFirstName());
        }

        //put - puts key and value in map
        studentMap.put("Gates", st3);

        studentMap.put("Doe", st1);
        studentMap.put("Smith", st2);
        studentMap.put("Gates", st3);
          
//Hashmap<String, object>
//String is key, object is value.
//we set temp to equal the value the key(Doe) retrieves for us, which is an object (st1)        
        
        
        temp = studentMap.get("Doe");                      //use key("Doe") to get info from HashMap(studentMap)
        System.out.println(temp.getFirstName());           // temp now holds info 

        
        // If you need to ask map what's in it and how to ask for them- (use Key Set---set of keys)
        Set myKeys = studentMap.keySet();            //gets us a pile of keys
        Iterator<String> iter = myKeys.iterator();   //visit each thing in set one by one, kind of like a for-loop for arrays

        while (iter.hasNext()) {               //
            System.out.println(iter.next());  //

            
            
            //myValues is a collection, not a set - collections can have duplicates
            //need unique keys, but can have duplicate values
            Collection myValues = studentMap.values();   //
            Iterator<Student> iter2 = myValues.iterator();
            
            while (iter2.hasNext()) {
                Student currentStudent = iter2.next();
                System.out.println(currentStudent.getFirstName() + " " + currentStudent.getLastName());

            }

        }

    }
}
