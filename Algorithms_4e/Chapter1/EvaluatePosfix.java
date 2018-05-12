/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import java.util.Iterator;

/**
 *
 * @author KK
 */
public class EvaluatePosfix {
    
    public static void main(String[] args) {
        InfixToPostfix.readInput();
        InfixToPostfix.transformExpression();
        Stack_ArrayIm<String> tmp=InfixToPostfix.getResult();
        Iterator<String> it=tmp.iterator();
        Stack_ArrayIm<Integer> evalStack=new Stack_ArrayIm<>();
        while(it.hasNext()){
            String tmpString=it.next();
            try {
                int num=Integer.parseInt(tmpString);
                evalStack.push(num);
            } catch (NumberFormatException e) {
            int left=evalStack.pop();
            int right=evalStack.pop();
            int topNum=0;
            if( null == tmpString)
                throw new RuntimeException("Illegal expression format");
            else switch (tmpString) {
                    case "+":
                        topNum=left+right;
                        break;
                    case "-":
                        topNum=right-left;
                        break;
                    case "*":
                        topNum=right*left;
                        break;
                    case "/":
                        topNum=right/left;
                        break;
                    default:
                        throw new RuntimeException("Illegal expression format");
                }
            evalStack.push(topNum);
            }
        }
        System.out.println(evalStack.peek());
    }
}
