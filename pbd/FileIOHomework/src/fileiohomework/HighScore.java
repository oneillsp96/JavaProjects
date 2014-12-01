
package fileiohomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class HighScore {

    public static void main(String[] args) throws Exception {
        
        
        System.out.println("Please enter your score");
        Scanner sc= new Scanner(System.in);                             //(new BufferedReader(new FileReader("HighScore.txt")));
        
        int score=Integer.parseInt(sc.nextLine());
        
        
        PrintWriter myPW= new PrintWriter(new FileWriter("HighScore.txt"));
        
        myPW.println(score);
        myPW.flush();
        myPW.close();
        
        
        
        
        
        
        
       
        
        
        
        
        
    }
}
