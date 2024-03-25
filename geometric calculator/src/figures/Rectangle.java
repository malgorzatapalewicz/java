package figures;

public class Rectangle extends Figure implements Printing {
    private final double a, b;

    public Rectangle(double length, double width){ //konstruktor
        if(isValidRectangle(length,width)) {
            this.a = length;
            this.b = width;
        } else {
            throw new IllegalArgumentException("Wartosci ujemne, nie da sie utworzyc prostokata");
        }
    }

    boolean isValidRectangle(double length, double width){
        return (!(length < 0 || width < 0));
    }
    @Override
    double calculateArea(){
        return (a * b);
    }

    @Override
    double calculatePerimeter(){
        return (2 * a + 2 * b);
    }

    @Override
    public void print(){
        System.out.print("Pole prostokata z bokami: " + a + ", " + b + ", " + a + ", " + b);
        System.out.println(" wynosi: " + calculateArea());
        System.out.print("Obwod prostokata z bokami: " + a + ", " + b + ", " + a + ", " + b);
        System.out.println(" wynosi: " + calculatePerimeter());
    }
}
