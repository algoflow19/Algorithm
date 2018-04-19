/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

/**
 *
 * @author KK
 */

import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class RandomMatch {
    
    
    public static int[] destoryMult(int [] List){
        if(List.length!=0){
            int WLLength=0;
            int[] tmp=new int[List.length];
            tmp[0]=List[0];
            for(int j=0;j<List.length;j++){
                if(tmp[WLLength]!=List[j])
                    tmp[++WLLength]=List[j];
            }
            List=new int[WLLength+1];
            for(int j=0;j<=WLLength;j++)
                List[j]=tmp[j];
            }
        return List;
    }
    
    public static void main(String[] args) {
        double T=Integer.parseInt(args[0]);
        //double T=5;
        int[] arrayLength={1000,10000,100000,1000000};
        int[] resultList=new int[4];
        for(int t=0;t<T;t++)
        for(int i=0;i<arrayLength.length;i++){
            int[] whiteList=new int[arrayLength[i]];
            int[] SearchList=new int[arrayLength[i]];
            for(int j=0;j<arrayLength[i];j++){
                whiteList[j]=StdRandom.uniform(100000, 1000000);
                SearchList[j]=StdRandom.uniform(100000, 1000000);
            }
            Arrays.sort(whiteList);
            Arrays.sort(SearchList);
            whiteList=destoryMult(whiteList);
            for(int j=0;j<whiteList.length;j++){
                if(Algs.rank(whiteList[j], SearchList)>=0)
                    ++resultList[i];
            }
        }
        String tail="";
        for(int i=0;i<4;i++){
            System.out.println("When N="+1000+tail+" We get "+resultList[i]/T);
            tail+="0";
        }
        
    }
    
}
