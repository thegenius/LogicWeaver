package com.lvonce;

import com.lvonce.BehaviorDebug;
import com.lvonce.annotations.BehaviorActionNode;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorFunction;

public class BehaviorEntityClass  implements IBehaviorEntity {
    @BehaviorActionNode(index=1)
    public static IBehaviorFunction action1;

    @BehaviorActionNode(index=2)
    public static IBehaviorFunction action2;

    @BehaviorActionNode(index=3)
    public static IBehaviorFunction action3;

    @BehaviorActionNode(index=4)
    public static IBehaviorFunction action3Appendix;

    @BehaviorActionNode(index=5)
    public static IBehaviorFunction action4;

    @BehaviorActionNode(index=6)
    public static IBehaviorFunction action4Appendix;


    static {
        action1 = (IBehaviorEntity entity, Object config)->{
            BehaviorDebug.debug("Person action1()");
            return BehaviorResult.TRUE;
        };

        action2 = (IBehaviorEntity entity, Object config)->{
            BehaviorDebug.debug("Person action2()");
            return BehaviorResult.FALSE;
        };

        action3 =  (IBehaviorEntity entity, Object config)->{
            BehaviorDebug.debug("Person action3()");
            return action3Appendix;
        };

        action3Appendix = (IBehaviorEntity entity, Object config) -> {
            BehaviorDebug.debug("Person action3() - appendix()");
            return BehaviorResult.TRUE;
        };

        action4 = (IBehaviorEntity entity, Object config)->{
            BehaviorDebug.debug("Person action4()");
            return action4Appendix;
        };

        action4Appendix = (IBehaviorEntity entity, Object config)->{
            BehaviorDebug.debug("Person action4() - appendix()");
            return BehaviorResult.FALSE;
        };

    };

}
