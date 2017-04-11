/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrectangle;

/**
 *
 * @author Trevor Flanigan
 * Jan 9, 2017
 */
public class Rectangle {
    int length;
    int width;
    
    //default construct
    public Rectangle(){
        length = 4;
        width = 3;
    }
    //override
    public Rectangle(int l, int w){
        length = l;
        width = w;
    }
    
    public int getLength(){
        return length;
    }
    
    public int getWidth(){
        return width;
    }
    
    public void setLength(int l){
        length = l;
    }
    public void setWidth(int w){
        width = w;
    }
    public int getArea(){
        int area = length*width;
        return area;
    }
    public int getPerimeter(){
        int p = length*2+width*2;
        return p;
    }
}
