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
import java.util.Iterator;

public class InfixToPostfix {
    
    static Stack_ArrayIm<String> words=new Stack_ArrayIm<>();
    static Stack_ArrayIm<String> tmp=new Stack_ArrayIm<>();
    static Stack_ArrayIm<String> OperatorStack=new Stack_ArrayIm<>();
    
    public static void main(String[] args){
        readInput();
        transformExpression();
        Iterator<String> it=tmp.iterator();
        while(it.hasNext())
            System.out.print(it.next());
        
    }
    
    public static void extractTerm(){
        if("(".equals(words.peek())){
            transformExpression();
        } else
            tmp.push(words.pop());
    }
    
    public static void transformExpression(){
        words.pop();
        extractTerm();
        extraceOperactor();
        extractTerm();
        words.pop();
        placeOperactor();
    }
    
    public static void extraceOperactor(){
        OperatorStack.push(words.pop());
    }
    
    public static void placeOperactor(){
        tmp.push(OperatorStack.pop());
    }
    
    public static void readInput(){
        while(!StdIn.isEmpty()){
            tmp.push(StdIn.readString());
        }
        while(!tmp.isEmpty())
            words.push(tmp.pop());
    }
    
    public static Stack_ArrayIm<String> getResult(){
        if(!words.isEmpty()) 
            throw new RuntimeException(" Input format error: brackets is not balanced ");
        Iterator<String> it=tmp.iterator();
        Stack_ArrayIm<String> result=new Stack_ArrayIm<>();
        while(it.hasNext())
            result.push(it.next());
        
        return result;
    }
    
}
