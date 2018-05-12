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
public class Buffer {
    Stack_ArrayIm<Character> left=new Stack_ArrayIm<>();
    Stack_ArrayIm<Character> right=new Stack_ArrayIm<>();
    
    public void insert(char c){
        left.push(c);
    }
    public char delete(){
        if(left.isEmpty()){
            System.err.println("No char remaining.");
            throw new RuntimeException("No value to return!");
        }
        return left.pop();
    }
    
    public void left(int k){
        if(left.size()<k) throw new RuntimeException("Cursor has moved to the head!");
        for(int i=0;i<k;i++)
            right.push(left.pop());
        
    }
    
    public void right(int k){
        if(right.size()<k) throw new RuntimeException("Cursor has moved to the tail!");
        for(int i=0;i<k;i++)
            left.push(right.pop());
    }
    
    public int size(){
        return right.size()+left.size();
    }
    
    public static void main(String[] args) {
        Buffer buffer=new Buffer();
        buffer.insert('H');
        buffer.insert('e');
        buffer.insert('l');
        buffer.insert('l');
        buffer.insert('o');
        buffer.left(3);
        System.out.println(buffer.delete());
        buffer.right(2);
        System.out.println(buffer.delete());
        System.out.println(buffer.delete());
        System.out.println(buffer.delete());
    }
}
