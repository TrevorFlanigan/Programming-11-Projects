/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holdem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Trevor
 */
public class HoldEm {

    /**
     * December 1, 2016
     *
     * @param args the command line arguments
     */
    public static int[] getHand(int[][] fiveCards) {
        //this function should find pairs, triples, etc. do this by having the user pass the card value arrays into the function and then match them.
        int[] answer = new int[6];
        int[] suits = new int[4];//0 hearts, 1 spades, 2 clubs, 3 diamonds
        int[] histogram = new int[13]; //an array that counts how many times a card 'occurs' in one's hand
        int ofWhat = 0; //finds the values of cards in pairs, two pairs, etc.
        int ofWhat2 = 0;
        int ofWhat3 = 0;
        int ofWhatSuit = 0;// if the suit matters, the suit will be stored in this variable
        int ofWhatHighCard = 0;
        int ofWhatLowCard = 0;
        String cardName;
        String cardName2;
        String cardName3;
        String suitName;
        String highCard = "";
        String lowCard = "";
        boolean flag = false;
        boolean pair = false;
        boolean twoPair = false;
        boolean threeOfAKind = false;
        boolean fourOfAKind = false;
        boolean fullHouse = false;
        boolean flush = false;
        boolean straight = false;
//creates a histogram with 5 values, if any of the 5 values are equal to 2, make a pair etc.
        for (int i = 0; i < fiveCards.length; i++) {
            histogram[fiveCards[i][1]] = histogram[fiveCards[i][1]] + 1;
        }

        //goes through the histogram and finds pairs
        for (int j = 0; j < histogram.length; j++) {
            if (histogram[j] == 2) {
                if (pair) {//checks if they already have a pair, if they do, make it a two pair
                    twoPair = true;
                    pair = false;
                    flag = true;
                    ofWhat2 = (j + 1);
//                    System.out.println("Two Pair!");
                }
                if (!flag) {
                    pair = true;
                    ofWhat = (j + 1);
                }

            }
            if (histogram[j] == 3) {
//                System.out.println("Found 3 "+(j+1)+"'s");
                threeOfAKind = true;
                ofWhat3 = (j + 1);
            }
            if (histogram[j] == 4) {
//                System.out.println("Quad "+(j+1)+"'s");
                fourOfAKind = true;
                ofWhat = (j + 1);
            }
            if (histogram[j] == 0 || histogram[j] == 1) {
//                System.out.println("No matches found");
            }
        }
        if (threeOfAKind && pair) {
//            System.out.println("Full House!");
            fullHouse = true;
            threeOfAKind = false;
            pair = false;
        }
        for (int j = 0; j < fiveCards.length; j++) {
            suits[fiveCards[j][0]] = suits[fiveCards[j][0]] + 1;
        }
        for (int h = 0; h < suits.length; h++) {
//            System.out.println("There are "+suits[h]+" "+h+ " suited cards");
        }
        for (int h = 0; h < suits.length; h++) {
            if (suits[h] == 5) {
                flush = true;
                ofWhatSuit = h;
            }
        }
        int[] topToBottom = new int[5];
        int[][] fiveCardsCopy = fiveCards;
        int num = 0;
        int large = 0;

        for (int i = 0; i < fiveCardsCopy.length; i++) { //Finds the largest hand value 
            num = fiveCardsCopy[i][1];
            if (num > large) {
                large = num;
            }
        }
        //orders the array (player's hand) from 'top to bottom'
        int counter = 0;
        for (int l = 0; l < 13; l++) {
            for (int k = 0; k < fiveCardsCopy.length; k++) {
                if (fiveCardsCopy[k][1] == large - l) {
                    topToBottom[counter] = (large - l) + 1;
                    counter++;
                }

            }
        }
        int count = 0;
//        System.out.println(Arrays.toString(topToBottom));
        if (topToBottom[0] == 13 && topToBottom[topToBottom.length - 1] == 1) {
            if (topToBottom[1] == 12 && topToBottom[2] == 11 && topToBottom[3] == 10) {
                straight = true;
                lowCard = Integer.toString(topToBottom[3]);
                ofWhatLowCard = topToBottom[3];
                highCard = Integer.toString(topToBottom[topToBottom.length - 1]);

                ofWhatHighCard = 1;
            }
        }
        for (int x = 0; x < topToBottom.length - 1; x++) {
            if (topToBottom[x] - topToBottom[x + 1] == 1) {
                count++;
            }
        }
        if (count == 4) {
            lowCard = Integer.toString(topToBottom[topToBottom.length - 1]);
            ofWhatLowCard = topToBottom[topToBottom.length - 1];
            highCard = Integer.toString(topToBottom[0]);
            ofWhatHighCard = topToBottom[0];
            straight = true;
        }

        switch (ofWhat) {
            case 1:
                cardName = "Ace";
                break;
            case 11:
                cardName = "Jack";
                break;
            case 12:
                cardName = "Queen";
                break;
            case 13:
                cardName = "King";
                break;
            default:
                cardName = Integer.toString(ofWhat);
        }
        switch (ofWhat2) {
            case 1:
                cardName2 = "Ace";
                break;
            case 11:
                cardName2 = "Jack";
                break;
            case 12:
                cardName2 = "Queen";
                break;
            case 13:
                cardName2 = "King";
                break;
            default:
                cardName2 = Integer.toString(ofWhat2);
        }
        switch (ofWhat3) {
            case 1:
                cardName3 = "Ace";
                break;
            case 11:
                cardName3 = "Jack";
                break;
            case 12:
                cardName3 = "Queen";
                break;
            case 13:
                cardName3 = "King";
                break;
            default:
                cardName3 = Integer.toString(ofWhat3);
        }
//        switch(ofWhatSuit){
//            case 0: suitName = "Hearts";
//            break;
//            case 1: suitName = "Spades";
//            break;
//            case 2: suitName = "Clubs";
//            break;
//            case 3: suitName = "Diamonds";
//            break;
//            default: suitName = "Doesn't Matter";
//        }
        boolean aceFound = false;
        answer[0] = 0;
        for (int i = 0; i < topToBottom.length; i++) {
            if (topToBottom[i] == 1) {
                aceFound = true;
            }
        }
        if (!aceFound) {
            answer[1] = topToBottom[0];
        } else {
            answer[1] = 1;
        }
        //answer[0] is type of hand
        //answer[1] is the value of the hand type. I.E, a pair of SEVENS, or a Full house with 3 FIVES
        //answer[2] is the value of the smaller card in a hand type that requires more than one type of card. I.E a two pair of kings and QUEENS. or full house of fives and TWOS.
        //answer[3] is the highest value of the five cards.
        //answer[4] is the suit in a flush.
        //answer[5] is the low card in a straight
        if (pair) {
//            System.out.println("pair of "+cardName+"s");
            answer[0] = 1; //the hand is a pair
            answer[1] = ofWhat; //Tells program what the pair is made of
            if (!aceFound) {
                answer[3] = topToBottom[0];//gets the highest card,
            } else {
                answer[3] = 1;//unless there is an ace
            }

        }
        if (twoPair) {
            answer[0] = 2;//the hand is a two pair
            if (ofWhat > ofWhat2) {//gets the higher value of the two pairs.
                answer[1] = ofWhat;
                answer[2] = ofWhat2;
            } else {
                answer[1] = ofWhat2;
                answer[2] = ofWhat;
            }
            if (!aceFound) {
                answer[3] = topToBottom[0];//gets the highest card
            } else {
                answer[3] = 1;//unless there is an ace
            }
//            System.out.println("two pairs of "+cardName+"s and of "+cardName2+"s");

        }
        if (threeOfAKind) {
            answer[0] = 3;//the hand is a three of a kind
            answer[1] = ofWhat3;//gets the value of the 3 cards
            if (!aceFound) {
                answer[3] = topToBottom[0];
            } else {
                answer[3] = 1;
            }
//            System.out.println("three of a kind of "+cardName3+"s");
        }
        if (fourOfAKind) {
            answer[0] = 7;//the hand is a four of a kind
            answer[1] = ofWhat;
            if (!aceFound) {
                answer[3] = topToBottom[0];//
            } else {
                answer[3] = 1;
            }
//            System.out.println("four of a kind of "+cardName+"s");
        }
        if (fullHouse) {
            answer[0] = 6;//the hand is a full house
            answer[1] = ofWhat3;//finds the value of the 3 cards
            answer[2] = ofWhat;//finds the value of the remaining 2 cards.
            if (!aceFound) {
                answer[3] = topToBottom[0];//
            } else {
                answer[3] = 1;
            }
//            System.out.println(cardName3+"s full of "+cardName+"s");
        }
        if (flush) {
//            System.out.println("flush of "+suitName+"!");
            answer[0] = 5;//hand is a flush
            answer[4] = ofWhatSuit;//gets the suit of the flush
            if (!aceFound) {
                answer[3] = topToBottom[0];//
            } else {
                answer[3] = 1;
            }

        }
        
        if (straight) {
//            System.out.print(lowCard+"-"+highCard+" straight");
            if (flush) {
//                System.out.print("-flush");
                answer[0] = 8;//the hand is a straight flush
                answer[1] = ofWhatHighCard;//gets the high value of the straight
                answer[4] = ofWhatSuit;
                answer[5] = ofWhatLowCard;
            } else {
                answer[0] = 4;//hand is a straight
                answer[1] = ofWhatHighCard;//gets the high value of the straight
                answer[5] = ofWhatLowCard;//gets the low value of the straight
            }
//            System.out.println("!");

        }
        return answer;
        //answer[Type of Hand, Hand Value, Small Value, Highest Card, Suit, Low Card Straight]
        //1 is pair,
        //2 is two pair
        //3 is three of a kind
        //4 is straight
        //5 is flush
        //6 is full house
        //7 is 4 of a kind
        //8 is straight-flush

    }

