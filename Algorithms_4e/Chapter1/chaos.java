/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.Random;
import java.util.Arrays;
import java.util.List;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.lang.reflect.Array;
import java.util.Vector;
/**
 *
 * @author KK
 */

public class Algs {
    
    static int rank(int target,int whiteList[]){
        int lo=0;
        int hi=whiteList.length-1;
        while(hi>=lo){
            int mid=lo+(hi-lo)/2; 
            if(whiteList[mid]<target) 
                lo=++mid;
            else if(whiteList[mid]>target) hi= --mid;
            else return mid;
        }
        return -1;
    }
    
    static String IntToTwoBaseString(int N){
        String result="";
        while(N!=0){
            result=N%2+result;
            N/=2;
        }
        return result;
    }
    
    static  int lg(int N){
        int floor=0;
        for(;N>1;N/=2)
            ++floor;
        return floor;
    }
    
    public static long F(int N){
        long[] data=new long[N+1];
        return doF(N, data);
    }
    static long doF(int N,long [] data){
        if(N==0) return 0;
        if(N==1) return 1;
        if(data[N]!=0) return data[N];
        data[N]=doF(N-1, data)+doF(N-2, data);
        return data[N];
    } 
    
    
    public static void main(String[] args) {   
        int[] whiteList=In.readInts(args[0]);
        boolean printFlag = false;
        if("+".equals(args[1])) printFlag=true;
        else if("-".equals(args[0])) printFlag=false;
        else System.err.println("Unexpected operator "+args[1]+" use '+' or '-' !");
        Arrays.sort(whiteList);
        
        if(whiteList.length!=0){
        int WLLength=0;
        int[] tmp=new int[whiteList.length];
        tmp[0]=whiteList[0];
        for(int i=0;i<whiteList.length;i++){
            if(tmp[WLLength]!=whiteList[i])
                tmp[++WLLength]=whiteList[i];
        }
        whiteList=new int[WLLength+1];
        for(int i=0;i<=WLLength;i++)
            whiteList[i]=tmp[i];
        }
        
         while(!StdIn.isEmpty()){
             int target=StdIn.readInt();
             if(rank(target, whiteList)<0?printFlag:!printFlag)
                 StdOut.println(target);
         }    
}
    
}
