/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;


import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
/**
 *
 * @author KK
 */
public class RandomQueue<Item> implements Iterable<Item>{
    Item[] store=(Item[])new Object[4];
    int size;
    public boolean isEmpty(){
        return size==0;
    }
    
    public void enqueue(Item key){
        store[size++]=key;
        if(size==store.length){
            Item[] tmp=(Item[])new Object[2*store.length];
            for(int i=0;i<store.length;i++)
                tmp[i]=store[i];
            store=tmp;
        }
    }
    
    public Item dequeue(){
        int index=StdRandom.uniform(size);
        Item tmp=store[index];
        store[index]=store[--size];
        store[size]=null;
        return tmp;
    }
    
    public Item sample(){
        return store[StdRandom.uniform(size)];
    }
    
    public Iterator<Item> iterator(){
        return new RQIterator();
    }
    
    class RQIterator implements Iterator<Item>{
        
        int index;
        public RQIterator() {
            StdRandom.shuffle(store,0,size); // 
        }
        
        
        public boolean hasNext(){
            return index!=size;
        }
        
        public Item next(){
            return store[index++];
        }
        
    }
    
    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue =new RandomQueue<>();
        for(int i=0;i<10;++i)
            randomQueue.enqueue(i);
        for(int i=0;i<10;++i)
            System.out.println(randomQueue.dequeue());
        randomQueue.enqueue(0);
        randomQueue.enqueue(1);
        for(int i=0;i<10;++i)
            System.out.print(randomQueue.sample());
        for(Integer k : randomQueue){
            System.out.println(k);
        }
    }
}
