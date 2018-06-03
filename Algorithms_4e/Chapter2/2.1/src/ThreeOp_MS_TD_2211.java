/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author KK doing Algs practice.
 *  1.Change MergeSort to InsertSort When array is very small < 5. ( Sharply reduce the Algo performance.
 *  2.Check if array is sorted.
 *  3.exchange a[] and aux[] to avoid copy every time.
 *  
 * Attantion:
 * Only (1) and (2) isn't confilct,
 * use (3) will destory (1) and (2).
 * 
 */

public class ThreeOp_MS_TD_2211 {
    
    private static InsertSort  Is=new InsertSort();
    
    public static void sort3(Comparable[] a){
        Comparable aux[] = new Comparable[a.length];
        doSortAToA(a, aux, 0, a.length-1);
    }
    
    public static void sort12(Comparable[] a){
        Comparable[] aux= new Comparable[a.length];
        
    }
    
    private static void doSortAToA(Comparable[] a,Comparable[] aux,int lo,int hi){
        if(lo>=hi) return;
        int mid=(lo+hi)/2;
            if(hi-lo<15){
            Is.sort(a,lo,hi);
            return;
            }
        doSortAToAux(a, aux, lo, mid);
        doSortAToAux(a, aux, mid+1, hi);
        if(aux[mid].compareTo(aux[mid+1])<0){
            for(int i=lo;i<=hi;i++)
                a[i]=aux[i];
        } else  
            merge(aux, a, lo, hi);
    }
    
    private static void doSortAToAux(Comparable[] a,Comparable[] aux,int lo,int hi){
        if(hi-lo<15){
            Is.sort(a,lo,hi);
            for(int i=lo;i<=hi;i++)
                aux[i]=a[i];
            return;
        }

        int mid=(lo+hi)/2;
        doSortAToA(a, aux, lo, mid);
        doSortAToA(a, aux, mid+1, hi);
        if(lo>=hi || a[mid].compareTo(a[mid+1])<0){
            for(int i=lo;i<=hi;i++)
                aux[i]=a[i];
        } else  
            merge(a, aux, lo, hi);
        
    }
    
    public static void merge(Comparable[] from,Comparable[] to,int lo,int hi){
        int mid=(lo+hi)/2;
        int i=lo;
        int j=mid+1;
        for(int x=lo;x<=hi;x++){
            if(i>mid)
                to[x]=from[j++];
            else if(j>hi || from[i].compareTo(from[j])<0)
                to[x]=from[i++];
            else 
                to[x]=from[j++];
        }
    }
    
    
    
}
