/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;
import java.util.Scanner;
/**
 *
 * @author flanigantrev
 */
public class Dice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //declare variables
        int die1;
        int die2;
        int total;
        int [] dice = new int [13];//dice needs 13 spots, since it will be storing values from 0-12,
        for(int x = 0;x<50;x++){
            die1 = (int)(Math.random()*6)+1;
//            System.out.println(die1); debugging
            die2 = (int)(Math.random()*6)+1;
            total = die1+die2;
            dice[total]=dice[total]+1; //the total is stored in the array, then it will increment every time that value is reached
        }
        for(int d = 2; d<13;d++){
            System.out.println("You rolled a "+d+" "+dice[d]+" time(s)"); // prints how many times each value was rolled.
        }
        
        //Harder version
        Scanner input = new Scanner(System.in);
        int total2=0;
        System.out.println("How many dice would you like to roll?");   
        int [] diceToRoll = new int [input.nextInt()]; // makes an array with as many spots for the amount of dice the user wants.
//        System.out.println(diceToRoll.length);Debugging
        System.out.println("How many times would you like to roll the "+diceToRoll.length+" dice?");
        int x = input.nextInt(); // gets the amount of times they would like to roll
        for(int i=0;i<x;i++){ // rolls as many times as they asked
            total2=0; // resets the total for next roll
            for(int j=0;j<diceToRoll.length;j++){ // loops for the amount of values in diceToRoll
                diceToRoll[j] = (int)(Math.random()*6)+1; // gives a random value to each die the user would like to roll
                System.out.println("Roll #"+(j+1)+" is "+diceToRoll[j]);//prints the value of each die in a 'roll'
                total2+=diceToRoll[j]; //adds the current dice roll to the total
//                System.out.println(total2); testing
            }
            System.out.println("You rolled a total of "+total2+"!");//tells the user what their total was for one given roll of their amount of dice
        }
    }
    
}
