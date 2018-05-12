/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import edu.princeton.cs.algs4.In;

/**
 *
 * @author KK doing Algs practice.
 */
public class UF_WQUIM extends UF_QUIM{
    protected int[] treeWeight;
    
    public void initHeight(int N){
        treeWeight=new int[N];
        for(int i=0;i<N;i++)
            treeWeight[i]=1;
    }

    @Override
    public void union(int p, int q) {
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ) return;
        if(treeWeight[rootP]>=treeWeight[rootQ]){
            treeWeight[rootP]+=treeWeight[rootQ];
            id[rootQ]=rootP;
        } else {
            treeWeight[rootQ]+=treeWeight[rootP];
            id[rootP]=rootQ;
        }
        count--;
    }
    
    public static void main(String[] args){
        
        UF_WQUIM qf=new UF_WQUIM();
        In in=new In(args[0]);
        int N=in.readInt();
        qf.initHeight(N);
        qf.initId(N);
        while(!in.isEmpty()){
            int p=in.readInt();
            int q=in.readInt();
            if(qf.connected(p, q)) continue;
            System.out.println(p+"  "+q);
            qf.union(p, q);
        }
        
        System.out.println(qf.count()+" at total.");
    }
}

