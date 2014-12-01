package interviewpractice;

//also tells if prime or not
public class Factorizor {

    public static void main(String[] args) {

        int inputNum = 7;
        
        boolean isPrime=true;

        for (int i = 2; i < inputNum; i++) {
            
            if (inputNum%i==0){
                System.out.println(i + " is a factor");
                isPrime=false;
            }
           

        }
        
        System.out.println(isPrime);
        
       
    }
}
