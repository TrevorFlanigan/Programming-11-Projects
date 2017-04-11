/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carddeck;

/**
 *
 * @author Trevor
 */
public class CardDeck {
    private int cardNumber;
    private String suit;
   
    //default construct
    public CardDeck(){
        cardNumber=1;
        suit="Clubs";
    }
    public CardDeck(int number, String s){
        cardNumber = number;
        suit=s;
    }
    public String getCard(){
        String cardName;
        cardName = cardNumber +" of " +suit;
        return cardName;
    }
    public void setCardSuit(String s){
        suit = s;
    }
    public void setCardNumber(){
        cardNumber = (int)(Math.random()*13)+1;
    }
    public void setCardNumber(int numb){
        cardNumber = numb;
    }
}