    public static int[] getValue(String card, int[][] cardValues) {
        int sIndex = 0;
        int nIndex = 0;
        int[] returns = new int[2];
        //finds integer values for card names (strings), basically makes an integer that represents a string i.e. "Ace" = (int)0, "2" = 1, etc.
        if (card.contains("Ace")) {
            nIndex = 0;
        } else if (card.contains("2")) {
            nIndex = 1;
        } else if (card.contains("3")) {
            nIndex = 2;
        } else if (card.contains("4")) {
            nIndex = 3;
        } else if (card.contains("5")) {
            nIndex = 4;
        } else if (card.contains("6")) {
            nIndex = 5;
        } else if (card.contains("7")) {
            nIndex = 6;
        } else if (card.contains("8")) {
            nIndex = 7;
        } else if (card.contains("9")) {
            nIndex = 8;
        } else if (card.contains("10")) {
            nIndex = 9;
        } else if (card.contains("Jack")) {
            nIndex = 10;
        } else if (card.contains("Queen")) {
            nIndex = 11;
        } else if (card.contains("King")) {
            nIndex = 12;
        }

        if (card.contains("Hearts")) {
            sIndex = 0;
        } else if (card.contains("Spades")) {
            sIndex = 1;
        } else if (card.contains("Clubs")) {
            sIndex = 2;
        } else if (card.contains("Diamonds")) {
            sIndex = 3;
        }
        returns[0] = sIndex; //since 2 values need to be returned, there must be an array that is returned.  This Gets the integer value of a card that originally was a string.
        returns[1] = nIndex;
        return returns;
    }

