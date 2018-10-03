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
public class StaticSETofIntsTest {
    
    public StaticSETofIntsTest() {
    }

    @Test
    public void testTwoDirFind() {
        int[] a={1,3,4,8,5,-11};
        StaticSETofInts test=new StaticSETofInts(a,false);
        assert test.twoDirFind(1, a);
        assert test.twoDirFind(8, a);
        assert test.twoDirFind(5, a);
        assert test.twoDirFind(-11, a);
        assert test.twoDirFind(3, a);
        assert test.twoDirFind(4, a);
        assert !test.twoDirFind(0, a);
        assert !test.twoDirFind(-6, a);
        assert !test.twoDirFind(9, a);
    }

    @Test
    public void testGetMinIndex() {
    }

    @Test
    public void testGetIndex() {
    }

    @Test
    public void testGetMaxIndex_int() {
    }

    @Test
    public void testGetMaxIndex_int_int() {
    }

    @Test
    public void testHowMany() {
    }

    @Test
    public void testPrintEqualElement() {
    }

    @Test
    public void testMain() {
    }
    
}
