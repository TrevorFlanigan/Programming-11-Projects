/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometry;

/**
 * September 12, 2016
 * @author flanigantrev
 */
public class Geometry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Create an application that calculates the area of a rectangle with 
        one side 4 and one side 6.  Have it display the output.*/
        int length = 6;
        int width = 4;
        int area = length*width;
        System.out.println("The area is " + area +" units");
        
        
        
        //pokemon
        int monday = 5;
        int tuesday = 2;
        int friday = 2;
        int total = monday + tuesday + friday;
        System.out.println("Mr. Galat walked "+ total +" km this week");
        
        
        //Area of Circle
        
        double pi = 3.14;
        double radius = 7.0;
        double equation = pi*radius*radius;
        System.out.println("The Area of the circle is "+ equation +" cm²");
                
        
        
        
    }
    
}
