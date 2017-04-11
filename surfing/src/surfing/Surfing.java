/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surfing;
import java.util.Scanner;
/**
 * September 20, 2016
 * @author flanigantrev
 */
public class Surfing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        System.out.println("I want to surf today!\nHow tall are the waves!");
        double wave=input.nextDouble();
        if(wave<2){
            if(wave>10){
                System.out.println("Woah dude too gnarly");
            }
            else{
                System.out.println("Surf's Up!");
            }
        }
        else{
            System.out.println("No surfing today dude");
            
        }
        System.out.println("How old are you?");
        double age=input.nextDouble();
        if(age>=18){
            System.out.println("You are eligible to vote!");
        }
        else{
            System.out.println("You cannot vote yet.");
        }
        
        input.close();
    }
    
}
