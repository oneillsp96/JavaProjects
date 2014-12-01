
package interviewpractice;


public class StringToIntegerRoundTwo {
    
    public static void main(String[] args) {
        
        int x=321;
        
        
       int onesPlace=(x%10);
        
       int tensPlace=(x/10)%10;
       
       int hundredsPlace=(x/100)%100;
        
        System.out.println(switcher(hundredsPlace) + " " + switcher(tensPlace) + " " + switcher(onesPlace));
        
        
        
        
        
        
    }
    
    public static String switcher(int a) {
        String stringNum="";
        
         switch (a) {
            case 1:
                 stringNum = "1";
                break;
            case 2: 
                stringNum="2";
                break;
            case 3:
                stringNum="3";
                break;
                
                //etc...digits 1-9
                
                
                
            default: System.out.println("invalid entry");
    
        }
         return stringNum;
    
    
    }
    
}
