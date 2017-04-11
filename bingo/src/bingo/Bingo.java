/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 * November 24, 2016
 * @author flanigantrev
 */
public class Bingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char [] bingo = "BINGO".toCharArray(); //sets the array bingo to have the values ["B","I","N","G","O"];
        for(int x = 0;x<bingo.length;x++){ //loops for as many times as there are letters in the dog's name
            System.out.println("There was a farmer who had a dog,\n" +
            "And Bingo was his name-o.\n-----"); // will print the first part of the verse at the beginning of every verse, before BINGO is spelt out
            for(int j = 0;j<3;j++){//says BINGO's name 3 times, spelt out
                for(int i=x;i<bingo.length;i++){// loops through the name of bingo, starting at the corresponding index in the verse.
                    if(i!=bingo.length-1){ //adds a hyphen if it is not the last letter of the array
                        System.out.print(bingo[i]+"-");
                    }
                    else{ //adds an exclaimation point if it is the last letter (ie. "O")
                        System.out.print(bingo[i]+"!");
                    }
                   
                }
                System.out.println("\n-----");//separates the BINGOS so they don't look gross.
            }
            System.out.println("And Bingo was his name-o.");//ends the verse.
        }
    }
    
}
