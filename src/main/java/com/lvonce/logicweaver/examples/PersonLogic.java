package com.lvonce.logicweaver.examples;

import com.lvonce.logicweaver.interfaces.IBehaviorNode;
import com.lvonce.logicweaver.builders.BehaviorBuilder;

/*****************************************************
*                          sequence
*                sequence            parallel
*                1  2  3             4  5  6
*****************************************************/
public final class PersonLogic {
    public static final IBehaviorNode logic = BehaviorBuilder.defineStart(Person.class)
        .genSequenceFalse(
                BehaviorBuilder.genSequenceTrue(
                        BehaviorBuilder.genNode(Person.action1, new PersonConfig(1, "config1")),
                        BehaviorBuilder.genNode(Person.action2, new PersonConfig(1, "config1")),
                        BehaviorBuilder.genNode(Person.action3, new PersonConfig(1, "config1"))
                ),
                BehaviorBuilder.genParallelAnd(
                        BehaviorBuilder.genNode(Person.action3Appendix, new PersonConfig(1, "config1")),
                        BehaviorBuilder.genNode(Person.action4, new PersonConfig(1, "config1")),
                        BehaviorBuilder.genNode(Person.action4Appendix, new PersonConfig(1, "config1"))
                )
        ).defineFinish();
}
























