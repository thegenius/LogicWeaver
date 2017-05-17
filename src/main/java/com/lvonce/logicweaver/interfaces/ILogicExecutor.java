package com.lvonce.logicweaver.interfaces;

import java.util.HashMap;
import com.lvonce.logicweaver.concepts.LogicResult;

public interface ILogicExecutor {
    enum STATUS {IDLE, WORKING, FINISHED};
    enum RESULT {
        NOP;
        private static final HashMap<ILogicResult, ILogicNode.RESULT> resultMap = new HashMap<ILogicResult, ILogicNode.RESULT>() {
            {
                put(null, ILogicNode.RESULT.NULL);
                put(LogicResult.NULL, ILogicNode.RESULT.NULL);
                put(LogicResult.TRUE, ILogicNode.RESULT.TRUE);
                put(LogicResult.FALSE, ILogicNode.RESULT.FALSE);
                put(LogicResult.DISCARD, ILogicNode.RESULT.DISCARD);
            }
        };
        public static ILogicNode.RESULT map(LogicResult result) {
           return resultMap.getOrDefault(result, ILogicNode.RESULT.NULL);
        }
    }

    void run();
    void clear();

    STATUS getStatus();
    Object getConfig();
    void setConfig(Object config);
}
