/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 *
 * @author KK doing Algs practice.
 */

public class Transaction implements Comparable<Transaction>{
    
    String who;
    Date when;
    double amount;
    
    public Transaction(String who,Date when,double amount) {
        this.who=who;
        this.when=when;
        this.amount=amount;
        
    }
    public Transaction(String word){
        String[] tmp=word.split("\\s+");
        when=new Date(tmp[0]);
        who=tmp[1];
        amount=Double.parseDouble(tmp[2]);
    }
    
    public String who(){
        return who;
    }
    public Date when(){
        return when;
    }
    public double amount(){
        return amount;
    }
    public boolean equals(Object that){
        if(that.getClass()!=this.getClass()) throw new RuntimeException("Unmatch Class type!");
        return equals((Transaction)that);  
    }
    
    boolean equals(Transaction that){
        return that.when==when&&that.who==who&&that.amount==amount;
    }

    @Override
    public int compareTo(Transaction t) {
        if(amount<t.amount) return -1;
        if(amount>t.amount) return 1;
        return 0;
    }
    @Override
    public String toString(){
        return when+"-"+who+"-"+amount;
    }
    
    public static Transaction[] readTransactions(){
        Queue<Transaction> inputTransactions=new Queue<>();
        while(!StdIn.isEmpty()){
            String who=StdIn.readString();
            Date when=new Date(StdIn.readString());
            double amount=StdIn.readDouble();
            inputTransactions.enqueue(new Transaction(who, when, amount));
        }
        Transaction[] t=new Transaction[inputTransactions.size()];
        for(int i=0;i<t.length;i++)
            t[i]=inputTransactions.dequeue();
        return t;
    }
    
    public static void main(String[] args) {
        Transaction[] t=readTransactions();
        ShellSort sort=new ShellSort();
        sort.sort(t);
        sort.show(t);
    }
}
