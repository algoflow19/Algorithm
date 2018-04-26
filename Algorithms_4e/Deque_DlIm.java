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
public class Deque_DlIm<Item> implements Iterable<Item>{
    DoubleNode<Item> store;

    public Deque_DlIm() {
        store=new DoubleNode<>();
    }
    
    public boolean isEmpty(){
        return store.size()==0;
    }
    
    public int size(){
        return store.size();
    }
    
    public void pushLeft(Item key){
        store.insertBeforeHead(key);
    }
    
    public void pushRight(Item key){
        store.insertAfterTail(key);
    }
    
    public Item popLeft(){
        Item result=store.getFirstKey();
        store.deleteHeadNode();
        return result;
    }
    
    public Item popRight(){
        Item result=store.getLastKey();
        store.deleteTailNode();
        return result;
    }
    
    /**
     * Iterator element from left to right.
     */
    public Iterator<Item> iterator(){
        return store.iterator();
    }
    
    public static void main(String[] args) {
        Deque_DlIm<String> deque=new Deque_DlIm<>();
        deque.pushLeft("Left");
        System.out.println(deque.popRight());
        deque.pushRight("Right");
        System.out.println(deque.popLeft());
        deque.pushLeft("Left1");
        deque.pushLeft("Left2");
        deque.pushLeft("Left3");
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        deque.pushRight("Right1");
        deque.pushRight("Right2");
        deque.pushRight("Right3");
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        deque.pushRight("Right4");
        deque.pushRight("Right5");
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
    }
    
}
