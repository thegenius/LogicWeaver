package com.lvonce.logicweaver.examples;

import com.lvonce.logicweaver.LogicDebug;
import com.lvonce.logicweaver.builders.LogicWeaver;
import com.lvonce.logicweaver.executors.LogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import org.junit.Test;
import static com.lvonce.logicweaver.builders.LogicWeaver.*;
import com.lvonce.logicweaver.examples.Person;
import com.lvonce.logicweaver.examples.PersonConfig;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

public class PersonLogicTest {

    @Test
    public void testSequence1() {
        ILogicNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action1, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        LogicExecutor executor = new LogicExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 1, 1}, commandList.toArray(new Integer[3]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 1, 1}, commandList.toArray(new Integer[3]));
    }

    @Test
    public void testSequence2() {
        ILogicNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        LogicExecutor executor = new LogicExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{2}, commandList.toArray(new Integer[1]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{2}, commandList.toArray(new Integer[1]));
    }

    @Test
    public void testSequence3() {
        ILogicNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action3, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        LogicExecutor executor = new LogicExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 2}, commandList.toArray(new Integer[2]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 2}, commandList.toArray(new Integer[2]));
    }

    @Test
    public void testSequence4() {
        ILogicNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action3, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        LogicExecutor executor = new LogicExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 3}, commandList.toArray(new Integer[2]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{4}, commandList.toArray(new Integer[1]));
    }

    @Test
    public void testParallel1() {
        ILogicNode logic = defineStart(Person.class).genParallelAnd(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        LogicExecutor executor = new LogicExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1,1,2,2}, commandList.toArray(new Integer[4]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1,1,2,2}, commandList.toArray(new Integer[4]));
    }

    @Test
    public void testParallel2() {
        ILogicNode logic = defineStart(Person.class).genParallelOr(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action3, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        LogicExecutor executor = new LogicExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1,2,3}, commandList.toArray(new Integer[3]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{4}, commandList.toArray(new Integer[1]));
    }
}
