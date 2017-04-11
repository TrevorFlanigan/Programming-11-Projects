/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @date 3-Apr-2017
 * @author Trevor
 */
public class Ball {
    int x;
    int y;
    int dx;
    int dy;
    int width;
    int height;
    
    public Ball(){
        x=0;
        y=0;
        dx=1;
        dy=1;
    }
    public Ball(int nx, int ny, int ndx, int ndy){
        x=nx;
        y=ny;
        dx=ndx;
        dy=ndy;
    }
    public void bounce(boolean f){
        if(f){
            dy=-dy;
        }
        else{
            dx=-dx;
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public void setX(int nx){
        x=nx;
    }
    public void setY(int ny){
        y=ny;
    }
    public void setHeight(int nHeight){
        height=nHeight;
    }
    public void setWidth(int nWidth){
        width=nWidth;
    }
}
