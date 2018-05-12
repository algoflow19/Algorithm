/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author KK doing Algs practice.
 */
public class ErdosRenyi {
    
    public static int count(int Num){
        UF_QUPIM uf=new UF_QUPIM();
        uf.initId(Num);
        int count=0;
        while(uf.count()!=1){
            int p=StdRandom.uniform(0, Num);
            int q=StdRandom.uniform(0, Num);
            if(!uf.connected(p, q)){
                uf.union(p, q);
            }
            ++count;
        }
        return count;
    }
    
    public static void main(String args[]){
        System.out.println(count(2));
    }
}
