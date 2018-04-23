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
import java.util.Iterator;

public class Stack_ArrayIm<Item> implements Iterable<Item>{
    
    Item[] store=(Item[])new Object[4];
    int N;
    
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void push(Item item){
        store[N++]=item;
        if(N==store.length)
            resize(store.length*2);
    }
    public Item pop(){
        if(N==0) throw new RuntimeException("Stack is empty");
        Item result=store[--N];
        if(N<store.length/4) resize(store.length/2);
        return result;
    }
    
    
    void resize(int length){
        Item[] tmp=(Item[])new Object[length];
        for (int i = 0; i < N; i++) {
            tmp[i]=store[i];
        }
        store=tmp;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
        //To change body of generated methods, choose Tools | Templates.
    }
    
    class ArrayIterator implements Iterator<Item>{
        
        int currentPos=0;
        @Override
        public boolean hasNext() {
            return currentPos<N&&N!=0;
        }

        @Override
        public Item next() {
            return store[currentPos++];
        }
        
        public void remove(){
            
        }
    }
    
    public Item peek(){
        if(N==0) throw new RuntimeException("Stack is empty");
        return store[N-1];
    }
    
    
    public static void main(String[] args) {
        Stack_ArrayIm<Integer> si=new Stack_ArrayIm<Integer>();
        si.push(3);
        si.push(4);
        si.push(5);
        si.push(6);
        Iterator<Integer> it=si.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(si.pop());
        System.out.println(si.pop());
        System.out.println(si.pop());
        System.out.println(si.pop());
        //System.out.println(si.pop());
    }
}
