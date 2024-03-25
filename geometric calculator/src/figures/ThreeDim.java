package figures;

import figures.Figure;

public class ThreeDim implements Printing {
    private Figure base;
    private double height;

    public ThreeDim(Figure figure, double height){
        this.base = figure;
        this.height = height;
    }

    double calculateArea(){ //pole powierzchni = 2pp + pb (obw * h)
        return (2 * base.calculateArea() + base.calculatePerimeter() * height);
    }

    double calculateVolume(){ //objetosc
        return (base.calculateArea() * height);
    }

    @Override
    public void print() {
        System.out.println("Powierzchnia graniastoslupa wynosi: " + calculateArea());
        System.out.println("Objetosc graniastoslupa wynosi: " + calculateVolume());
    }
}

