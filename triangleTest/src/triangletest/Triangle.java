/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package triangletest;

/**
 * @date 11-Jan-2017
 * @author Trevor
 */
public class Triangle {
    //variable declaration
    private double side1Length;
    private double side2Length;
    private double side3Length;
    private double subPerimeter;
    private double area;
    /**
     * constructor pre: none post: A Circle object created. Radius initialized
     * to 1.
     */
    
    //default
    public Triangle(){
        side1Length = 1;
        side2Length = 1;
        side3Length = 1;
        subPerimeter = (side3Length+side2Length+side1Length)/2;//sub perimeter is half of perimiter, part of the formula
        area = Math.sqrt(subPerimeter*((subPerimeter-side1Length)*(subPerimeter-side3Length)*(subPerimeter-side2Length))); //this formula gets the area of a triangle from 3 side lengths.
    }
    //override
    public Triangle(double s1,double s2,double s3){
        side1Length = s1;
        side2Length = s2;
        side3Length = s3;
        subPerimeter = (side3Length+side2Length+side1Length)/2;
        area = Math.sqrt(subPerimeter*((subPerimeter-side1Length)*(subPerimeter-side3Length)*(subPerimeter-side2Length)));
    }
    public void makeEquilaterial(double l){ //changes a triangle into an equilateral triangle
        side1Length = l;
        side2Length = l;
        side3Length = l;
        subPerimeter = (side3Length+side2Length+side1Length)/2;
        area = Math.sqrt(subPerimeter*((subPerimeter-side1Length)*(subPerimeter-side3Length)*(subPerimeter-side2Length)));
    }
    public double getArea(){
        return area;
    }
    public void setLengths(double s1, double s2, double s3){//allows user to change 
        side1Length = s1;
        side2Length = s2;
        side3Length = s3;
    }
    
    
}
