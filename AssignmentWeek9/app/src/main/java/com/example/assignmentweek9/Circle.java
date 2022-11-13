package com.example.assignmentweek9;

public class Circle extends Shape{

    Circle(double r) {
        this.r = r;
    }

    public double Area(){
        area = Math.PI*r*r;
        return area;
    }

    public double Circumference(){
        circumference = 2*Math.PI*r;
        return circumference;
    }
}
