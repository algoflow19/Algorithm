/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Arrays;

/**
 *
 * @author KK doing Algs practice.
 */
public class ShellSort extends SortBase {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int[] hList = null;
        this.a = a;
        hList = hList(1, N, 0);
        int CompareTimes = 0;
        for (int x = hList.length - 1; x >= 0; x--) {
            int h = hList[x];
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
                    exch(j - h, j);
                    CompareTimes += 2;
                }
                CompareTimes += 2;
            }
            System.out.println(1.0 * CompareTimes / a.length);
            CompareTimes = 0;
        }
    }
    
    public boolean check(Object[] a){
        Object[] copy=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(copy[i]!=a[i]) return false;
        return true;
    }
    public boolean check(char [] a){
        char[] copy=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(copy[i]!=a[i]) return false;
        return true;
    }
    
    public boolean check(int [] a){
        int[] copy=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(copy[i]!=a[i]) return false;
        return true;
    }
    
    public boolean check(double [] a){
        double[] copy=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(copy[i]!=a[i]) return false;
        return true;
    }
    
    public boolean check(long [] a){
        long [] copy=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(copy[i]!=a[i]) return false;
        return true;
    }
    
    public boolean check(float [] a){
        float[] copy=Arrays.copyOf(a, a.length);
        Arrays.sort(a);
        for(int i=0;i<a.length;i++)
            if(copy[i]!=a[i]) return false;
        return true;
    }
    
    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int N = 100000;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Stopwatch clock = new Stopwatch();
        sort.check(a);
        System.out.print(clock.elapsedTime());

    }

    int[] hList(int h, int N, int i) {
        int result[];
        if (h >= N / 3) {
            result = new int[i + 1];
            result[i] = h;
            return result;
        } else {
            result = hList(3 * h + 1, N, i + 1);
            result[i] = h;
            return result;
        }
    }

}
