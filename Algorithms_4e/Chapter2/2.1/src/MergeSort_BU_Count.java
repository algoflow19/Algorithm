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
public class MergeSort_BU_Count extends MergeSort_BottomUp{
    
    
    public static int conut=0;
    
    public static int catchCountAndReflash(){
        int tmp=conut;
        conut=0;
        //System.out.println(tmp);
        return tmp;
    }
    
    
    public static void sort(Comparable[] a){
        Comparable[] aux=new Comparable[a.length];
        for(int size=1;size<a.length;size=size+size){
            for(int i=0;i<a.length-size;i+=size+size)
                merge(a, aux, i, size);
        }
    }
    
    static void merge(Comparable[] a,Comparable[] aux,int lo,int size){
        int mid=lo+size-1;
        int hi=Math.min(lo+size+size-1, a.length-1);
        for(int x=lo;x<=hi;x++){
            aux[x]=a[x];
            conut+=2;
        }
        int i=lo;
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
    
    public static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        int MAX=4096*2*2*2+1000;
        StdDraw.setXscale(1, MAX);
        StdDraw.setYscale(0, 6*MAX*Math.log(MAX));
        for(int N=1;N<=MAX;N++){
        Double d[]=new Double[N];
        
        for(int i=0;i<N;i++)
            d[i]=StdRandom.uniform();
        
        MergeSort_BU_Count.sort(d);
        int count=MergeSort_BU_Count.catchCountAndReflash();
        
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.point(N,count-4*6*N);
        StdDraw.setPenColor(Color.RED);
        StdDraw.point(N, 6*N*Math.log(N));
        }
    }
}
