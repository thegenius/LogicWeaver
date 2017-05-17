package com.lvonce.logicweaver.examples;

import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.builders.LogicWeaver;

/*****************************************************
*                          sequence
*                sequence            parallel
*                1  2  3             4  5  6
*****************************************************/
public final class PersonLogic {
    public static final ILogicNode logic = LogicWeaver.defineStart(Person.class)
        .genSequenceFalse(
                LogicWeaver.genSequenceTrue(
                        LogicWeaver.genNode(Person.action1, new PersonConfig(1, "config1")),
                        LogicWeaver.genNode(Person.action2, new PersonConfig(1, "config1")),
                        LogicWeaver.genNode(Person.action3, new PersonConfig(1, "config1"))
                ),
                LogicWeaver.genParallelAnd(
                        LogicWeaver.genNode(Person.action3Appendix, new PersonConfig(1, "config1")),
                        LogicWeaver.genNode(Person.action4, new PersonConfig(1, "config1")),
                        LogicWeaver.genNode(Person.action4Appendix, new PersonConfig(1, "config1"))
                )
        ).defineFinish();
}
























