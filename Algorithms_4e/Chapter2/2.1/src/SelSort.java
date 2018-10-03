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
public class SelSort extends SortBase{

    public SelSort(Comparable[] a) {
        this.a=a;
    }
    
    
    @Override
    public void sort(Comparable[] a) {
        int min;
        for(int i=0;i<a.length-1;i++){
            min=i;
            for(int j=i+1;j<a.length;j++)
                if(a[j].compareTo(a[min])<0) min=j;
            exch(i, min);
        }
    }
    
    public static void main(String[] args) {
        int N=100000;
        Integer[] a=new Integer[N];
        for(int i=0;i<N;i++)
            a[i]=StdRandom.uniform(100000);
        SelSort sort=new SelSort(a);
        Stopwatch clock=new Stopwatch();
        sort.sort(a);
        System.out.print(clock.elapsedTime());
        
    }
    
    

}
