package com.lvonce.logicweaver.interfaces;

import java.util.HashMap;
import com.lvonce.logicweaver.concepts.BehaviorResult;

public interface IBehaviorExecutor {
    enum STATUS {IDLE, WORKING, FINISHED};
    enum RESULT {
        NOP;
        private static final HashMap<IBehaviorResult, IBehaviorNode.RESULT> resultMap = new HashMap<IBehaviorResult, IBehaviorNode.RESULT>() {
            {
                put(null, IBehaviorNode.RESULT.NULL);
                put(BehaviorResult.NULL, IBehaviorNode.RESULT.NULL);
                put(BehaviorResult.TRUE, IBehaviorNode.RESULT.TRUE);
                put(BehaviorResult.FALSE, IBehaviorNode.RESULT.FALSE);
                put(BehaviorResult.DISCARD, IBehaviorNode.RESULT.DISCARD);
            }
        };
        public static IBehaviorNode.RESULT map(BehaviorResult result) {
           return resultMap.getOrDefault(result, IBehaviorNode.RESULT.NULL);
        }
    }

    void run();
    void clear();

    STATUS getStatus();
    Object getConfig();
    void setConfig(Object config);
}
