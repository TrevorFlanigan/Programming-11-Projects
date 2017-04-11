/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrectangle;

/**
 *
 * Trevor Flanigan
 * Jan 9, 2017
 */
public class TestRectangle {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle jeff = new Rectangle();
        System.out.println("The length is "+ jeff.length+" or "+jeff.getLength());
        Rectangle joey = new Rectangle(16,9);
//        jeff.setLength(16);
//        jeff.setWidth(9);  
        System.out.println("The area of the first rectangle is "+jeff.getArea());
        System.out.println("The length of the first rectangle is "+jeff.length);
        System.out.println("The width of the first rectangle is "+ jeff.width);
        System.out.println("The perimeter of the first rectangle is "+jeff.getPerimeter());
        System.out.println("The area of the second rectangle is "+joey.getArea());
        System.out.println("The length of the second rectangle is "+joey.length);
        System.out.println("The width of the second rectangle is "+ joey.width);
        System.out.println("The perimeter of the second rectangle is "+joey.getPerimeter());
    }
    
}
