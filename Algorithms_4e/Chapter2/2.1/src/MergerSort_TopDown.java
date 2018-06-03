/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author KK doing Algs practice.
 */
public class MergerSort_TopDown {
    
    /**
     * Implement Notes: should't use a static var beacuse,
     * It may cause error when multiple call the function
     * @param a 
     */
    public static void sort(Comparable[] a){
        Comparable[] aux=new Comparable[a.length]; 
        sort(a,aux,0,a.length-1);
    }
    
    public static void sort(Comparable[] a,Comparable[] aux,int lo,int hi){
        if(lo>=hi) return;
        int mid=(lo+hi)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        for(int i=lo;i<=hi;i++)
            aux[i]=a[i];
        merge(a, aux, lo, hi);
        
    }
    public static void merge(Comparable[] a,Comparable[] aux,int lo,int hi){
        int i=lo;
        int mid=(lo+hi)/2;
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
    
    // Using case.
    public static void main(String[] args) {
        /**
         * Casue OutOfMemoryError when you / 4!
         */
        int N=Integer.MAX_VALUE/1000; 
        Double d[]=new Double[N];
        for(int i=0;i<N;i++)
            d[i]=StdRandom.uniform();
        MergerSort_TopDown.sort(d);
        //MergerSort_TopDown.show(d);
    }
    
}
