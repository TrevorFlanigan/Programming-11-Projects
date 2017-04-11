/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bankoftrevor;

/**
 * @date 9-Jan-2017
 * @author Trevor
 */
public class Account {
    private double balance;
    private String name;
    
    //default construct
    public Account(){
        balance = 0;
        name = "John Doe";
    }
    //override
    public Account(double b, String n){
        balance = b;
        name = n;
    }
    
    public void changeName(String n){
        name = n;
    }
    public void addFunds(double a){
        balance += a;
    }
    public void withdrawFunds(double w){
        balance-=w;
    }
    public String getName(){
        return name;
    } //these methods are needed because the variables themselves are private
    public double getBalance(){
        return balance;
    }
}
