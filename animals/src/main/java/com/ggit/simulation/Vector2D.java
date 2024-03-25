package com.ggit.simulation;
import java.util.Objects;
public class Vector2D {
    private int x,y;
    public Vector2D(int x, int y){ // konstruktor
        this.x = x;
        this.y = y;
    }

    // settery i gettery
    public int getX(){ return x;}
    public int getY() { return y;}
    public void setX(int x){ this.x = x;}
    public void setY(int y) { this.y = y;}

    public Vector2D add(Vector2D vector){ return new Vector2D(x +vector.x, y+ vector.y);} // dodawanie
    public Vector2D opposite(){ return new Vector2D(-x,-y);} // odwrotnosc wektora
    public Vector2D subtrack(Vector2D vector){ return add(vector.opposite());}  // odejmowanie



    @Override // informuja nas ze jest to metoda rozszerzona
    public String toString(){
        return String.format("[%s,%s]",x,y); //"[" + x + "," + y + "]";
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(!(object instanceof Vector2D vector2D)) return false; // jesli sa roznego typu to zwroc
       // Vector2D vector2D = (Vector2D) object; // rzutujemy object na Vector2D
        return x == vector2D.x && y == vector2D.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}


