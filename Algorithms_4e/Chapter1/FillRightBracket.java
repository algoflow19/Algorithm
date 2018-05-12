/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

/**
 *
 * @author KK
 */
public class FillRightBracket {
    
    static Stack_ArrayIm<String> words=new Stack_ArrayIm<>();
    static Stack_ArrayIm<String> tmpStack=new Stack_ArrayIm<>();
    
    
    public static void main(String[] args) {
        String tmp;
        while(!StdIn.isEmpty()){
            tmp=StdIn.readString();
            if(!")".equals(tmp))
                words.push(tmp);
            else{
                readExpression();
                addRightBracket();
                ReceoverWords();
                words.push(")");
            }
        }
        printResult();
    }
    
    static void readOneTerm(){
        String tmp=words.pop();
        if(")".equals(tmp)){
            tmpStack.push(tmp);   // push ) into tmpStack
            readExpression();
            tmpStack.push(words.pop()); // push ( into tmpStack
        } else{
            tmpStack.push(tmp);
        }
    }
    
    static void readExpression(){
        readOneTerm();
        readOperator();
        readOneTerm();
    }
    
    
    static void readOperator(){
        String tmp=words.pop();
        if("-".equals(tmp)||"+".equals(tmp)||"*".equals(tmp)||"/".equals(tmp))
            tmpStack.push(tmp);
        else
            throw new RuntimeException("Parse expression failed.Input expression is illegal.");
    }
    
    static void addRightBracket(){
        words.push("(");
    }
    static void printResult(){
        Iterator<String> it=words.iterator();
        while(it.hasNext())
            System.out.print(it.next());
        System.out.println();
    }
    static void ReceoverWords(){
        while(!tmpStack.isEmpty())
            words.push(tmpStack.pop());
    }
}
