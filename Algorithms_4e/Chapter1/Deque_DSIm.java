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
public class Deque_DSIm<Item> {
    Steque_DouStackIm<Item> steque=new Steque_DouStackIm<>();
    Stack_ArrayIm<Item> stack=new Stack_ArrayIm<>();
    
    public int getOperatorTimes(){
        return steque.getTotalOperator()+stack.popCount+stack.pushCount;
    }
    
    public int size(){
        return steque.size()+stack.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public void pushLeft(Item key){
        steque.push(key);
    }
    public void pushRight(Item key){
        stack.push(key);
    }
    public Item popLeft(){
        if(steque.isEmpty()){
            while(!stack.isEmpty())
                steque.push(stack.pop());
            int giveBackNum=steque.size()/2;
            int totalSize=steque.size();
            for(int i=1;i<=totalSize-giveBackNum;i++)
                steque.enqueue(steque.pop());
            for(int i=1;i<=giveBackNum;i++)
                stack.push(steque.pop());
        }
        return steque.pop();
    }
    
    public Item popRight(){
        if(stack.isEmpty()){
            int remainNum=steque.size()/2;
            int totalSize=steque.size();
            for(int i=1;i<=remainNum;i++)
                steque.enqueue(steque.pop());
            for(int i=1;i<=totalSize-remainNum;i++)
                stack.push(steque.pop());
        }
        return stack.pop();
    }
}
