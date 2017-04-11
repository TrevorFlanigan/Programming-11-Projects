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
public class deckTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CardDeck card = new CardDeck(1,"Hearts");
        CardDeck card2 = new CardDeck();
        card2.setCardNumber();
        CardDeck card3 = new CardDeck();
        card3.setCardNumber(2);
        
        System.out.println("Your card is the "+card.getCard());
        System.out.println("The second card is "+card2.getCard());
        System.out.println("This card is a 2: "+card3.getCard());
    }
    
}
