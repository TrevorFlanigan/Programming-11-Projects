/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 * @date 13-Jan-2017
 * @author Trevor
 */
public class TTT {

    private String[][] tttBoard;
    private String player1, player2;

    /**
     * constructor pre: none post: tttBoard has been initialized. player1 is X
     * and player2 is O.
     */
    public TTT() {
        player1 = "X";
        player2 = "O";
        tttBoard = new String[3][3];
        for (int row = 0; row < tttBoard.length; row++) {
            for (int col = 0; col < tttBoard[0].length; col++) {
                tttBoard[row][col] = " ";
            }
        }
    }

    /**
     * Plays a game of tic-tac-toe with two users, keeping track of player (X or
     * O) turns. player1 goes first. pre: none post: A game of tic-tac-toe has
     * been played.
     */
    int movesMade = 0;

    public void play() {
        String currPlayer = player1;
        movesMade = 0;

        do {
            displayBoard();
            if (currPlayer == player1) {
                makeMove(player1);
                currPlayer = player2;
                movesMade++;
            } else {
                compMove();
                currPlayer = player1;
            }
        if(movesMade>=9&&winner()==" "){
            System.out.println("The game is a tie!");
        }
        else if(winner()!=" "){
//            System.out.println(movesMade);
            System.out.println("Winner is " + winner());
        }
        } while (movesMade <= 9 && winner() == " ");
        displayBoard();
        
//        System.out.println(winner());
        
        
    }

    /**
     * Displays the board. pre: none post: The tic-tac-toe board has been
     * displayed.
     */
    private void displayBoard() {
        for (int row = 0; row < tttBoard.length; row++) {
            for (int col = 0; col < tttBoard[0].length; col++) {
                System.out.print("[" + tttBoard[row][col] + "]");
            }
            System.out.println();
        }
    }

    /**
     * Prompt user for a move until a valid move has been made. pre: none post:
     * A mark has been made in an empty tic-tac-toe board square.
     */
    private void compMove() {
        boolean makeMove = false;
        makeMove = compWin();
        if (!makeMove) {
            makeMove = compBlock();
        }
        if (!makeMove) {
            makeMove = bestMove(movesMade);
        }
    }

    private void makeMove(String player) {
        Scanner input = new Scanner(System.in);
        boolean validMove = false;
        int row, col;

        do {
            System.out.print("Enter row number (0, 1, 2): ");
            row = input.nextInt();
            System.out.print("Enter column number (0, 1, 2): ");
            col = input.nextInt();
            if ((row >= 0 && row < tttBoard.length
                    && col >= 0 && col < tttBoard[0].length)
                    && tttBoard[row][col].equals(" ")) {
                tttBoard[row][col] = player;
                validMove = true;
                movesMade++;
            } else {
                System.out.println("Invalid move.  Try again.");
            }
        } while (!validMove);
//        movesMade += 1;
    }

    /**
     * Determine winner. Return " " if no winner. pre: none post: X, O, or " "
     * has been returned as the winner.
     */
    private String winner() {

        /* test rows */
        for (int row = 0; row < tttBoard.length; row++) {
            if (tttBoard[row][0].equals(tttBoard[row][1]) && tttBoard[row][1].equals(tttBoard[row][2])
                    && !(tttBoard[row][0].equals(" "))) {
                return (tttBoard[row][0]);
            }
        }

        /* test columns */
        for (int col = 0; col < tttBoard[0].length; col++) {
            if (tttBoard[0][col].equals(tttBoard[1][col]) && tttBoard[1][col].equals(tttBoard[2][col])
                    && !(tttBoard[0][col].equals(" "))) {
                return (tttBoard[0][col]);
            }
        }

        /* test diagonal */
        if (tttBoard[0][0].equals(tttBoard[1][1]) && tttBoard[1][1].equals(tttBoard[2][2])
                && !(tttBoard[0][0].equals(" "))) {
            return (tttBoard[0][0]);
        }

        /* test other diagonal */
        if (tttBoard[0][2].equals(tttBoard[1][1]) && tttBoard[1][1].equals(tttBoard[2][0])
                && !(tttBoard[0][2].equals(" "))) {
            return (tttBoard[0][2]);
        }

        return (" ");
    }

