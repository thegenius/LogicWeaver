package com.lvonce.examples;

import com.lvonce.examples.Person;
import com.lvonce.examples.PersonConfig;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorEntity;

public final class PersonLogic {
    private static final IBehaviorNode logic;

    static {
        /*
        *                          sequence
        *                sequence            parallel
        *                1  2  3             4  5  6
        *
        */
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3, new PersonConfig(3, "config3"));
        IBehaviorNode node4 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3Appendix, new PersonConfig(4, "config4"));
        IBehaviorNode node5 = IBehaviorEntity.Builder.genNode(Person.class, Person.action4, new PersonConfig(5, "config5"));
        IBehaviorNode node6 = IBehaviorEntity.Builder.genNode(Person.class, Person.action4Appendix, new PersonConfig(6, "config6"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode sequence = IBehaviorEntity.Builder.genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode[] list2 = new IBehaviorNode[]{ node4, node5, node6};
        IBehaviorNode parallel = IBehaviorEntity.Builder.genSequence(Person.class, list2, 0);

        IBehaviorNode[] list3 = new IBehaviorNode[] {sequence, parallel};
        IBehaviorNode root = IBehaviorEntity.Builder.genSequence(Person.class, list3, IBehaviorNode.RESULT.FALSE.value);

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
























