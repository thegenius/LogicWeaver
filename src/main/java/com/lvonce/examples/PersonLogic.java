package com.lvonce.examples;

import com.lvonce.examples.Person;
import com.lvonce.examples.PersonConfig;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorEntity;
import static com.lvonce.interfaces.IBehaviorEntity.Builder.genNode;
import static com.lvonce.interfaces.IBehaviorEntity.Builder.genSequence;
import static com.lvonce.interfaces.IBehaviorEntity.Builder.genParallel;

public final class PersonLogic {
    private static final IBehaviorNode logic;

    static {
        /*
        *                          sequence
        *                sequence            parallel
        *                1  2  3             4  5  6
        *
        */
        IBehaviorNode node1 = genNode(Person.class, Person.action2, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = genNode(Person.class, Person.action3, new PersonConfig(3, "config3"));
        IBehaviorNode node4 = genNode(Person.class, Person.action3Appendix, new PersonConfig(4, "config4"));
        IBehaviorNode node5 = genNode(Person.class, Person.action4, new PersonConfig(5, "config5"));
        IBehaviorNode node6 = genNode(Person.class, Person.action4Appendix, new PersonConfig(6, "config6"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode sequence = genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode[] list2 = new IBehaviorNode[]{ node4, node5, node6};
        IBehaviorNode parallel = genSequence(Person.class, list2, 0);

        IBehaviorNode[] list3 = new IBehaviorNode[] {sequence, parallel};
        IBehaviorNode root = genSequence(Person.class, list3, IBehaviorNode.RESULT.FALSE.value);

        boolean success = root.defineCompleted();
        if (success) {
            logic = root;
        } else {
            logic = null;
        }
    }

    public static final IBehaviorNode getLogic() {
        return logic;
    }
}
























