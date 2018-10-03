/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KK
 */
public class Steque_DouStackImTest {
    
    public Steque_DouStackImTest() {
        
        
    }

    @Test
    public void testSize() {
    }

    @Test
    public void testPush() {
    }

    @Test
    public void testPop() {
    }

    @Test
    public void testEnqueue() {
    }
    
    @Test
    public void Integrate(){
        Steque_DouStackIm<Integer> steque=new Steque_DouStackIm<>();
        steque.push(3);
        steque.push(2);
        steque.push(1);
        steque.enqueue(4);
        steque.enqueue(5);
        steque.enqueue(6);
        int num=1;
        while(!steque.isEmpty())
            assert steque.pop()==num++;
        steque.enqueue(10);
        steque.enqueue(11);
        steque.enqueue(12);
        steque.push(9);
        steque.push(8);
        steque.push(7);
        while(!steque.isEmpty())
            assert steque.pop()==num++;
        assert steque.isEmpty();
    }
}
