package com.example.assignmentweek9;

public class Square extends Shape{

    Square(double a) {
        this.x = a;
    }

    public double Area(){
        area = x*x;
        return area;
    }

    public double Circumference(){
        circumference = 4*x;
        return circumference;
    }
}
