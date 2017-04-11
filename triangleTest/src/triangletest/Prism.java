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

//Triangle(super Triangle) -> Prism;
class Prism extends Triangle{
        //variable declaration
        private double volume;
        private double depth;
        
        //default
        public Prism(){
            super();
            depth=1;
        }
        //override
        public Prism(double l1,double l2, double l3,double d){
            super(l1,l2,l3);//makes a prism with face sides l1,l2,and l3, with a depth of d
            depth=d;
        }
        public void setDepth(double d){
            depth=d;//used to change depth
        }
        public double getVolume(){
            volume = super.getArea()*depth;
            return volume;
        }
        public double getDepth(){
            return depth;
        }
}