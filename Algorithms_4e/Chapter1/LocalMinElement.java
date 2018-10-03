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
public class LocalMinElement {
    
    /**
     * find the min element in a 2D array(N*N).
     * @param the input Array
     * @return the index of the pos in the square.
     */
    public static int [] squareLocalMin(int [][] input){
        int col=0;
        int row=0;
        while(col<input.length-1){
            if(IsFind(col, row, input)){
                int[] result=new int[2];
                result[0]=row;
                result[1]=col;
                return result;
            }
            int bottom=input[col+1][row];
            int right=row<input[0].length-1?input[col-1][row+1]:Integer.MAX_VALUE;
            int left=row>0?input[col-1][row-1]:Integer.MAX_VALUE;
            
        }
        return null;
    }
    
    public static int arrayLocalMin(int [] input){
        int bottom=0;
        int top=input.length-1;
        if(input.length==1) return 0;
        if(input[0]<input[1]) return 0;
        if(input[input.length-1]<input[input.length-2]) return input.length-1; 
        try {
            while(true){
            int middle=(top+bottom)/2;
            if(input[middle]<input[middle+1]&&input[middle]<input[middle-1]) return middle;
            if(input[middle]<input[middle+1]) top=middle-1;
            else bottom=middle+1;
        }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage()+" Probably you input a illegal array.");
        }
    }
    
    public static boolean IsFind(int col,int row,int [][] input){
        int top= col>0?input[col-1][row]:Integer.MAX_VALUE;
        int bottom=col<input.length-1?input[col+1][row]:Integer.MAX_VALUE;
        int right=row<input[0].length-1?input[col][row+1]:Integer.MAX_VALUE;
        int left=row>0?input[col][row-1]:Integer.MAX_VALUE;
        int num=input[col][row];
        return num<top&&num<bottom&&num<right&&num<left;
    }
    
    
    
}