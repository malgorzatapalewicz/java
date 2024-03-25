package figures;

public abstract class Figure implements Printing{

    abstract double calculateArea();
    abstract double calculatePerimeter();
}
interface Printing{
    void print();
}