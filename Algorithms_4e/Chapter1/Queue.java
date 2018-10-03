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


public class Queue<Item> {

    public Queue(Queue<Item> source) {
        if(getClass()!=source.getClass()) throw new ClassFormatError(" Not same class!");
        for(int i=0;i<source.size;i++){
            Item tmp=source.dequeue();
            enqueue(tmp);
            source.enqueue(tmp);
        }
    }
    public Queue(){ /* Empty */}
    
    
    DNode<Item> last;
    int size;
    
    static class DNode<Item>{
        DNode<Item> next;
        Item key;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void enqueue(Item key){
        if(last==null){
            last=new DNode<>();
            last.key=key;
            last.next=last;
            ++size;
        } else {
            DNode<Item> tmp=last.next;
            last.next=new DNode<>();
            last.next.next=tmp;
            last.next.key=key;
            ++size;
        }
    }
    
    public Item dequeue(){
        
        if(size==0) throw new RuntimeException("Queue was Empty.");
        DNode<Item> tmp=last;
        if(size--==1) {
            last=null;
        }
        else {
            while(tmp.next!=last)
                tmp=tmp.next;
            last=tmp;
            tmp=last.next;
            last.next=last.next.next;
        }
        return tmp.key;
    }
    
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>();
        for(int i=0;i<10;i++)
        queue.enqueue(i);
        for(int i=0;i<10;i++)
            System.out.print(queue.dequeue());
        for(int i=10;i<20;i++)
        queue.enqueue(i);
        for(int i=0;i<10;i++)
            System.out.print(queue.dequeue());
        queue.enqueue(333);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.enqueue(888);
        System.out.println(queue.dequeue());
        assert false;
    }
}
