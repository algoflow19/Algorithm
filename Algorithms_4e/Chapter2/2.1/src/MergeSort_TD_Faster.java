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
public class MergeSort_TD_Faster extends MergerSort_TopDown{
    
    public static void sort(Comparable[] a){
        Comparable[] aux=new Comparable[a.length]; 
        sort(a,aux,0,a.length-1);
    }
    public static void sort(Comparable[] a,Comparable[] aux,int lo,int hi){
        if(lo>=hi) return;
        int mid=(lo+hi)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        for(int i=lo;i<=mid;i++)
            aux[i]=a[i];
        for(int i=hi;i>=mid+1;i--)
            aux[i]=a[hi-i+mid+1];
        merge(a, aux, lo, hi);
    }
    public static void merge(Comparable[] a,Comparable[] aux,int lo,int hi){
        int i=lo;
        int j=hi;
        for(int x=lo;x<=hi;x++){
            if(aux[i].compareTo(aux[j])<0) a[x]=aux[i++];
            else a[x]=aux[j--];
        }
    }
    
    public static void main(String[] args) {
        int N=10; // the Max length of the array must less than 1
        Double d[]=new Double[N];
        for(int i=0;i<N;i++)
            d[i]=StdRandom.uniform();
        Stopwatch s1=new Stopwatch();
        MergeSort_TD_Faster.sort(d);
        double t1=s1.elapsedTime();
        MergeSort_TD_Faster.show(d);
        Double k[]=new Double[N];
        for(int i=0;i<N;i++)
            k[i]=StdRandom.uniform();
        Stopwatch s2=new Stopwatch();
        MergerSort_TopDown.sort(k);
        double t2=s2.elapsedTime();
        System.out.println(t1);
        System.out.println(t2);
        //MergeSort_TD_Faster.show(d);
    }
}
