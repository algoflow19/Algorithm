/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;
import java.util.Arrays;
import javafx.print.PaperSource;

/**
 *
 * @author KK
 */
public class StaticSETofInts {
    int[] a;

    public StaticSETofInts(int[] inputArray,boolean sort) {
        a=inputArray.clone();
        if(sort)
        Arrays.sort(a);
    }
    
    public boolean twoDirFind(int target,int [] input){
        int bottom=0;
        int top=input.length-1;
        if(input.length<3){
            if(input.length<2) throw new IllegalArgumentException("Expect a b array, get"+Arrays.toString(input));
            return input[0]==target||input[1]==target;
        }
        if(input[0]>input[1]||input[input.length-2]<input[input.length-1]) throw new IllegalArgumentException("Not a Bitonic array");
        int middle=0;
        while(bottom<=top){
            middle=(bottom+top)/2;
            int second=input[middle];
            if(second==target) return true;
            int third=input[middle+1];
            int first=input[middle-1];
            if(first<second&&second>third) break;
            else if(second>first){
                bottom=middle+1;
            } else{
                top=middle-1;
            }
        }
        
        return getIndex(target, 0, middle-1)!=-1||getRevArrayIndex(target, middle+1, input.length-1)!=-1;
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
    
    public int getIndex(int key,int bottom,int top){
        if(a.length==0) return -1;
        while(bottom<=top){
            int middle=(bottom+top)/2;
            if(key>a[middle]){
                bottom=middle+1;
            } else if(key<a[middle]){
                top=middle-1;
            } else{
                return middle;
            }
        }
        return -1;
    }
    public int getRevArrayIndex(int key,int bottom,int top){
        if(a.length==0) return -1;
        while(bottom<=top){
            int middle=(bottom+top)/2;
            if(key>a[middle]){
                top=middle-1;
            } else if(key<a[middle]){
                bottom=middle+1;
            } else{
                return middle;
            }
        }
        return -1;
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
        StaticSETofInts list=new StaticSETofInts(a,true);
        //System.out.println(list.howMany(77));
        StaticSETofInts.printEqualElement(a, b);
    }
}
