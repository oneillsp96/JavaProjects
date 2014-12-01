package functions.homework;

import java.util.Scanner;

public class ARefresherChallenge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a name");
        String name = sc.nextLine();
        int num=10;
        
        if (name.equals("Mitchell")){
        num=5;
        
        }
        
        for(int i=0; i<num; i++){
        
            System.out.println(name);
        }
        
        
        
        

    }
}
