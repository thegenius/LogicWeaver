package com.lvonce.examples;

import com.lvonce.interfaces.IBehaviorNode;
import static com.lvonce.builders.BehaviorBuilder.*;
/*****************************************************
*                          sequence
*                sequence            parallel
*                1  2  3             4  5  6
*****************************************************/
public final class PersonLogic {
    public static final IBehaviorNode logic = defineStart(Person.class)
        .genSequenceFalse(
                genSequenceTrue(
                        genNode(Person.action1, new PersonConfig(1, "config1")),
                        genNode(Person.action2, new PersonConfig(1, "config1")),
                        genNode(Person.action3, new PersonConfig(1, "config1"))
                ),
                genParallelAnd(
                        genNode(Person.action3Appendix, new PersonConfig(1, "config1")),
                        genNode(Person.action4, new PersonConfig(1, "config1")),
                        genNode(Person.action4Appendix, new PersonConfig(1, "config1"))
                )
        ).defineFinish();
}
























