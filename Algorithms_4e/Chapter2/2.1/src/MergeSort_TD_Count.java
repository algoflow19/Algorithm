/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.awt.Color;

/**
 *
 * @author KK doing Algs practice.
 */
public class MergeSort_TD_Count extends MergerSort_TopDown{
    static int conut=0;
    
    public static int catchCountAndReflash(){
        int tmp=conut;
        conut=0;
        return tmp;
    }
    
    public static void sort(Comparable[] a){
        Comparable[] aux=new Comparable[a.length]; 
        sort(a,aux,0,a.length-1);
    }
    
    public static void sort(Comparable[] a,Comparable[] aux,int lo,int hi){
        if(lo>=hi) return;
        int mid=(lo+hi)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        for(int i=lo;i<=hi;i++){
            aux[i]=a[i];
            conut++;
        }
        merge(a, aux, lo, hi);
        
    }
    public static void merge(Comparable[] a,Comparable[] aux,int lo,int hi){
        int i=lo;
        int mid=(lo+hi)/2;
        int j=mid+1;
        for(int x=lo;x<=hi;x++){
            if(i>mid) a[x]=aux[j++];
            else if(j>hi) a[x]=aux[i++];
            else if(aux[i].compareTo(aux[j])<0) {
                a[x]=aux[i++];
                conut+=2;
            }
            else a[x]=aux[j++];
            conut+=2;
        }
    }
    
    public static void main(String[] args) {
        StdDraw.setXscale(1, 512);
        StdDraw.setYscale(0, 6*512*Math.log(512));
        for(int N=1;N<=512;N++){
            Double[] inputArray=new Double[N];
            for(int i=0;i<N;i++)
                inputArray[i]=StdRandom.uniform();
            MergeSort_TD_Count.sort(inputArray);
            int count=MergeSort_TD_Count.catchCountAndReflash();
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(N,count);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(N, 6*N*Math.log(N));
        }
    }
}
