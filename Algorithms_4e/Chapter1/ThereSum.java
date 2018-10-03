/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
/**
 *
 * @author KK
 */
public class ThereSum {
    // Do not instantiate.
    private ThereSum() { }

    /**
     * Prints to standard output the (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     */
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if ((long)a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 
    
    public static int fastConut(int[] a){
        int conut=0;
        for(int i=0;i<a.length-2;i++){
            conut+=twoSumFastCount(a, i+1, a.length-1, a[i]*(-1));
        }
        return conut;
    }
    
    public static int twoSumFastCount(int[] a){
        return twoSumFastCount(a, 0, a.length-1, 0);
    }
    
    static int twoSumFastCount(int [] a,int bottom,int top,int sum){
        if(a.length==0) return 0;
        int count=0;
        while(bottom<top){
            if((a[bottom]+a[top])== sum ){
                count++;
                if(a[bottom+1]==a[bottom]) bottom++;
                else top--;
            } else if(a[bottom]+a[top]< sum) bottom++;
            else top--;
        }
        return count;
    }
    
    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  { 
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Arrays.sort(a);
        Stopwatch timer = new Stopwatch();
        int count = fastConut(a);
        System.out.println(a.length);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }
}
