/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Draw;
/**
 *
 * @author KK
 */
public class GraphUseCase {
    
    public static void pointUsecase(int N){
        Point2D[] point2Ds=new Point2D[N];
        double min=1.5;
        double dis;
        Draw pointDraw=new Draw("pointDraw");
        pointDraw.setXscale(0, 1);
        pointDraw.setYscale(0, 1);
        pointDraw.setPenRadius(0.005);
        for(int i=0;i<N;i++){
            point2Ds[i]=new Point2D(StdRandom.random(), StdRandom.random());
            pointDraw.point(point2Ds[i].x(),point2Ds[i].y());
        }
        int from=0,to=0;
        for(int i=0;i<N;i++)
            for(int j=i+1;j<N;j++){
                dis=point2Ds[i].distanceTo(point2Ds[j]);
                if(dis<min){ 
                    min=dis;
                    from=i;
                    to=j;
                }
            }
        System.out.println(min);
        pointDraw.line(point2Ds[from].x(), point2Ds[from].y(), point2Ds[to].x(), point2Ds[to].y());
    }
    
    public static void main(String[] args) {
        pointUsecase(10);
        
    }
    
    
}
