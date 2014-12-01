package inheritancelab1shapesandperimeters;

public abstract class Shape {

    protected String color;

    public abstract double area();

    public abstract double perimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
