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
public class LL_Practice {
    
    static class Node<Item /* ,Value */ >{
        public Node next;
        public Item key;
        // Value value;
    }
    
    
    
    public static boolean find(Node<String> head,String k){
        while(head!=null){
            if(head.key==k) return true;
            head=head.next;
        }
        return false;
    }
    
    public static void removeAfter(Node node){
        if(node!=null&&node.next!=null)
        node.next=null;
    }
    
    public static void insertAfter(Node first,Node second){
        if(first==null)
            throw new NullPointerException("No place to insert the point!");
        if(second==null)
            System.out.println("Warnning: Insert null after a node, may cause delete");
        Node tmp=first.next;
        first.next=second;
        if(second!=null)
        second.next=tmp;
    }
    
    
    /**
     * Attantion: Java not support null parameter, So it's diffcult
     * to remove first node!
     */
    public static Node<String> remove(Node<String> head, String key){
        if(head==null) return null;
        while(head!=null&&head.key==key){
            Node<String> tmp=head;
            head=head.next;
            tmp.next=null;
        }
        Node<String> checker=head;
        while(checker!=null){
            Node<String> tmp=checker;
            if(checker.next!=null&&checker.next.key==key){
                checker.next=checker.next.next;
                tmp.next=null;
            }
            checker=checker.next;
        }
        return head;
    }
    
    
    public static int max(Node<Integer> head){
        int max=Integer.MIN_VALUE;
        while(head!=null){
            if(head.key>max)
                max=head.key;
            head=head.next;
        }
        return max;
    }
    
    public static int max_reim(Node<Integer> head){
        return max_reim(head,Integer.MIN_VALUE);
    }
    
    public static int max_reim(Node<Integer> head,int max){
        if(head==null) return max;
        max=head.key>max?head.key:max;
        return max_reim(head.next, max);
    }
    
    public static Node revertList(Node headNode){
        Node first,second,nextTarget;
        if(headNode==null) return null;
        first=headNode;
        second=first.next;
        while(second!=null){
            nextTarget=second.next;
            second.next=first;
            first=second;
            second=nextTarget;
        }
        headNode.next=null;
        headNode=first;
        return headNode;
    }
    
    
    public static void main(String[] args) {
        /* Test revert list funation!*/
        Node<Integer> head=new Node<>();
        head.next=null;
        head.key=0;
        for(int i=1;i<11;++i){
            Node<Integer> tmp=new Node<>();
            tmp.next=head;
            tmp.key=i;
            head=tmp;
        }
        System.out.println(head.key);
        head=revertList(head);
        System.out.println(head.key);
        head=head.next;
        while(head!=null){
            System.out.println(head.key);
            head=head.next;
        }
        /*  */
        
    }
}
