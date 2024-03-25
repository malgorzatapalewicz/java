package menu;
import figures.*;

import java.util.Scanner;

public class Menu {

    private boolean isValidHeight(double height){
        return height != 0;
    }

    private void optionsPrism(int choice, double height, Figure baseFigure, Scanner scanner){
        switch(choice){
            case 1 -> {
                System.out.println("podaj dlugosc bokow trojkata: ");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                Triangle triangle = new Triangle(side1, side2, side3);
                if (isValidHeight(height)) {
                    ThreeDim prism = new ThreeDim(triangle, height);
                    prism.print();
                } else {
                    throw new IllegalArgumentException("wysokosc nie moze byc wartoscia ujemna");
                }
            }
            case 2 -> {
                System.out.println("podaj dlugosc bokow prostokata: ");
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                Rectangle rectangle = new Rectangle(length, width);
                if (isValidHeight(height)) {
                    ThreeDim prism = new ThreeDim(rectangle, height);
                    prism.print();
                } else {
                    throw new IllegalArgumentException("wysokosc nie moze byc wartoscia ujemna");
                }
            }
            case 3 -> {
                System.out.println("podaj dlugosci przekatnych rombu: ");
                double diagonal1 = scanner.nextDouble();
                double diagonal2 = scanner.nextDouble();
                Diamond diamond = new Diamond(diagonal1, diagonal2);
                if (isValidHeight(height)) {
                    ThreeDim prism = new ThreeDim(diamond, height);
                    prism.print();
                } else {
                    throw new IllegalArgumentException("wysokosc nie moze byc wartoscia ujemna");
                }
            }
            default -> System.out.println("wybrano nieprawidlowa opcje");
        }
    }



    public void run(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("wybierz opcje: ");
            System.out.println("1. trojkat ");
            System.out.println("2. prostokat");
            System.out.println("3. romb ");
            System.out.println("4. graniastoslup");
            System.out.println("0. wyjscie");

            int response = scanner.nextInt();
            switch(response){
                case 1 -> {
                    System.out.println("podaj dlugosc bokow trojkata: ");
                    double side1 = scanner.nextDouble();
                    double side2 = scanner.nextDouble();
                    double side3 = scanner.nextDouble();
                    Triangle triangle = new Triangle(side1,side2,side3);
                    triangle.print();
                }
                case 2 -> {
                    System.out.println("podaj dlugosc bokow prostokata: ");
                    double length = scanner.nextDouble();
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length,width);
                    rectangle.print();
                }
                case 3 -> {
                    System.out.println("podaj dlugosci przekatnych rombu: ");
                    double diagonal1 = scanner.nextDouble();
                    double diagonal2 = scanner.nextDouble();
                    Diamond diamond = new Diamond(diagonal1, diagonal2);
                    diamond.print();
                }
                case 4 -> {
                   System.out.println("wybierz podstawe graniastoslupa: ");
                   System.out.println("1. trojkat");
                   System.out.println("2. prostokat");
                   System.out.println("3. romb");
                   int choice = scanner.nextInt();
                   double height;
                   Figure baseFigure = null;

                   System.out.println("podaj wysokosc graniastoslupa: ");
                   height = scanner.nextDouble();
                   optionsPrism(choice, height, baseFigure, scanner);
                }
                case 0 -> {
                   System.out.println("do widzenia!");
                   scanner.close();
                   return;
                }
                default -> System.out.println("wybrano nieprawidlowa opcje, wybierz ponownie");
            }
        }
    }
}
