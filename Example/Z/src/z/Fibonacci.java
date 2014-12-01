package z;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {

        //0,1,1,2,3,5,8,13,21,34
        
        int fibCount = 15;
        int[] fib = new int[fibCount];

        int febCount = 15;
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fibCount; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i = 0; i < fibCount; i++) {
            System.out.print(fib[i] + " ");
        }

    }

}


