/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankoftrevor;

import java.util.Scanner;

/**
 * @date 9-Jan-2017
 * @author Trevor
 */
public class BankOfTrevor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner declaration
        Scanner input = new Scanner(System.in);
//variable declaration
        int answer = 0;
        double balance = 0;
        double add;
        double withdraw;
        boolean flag = true;

        System.out.println("Welcome to the Bank of Trevor!");
        System.out.println("We are happy to set up an account for you!");
        System.out.println("First up, what is your name?");
        String name = input.nextLine();
        System.out.println("Perfect! Next, how much money would you like to save?");
        balance = input.nextDouble();
        Account client1 = new Account(balance, name);

        while (answer <4) { //loops until they choose "Exit"
            System.out.println("Welcome, " + client1.getName());
            System.out.println("\n\t1. Display Balance\n\t2. Add Funds\n\t3. Withdraw Funds\n\t4. Exit");
            answer = input.nextInt(); //records their choice
            switch (answer) {
                case 1: //displays balance
                    System.out.println("Your balance is $" + client1.getBalance());
                    break;
                case 2:
                    System.out.println("How much money would you like to add?");
                    add = Math.abs(input.nextInt()); //gets the absolute value, so they can't put a negative number
                    client1.addFunds(add);//adds that amount to their balance
                    System.out.println("You now have $" + client1.getBalance()); //displays their updated money
                    break;
                case 3:
                    do {
                        System.out.println("How much money would you like to withdraw?");
                        withdraw = Math.abs(input.nextInt());//gets the absolute value, so they can't put a negative number
                        if (withdraw > client1.getBalance()) {//if they try to withdraw more than they have, it fails.
                            flag = false;//con
                            System.out.println("Insufficient Funds.");
                        } else {
                            client1.withdrawFunds(withdraw);//subtracts that amount to their balance
                            flag=true;//will end the for loop
                        }
                    } while (!flag);//runs until they draw less than their balance.
                    System.out.println("You now have $" + client1.getBalance());//displays their updated money
                    break;
                default://if they answer anything other than 1, 2, or 3, it quits. This includes 4
                    System.out.println("Goodbye!");
            }
        }
    }

}
