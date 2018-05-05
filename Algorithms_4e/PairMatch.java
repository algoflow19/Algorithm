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
public class PairMatch {
    
    public static double [] findCloestMatch1D(double [] input){
        double [] copy=input.clone();
        Arrays.sort(copy);
        double [] result=new double [2];
        double difference=Double.MAX_VALUE;
        for(int i=0;i<copy.length-1;i++){
            double  tmp=copy[i+1]-copy[i];
            if(tmp<difference){
                result[0]=copy[i];
                result[1]=copy[i+1];
                difference=tmp;
            }
        }
        return result;
    }
    
    public static double [] findFarestMatch1D(double [] input){
        double min=Double.MAX_VALUE;
        double max=Double.MIN_VALUE;
        for(int i=0;i<input.length;i++){
            double tmp=input[i];
            if(max<tmp) max=tmp;
            if(min>tmp) min=tmp;
        }
        double[] result=new double[2];
        result[0]=min;
        result[1]=max;
        return result;
    }
}