    public static String[] putInPlay(String[][] usedCards, String[][] deck) {
        String[] cards = new String[3];
        boolean flag;
        int sIndex;
        int nIndex;
        do {
            sIndex = getSuit();
            nIndex = getNumber();
            flag = usedCards[sIndex][nIndex] != null;
            //gets a random card until it is not the same as one that is already in play.
        } while (flag);
        cards[0] = deck[sIndex][nIndex];//0 is the string that will be presented to the user
        cards[1] = Integer.toString(sIndex);//1 is the index of the suit
        cards[2] = Integer.toString(nIndex);//2 is the index of the number (to be used in usedCard array)
        return cards;
    }

    public static int getSuit() {
        int randSuit = (int) (Math.random() * 4);//selects the player's card's suit
        return randSuit;
    }

    public static int getNumber() {
        int randNumber = (int) (Math.random() * 13); // selects the card's value
        return randNumber;
    }

    public static String intToCard(int suit, int number) { //converts an integer value into a card, i.e. [0][0] = "Ace of Hearts"

        String card;
        String stringSuit = "";
        String stringNumber = "";

        switch (suit) {
            case 0:
                stringSuit = " of Hearts";
                break;
            case 1:
                stringSuit = " of Spades";
                break;
            case 2:
                stringSuit = " of Clubs";
                break;
            case 3:
                stringSuit = " of Diamonds";
                break;
            default:
                stringSuit = "an Error Occurred";//this should never occur, but it is to prevent the code from saying "may not be defined yet"
        }
        switch (number) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                stringNumber = Integer.toString(number + 1);//converts an integer into a string, which represents the number, ie 1 = "2"
                break;
            case 0:
                stringNumber = "Ace"; //gets the names of all un numbered cards
                break;
            case 10:
                stringNumber = "Jack";
                break;
            case 11:
                stringNumber = "Queen";
                break;
            case 12:
                stringNumber = "King";
                break;
        }
        card = stringNumber + stringSuit;// the card becomes eg. "Ace" + " of Hearts" to become "Ace of Hearts"
//        System.out.println(deck[randSuit][randNumber]);
        return card;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
//        int [][] deck = new int[4][13]; unused
//        hearts is 0
//        spades is 1
//        clubs is 2
//        diamonds is 3 
//        for(int k=0;k<2500;k++){
        String[][] suits = new String[4][13];
        String[][] usedCards = new String[4][13];
        int[][] cardValues = new int[4][13];
        System.out.println("This is 5 Card Poker. You are playing against the dealer, whatever you bet you will win two-fold.\nUnlike Texas Hold'em, you will only be given a flop, not a turn or river.\nMay the best hand win. ");
        int coins = 100;
        int turn = 0;
        int blind = 10;
        int bet = 0;
        //variable declaration
        boolean playing = true;//starts playing
        System.out.println("You start with " + coins + " coins.");
        do {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    suits[i][j] = intToCard(i, j);
                    cardValues[i][j] = j; //creates the entire deck.
                    //                System.out.println(cardValues[i][j]);
                    //                System.out.println(suits[i][j]);
                }
            }

