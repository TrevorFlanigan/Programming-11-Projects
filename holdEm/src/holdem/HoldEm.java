/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdem;

import java.util.Arrays;

/**
 *
 * @author Trevor
 */
public class HoldEm {

    /** December 1, 2016
     * @param args the command line arguments
     */
    public static int getSuit(){
        int randSuit=(int)(Math.random()*4);//selects the player's card's suit
        return randSuit;
    }
    public static int getNumber(){
        int randNumber=(int)(Math.random()*13); // selects the card's value
        return randNumber;
    }
    public static String intToCard(int suit, int number){
//        int randNumber=(int)(Math.random()*13);
//        int randSuit=(int)(Math.random()*4);
//        while(deck[randSuit][randNumber]==-1){
//            randNumber = (int)(Math.random()*13);
//            randSuit=(int)(Math.random()*4); moved to another function
//        }
        
        String card;
        String stringSuit="";
        String stringNumber="";
        
        switch(suit){
            case 0:stringSuit=" of Hearts";
            break;
            case 1:stringSuit = " of Spades";
            break;
            case 2:stringSuit=" of Clubs";
            break;
            case 3:stringSuit=" of Diamonds";
            break;
            default:stringSuit="an Error Occurred";
        }
        switch(number){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:stringNumber=Integer.toString(number+1);
            break;
            case 0:stringNumber="Ace";
            break;
            case 10:stringNumber="Jack";
            break;
            case 11:stringNumber="Queen";
            break;
            case 12:stringNumber="King";
            break;
        }
        card = stringNumber + stringSuit;
//        System.out.println(deck[randSuit][randNumber]);
        return card;
    }
    public static void main(String[] args) {
        // TODO code application logic here
//        int [][] deck = new int[4][13]; unused
//        hearts is 0
//        spades is 1
//        clubs is 2
//        diamonds is 3 unused
        String [][] suits = new String[4][13];
        String [][] usedCards = new String[4][13];
        System.out.println("This is the Hold'Em Casino\nHere, you play hard or you don't play at all.");
        int coins = 100;
        System.out.println("You start with "+coins+" coins.");
        
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
//                deck[i][j]=j; unused, but commented out in case I need it again
//                System.out.println(intToCard(i,j));
                suits[i][j]=intToCard(i,j);
                System.out.println(suits[i][j]);
            }
        }
        
        int suitIndex1=getSuit();
        int numberIndex1=getNumber();
        String playerHand1 = suits[suitIndex1][numberIndex1];
        usedCards[suitIndex1][numberIndex1]=suits[suitIndex1][numberIndex1];//adds the card that was chosen to an array that will hold all dealt cards.
        int numberIndex2;
        int suitIndex2;
        boolean flag = true;
        System.out.println(usedCards[suitIndex1][numberIndex1]);
        do{ //this loop goes until the generator chooses a card that has not been picked (ie. already in the usedCards array...)
            numberIndex2=getNumber(); // selects the card's value
            suitIndex2=getSuit();//selects the player's card's suit
            flag = usedCards[suitIndex2][numberIndex2] != null; //flag is set to true if the usedCards array already has a value for the two numbers.
        }while(flag);
        
        String playerHand2=suits[suitIndex2][numberIndex2]; 
        usedCards[suitIndex2][numberIndex2]=suits[suitIndex2][numberIndex2];
        
        System.out.println("You were dealt the "+playerHand1+" and the "+playerHand2);
        int compSuitIndex1;
        int compNumberIndex1;
        do{
            compSuitIndex1=getSuit();
            compNumberIndex1=getNumber();
            flag = usedCards[compSuitIndex1][compNumberIndex1] != null;
        }while(flag);
        
        String computerHand1 = suits[compSuitIndex1][compNumberIndex1];
        usedCards[compSuitIndex1][compNumberIndex1] = computerHand1;
        
        int compSuitIndex2;
        int compNumberIndex2;
        do{
            compSuitIndex2=getSuit();
            compNumberIndex2=getNumber();
            flag = usedCards[compSuitIndex2][compNumberIndex2] != null;
        }while(flag);
        String computerHand2 = suits[compSuitIndex2][compNumberIndex2];
        usedCards[compSuitIndex2][compNumberIndex2] = computerHand2;
        
        System.out.println("The computer drew the "+computerHand1+" and the "+computerHand2); //obviously I am not telling the user what the computer draws, just using for
        //next, I need to choose 3 flops, a turn and a river.
        
        //also, ask user to bet here.
        //find a way to change the strings back into their values to compute them.
    }
    
}
