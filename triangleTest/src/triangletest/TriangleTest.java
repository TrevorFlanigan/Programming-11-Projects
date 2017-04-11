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
public class TriangleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangle j = new Triangle(6,7,8);//creates triangle with sides 6, 7, and 8
        
        System.out.println("The area is "+j.getArea());
        Prism k = new Prism(6,7,8,7);
        System.out.println("The triangluar prism with that face has a volume of "+k.getVolume());
        System.out.println("The area of the face of that prism is "+k.getArea());
        System.out.println("The depth of the prism is "+k.getDepth());
        Triangle defaultT = new Triangle();
        Prism defaultP = new Prism();
        System.out.println("The default area of the triangle class is "+defaultT.getArea());
        System.out.println("The default volume of the prism class is "+defaultP.getVolume());
        System.out.println("The default depth of the prism class is "+defaultP.getDepth());
    }

}
