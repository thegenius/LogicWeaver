package com.lvonce.composites;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by WangWei on 2017/3/24.
 */
public class BehaviorSerialChooserTest {
    @Test
    public void unchosenTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(10);
    }

    @Test
    public void clearTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(10);
        chooser.next();
        chooser.next();
        chooser.clear();
    }

    @Test
    public void nextTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(5);
//        assertEquals(-1, chooser.current());
//        assertEquals(0, chooser.next());
//        assertEquals(1, chooser.next());
//        assertEquals(2, chooser.next());
//        assertEquals(3, chooser.next());
//        assertEquals(4, chooser.next());
//        assertEquals(5, chooser.next());
    }

    @Test
    public void countTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(3);
//        assertEquals(-1, chooser.current());
//        assertEquals(0, chooser.count());
//        assertEquals(0, chooser.next());
//        assertEquals(1, chooser.count());
//        assertEquals(1, chooser.next());
//        assertEquals(2, chooser.count());
//        assertEquals(2, chooser.next());
//        assertEquals(3, chooser.count());
//        assertEquals(3, chooser.next());
//        assertEquals(4, chooser.count());
//        assertEquals(3, chooser.next());
//        assertEquals(4, chooser.count());
//        assertEquals(3, chooser.next());
//        assertEquals(4, chooser.count());
    }

    @Test
    public void limitTest() {
        BehaviorSerialChooser chooser1 = new BehaviorSerialChooser(3);
        assertEquals(3, chooser1.limit());
        BehaviorSerialChooser chooser2 = new BehaviorSerialChooser(4);
        assertEquals(4, chooser2.limit());
    }

    @Test
    public void currentTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(2);
//        assertEquals(-1, chooser.current());
//        assertEquals(-1, chooser.current());
//        assertEquals(0, chooser.next());
//        assertEquals(0, chooser.current());
//        assertEquals(1, chooser.next());
//        assertEquals(1, chooser.current());
//        assertEquals(2, chooser.next());
//        assertEquals(2, chooser.current());
//        assertEquals(2, chooser.next());
//        assertEquals(2, chooser.current());
    }

    public void isUnchosenTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(2);

        assertEquals(0, chooser.next());

        assertEquals(1, chooser.next());

        assertEquals(2, chooser.next());

        assertEquals(2, chooser.next());

    }

    public void isFinishedTest() {
        BehaviorSerialChooser chooser = new BehaviorSerialChooser(5);
        assertEquals(false, chooser.finished());
        assertEquals(0, chooser.next());
        assertEquals(false, chooser.finished());
        assertEquals(1, chooser.next());
        assertEquals(false, chooser.finished());
        assertEquals(2, chooser.next());
        assertEquals(false, chooser.finished());
        assertEquals(3, chooser.next());
        assertEquals(false, chooser.finished());
        assertEquals(4, chooser.next());
        assertEquals(false, chooser.finished());
        assertEquals(5, chooser.next());
        assertEquals(true, chooser.finished());
        assertEquals(5, chooser.next());
        assertEquals(true, chooser.finished());
    }

}
