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
public class LocalMinElementTest {
    
    public LocalMinElementTest() {
    }

    @Test
    public void testSquareLocalMin() {
    }

    @Test
    public void testArrayLocalMin() {
        int[] input={10,7,3,-1,0,8,9};
        assert LocalMinElement.arrayLocalMin(input)==3;
        int[] input1={8,7,5,3,1};
        assert LocalMinElement.arrayLocalMin(input1)==4;
        int[] input2={8,7,5,3,1,10,-5};
        assert LocalMinElement.arrayLocalMin(input2)==input2.length-1;
        int[] input3={8,1,2,3,4,10,12};
        assert LocalMinElement.arrayLocalMin(input3)==1;
    }

    @Test
    public void testIsFind() {
        
    }
    
}
