package inheritancelab1shapesandperimeters;

public class Square extends Shape {

    double side;

    @Override
    public double area() {

        return side * side;
    }

    @Override
    public double perimeter() {
        return (side * 4);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

}
