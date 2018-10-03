/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;
import edu.princeton.cs.algs4.In;
import java.util.Arrays;
/**
 *
 * @author KK
 */


public class FileInput {
    
    public static int[] readInts(String fileName){
        In in=new In(fileName);
        String cluse=in.readAll();
        String[] strList=cluse.split("\\s+");
        int[] result=new int[strList.length];
        for(int i=0;i<result.length;++i){
            result[i]=Integer.parseInt(strList[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] testList=readInts("tinyT.txt");
        System.out.println(Arrays.toString(testList));
    }
}
