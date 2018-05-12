/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 *
 * @author KK doing Algs practice.
 */
public abstract class UF_Base {
    static int[] id;
    static int count;
    
    public void initId(int N){
        id=new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
        count=N;
    }
    
    public abstract int find(int p);
    public abstract void union(int p,int q);
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int count(){
        return count;
    }
    
}
