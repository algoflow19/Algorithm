/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.StdIn;

/**
 * Well, is this really effective?
 * @author KK
 */
public class MoveToFront {
    
    static LinkList<Character> list=new LinkList<>();
    public static void main(String[] args) {
        while(StdIn.hasNextChar()){
            char word=StdIn.readChar();
            list.deleteKey(word);
            list.insertBeforeHead(word);
        }
    }
}
