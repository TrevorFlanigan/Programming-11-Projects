/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcircle;

/**
 *
 * @author Trevor
 */
public class TestCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circle spot = new Circle(); //creates a new object with the default radius
        Circle disk = new Circle(7); //overrides the default with another radius of 7
        Circle puck = new Circle(); // creates a default radius circle
        puck.setRadius(2.6); //sets the radius to 2.6
        
        System.out.println("The Area of the spot is "+spot.area());
        System.out.println("The Radius of the spot is "+spot.getRadius());
        System.out.println("The Area of the disk is "+disk.area());
        System.out.println("The Radius of the disk is "+disk.getRadius());
        System.out.println("The Area of the puck is "+puck.area());
        System.out.println("The Radius of the puck is "+puck.getRadius());
    }
    
}
