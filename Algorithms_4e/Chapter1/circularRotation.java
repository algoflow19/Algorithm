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
public class circularRotation {
    
    public static boolean isCirRot(String s1,String s2){
        return s1.length()==s2.length()&&(s1+s1).indexOf(s2)>=0;
    }
    
    public static void main(String[] args) {
        System.out.println(isCirRot("ACTGACG", "TGACGAC"));
        System.out.println(isCirRot("AABBCDD", "ABBCDDA"));
        System.out.println(isCirRot("ABBCDDA", "DDAABBC"));
        System.out.println(isCirRot("AXA", "AAX"));
    }
}
