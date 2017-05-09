package examples;

import com.lvonce.BehaviorDebug;
import com.lvonce.examples.PersonConfig;
import org.junit.Test;
import com.lvonce.examples.Person;
import com.lvonce.examples.PersonLogic;
import com.lvonce.executors.BehaviorExecutor;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorNode;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class PersonLogicTest {
    @Test
    public void testSequence1() {
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(3, "config3"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode root = IBehaviorEntity.Builder.genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
        ArrayList<Integer> expectedList = new ArrayList<Integer>(){{
            add(1); add(1); add(1);
        }};

        ArrayList<Integer> commandList = executor.runDebug();
        assertEquals(expectedList, commandList);

        commandList = executor.runDebug();
        assertEquals(expectedList, commandList);
    }

    @Test
    public void testSequence2() {
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(3, "config3"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode root = IBehaviorEntity.Builder.genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
        ArrayList<Integer> expectedList = new ArrayList<Integer>(){{
            add(2);
        }};

        ArrayList<Integer> commandList = executor.runDebug();
        assertEquals(expectedList, commandList);

        commandList = executor.runDebug();
        assertEquals(expectedList, commandList);
    }

    @Test
    public void testSequence3() {
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3, new PersonConfig(3, "config3"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode root = IBehaviorEntity.Builder.genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
        ArrayList<Integer> expectedList = new ArrayList<Integer>(){{
            add(1); add(2);
        }};

        ArrayList<Integer> commandList = executor.runDebug();
        assertEquals(expectedList, commandList);

        commandList = executor.runDebug();
        assertEquals(expectedList, commandList);
    }

    @Test
    public void testSequence4() {
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3, new PersonConfig(2, "config2"));

        IBehaviorNode[] list1 = {node1, node2};
        IBehaviorNode root = IBehaviorEntity.Builder.genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(3); }};
        ArrayList<Integer> commandList = executor.runDebug();
        assertEquals(expectedList, commandList);

        expectedList = new ArrayList(){{ add(4); }};
        commandList = executor.runDebug();
        assertEquals(expectedList, commandList);
    }

    @Test
    public void testParallel1() {
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node4 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));

        IBehaviorNode[] list1 = {node1, node2, node3, node4};
        IBehaviorNode root = IBehaviorEntity.Builder.genParallel(Person.class, list1, 1);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(1); add(2); add(2); }};
        ArrayList<Integer> commandList = executor.runDebug();
        assertEquals(expectedList, commandList);

        commandList = executor.runDebug();
        assertEquals(expectedList, commandList);
    }

    @Test
    public void testParallel2() {
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3, new PersonConfig(2, "config2"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode root = IBehaviorEntity.Builder.genParallel(Person.class, list1, 0);

        IBehaviorNode logic = root;
        Person entity = new Person();

        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);

        ArrayList<Integer> expectedList = new ArrayList(){{ add(1); add(2); add(3); }};
        ArrayList<Integer> commandList = executor.runDebug();
        assertEquals(expectedList, commandList);

        expectedList = new ArrayList(){{ add(4); }};
        commandList = executor.runDebug();
        assertEquals(expectedList, commandList);
    }
}
