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
public class UF_HQUIM extends UF_WQUIM{
    
    @Override
    public void union(int p, int q) {
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ) return;
        if(treeWeight[rootP]>=treeWeight[rootQ]){
            if(treeWeight[rootP]==treeWeight[rootQ])
            treeWeight[rootP]+=treeWeight[rootQ];
            id[rootQ]=rootP;
        } else {
            treeWeight[rootQ]+=treeWeight[rootP];
            id[rootP]=rootQ;
        }
        count--;
    }
    public void showPath(int key){
        while(id[key]!=key){
            System.out.println(key);
            key=id[key];
        }
        System.out.println(key);
    }
    public int conutPathLength(int key){
        int count=1;
        while(id[key]!=key){
            count++;
            key=id[key];
        }
        return count;
    }
    
}
