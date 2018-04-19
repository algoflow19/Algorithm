/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

/**
 *
 * @author KK
 */

import java.util.Calendar;
import edu.princeton.cs.algs4.StdRandom;

public class DetemindPlayOrNot {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
        StdRandom.setSeed(c.getTime().hashCode());
        if(StdRandom.random()>=0.5)
        System.out.println("This day mean to play!");
        else
            System.out.println("This day should study!");
    }
}
