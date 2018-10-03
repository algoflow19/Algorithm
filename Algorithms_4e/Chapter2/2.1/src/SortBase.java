/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author KK doing Algs practice. 
 */
public abstract class SortBase {
    public Comparable[] a;
    public abstract void sort(Comparable [] a);
    
    protected boolean less(Comparable v,Comparable w){ // comparable 
        return v.compareTo(w)<0;
    }
    
    protected void exch(int i,int j){
        Comparable tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    
    public void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"  ");
        System.out.println();
    }
    
    public boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++)
            if(a[i].compareTo(a[i-1])<0) return false;
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}
