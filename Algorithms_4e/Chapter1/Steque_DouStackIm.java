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
public class Steque_DouStackIm<Item> {
    Stack_ArrayIm<Item> ppStack=new Stack_ArrayIm<>();
    Stack_ArrayIm<Item> qeStack=new Stack_ArrayIm<>();
    
    public int getTotalOperator(){
        return ppStack.popCount+ppStack.pushCount+qeStack.popCount+qeStack.pushCount;
    }
    
    public int size(){
        return ppStack.size()+qeStack.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }
    
    public void push(Item key){
        ppStack.push(key);
    }
    public Item pop(){
        if(ppStack.size()!=0)
        return ppStack.pop();
        else{
            while(!qeStack.isEmpty())
                ppStack.push(qeStack.pop());
        }
        return ppStack.pop();
    }
    public void enqueue(Item key){
        qeStack.push(key);
    }
    
}
