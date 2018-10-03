/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

/**
 * Im this class using dynamic array!
 * @author KK
 */
public class RandomBag<Item> implements Iterable<Item>{
    
    Item[] store=(Item[])new Object[4];
    int size;
    public boolean isEmpty(){
        return size==0;
    }
    
    public int size(){
        return size;
    }
    
    public void add(Item key){
        store[size++]=key;
        if(size==store.length){
            Item[] tmpStore=(Item[])new Object[2*store.length];
            for(int i=0;i<store.length;i++)
                tmpStore[i]=store[i];
            store=tmpStore;
        }
    }
    
    public Iterator<Item> iterator(){
        return new BagIterator();
    }
    
    class BagIterator implements Iterator<Item>{
        
        int index;
        public BagIterator() {
            StdRandom.shuffle(store,0,size);
        }
        
        public boolean hasNext(){
            return index!=size;
        }
        
        public Item next(){
            Item result=store[index++];
            return result;
        }
    }
    public static void main(String[] args) {
        RandomBag<Integer> bag=new RandomBag<>();
        for(int i=0;i<10;i++)
            bag.add(i);
        for (Iterator<Integer> iterator = bag.iterator(); iterator.hasNext();) {
            int next = iterator.next();
            System.out.println(next);
        }
        
    }
}
