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
public class StackGenerable {
    
    public static boolean isOverFlow(int[] serizal){
        int conut=0;
        for(int i=0;i<serizal.length;i++){
            if(serizal[i]==-1) conut--;
            else conut++;
            if(conut<0) return true;
        }
        return false;
    }
    
    public static boolean isThisSerizal(int[] serizal,int[] target){
        boolean inMatching=false;
        boolean inputComplain=false;
        int targetPos=target.length-1;
        int conut=0;
        for(int i=0;i<serizal.length;i++){
            if(inMatching||serizal[i]==target[targetPos]){
                if(inputComplain){
                    if(serizal[i]==-1) conut--;
                    else return false;
                    if(conut==0) return true;
                    continue;
                }
                inMatching=true;
                if(serizal[i]==-1){ 
                    conut--;
                    if(conut<0) return false;
                }
                else if(serizal[i]==target[targetPos]){
                    conut++;
                    --targetPos;
                    if(targetPos==-1) inputComplain=true;
                }
                else return false;
            }
        }
        return false;
    }
    
    
    
}
