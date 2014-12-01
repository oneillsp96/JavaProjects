package inheritancelab1shapesandperimeters;

public class InheritanceLab1ShapesAndPerimeters {

    public static void main(String[] args) {

        Square s1 = new Square();

        s1.setSide(3);
        System.out.println("square area " + s1.area());
        System.out.println("square perimeter " + s1.perimeter());

        Rectangle r1 = new Rectangle();

        r1.setSide1(3);
        r1.setSide2(8);

        System.out.println("rectangle area " + r1.area());
        System.out.println("rectangle perimeter " + r1.perimeter());

        Triangle t1 = new Triangle();

        t1.setSideL(5);
        t1.setSideR(5);
        t1.setBase(4.3);
        t1.setHeight(3);

        // I realize this isn't good math but am in a rush to get to next lab at the moment
        System.out.println("triangel area " + t1.area());
        System.out.println("triangle perimeter " + t1.perimeter());

        Circle c1 = new Circle();

        c1.setRadius(2);

        System.out.println("circle area " + c1.area());
        System.out.println("circle perimeter" + c1.perimeter());

    }

}
