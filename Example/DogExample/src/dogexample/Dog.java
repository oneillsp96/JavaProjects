
package dogexample;

public class Dog {

    
    private String dogName;
    private int age;
    private int weight;
    
    
   private static int count = 0;
    
   public static int getCount() {
   return count;
   
   }
   
   
   
   
   
    //another option to create dogs
    
    public Dog(String dogNameIn, int ageIn, int weightIn) {
    
        dogName=dogNameIn;
        age=ageIn;
        weight=weightIn;
        count++;  //track how many dogs are created along the way
    }

    
    
    
    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    
    
    
}
