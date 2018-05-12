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
    public int popCount;
    public int pushCount;
    public int indexCount;
    
    public void catenation(Stack_ArrayIm<Item> other){
        if(other.N==0) return;
        int length=store.length;
        while(length<N+other.N)
            length*=2;
        if(length!=store.length)
            resize(length);
        for(int i=N;i<N+other.N;i++)
            store[i]=other.store[i-N];
        N+=other.N;
    }
    
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void push(Item item){
        pushCount++;
        store[N++]=item;
        indexCount++;
        if(N==store.length)
            resize(store.length*2);
    }
    public Item pop(){
        popCount++;
        if(N==0) throw new RuntimeException("Stack is empty");
        Item result=store[--N];
        if(N<store.length/4) resize(store.length/2);
        return result;
    }
    
    
    void resize(int length){
        Item[] tmp=(Item[])new Object[length];
        for (int i = 0; i < N; i++) {
            tmp[i]=store[i];
            indexCount+=2;
        }
        store=tmp;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
        //To change body of generated methods, choose Tools | Templates.
    }
    
    class ArrayIterator implements Iterator<Item>{
        
        
        
        public ArrayIterator() {
            pushCount=Stack_ArrayIm.this.pushCount;
            popCount=Stack_ArrayIm.this.popCount;
        }
        
        int popCount;
        int pushCount;
        int currentPos=0;
        @Override
        public boolean hasNext() {
            if(popCount!=Stack_ArrayIm.this.popCount||pushCount!=Stack_ArrayIm.this.pushCount)
                throw new RuntimeException("This iterator doesn't support add or remove element when iterating yet!");
            return currentPos<N&&N!=0;
        }

        @Override
        public Item next() {
            if(popCount!=Stack_ArrayIm.this.popCount||pushCount!=Stack_ArrayIm.this.pushCount)
                throw new RuntimeException("This iterator doesn't support add or remove element when iterating yet!");
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
        
        Stack_ArrayIm<Integer> test=new Stack_ArrayIm<>();
        for(int i=0;i<4097;i++)
            test.push(i);
        System.out.print(test.indexCount/4097.0);
    }
}
