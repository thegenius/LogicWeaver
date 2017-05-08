package com.lvonce;

import com.lvonce.BehaviorDebug;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorAction;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorFunction;
import com.lvonce.annotations.BehaviorActionNode;

public class BehaviorEntityClass  implements IBehaviorEntity {
    public class BehaviorEntityClassConfig {
        public int x = 23;
        public String y = "hello config";
        public void build(Object ...args) {
            x = ((int)args[0]);
            y = ((String)args[1]);
        }
    }
 
    @BehaviorActionNode(index=1)
    public static IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> action1;

    @BehaviorActionNode(index=2)
    public static IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> action2;

    @BehaviorActionNode(index=3)
    public static IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> action3;

    @BehaviorActionNode(index=4)
    public static IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> action3Appendix;

    @BehaviorActionNode(index=5)
    public static IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> action4;

    @BehaviorActionNode(index=6)
    public static IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> action4Appendix;

    static {
        action1 = (BehaviorEntityClass person, IBehaviorExecutor e, BehaviorEntityClassConfig config)->{
            BehaviorDebug.debug("BehaviorEntityClass action1(%s)", config);
            BehaviorDebug.debug("action1 config:%s, %s", config.x, config.y);
            return BehaviorResult.TRUE;
        };

        action2 = (BehaviorEntityClass person, IBehaviorExecutor e, BehaviorEntityClassConfig config)->{
            BehaviorDebug.debug("BehaviorEntityClass action2(%s)", config);
            return BehaviorResult.FALSE;
        };

        action3 =  (BehaviorEntityClass person, IBehaviorExecutor e, BehaviorEntityClassConfig config)->{
            BehaviorDebug.debug("BehaviorEntityClass action3(%s)", config);
            String somethingPass = "something pass";
            int x = 0;
            IBehaviorAction<BehaviorEntityClass, BehaviorEntityClassConfig> result = (BehaviorEntityClass person2, IBehaviorExecutor e2, BehaviorEntityClassConfig config2) -> {
                BehaviorDebug.debug("result action3() - appendix(%s)", config2);
                BehaviorDebug.debug("pass:%s", somethingPass);
                return BehaviorResult.TRUE;
            };
            return result;
        };

        action3Appendix = (BehaviorEntityClass person, IBehaviorExecutor e, BehaviorEntityClassConfig config) -> {
            BehaviorDebug.debug("BehaviorEntityClass action3() - appendix(%s)", config);
            return BehaviorResult.TRUE;
        };

        action4 = (BehaviorEntityClass person, IBehaviorExecutor e, BehaviorEntityClassConfig config)->{
            BehaviorDebug.debug("BehaviorEntityClass action4(%s)", config);
            return action4Appendix;
        };

        action4Appendix = (BehaviorEntityClass person, IBehaviorExecutor e, BehaviorEntityClassConfig config)->{
            BehaviorDebug.debug("BehaviorEntityClass action4() - appendix(%s)", config);
            return BehaviorResult.FALSE;
        };

    };
}
