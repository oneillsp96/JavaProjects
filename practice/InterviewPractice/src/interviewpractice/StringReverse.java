package interviewpractice;

import java.util.ArrayList;
import java.util.List;

public class StringReverse {

    public static void main(String[] args) {

        String inputString = "car";
        
        List<Character> charList=new ArrayList<>();

        for (int i=inputString.length()-1; i>=0; i--){

            charList.add(inputString.charAt(i));
          
            
            System.out.print(inputString.charAt(i));
        
        }
        
        
        
    }
}
