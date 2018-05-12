/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author KK doing Algs practice.
 */
public class InsertSort extends SortBase{

    @Override
    public void sort(Comparable[] a) {
        this.a=a;
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0&&a[j].compareTo(a[j-1])<0;j--)
                exch(j, j-1);
        }
    }
    
    public static void main(String[] args) {
        InsertSort sort=new InsertSort();
        int N=10000;
        Integer[] a=new Integer[N];
        for(int i=0;i<N;i++)
            a[i]=StdRandom.uniform(3);
        Stopwatch clock=new Stopwatch();
        sort.sort(a);
        System.out.println(clock.elapsedTime());
    }
    
}
