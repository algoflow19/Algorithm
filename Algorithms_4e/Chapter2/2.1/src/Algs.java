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

public class Algs {
    
    public static int rank(int target,int whiteList[]){
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
        
        String s1="Hello";
        String s2=s1;
        s1="World";
        System.out.println(s1);
        System.out.println(s2);
    }
    
}
