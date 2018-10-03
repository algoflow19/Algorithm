/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import algs.StackGenerable;

/**
 *
 * @author KK
 */
public class StackGenerableTest {
    
    public StackGenerableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsOverFlow() {
        int[] test1={1,2,3,-1,-1,-1};
        assert !StackGenerable.isOverFlow(test1);
        int[] test2={-1,1,2,3,-1,-1,-1};
        assert StackGenerable.isOverFlow(test2);
        int[] test3={1,2,-1,3,-1,-1,-1,4};
        assert StackGenerable.isOverFlow(test3);
        int[] test4={1,2,-1,3,-1,-1,-1,4};
        assert StackGenerable.isOverFlow(test4);
        int[] test5={1,2,-1,3,-1,-1,4};
        assert !StackGenerable.isOverFlow(test5);
    }

    @Test
    public void testIsThisSerizal() {
        int[] serizal_1={3,2,1,-1,-1,-1};
        int[] serizal_2={3,-1,2,1,-1,-1};
        int[] serizal_3={3,2,-1,1,-1,-1};
        int[] serizal_4={3,-1,2,-1,1,-1};
        int[] serizal_5={3,2,-1,-1,4,1,-1};
        int[] serizal_6={4,3,2,-1,-1,1,-1,-1};
        int[] serizal_7={4,3,2,-1,-1,1,-1,-1,6,7,3,-1,-1,-1};
        int[] target={1,2,3};
        assert StackGenerable.isThisSerizal(serizal_3, target);
        assert StackGenerable.isThisSerizal(serizal_1, target);
        assert StackGenerable.isThisSerizal(serizal_2, target);
        assert StackGenerable.isThisSerizal(serizal_4, target);
        assert !StackGenerable.isThisSerizal(serizal_5, target);
        assert StackGenerable.isThisSerizal(serizal_6, target);
        assert StackGenerable.isThisSerizal(serizal_7, target);
    }
    
}
