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
public class Deque_DSImIT {
    
    public Deque_DSImIT() {
    }

    @Test
    public void integrateTest(){
        Deque_DSIm<Integer> deque=new Deque_DSIm<>();
        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);
        for(int i=1;i<=3;i++)
            assert deque.popLeft()==i;
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        for(int i=1;i<=3;i++)
            assert deque.popRight()==i;
    }
    
    @Test
    public void performenceTest(){
        Deque_DSIm<Integer> deque=new Deque_DSIm<>();
        double totalPush=1000000;
        for(int i=1;i<=totalPush;i++)
            deque.pushLeft(i);
        for(int i=1;i<=totalPush;i++)
            deque.popRight();
        assert deque.getOperatorTimes()/totalPush<8;
    }
}
