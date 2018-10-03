/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

/**
 * Use two stack in one class.
 * @author KK
 */
public class DoubleStack<Item> {
    Deque_DlIm<Item> store=new Deque_DlIm<>();
    int rightSize;
    int leftSize;
    
    public void pushRight(Item key){
        store.pushRight(key);
        rightSize++;
    }
    public void pushLeft(Item key){
        store.pushLeft(key);
        leftSize++;
    }
    public Item popLeft(){
        if(leftSize==0) throw new RuntimeException("Left Stack is empty");
        leftSize--;
        return store.popLeft();
    }
    public Item popRight(){
        if(rightSize==0) throw new RuntimeException("Right Stack is empty");
        rightSize--;
        return store.popRight();
    }
}
