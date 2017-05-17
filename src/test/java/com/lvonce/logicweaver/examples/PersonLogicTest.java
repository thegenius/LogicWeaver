package com.lvonce.logicweaver.examples;

import com.lvonce.logicweaver.builders.BehaviorBuilder;
import com.lvonce.logicweaver.executors.BehaviorExecutor;
import com.lvonce.logicweaver.interfaces.IBehaviorNode;
import org.junit.Test;
import static com.lvonce.logicweaver.builders.BehaviorBuilder.*;
import com.lvonce.logicweaver.examples.Person;
import com.lvonce.logicweaver.examples.PersonConfig;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

public class PersonLogicTest {

    @Test
    public void testSequence1() {
        IBehaviorNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action1, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 1, 1}, commandList.toArray(new Integer[3]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 1, 1}, commandList.toArray(new Integer[3]));
    }

    @Test
    public void testSequence2() {
        IBehaviorNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{2}, commandList.toArray(new Integer[1]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{2}, commandList.toArray(new Integer[1]));
    }

    @Test
    public void testSequence3() {
        IBehaviorNode logic = defineStart(Person.class).genSequenceTrue(
                genNode(  Person.action1, new PersonConfig(1, "config1")),
                genNode(  Person.action2, new PersonConfig(1, "config1")),
                genNode(  Person.action3, new PersonConfig(1, "config1"))
        );

        Person entity = new Person();
        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 2}, commandList.toArray(new Integer[2]));

        commandList = executor.runDebug();
        assertArrayEquals(new Integer[]{1, 2}, commandList.toArray(new Integer[2]));
    }



//    @Test
//    public void testSequence4() {
//        IBehaviorNode node1 =  genNode(  Person.action1, new PersonConfig(1, "config1"));
//        IBehaviorNode node2 =  genNode(  Person.action3, new PersonConfig(2, "config2"));
//
//        IBehaviorNode[] list1 = {node1, node2};
//        IBehaviorNode root =  genSequence(  list1, IBehaviorNode.RESULT.TRUE.value);
//
//        IBehaviorNode logic = root;
//        Person entity = new Person();
//
//        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
//
//        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(3); }};
//        ArrayList<Integer> commandList = executor.runDebug();
//        assertEquals(expectedList, commandList);
//
//        expectedList = new ArrayList(){{ add(4); }};
//        commandList = executor.runDebug();
//        assertEquals(expectedList, commandList);
//    }
//
//    @Test
//    public void testParallel1() {
//        IBehaviorNode node1 =  genNode(  Person.action1, new PersonConfig(1, "config1"));
//        IBehaviorNode node2 =  genNode(  Person.action1, new PersonConfig(2, "config2"));
//        IBehaviorNode node3 =  genNode(  Person.action2, new PersonConfig(2, "config2"));
//        IBehaviorNode node4 =  genNode(  Person.action2, new PersonConfig(2, "config2"));
//
//        IBehaviorNode[] list1 = {node1, node2, node3, node4};
//        IBehaviorNode root =  genParallel(  list1, 1);
//
//        IBehaviorNode logic = root;
//        Person entity = new Person();
//
//        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
//
//        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(1); add(2); add(2); }};
//        ArrayList<Integer> commandList = executor.runDebug();
//        assertEquals(expectedList, commandList);
//
//        commandList = executor.runDebug();
//        assertEquals(expectedList, commandList);
//    }
//
//    @Test
//    public void testParallel2() {
//        IBehaviorNode node1 =  genNode(  Person.action1, new PersonConfig(1, "config1"));
//        IBehaviorNode node2 =  genNode(  Person.action2, new PersonConfig(2, "config2"));
//        IBehaviorNode node3 =  genNode(  Person.action3, new PersonConfig(2, "config2"));
//
//        IBehaviorNode[] list1 = {node1, node2, node3};
//        IBehaviorNode root =  genParallel(  list1, 0);
//
//        IBehaviorNode logic = root;
//        Person entity = new Person();
//
//        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
//
//        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(2); add(3); }};
//        ArrayList<Integer> commandList = executor.runDebug();
//        assertEquals(expectedList, commandList);
//
//        expectedList = new ArrayList(){{ add(4); }};
//        commandList = executor.runDebug();
//        assertEquals(expectedList, commandList);
//    }
}
