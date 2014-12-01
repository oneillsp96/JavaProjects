package z;

public class Factors {

    public static void main(String[] args) {

    //if n is a factor of ntf
        int ntf = 8;

        for (int i = 1; i < ntf; i++) {

            if (ntf % i == 0) {
                System.out.println("prime");
            }
            else {
                System.out.println("not prime");
            }

        }
    }
}
