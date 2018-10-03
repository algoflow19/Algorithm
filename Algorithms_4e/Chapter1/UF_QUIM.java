/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

/**
 *
 * @author KK doing Algs practice.
 */
public class UF_QUIM extends UF_Base{
    
    public int total;
    public int cost;
    
    @Override
    public int find(int p) {
        int tmp=id[p];
        while(tmp!=p){
            p=tmp;
            tmp=id[p];
            ++cost;
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int rootp=find(p);
        int rootq=find(q);
        if(rootp==rootq) return ;
        id[rootp]=rootq;
        ++cost;
        count--;
    }
    
    /*
    public static void main(String[] args) {
        UF_QUIM qf=new UF_QUIM();
        In in=new In(args[0]);
        qf.initId(in.readInt());
        while(!in.isEmpty()){
            int p=in.readInt();
            int q=in.readInt();
            if(qf.connected(p, q)) continue;
            System.out.println(p+"  "+q);
            qf.union(p, q);
        }
        
        System.out.println(qf.count()+" at total.");
    }
    */
    
    public static void drawTotal(int i,int total,Draw canven){
        canven.setPenColor(Color.RED);
        canven.point(i, total/i);
    }
    
    public static void drawCost(int i,int cost,Draw canven){
        canven.setPenColor(Color.BLACK);
        canven.point(i, cost);
    }
    
    
    
    public static void main(String[] args) {
        UF_QUIM qf=new UF_QUIM();
        In in=new In("mediumUF.txt");
        if(!in.exists()){
            throw new RuntimeException("Can't got input stream");
        }
        int totalNum=in.readInt();
        qf.initId(totalNum);
        Draw canven=new Draw();
        canven.setXscale(0, 900);
        canven.setYscale(0, 1300);
        canven.setPenRadius(0.002);
        int N=1;
        
        while(!in.isEmpty()){
            int p=in.readInt();
            int q=in.readInt();
            if(!qf.connected(p, q))
            qf.union(p,q);
            qf.total+=qf.cost;
            drawTotal(N,qf.total ,canven);
            drawCost(N, qf.cost, canven);
            qf.cost=0;
            N++;
        }
        System.out.println(qf.total/N);
    }
    
}
