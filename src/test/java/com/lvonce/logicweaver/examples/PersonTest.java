package com.lvonce.logicweaver.examples;

import com.lvonce.logicweaver.LogicDebug;
import com.lvonce.logicweaver.executors.LogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class PersonTest {
    @Test
    public void test() {
        Person entity = new Person();
        ILogicNode logic = PersonLogic.logic;
        if (logic != null){
            LogicExecutor executor = new LogicExecutor(entity, logic);
            ArrayList<Integer> commandList = executor.runDebug();
            assertArrayEquals(new Integer[]{1, 2, 4, 5}, commandList.toArray(new Integer[4]));

            commandList = executor.runDebug();
            assertArrayEquals(new Integer[]{6, 6}, commandList.toArray(new Integer[2]));
        }
    }
}
