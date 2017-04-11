
import java.awt.Color;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @date 30-Mar-2017
 * @author Trevor
 */
public class Brick {
    private int x;
    private int y;
    private int height;
    private int width;
    private int power;
    private boolean alive;
    private Color color;
    public Brick(){
        x=0;
        y=0;
        height=100;
        width=50;
        power=1;
        alive = true;
        color = Color.RED;
    }
    
    //override
    public Brick(int nx, int ny, int nheight, int nwidth, boolean nalive,Color ncolor){
        x=nx;
        y=ny;
        height=nheight;
        width=nwidth;
        alive = nalive;
        color = ncolor;
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
    public int getPower(){
        return power;
    }
    public boolean getState(){
        return alive;
    }
    public Color getColor(){
        return color;
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
    public void setPower(int nPower){
        power=nPower;
    }
    public void setState(boolean nalive){
        alive = nalive;
    }
    public void setColor(Color ncolor){
        color = ncolor;
    }
    public Rectangle getRect(){
        Rectangle rect = new Rectangle();
        rect.setBounds(x, y, width, height);
        return rect;
    }
}
