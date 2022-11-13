package com.example.assignmentweek9;

public class Rectangle extends Shape{

    Rectangle(double a, double b) {
        this.x = a;
        this.y = b;
    }

    public double Area(){
        area = this.x*this.y;
        return area;
    }

    public double Circumference(){
        circumference = 2*this.x + 2*this.y;
        return circumference;
    }

}
