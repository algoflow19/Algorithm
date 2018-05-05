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

/**
 *
 * @author KK
 */
public class LinkListTest {
    
    public LinkListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Before class is running!");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After class is running!");
    }
    
    @Before
    public void setUp() {
        System.out.println("Before is running!");
    }
    
    @After
    public void tearDown() {
        System.out.println("After is running!");
    }
    
    @Test
    public void testInitClass(){
        Queue<Integer> source=new Queue<>();
        source.enqueue(1);
        source.enqueue(2);
        source.enqueue(3);
        Queue<Integer> target=new Queue<>(source);
        assertEquals(source.size(), target.size());
        for(int i=1;i<=3;i++)
            assertEquals((int)i, (int)target.dequeue());
    }

    @Test
    public void testGetKey() {
    }

    @Test
    public void testInsertBeforeHead() {
    }

    @Test
    public void testDeleteKey() {
    }
    
}
