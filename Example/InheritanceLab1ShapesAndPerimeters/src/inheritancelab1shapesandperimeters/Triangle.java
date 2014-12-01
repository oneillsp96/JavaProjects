package inheritancelab1shapesandperimeters;

public class Triangle extends Shape {

    double base;
    double sideL;
    double sideR;

    double height;

    public double area() {
        return base * height * 0.5;
    }

    public double perimeter() {
        return base + sideL + sideR;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getSideL() {
        return sideL;
    }

    public void setSideL(double sideL) {
        this.sideL = sideL;
    }

    public double getSideR() {
        return sideR;
    }

    public void setSideR(double sideR) {
        this.sideR = sideR;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
