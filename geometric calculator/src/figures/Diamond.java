package figures;

public class Diamond extends Figure implements Printing {
    private final double d1, d2;

    public Diamond(double diagonal1, double diagonal2){ //konstruktor
        if(isValidDiamond(diagonal1,diagonal2)){
        this.d1 = diagonal1;
        this.d2 = diagonal2;
    } else {
            throw new IllegalArgumentException("Wartosci ujemne, nie da sie utworzyc rombu");
        }
    }

    boolean isValidDiamond(double diagonal1, double diagonal2){
        return (!(diagonal1 < 0 || diagonal2 < 0));
    }

    @Override
    double calculateArea(){
        return (d1 * d2 / 2);
    }

    @Override
    double calculatePerimeter(){
        double a = Math.sqrt((d1/2 * d1/2) + (d2/2 * d2/2));
        return (a * 4); //dlugosc wszystkich bokow
    }

    @Override
    public void print(){
        System.out.println("Pole rombu z przekątnymi: " + d1 + ", " + d2 + " wynosi: " + calculateArea());
        System.out.println("Obwód rombu z przekątnymi: " + d1 + ", " + d2 +  " wynosi: " + calculatePerimeter());
    }
}

