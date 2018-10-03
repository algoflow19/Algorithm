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
public class UF_WQUPIM extends UF_WQUIM{
    @Override
    public int find(int key){
        int root=key;
        while(id[root]!=root) root=id[root];
        while(id[key]!=root){
            int tmp=key;
            key=id[key];
            id[key]=root;
        }
        return root;
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
    
    public static void main(String[] args) {
        UF_WQUPIM uf=new UF_WQUPIM();
        uf.initId(8);
        uf.initHeight(8);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(0, 2);
        
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(4, 6);
        
        uf.union(0, 4);
        
        uf.showPath(7);
        
    }
}
