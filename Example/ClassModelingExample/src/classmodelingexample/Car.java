
package classmodelingexample;

public class Car {
    
    private String make;
    private String model;
    private int year;
    private String color;
    private int horsepower;
    
    
    public Car(String make, String Model, int year, String color, int horsepower) {
    
        this.make=make;
        this.model=model;
        this.year=year;
        this.color=color;
        this.horsepower=horsepower;
    
    
    }
    
    
    
    public String getMake() {
        return make;
    }

    
    //commented out/ deleting setMake means that make is read-only
    
//    public void setMake(String make) {   
//        this.make = make;
//    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    
} 
    
    
//    public boolean move(String direction, int velocity){
//    
//        
//    }
//    
//    
//}
