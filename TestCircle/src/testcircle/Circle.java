/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircle;

/**
 * Circle class.
 */
public class Circle {

    private static double PI = 3.14;
    private double radius;

    /**
     * constructor pre: none post: A Circle object created. Radius initialized
     * to 1.
     */
    public Circle() {
        radius = 2;	//default radius
    }

    public Circle(double newRad) {
        radius = newRad;
    }

    /**
     * Changes the radius of the circle. pre: none post: Radius has been
     * changed.
     */
    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    /**
     * Calcuates the area of the circle. pre: none post: The area of the circle
     * has been returned.
     */
    public double area() {
        double circleArea;

        circleArea = PI * radius * radius;
        return (circleArea);
    }

    /**
     * Returns the radius of the circle. pre: none post: The radius of the
     * circle has been returned.
     */
    public double getRadius() {
        return (radius);
    }

}
