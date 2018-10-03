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
public class VisualInsertSort extends SortBase{
    Double[] d;

    public VisualInsertSort(Double[] d) {
        this.d=d;
        this.a=d;
        StdDraw.setCanvasSize(100,800);
        StdDraw.setYscale(0,a.length);
        StdDraw.setXscale(0,a.length);
        
    }
    
    public void show(int minIndex,int beginIndex){
        StdDraw.setPenColor(Color.BLUE);
        for(int i=0;i<minIndex;i++)
            StdDraw.filledRectangle(i+0.5, beginIndex+d[i]*0.9*0.5, 0.5*0.7, d[i]*0.9*0.5);
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledRectangle(minIndex+0.5, beginIndex+d[minIndex]*0.9*0.5, 0.5*0.7, d[minIndex]*0.9*0.5);
        StdDraw.setPenColor(Color.BLACK);
        for(int i=minIndex+1;i<=beginIndex;i++){
            StdDraw.filledRectangle(i+0.5, beginIndex+d[i]*0.9*0.5, 0.5*0.7, d[i]*0.9*0.5);
        }
        StdDraw.setPenColor(Color.BLUE);
        for(int i=beginIndex+1;i<a.length;i++)
            StdDraw.filledRectangle(i+0.5, beginIndex+d[i]*0.9*0.5, 0.5*0.7, d[i]*0.9*0.5);
        
    }
    
    @Override
    public void sort(Comparable[] a) {
        this.a=a;
        for(int i=0;i<a.length;i++){
            int j;
            for(j=i;j>0&&a[j].compareTo(a[j-1])<0;j--)
                exch(j, j-1);
            show(j,i);
        }
    }
    
    public static void main(String[] args) {
        int size=10;
        Double[] test=new Double[size];
        for(int i=0;i<size;i++)
            test[i]=StdRandom.uniform();
        VisualInsertSort sort=new VisualInsertSort(test);
        sort.sort(test);
        
    }
}
