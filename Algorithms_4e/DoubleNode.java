/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import java.util.Iterator;

/** This class is for practicing the operation of DoubleNode
 *  o -> o -> o // Left to Right!
 * @author KK
 */
public class DoubleNode<Item> implements Iterable<Item>{
    
    DNode<Item> head;
    DNode<Item> tail;
    int size;
    
    public static class DNode<Item>{
        DNode<Item> next;
        DNode<Item> last;
        Item key;
    }
    
    public int size(){
        return size;
    }
    
    public void insertBeforeHead(Item key){
        if(size==0){
            head=tail=new DNode<>();
            head.key=key;
            ++size;
            return;
        }
        DNode<Item> tmp=head;
        head=new DNode<>();
        head.key=key;
        head.next=tmp;
        tmp.last=head;
        ++size;
    }
    
    public void insertAfterTail(Item key){
        if(size==0) {
            insertBeforeHead(key);
            return;
        }
        DNode<Item> tmp=tail;
        tail=new DNode<>();
        tail.key=key;
        tail.last=tmp;
        tmp.next=tail;
        ++size;
    }
    
    public void deleteHeadNode(){
        if(size==0) throw new RuntimeException("List has been Empty");
        if(size==1){
            head=tail=null;
            --size;
            return;
        }
        head=head.next;
        head.last.next=head.last.last=null;
        --size;
    }
    
    public void deleteTailNode(){
        if(size<=1) {
            deleteHeadNode();
            return;
        }
        tail=tail.last;
        tail.next.last=tail.next.next=null;
        tail.next=null;
        --size;
    }
    
    public void insertBeforeNode(DNode node,Item key){
        if(node==null) throw new NullPointerException(" Input node is null.");
        DNode<Item> tmp=node.last;
        tmp.next=new DNode<>();
        tmp.next.last=tmp;
        tmp.next.next=node;
        ++size;
    }
    
    public void insertAfterNode(DNode node,Item key){
        if(node==null) throw new NullPointerException(" Input node is null.");
        DNode<Item> tmp=node.next;
        tmp.last=new DNode<>();
        tmp.last.next=tmp;
        tmp.last.last=node;
        ++size;
    }
    
    public void deleteNode(DNode node){
        DNode<Item> tmpNext=node.next;
        tmpNext.last=node.last;
        tmpNext.last.next=node.next;
        node.next=node.last=null;
    }
    
    public void showList(){
        DNode<Item> tmp=head;
        while(tmp!=null){
        System.out.println(tmp.key);
        tmp=tmp.next;
        }
        
    }
    
    public Item getKey(int index){
        if(size==0) throw new RuntimeException(" The list is Empty, ");
        if(index<0||index>size-1) throw new RuntimeException("The index " + index +" is out of range");
        DNode<Item> node=head;
        for(int i=0;i<index;i++)
            node=node.next;
        return node.key;
    }
    
    public Item getFirstKey(){
        return head.key;
    }
    
    public Item getLastKey(){
        return tail.key;
    }
    
    @Override
    public Iterator<Item> iterator(){
        return new Diterator();
    }
    
    class Diterator implements Iterator<Item>{
        int nextIndex;
        DNode<Item> nextNode=head;
        @Override
        public boolean hasNext(){
            return nextIndex!=size;
        }
        @Override
        public Item next(){
            if(nextIndex==size) throw new RuntimeException(" There is no next element in this iterator");
            Item key=nextNode.key;
            nextNode=nextNode.next;
            ++nextIndex;
            return key;
        }
        
        /**
         * This iterator don't support remove element when doing iterating!
         */
        @Override
        public void remove(){
            throw new NoSuchMethodError("This iterator don't support remove element when doing iterating!");
        }
        
    }
    
    public static void main(String[] args) {
        DoubleNode<Integer> dn=new DoubleNode<>();
        dn.insertBeforeHead(1);
        dn.insertBeforeHead(2);
        dn.insertBeforeHead(3);
        dn.insertBeforeHead(4);
        dn.insertAfterTail(5);
        dn.insertAfterTail(1);
        dn.showList();
    }
}
