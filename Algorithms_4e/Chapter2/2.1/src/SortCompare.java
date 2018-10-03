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
public class SortCompare {
    
    public static double time(String arg,Comparable[] a){
        
        Stopwatch clock=null;
        if(arg.equals("Insert")){ 
            new InsertSort().sort(a);
            clock=new Stopwatch();
        }
        else if(arg.equals("Shell")){
            new ShellSort().sort(a);
            clock=new Stopwatch();
        } else if(arg.equals("Select")){
            new SelSort(a).sort(a);
            clock=new Stopwatch();
        } 
        return clock.elapsedTime();
    }
    
    public static double timeRandomInput(String alg,int N,int T){
        double total=0.0;
        Double[] result=new Double[N];
        for(int i=0;i<T;i++){
            for(int j=0;j<N;j++)
                result[j]=StdRandom.uniform();
            total+=time(alg, result);
        }
        return total;
    }
}
