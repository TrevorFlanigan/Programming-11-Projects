/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namearray;
import java.util.Scanner;

/**
 * November 28, 2016
 * @author flanigantrev
 */
public class NameArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        //tells the user the middle character
        System.out.println("Give me a word or phrase, and I will tell you the middle letter.");
        String phrase = input.nextLine();
        char[] lettersOfPhrase;
        lettersOfPhrase = phrase.toCharArray(); //sets the letters of the phrase into an array
        int middleLetter = lettersOfPhrase.length/2; //gets the middle of the array
        System.out.println("The middle letter is "+lettersOfPhrase[middleLetter]+"."); //tells the user the middle character
        
        System.out.println("Give me your name.");
        String name = input.nextLine();
        System.out.println("Your name is "+name.length()+" letters long"); //tells them how long their name is 
        char[] lettersOfName = name.toCharArray(); //puts their name into an array of characters
        for (int i=lettersOfName.length-1;i>=0;i--){
            System.out.print(lettersOfName[i]);//prints their name backwards
            
        }
        System.out.println(" ,olleH");//says hello
    }
    
}