//            poker hands
//            //1 is pair,
//            //2 is two pair
//            //3 is three of a kind
//            //4 is straight
//            //5 is flush
//            //6 is full house
//            //7 is 4 of a kind
//            //8 is straight-flush
//            //9 is royal flush
            String[] cards = putInPlay(usedCards, suits);
            String playerHand1 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = playerHand1;//adds the card that was chosen to an array that will hold all dealt cards.
            int[] playerHand1v = getValue(playerHand1, cardValues); //puts cards into play, 2 for player
            //sets the card, which is an array, into its own array, playerHand1v (player's 1st card value)

            cards = putInPlay(usedCards, suits);
            String playerHand2 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = playerHand2;//adds the card that was chosen to an array that will hold all dealt cards.
            int[] playerHand2v = getValue(playerHand2, cardValues); //sets the card, which is an array, into its own array, playerHand2v (player's 2nd card value)

            cards = putInPlay(usedCards, suits);
            String computerHand1 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = computerHand1;
            int[] computerHand1v = getValue(computerHand1, cardValues);//2 for computer
            //sets the card, which is an array, into its own array, computerHand1v (computer's 1st card value)
            cards = putInPlay(usedCards, suits);
            String computerHand2 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = computerHand2;
            int[] computerHand2v = getValue(computerHand2, cardValues);
            //sets the card, which is an array, into its own array, computerHand2v (computer's 2nd card value)

            cards = putInPlay(usedCards, suits);
            String flop1 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = flop1;
            int[] flop1v = getValue(flop1, cardValues);// and 3 for the flop.

            cards = putInPlay(usedCards, suits);
            String flop2 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = flop2;
            int[] flop2v = getValue(flop2, cardValues);

            cards = putInPlay(usedCards, suits);
            String flop3 = cards[0];
            usedCards[Integer.parseInt(cards[1])][Integer.parseInt(cards[2])] = flop3;
            int[] flop3v = getValue(flop3, cardValues);
            //        System.out.println(Arrays.toString(flop3v));
            System.out.println("You were dealt the " + playerHand1 + " and the " + playerHand2);
            System.out.println("You have the blind, betting " + blind);
            coins -= blind;
            bet += blind;
            System.out.println("Your balance is " + coins);
            System.out.println("How much would you like to bet?\n(Put 0 if you would like to check)");
            int nextBet = Math.abs(input.nextInt()); //makes sure the player can only bet positively.
            if (nextBet >= coins) {
                System.out.println("Going All In");
                bet += coins;
                coins -= coins;
            } else if (nextBet > 0 && nextBet < coins) {
                System.out.println("Betting " + nextBet + " coins.");
                bet += nextBet;
                coins -= nextBet;
                System.out.println("Your balance is " + coins); //calculates the coins the player has and the pot after a bet.
            } else if (nextBet == 0) {
                System.out.println("Checking."); //checks if they put 0
            }
            int pot = 2 * bet;
            System.out.println("The pot is " + pot);
            System.out.println("You have the " + playerHand1 + " and the " + playerHand2);
