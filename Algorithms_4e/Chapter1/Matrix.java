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

import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Matrix {
    public static double dot(double [] a,double [] b){
        if(a.length!=b.length){
            System.err.println("Error, two vector has unequal length");
            System.exit(-1);
        }
        double sum=0;
        for(int i=0;i<a.length;++i){
            sum+=a[i]*b[i];
        }
        return sum;
    }
    
    public static double[] mult(double [][] a,double []b){
        if(a[0].length!=b.length)
            System.err.println("Error, two params has unequal length");
        double[] c=new double[a.length];
        for(int i=0;i<c.length;++i){
            c[i]=dot(a[i], b);
        }
        return c;
    }
    
    public static double[] mult(double[] a,double[][] b){
        double[][] tmp=new double[1][b.length];
        tmp[0]=a;
        return mult(tmp,b)[0];
    }
    
    
    public static double[][] mult(double [][] a,double [][]b){
        if(a[0].length!=b.length)
            System.err.println("Error, two params has unequal length");
        b=transpose(b);
        double[][] result=new double[b.length][a.length];
        for(int i=0;i<b.length;i++)
            result[i]=mult(a, b[i]);
        return transpose(result);
    }
    
    public static double [][] transpose(double[][] a){
        double c[][]=new double[a[0].length][a.length];
        int cols=a.length;
        int rows=a[0].length;
        for(int i=0;i<cols;i++)
            for(int j=0;j<rows;j++){
                c[j][i]=a[i][j];
            }
        return c;
    }
    
    
    public static double[][] readMatrix(){
        int col=StdIn.readInt();
        int row=StdIn.readInt();
        double[][] mat=new double[col][row];
        double[] k=new double[col*row];
        k=mat[0];
        while(!StdIn.isEmpty()){
            k=StdIn.readAllDoubles();
        }
        for(int i=0;i<col;i++)
            for(int j=0;j<row;j++){
                mat[i][j]=k[i*row+j];
            }
        return mat;
    }
    
    
    // Test case.
    public static void main(String[] args) {
        double[][] mat1;
        mat1=readMatrix();
        double[][] mat2={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        double[] mat3={1,2,3};
        mat2=mult(mat2, mat1);
        for(int i=0;i<mat2.length;i++)
            StdOut.println(Arrays.toString(mat2[i]));
        mat3=mult(mat3, mat1);
        StdOut.println(Arrays.toString(mat3));
        
    }
    
}
