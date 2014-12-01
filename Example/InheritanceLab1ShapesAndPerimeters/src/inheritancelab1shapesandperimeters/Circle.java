package inheritancelab1shapesandperimeters;

public class Circle extends Shape {

    double radius;
    final double pi = 3.14;
    double perimeter;

    @Override
    public double area() {

        return pi * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * pi * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

}