//            System.out.println("The computer drew the " + computerHand1 + " and the " + computerHand2); //obviously I am not telling the user what the computer draws, just using for
            //next, I need to choose 3 flops
            //find a way to change the strings back into their values to compute them.

            System.out.println("************\nThe flop is the " + flop1 + ", the " + flop2 + ", and the " + flop3 + "\n************");
            //ask for bets,checks etc. BEFORE FLOP, computer has no balance, just playing against the dealer for money.  depending on how much you bet, you earn more based on how much you bet.
            System.out.println("Would you like to bet, check, or fold?\nYour balance is " + coins);
            String nextBet2 = input.next().toUpperCase(); //makes the input work no matter the case.
            boolean fold = false;
            switch (nextBet2) {
                case "B":
                case "BET":
                    System.out.println("How much would you like to bet?");
                    //                        System.out.println("How much would you like to bet?\n(Put 0 if you would like to check)");
                    nextBet = Math.abs(input.nextInt());//positive bets only
                    if (nextBet >= coins) {
                        System.out.println("Going All In");
                        bet = coins;
                        coins -= coins;
                    } else if (nextBet > 0 && nextBet < coins) {
                        System.out.println("Betting " + nextBet + " coins.");
                        bet = nextBet;
                        coins -= nextBet;
                    } else if (nextBet == 0) {
                        System.out.println("Checking.");
                    }
                    break;
                case "C":
                case "CHECK":
                    bet = 0;
                    System.out.println("Checking");
                    break;
                case "F":
                case "FOLD":
                    System.out.println("Folding.");
                    fold = true;
                    break;
                default:
                    System.out.println("Incorrect Input, checking.");
                    bet=0;
            }

            if (!fold) {

                int compBet = bet;

                pot += bet + compBet;
                System.out.println("The pot is now " + pot);
                int[][] fiveCards = new int[5][];
                fiveCards[0] = playerHand1v;
                fiveCards[1] = playerHand2v;
                fiveCards[2] = flop1v;
                fiveCards[3] = flop2v;
                fiveCards[4] = flop3v;

                int[][] compFiveCards = new int[5][];
                compFiveCards[0] = computerHand1v;
                compFiveCards[1] = computerHand2v;
                compFiveCards[2] = flop1v;
                compFiveCards[3] = flop2v;
                compFiveCards[4] = flop3v;

                int[] playerHand = getHand(fiveCards);
                //        System.out.println(Arrays.toString(playerHand));
                int playerHandType = playerHand[0];
                int playerHighCard = playerHand[1];
                String playerHighCardName = "";
                int playerLowCard = playerHand[2];
                String playerLowCardName = "";
                int[] computerHand = getHand(compFiveCards);
                int computerHandType = computerHand[0];
                int computerHighCard = computerHand[1];
                String computerHighCardName = "";
                int computerLowCard = computerHand[2];
                String computerLowCardName = "";
                System.out.println("The computer drew the " + computerHand1 + " and the " + computerHand2);
                System.out.println("You have the " + playerHand1 + " and the " + playerHand2);
                System.out.println("The flop is the " + flop1 + ", the " + flop2 + ", and the " + flop3);
                switch (playerHighCard) {
                    case 1:
                        playerHighCardName = "Ace";
                        break;
                    case 11:
                        playerHighCardName = "Jack";
                        break;
                    case 12:
                        playerHighCardName = "Queen";
                        break;
                    case 13:
                        playerHighCardName = "King";
                        break;
                    default:
                        playerHighCardName = Integer.toString(playerHighCard);
                }
                //            System.out.println("The low card is "+playerLowCard);
                switch (playerLowCard) {
                    case 1:
                        playerLowCardName = "Ace";
                        break;
                    case 11:
                        playerLowCardName = "Jack";
                        break;
                    case 12:
                        playerLowCardName = "Queen";
                        break;
                    case 13:
                        playerLowCardName = "King";
                        break;
                    default:
                        playerLowCardName = Integer.toString(playerLowCard);
                }
                //            System.out.println("The computer's high card is "+computerHighCard);
                switch (computerHighCard) {
                    case 1:
                        computerHighCardName = "Ace";
                        break;
                    case 11:
                        computerHighCardName = "Jack";
                        break;
                    case 12:
                        computerHighCardName = "Queen";
                        break;
                    case 13:
                        computerHighCardName = "King";
                        break;
                    default:
                        computerHighCardName = Integer.toString(computerHighCard);
                }
                //            System.out.println("The computer's low card is "+computerLowCard);
                switch (computerLowCard) {
                    case 1:
                        computerLowCardName = "Ace";
                        break;
                    case 11:
                        computerLowCardName = "Jack";
                        break;
                    case 12:
                        computerLowCardName = "Queen";
                        break;
                    case 13:
                        computerLowCardName = "King";
                        break;
                    //                default: computerLowCardName = Integer.toString(playerHighCard);
                }
                String suitName;
                switch (playerHand[4]) { //turns an integer representing a suit into an english suit
                    case 0:
                        suitName = "Hearts";
                        break;
                    case 1:
                        suitName = "Spades";
                        break;
                    case 2:
                        suitName = "Clubs";
                        break;
                    case 3:
                        suitName = "Diamonds";
                        break;
                    default:
                        suitName = "Doesn't Matter";
                }
                String csuitName;
                switch (computerHand[4]) {//turns an integer representing a suit into an english suit
                    case 0:
                        csuitName = "Hearts";
                        break;
                    case 1:
                        csuitName = "Spades";
                        break;
                    case 2:
                        csuitName = "Clubs";
                        break;
                    case 3:
                        csuitName = "Diamonds";
                        break;
                    default:
                        csuitName = "Doesn't Matter";
                }
                switch (playerHandType) { //tells the user exactly what kind of hand they have.
                    case 0:
                        System.out.println("You got High Card of " + playerHighCardName);
                        break;
                    case 1:
                        System.out.println("You got a Pair of " + playerHighCardName + "s");
                        break;
                    case 2:
                        System.out.println("You got 2 Pair of " + playerHighCardName + "s and " + playerLowCardName + "s");
                        break;
                    case 3:
                        System.out.println("You got a 3 of a Kind of " + playerHighCardName + "s");
                        break;
                    case 4:
                        System.out.println("You got a Straight of " + playerHighCardName + "s");
                        break;
                    case 5:
                        System.out.println("You got a Flush of " + suitName);
                        break;
                    case 6:
                        System.out.println("You got a Full House of " + playerHighCardName + "s");
                        break;
                    case 7:
                        System.out.println("You got a 4 of a kind of " + playerHighCardName + "s");
                        break;
                    case 8:
                        System.out.println("You got a Straight-Flush of " + playerHighCardName);
                        break;
                }
                switch (computerHandType) { //tells the user exactly what kind of hand they got.
                    case 0:
                        System.out.println("The computer got High Card of " + computerHighCardName);
                        break;
                    case 1:
                        System.out.println("The computer got a Pair of " + computerHighCardName + "s");
                        break;
                    case 2:
                        System.out.println("The computer got 2 Pair of " + computerHighCardName + "s and " + computerLowCardName + "s");
                        break;
                    case 3:
                        System.out.println("The computer got a 3 of a Kind of " + computerHighCardName + "s");
                        break;
                    case 4:
                        System.out.println("The computer got a Straight of " + computerHighCardName + " to " + computerLowCardName);
                        break;
                    case 5:
                        System.out.println("The computer got a Flush of " + csuitName);
                        break;
                    case 6:
                        System.out.println("The computer got a Full House of " + computerHighCardName);
                        break;
                    case 7:
                        System.out.println("The computer got a 4 of a kind of " + computerHighCardName);
                        break;
                    case 8:
                        System.out.println("The computer got a Straight-Flush of " + computerHighCardName);
                        break;
                }
                if (playerHandType > computerHandType) { //if you have a better hand, you win.
                    System.out.println("You Win!");

                    //make the player win 2x their bet.
                } else if (computerHandType > playerHandType) {
                    System.out.println("You lose.");
                    pot = 0;
                    if (coins <= 0) {
                        playing = false;
                    }
                    //make the player lose their bet.
                } else {

//                    System.out.println("The hands are the same. Checking values."); removed for awkward game flow
                    if (playerHighCard > computerHighCard || (playerHighCard == 1 && computerHighCard != 1)) {//checks who has the higher kicker, or aces.
                        System.out.println("You have the higher value, you win!");
                    } else if (computerHighCard > playerHighCard || (playerHighCard != 1 && computerHighCard == 1)) {
                        System.out.println("The computer has the higher value, you lose.");
                        pot = 0;
                        if (coins <= 0) {
                            playing = false;
                        }
                    } else {
                        if (computerHand[3] == 1) {
                            computerHand[3] = 14;
                        }
                        if (playerHand[3] == 1) {
                            playerHand[3] = 14;
                        }
                        System.out.println("The values are the same.");
                        if (computerHand[3] == playerHand[3]) {
                            System.out.println("The game is a tie, returning bets.");
                            pot = pot/2;
                        } else if (computerHand[3] < playerHand[3]) {
                            System.out.println("You win! You have the higher kicker.");
                        } else if (computerHand[3] > playerHand[3]) {
                            System.out.println("You lose because the computer has a higher kicker.");
                            pot = 0;
                            if (coins <= 0) {
                                playing = false;
                            }
                        }
                    }
                }

                //        }
                coins += pot;
            }
            if (coins > 0) {
                System.out.println("Your balance is now " + coins + "\nWould you like to keep playing?\n (Yes|No)");
                String yesNo = input.next().toUpperCase();//makes their answer work no matter the case
                switch (yesNo) {
                    case "YES":
                        System.out.println("");
                        System.out.println("");
                        break;
                    case "NO":
                        System.out.println("Thanks for playing!");
                        playing = false;
                        break;
                    default:
                        System.out.println("");
                        System.out.println("");
                }
            } else {
                System.out.println("Thanks for playing!");
                playing = false;
            }
        } while (playing); //runs while they have not answered No, or ran out of coins

    }

}
