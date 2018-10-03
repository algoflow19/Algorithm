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
public class VisualSelSort extends SortBase{
    
    Double[] d;
    
    public VisualSelSort(Double[] a) {
        this.d=a;
        this.a=a;
        StdDraw.setCanvasSize(100,800);
        StdDraw.setYscale(0,a.length);
        StdDraw.setXscale(0,a.length);
        
    }
    
    public void show(int minIndex,int beginIndex){
        
        StdDraw.setPenColor(Color.BLUE);
        for(int i=0;i<beginIndex;i++)
            StdDraw.filledRectangle(i+0.5, beginIndex+d[i]*0.9*0.5, 0.5*0.7, d[i]*0.9*0.5);
        StdDraw.setPenColor(Color.BLACK);
        for(int i=beginIndex;i<a.length;i++){
            if(i!=minIndex)
            StdDraw.filledRectangle(i+0.5, beginIndex+d[i]*0.9*0.5, 0.5*0.7, d[i]*0.9*0.5);
            else {
                StdDraw.setPenColor(Color.RED);
                StdDraw.filledRectangle(i+0.5, beginIndex+d[i]*0.9*0.5, 0.5*0.7, d[i]*0.9*0.5);
                StdDraw.setPenColor(Color.BLACK);
            }
        }
        
    }
    
    @Override
    public void sort(Comparable[] a) {
        int min;
        for(int i=0;i<a.length;i++){
            min=i;
            for(int j=i+1;j<a.length;j++)
                if(a[j].compareTo(a[min])<0) min=j;
            show(min, i);
            exch(i, min);
        }
    }
    
    public static void main(String[] args) {
        int size=10;
        Double[] test=new Double[size];
        for(int i=0;i<size;i++)
            test[i]=StdRandom.uniform();
        VisualSelSort sort=new VisualSelSort(test);
        sort.sort(test);
        
    }
}
