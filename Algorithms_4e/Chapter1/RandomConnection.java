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
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class RandomConnection {
    
    // args[0] is N fargment, args[1] is a possilbity.
    public static void main(String[] args) {
        StdDraw.setXscale(0d,2d);
        StdDraw.setYscale(0d,2d);
        int N=Integer.parseInt(args[0]);
        double p=Double.parseDouble(args[1]);
        double[][] points=new double[N][2];
        StdDraw.circle(1, 1, 1);
        StdDraw.setPenRadius(0.01);
        for(int i=0;i<N;i++){
            points[i][0]=1+Math.cos(2*Math.PI*i/N);
            points[i][1]=1+Math.sin(2*Math.PI*i/N);
            StdDraw.point(points[i][0],points[i][1]);
        }
        StdDraw.setPenColor(StdDraw.GRAY);
        
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(StdRandom.bernoulli(p))
                    StdDraw.line(points[i][0],points[i][1], points[j][0], points[j][1]);
            }
        }
        
    }
    
}
