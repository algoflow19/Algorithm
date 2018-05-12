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
public class LinkList<Item> {
    
    Node head;
    int size;
    class Node{
        public Node next;
        public Item key;
    }
    
    public Item getKey(int index){
        if(index>=size)
            throw new RuntimeException(" index is out of range. ");
        Node result=head;
        for(int i=0;i<=index;i++){
            result=result.next;
        }
        return result.key;
    }
    
    public void insertBeforeHead(Item key){
        Node tmp=new Node();
        tmp.key=key;
        tmp.next=head;
        head=tmp;
        ++size;
    }
    
    // search from head to tail
    public void deleteKey(Item key){
        if(size==0) return;
        Node tmp=head;
        while(tmp.next!=null){
            if(tmp.next.key==key){
                tmp.next=tmp.next.next;
                size--;
                return;
            } 
            else
                tmp=tmp.next;
        }
        return;
    }
    
    
    
}
