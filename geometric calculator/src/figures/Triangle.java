package figures;

public class Triangle extends Figure implements Printing {
    private final double a, b, c;

    public Triangle(double side1, double side2, double side3){ //kostruktor
        if(isValidTriangle(side1, side2, side3)){
            this.a = side1;
            this.b = side2;
            this.c = side3;
        } else {
            throw new IllegalArgumentException("Z podanych bokow nie da sie zbudowac trojkata");
        }
    }

    boolean isValidTriangle(double side1, double side2, double side3){
        if(side1 <= 0 || side2 <= 0 || side3 <= 0) return false;
        return ((side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1));
    }

    @Override
    double calculateArea(){
        //wzor Herona
        double p = (a + b + c) / 2  ;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    double calculatePerimeter(){
        return (a + b + c);
    }

    @Override
    public void print(){
        System.out.println("Pole trojkata z bokami: " + a + ", " + b + ", " + c + " wynosi: " + calculateArea());
        System.out.println("Obwod trojkata z bokami: " + a + ", " + b + ", " + c + " wynosi: " + calculatePerimeter());
    }
}

