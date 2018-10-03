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
public class UF_QUPIM extends UF_QUIM{
    
    public static void main(String[] args) {
        UF_QUPIM uf=new UF_QUPIM();
        uf.initId(10);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(2, 3);
        //uf.union(3, 4); We has produce a 4 points link!
        uf.showPath(0);
    }
    
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
    
}
