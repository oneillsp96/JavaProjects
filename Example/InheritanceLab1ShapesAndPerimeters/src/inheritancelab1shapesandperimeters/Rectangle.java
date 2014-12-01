package inheritancelab1shapesandperimeters;

public class Rectangle extends Shape {

    double side1;
    double side2;

    @Override
    public double area() {
        return (side1 * side2);
    }

    @Override
    public double perimeter() {
        return (side1 * 2 + side2 * 2);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

}
