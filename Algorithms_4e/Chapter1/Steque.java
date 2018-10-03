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
public class Steque<Item> {
    DoubleNode<Item> store;

    public Steque() {
        store=new DoubleNode<>();
    }
    
    public void catenation(Steque<Item> other){
        store.catenation(other.store);
    }
    
    public void enqueue(Item key){
        store.insertAfterTail(key);
    }
    
    public void push(Item key){
        store.insertBeforeHead(key);
    }
    
    public Item pop(){
        Item result=store.getKey(0);
        store.deleteHeadNode();
        return result;
    }
    
    public static void main(String[] args) {
        Steque<Integer> st=new Steque<>();
        st.push(1);
        st.enqueue(0);
        st.enqueue(99);
        System.out.println(st.pop());
        System.out.println(st.pop());
        st.push(77);
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
