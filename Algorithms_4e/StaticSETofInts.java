/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;
import java.util.Arrays;

/**
 *
 * @author KK
 */
public class StaticSETofInts {
    int[] a;

    public StaticSETofInts(int[] inputArray) {
        a=inputArray.clone();
        Arrays.sort(a);
    }
    public int getMinIndex(int key){
        if(a.length==0) return -1;
        int top=a.length-1;
        int bottom=0;
        int index=-1;
        while(bottom<=top){
            int middle=(bottom+top)/2;
            if(key>a[middle]){
                bottom=middle+1;
            } else if(key<a[middle]){
                top=middle-1;
            } else{
                index=middle;
                top=middle-1;
            }
        }
        return index;
    }
    
    
    public int getMaxIndex(int key){
        return getMaxIndex(key, 0);
    }
    int getMaxIndex(int key,int bottom){
        if(a.length==0) return -1;
        int top=a.length-1;
        int index=-1;
        while(bottom<=top){
            int middle=(bottom+top)/2;
            if(key>a[middle]){
                bottom=middle+1;
            } else if(key<a[middle]){
                top=middle-1;
            } else{
                index=middle;
                bottom=middle+1;
            }
        }
        return index;
    }
    
    public int howMany(int key){
        int minIndex=getMinIndex(key);
        if(minIndex==-1) return 0;
        int maxIndex=getMaxIndex(key,minIndex);
        return 1+maxIndex-minIndex;
    }
    
    
    public static void printEqualElement(int[] a,int []b){
        int aIndex=0;
        int bIndex=0;
        while(aIndex<a.length&&bIndex<b.length){
            if(a[aIndex]==b[bIndex]){
                System.out.println(a[aIndex]);
                aIndex++;
            } else if(a[aIndex]<b[bIndex]) aIndex++;
            else bIndex++;
        }
    }
    
    
    public static void main(String[] args) {
        int[] a={3,1,2,3,3,4,55,55,13,15,23,77};
        int[] b={1,33,44,5,6,7,8,9,10,2,23,77};
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        StaticSETofInts list=new StaticSETofInts(a);
        //System.out.println(list.howMany(77));
        StaticSETofInts.printEqualElement(a, b);
    }
}