    private boolean compBlock() {
        boolean madeMove = false;
        //test columns
        //left column
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[1][0]) && tttBoard[0][0].equals("X") && tttBoard[2][0] == " ")) {
            tttBoard[2][0] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[2][0]) && tttBoard[0][0].equals("X") && tttBoard[1][0] == " ")) {
            tttBoard[1][0] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][0].equals(tttBoard[1][0]) && tttBoard[2][0].equals("X") && tttBoard[0][0] == " ")) {
            tttBoard[0][0] = "O";
            madeMove = true;
        }
        //middle column
        if (!madeMove && (tttBoard[0][1].equals(tttBoard[1][1]) && tttBoard[0][1].equals("X") && tttBoard[2][1] == " ")) {
            tttBoard[2][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][1].equals(tttBoard[2][1]) && tttBoard[0][1].equals("X") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][1].equals(tttBoard[1][1]) && tttBoard[2][1].equals("X") && tttBoard[0][1] == " ")) {
            tttBoard[0][1] = "O";
            madeMove = true;
        }
        //right column
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[1][2]) && tttBoard[0][2].equals("X") && tttBoard[2][2] == " ")) {
            tttBoard[2][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[2][2]) && tttBoard[0][2].equals("X") && tttBoard[1][2] == " ")) {
            tttBoard[1][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][2].equals(tttBoard[1][2]) && tttBoard[2][2].equals("X") && tttBoard[0][2] == " ")) {
            tttBoard[0][2] = "O";
            madeMove = true;
        }
        //test rows
        //top row
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[0][1]) && tttBoard[0][0].equals("X") && tttBoard[0][2] == " ")) {
            tttBoard[0][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[0][2]) && tttBoard[0][0].equals("X") && tttBoard[0][1] == " ")) {
            tttBoard[0][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][1].equals(tttBoard[0][2]) && tttBoard[0][1].equals("X") && tttBoard[0][0] == " ")) {
            tttBoard[0][0] = "O";
            madeMove = true;
        }
        //middle row
        if (!madeMove && (tttBoard[1][0].equals(tttBoard[1][1]) && tttBoard[1][0].equals("X") && tttBoard[1][2] == " ")) {
            tttBoard[1][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][0].equals(tttBoard[1][2]) && tttBoard[1][0].equals("X") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][2].equals(tttBoard[1][1]) && tttBoard[1][2].equals("X") && tttBoard[1][0] == " ")) {
            tttBoard[1][0] = "O";
            madeMove = true;
        }
        //bottom row
        if (!madeMove && (tttBoard[2][0].equals(tttBoard[2][1]) && tttBoard[2][0].equals("X") && tttBoard[2][2] == " ")) {
            tttBoard[2][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][0].equals(tttBoard[2][2]) && tttBoard[2][0].equals("X") && tttBoard[2][1] == " ")) {
            tttBoard[2][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][2].equals(tttBoard[2][1]) && tttBoard[2][2].equals("X") && tttBoard[2][0] == " ")) {
            tttBoard[2][0] = "O";
            madeMove = true;
        }
        //test diagonals
        //right to left
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[1][1]) && tttBoard[0][2].equals("X") && tttBoard[2][0] == " ")) {
            tttBoard[2][0] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[2][0]) && tttBoard[0][2].equals("X") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][1].equals(tttBoard[2][0]) && tttBoard[1][1].equals("X") && tttBoard[0][2] == " ")) {
            tttBoard[0][2] = "O";
            madeMove = true;
        }
        //left to right
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[1][1]) && tttBoard[0][0].equals("X") && tttBoard[2][2] == " ")) {
            tttBoard[2][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[2][2]) && tttBoard[0][0].equals("X") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][1].equals(tttBoard[2][2]) && tttBoard[1][1].equals("X") && tttBoard[0][0] == " ")) {
            tttBoard[0][0] = "O";
            madeMove = true;
        }
        return madeMove;
    }

    private boolean compWin() {
        boolean madeMove = false;
        //test columns
        //left column
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[1][0]) && tttBoard[0][0].equals("O") && tttBoard[2][0] == " ")) {
            tttBoard[2][0] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[2][0]) && tttBoard[0][0].equals("O") && tttBoard[1][0] == " ")) {
            tttBoard[1][0] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][0].equals(tttBoard[1][0]) && tttBoard[2][0].equals("O") && tttBoard[0][0] == " ")) {
            tttBoard[0][0] = "O";
            madeMove = true;
        }
        //middle column
        if (!madeMove && (tttBoard[0][1].equals(tttBoard[1][1]) && tttBoard[0][1].equals("O") && tttBoard[2][1] == " ")) {
            tttBoard[2][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][1].equals(tttBoard[2][1]) && tttBoard[0][1].equals("O") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][1].equals(tttBoard[1][1]) && tttBoard[2][1].equals("O") && tttBoard[0][1] == " ")) {
            tttBoard[0][1] = "O";
            madeMove = true;
        }
        //right column
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[1][2]) && tttBoard[0][2].equals("O") && tttBoard[2][2] == " ")) {
            tttBoard[2][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[2][2]) && tttBoard[0][2].equals("O") && tttBoard[1][2] == " ")) {
            tttBoard[1][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][2].equals(tttBoard[1][2]) && tttBoard[2][2].equals("O") && tttBoard[0][2] == " ")) {
            tttBoard[0][2] = "O";
            madeMove = true;
        }
        //test rows
        //top row
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[0][1]) && tttBoard[0][0].equals("O") && tttBoard[0][2] == " ")) {
            tttBoard[0][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[0][2]) && tttBoard[0][0].equals("O") && tttBoard[0][1] == " ")) {
            tttBoard[0][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][1].equals(tttBoard[0][2]) && tttBoard[0][1].equals("O") && tttBoard[0][0] == " ")) {
            tttBoard[0][0] = "O";
            madeMove = true;
        }
        //middle row
        if (!madeMove && (tttBoard[1][0].equals(tttBoard[1][1]) && tttBoard[1][0].equals("O") && tttBoard[1][2] == " ")) {
            tttBoard[1][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][0].equals(tttBoard[1][2]) && tttBoard[1][0].equals("O") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][2].equals(tttBoard[1][1]) && tttBoard[1][2].equals("O") && tttBoard[1][0] == " ")) {
            tttBoard[1][0] = "O";
            madeMove = true;
        }
        //bottom row
        if (!madeMove && (tttBoard[2][0].equals(tttBoard[2][1]) && tttBoard[2][0].equals("O") && tttBoard[2][2] == " ")) {
            tttBoard[2][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][0].equals(tttBoard[2][2]) && tttBoard[2][0].equals("O") && tttBoard[2][1] == " ")) {
            tttBoard[2][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[2][2].equals(tttBoard[2][1]) && tttBoard[2][2].equals("O") && tttBoard[2][0] == " ")) {
            tttBoard[2][0] = "O";
            madeMove = true;
        }
        //test diagonals
        //right to left
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[1][1]) && tttBoard[0][2].equals("O") && tttBoard[2][0] == " ")) {
            tttBoard[2][0] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][2].equals(tttBoard[2][0]) && tttBoard[0][2].equals("O") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][1].equals(tttBoard[2][0]) && tttBoard[1][1].equals("O") && tttBoard[0][2] == " ")) {
            tttBoard[0][2] = "O";
            madeMove = true;
        }
        //left to right
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[1][1]) && tttBoard[0][0].equals("O") && tttBoard[2][2] == " ")) {
            tttBoard[2][2] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[0][0].equals(tttBoard[2][2]) && tttBoard[0][0].equals("O") && tttBoard[1][1] == " ")) {
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove && (tttBoard[1][1].equals(tttBoard[2][2]) && tttBoard[1][1].equals("O") && tttBoard[0][0] == " ")) {
            tttBoard[0][0] = "O";
            madeMove = true;
        }
        return madeMove;
    }

    private boolean bestMove(int movesMade) {
        boolean madeMove = false;
        int randomizer;
        if (!madeMove && (tttBoard[1][1].equals("X") && (movesMade == 1))) {
            //play in a corner if the centre is an x
            do {
                randomizer = (int) (Math.random() * 4) + 1;

                switch (randomizer) {
                    case 1: //chooses a random corner to go in if the centre is taken
                        if (tttBoard[0][0] == " ") {
                            tttBoard[0][0] = "O";
                            madeMove = true;
                        }

                        break;
                    case 2:
                        if (tttBoard[0][2] == " ") {
                            tttBoard[0][2] = "O";
                            madeMove = true;
                        }
                        break;
                    case 3:
                        if (tttBoard[2][0] == " ") {
                            tttBoard[2][0] = "O";
                            madeMove = true;
                        }
                        break;
                    case 4:
                        if (tttBoard[2][2] == " ") {
                            tttBoard[2][2] = "O";
                            madeMove = true;
                        }
                        break;
                }
            } while (!madeMove);
        }
        if (!madeMove && (tttBoard[1][1].equals(" ") && (movesMade == 1))) {
            //if x plays not in the centre, go in the cenrte
            tttBoard[1][1] = "O";
            madeMove = true;
        }
        if (!madeMove) {

            do {
                randomizer = (int) (Math.random() * 9) + 1;
                switch (randomizer) {
                    case 1://computer makes a random move after turn 2
                        if (!madeMove&&tttBoard[0][0].equals(" ")) {
                            tttBoard[0][0]=("O");
                            madeMove = true;
                        }
                    case 2:
                        if (!madeMove&&tttBoard[0][1].equals(" ")) {
                            tttBoard[0][1]=("O");
                            madeMove = true;
                        }
                    case 3:
                        if (!madeMove&&tttBoard[0][2].equals(" ")) {
                            tttBoard[0][2]=("O");
                            madeMove = true;
                        }
                    case 4:
                        if (!madeMove&&tttBoard[1][0].equals(" ")) {
                            tttBoard[1][0]=("O");
                            madeMove = true;
                        }
                    case 5:
                        if (!madeMove&&tttBoard[1][1].equals(" ")) {
                            tttBoard[1][1]=("O");
                            madeMove = true;
                        }
                    case 6:
                        if (!madeMove&&tttBoard[1][2].equals(" ")) {
                            tttBoard[1][2]=("O");
                            madeMove = true;
                        }
                    case 7:
                        if (!madeMove&&tttBoard[2][0].equals(" ")) {
                            tttBoard[2][0]=("O");
                            madeMove = true;
                            System.out.println("7");
                        }
                    case 8:
                        if (!madeMove&&tttBoard[2][1].equals(" ")) {
                            tttBoard[2][1]=("O");
                            madeMove = true;
                        }
                    case 9:
                        if (!madeMove&&tttBoard[2][2].equals(" ")) {
                            tttBoard[2][2]=("O");
                            madeMove = true;
                        }
                }
            } while (!madeMove);
        }

        return madeMove;
    }
}

//        return (" ")

