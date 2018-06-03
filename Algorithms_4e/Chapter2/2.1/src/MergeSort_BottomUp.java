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
public class MergeSort_BottomUp {
    
    public static void sort(Comparable[] a){
        Comparable[] aux=new Comparable[a.length];
        for(int size=1;size<a.length;size+=size){
            for(int i=0;i+size<a.length;i+=2*size)
                merge(a, aux, i, size);
        }
    }
    
    static void merge(Comparable[] a,Comparable[] aux,int lo,int size){
        int mid=lo+size-1;
        int hi=Math.min(mid+size, a.length-1);
        for(int x=lo;x<=hi;x++)
            aux[x]=a[x];
        int i=lo;
        int j=mid+1;
        for(int x=lo;x<=hi;x++){
            if(i>mid) a[x]=aux[j++];
            else if(j>hi) a[x]=aux[i++];
            else if(aux[i].compareTo(aux[j])<0) a[x]=aux[i++];
            else a[x]=aux[j++];
        }
    }
    
    public static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        /**
         * Casue OutOfMemoryError when you / 4!
         */
        int N=1000000; 
        Double d[]=new Double[N];
        for(int i=0;i<N;i++)
            d[i]=StdRandom.uniform();
        Stopwatch clock=new Stopwatch();
        MergeSort_BottomUp.sort(d);
        System.out.println(clock.elapsedTime());
    }
}
