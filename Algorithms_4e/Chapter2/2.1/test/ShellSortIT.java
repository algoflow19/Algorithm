/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KK
 */
public class ShellSortIT {
    
    public ShellSortIT() {
    }

    @Test
    public void testSort() {
    }

    @Test
    public void testCheck() {
        ShellSort sort=new ShellSort();
        int testSize=100;
        int[] a=new int[testSize];
        for(int i=0;i<testSize;i++){
            a[i]=StdRandom.uniform(testSize);
        }
        assert !sort.check(a);
        int[] ba={1,2,3,4,5,6,7};
        Integer[] b={1,2,3,4,5,6,7};
        assert sort.check(ba);
        assert sort.check(b);
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testHList() {
    }
    
}
