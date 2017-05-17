package com.lvonce.logicweaver.composites;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by WangWei on 2017/3/24.
 */
public class LogicRandomChooserTest {
    @Test
    public void unchosenTest() {
        float[] weights = {1.0f, 1.0f};
        LogicRandomChooser chooser = new LogicRandomChooser(weights, 1);
        assertEquals(-1, chooser.unchosen());
    }

    @Test
    public void clearTest() {
        float[] weights = {1.0f, 1.0f, 1.0f};
        LogicRandomChooser chooser = new LogicRandomChooser(weights, 2);
        assertEquals(-1, chooser.current());
        assertEquals(0, chooser.count());


        chooser.next();
        assertEquals(true, chooser.current() >= 0);
        assertEquals(true, chooser.current() < weights.length);
        assertEquals(1, chooser.count());


        chooser.next();
        assertEquals(true, chooser.current() >= 0);
        assertEquals(true, chooser.current() < weights.length);
        assertEquals(2, chooser.count());


        chooser.next();
        assertEquals(weights.length, chooser.current());
        assertEquals(3, chooser.count());


        chooser.clear();
        assertEquals(-1, chooser.current());
        assertEquals(0, chooser.count());
    }

    @Test
    public void nextTest() {
    }

}
