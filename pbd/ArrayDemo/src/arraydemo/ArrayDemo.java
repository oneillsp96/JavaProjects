package arraydemo;

public class ArrayDemo {

    public static void main(String[] args) {

        int []teamScores = {3,4,8,12,8};

        

        for (int i = 0; i < teamScores.length; i++) {
            System.out.println("Element = " + teamScores[i]);
        
        
 }
        
        System.out.println("==================================");
 for (int num : teamScores) {
            System.out.println("Element = " + num);
        }

    }

}
