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
public class UF_QFIM extends UF_Base{
    
    public int cost;
    public int total;
    
    @Override
    public int find(int p) {
        cost++;
        return id[p];
        
    }

    @Override
    public void union(int p, int q) {
        int idp=find(p);
        int idq=find(q);
        if(idp==idq) return ;
        for(int i=0;i<id.length;i++){
            if(id[i]==idp){
                id[i]=idq;
                cost++;
            }
            cost++;
        }
        --count;   
    }
    
    public static void drawTotal(int i,int total,Draw canven){
        canven.setPenColor(Color.RED);
        canven.point(i, total/i);
    }
    
    public static void drawCost(int i,int cost,Draw canven){
        canven.setPenColor(Color.BLACK);
        canven.point(i, cost);
    }
    
    public static void main(String[] args) {
        UF_QFIM qf=new UF_QFIM();
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
            qf.union(in.readInt(), in.readInt());
            qf.total+=qf.cost;
            drawTotal(N,qf.total ,canven);
            drawCost(N, qf.cost, canven);
            qf.cost=0;
            N++;
        }
        
    }
    
}
