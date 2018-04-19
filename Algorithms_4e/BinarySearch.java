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

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class BinarySearch {
    
    // return the target pos in dataList(Random),
    // if target is not in dataList, return the nearest pos small than target ideal pos( may be -1 ).
    public static int FindIdealPos(int target,int [] dataList){
        if(dataList.length==0) return -1;
        int lo=0;
        int hi=dataList.length-1;
        int mid=0;
        while(lo<=hi){
            mid=lo+(hi-lo)/2;
            if(target>dataList[mid])
                lo=++mid;
            else if(target<dataList[mid])
                hi=--mid;
            else return mid;
        }
        if(mid>=dataList.length||mid>=0&&target<dataList[mid])
            return --mid;
        return mid;
    }
    
    public static int rank(int target,int[] dataList){
        int pos=FindIdealPos(target, dataList);
        if(pos<0) return 0;
        if(dataList[pos]==target)
            while(--pos>0&&dataList[pos]==target) ;
        return pos+1;
    }
    
    public static int count(int target,int[] dataList){
        int pos=FindIdealPos(target, dataList);
        if(pos<0||pos>=dataList.length) return 0;
        if(dataList[pos]!=target) return 0;
        int lo=pos;
        int hi=pos;
        while(--lo>=0&&dataList[lo]==target);
        while(++hi<=dataList.length-1&&dataList[hi]==target);
        return hi-lo-1;
    }
    
    public static void main(String[] args) {
        int[] dataList={1,2,3,4,-3,11,9,7,6,5,13,-5,3,3,4,6,77,-5,-5};
        Arrays.sort(dataList);
        StdOut.println(Arrays.toString(dataList));
        StdOut.println(rank(15, dataList));
        StdOut.println(rank(-10, dataList));
        StdOut.println(rank(-3, dataList));
        StdOut.println(count(14, dataList));
        StdOut.println(count(-10, dataList));
        StdOut.println(count(3, dataList));
        StdOut.println(count(77, dataList));
    }
    
}
