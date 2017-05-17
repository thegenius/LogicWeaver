package com.lvonce.logicweaver;

import com.lvonce.logicweaver.concepts.LogicResult;
import com.lvonce.logicweaver.interfaces.ILogicAction;
import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.annotations.LogicAction;

public class LogicEntityClass {
    public class BehaviorEntityClassConfig {
        public int x = 23;
        public String y = "hello config";
        public void build(Object ...args) {
            x = ((int)args[0]);
            y = ((String)args[1]);
        }
    }
 
    @LogicAction(index=1)
    public static ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> action1;

    @LogicAction(index=2)
    public static ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> action2;

    @LogicAction(index=3)
    public static ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> action3;

    @LogicAction(index=4)
    public static ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> action3Appendix;

    @LogicAction(index=5)
    public static ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> action4;

    @LogicAction(index=6)
    public static ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> action4Appendix;

    static {
        action1 = (LogicEntityClass person, ILogicExecutor e, BehaviorEntityClassConfig config)->{
            LogicDebug.debug("BehaviorEntityClass action1(%s)", config);
            LogicDebug.debug("action1 config:%s, %s", config.x, config.y);
            return LogicResult.TRUE;
        };

        action2 = (LogicEntityClass person, ILogicExecutor e, BehaviorEntityClassConfig config)->{
            LogicDebug.debug("BehaviorEntityClass action2(%s)", config);
            return LogicResult.FALSE;
        };

        action3 =  (LogicEntityClass person, ILogicExecutor e, BehaviorEntityClassConfig config)->{
            LogicDebug.debug("BehaviorEntityClass action3(%s)", config);
            String somethingPass = "something pass";
            int x = 0;
            ILogicAction<LogicEntityClass, BehaviorEntityClassConfig> result = (LogicEntityClass person2, ILogicExecutor e2, BehaviorEntityClassConfig config2) -> {
                LogicDebug.debug("result action3() - appendix(%s)", config2);
                LogicDebug.debug("pass:%s", somethingPass);
                return LogicResult.TRUE;
            };
            return result;
        };

        action3Appendix = (LogicEntityClass person, ILogicExecutor e, BehaviorEntityClassConfig config) -> {
            LogicDebug.debug("BehaviorEntityClass action3() - appendix(%s)", config);
            return LogicResult.TRUE;
        };

        action4 = (LogicEntityClass person, ILogicExecutor e, BehaviorEntityClassConfig config)->{
            LogicDebug.debug("BehaviorEntityClass action4(%s)", config);
            return action4Appendix;
        };

        action4Appendix = (LogicEntityClass person, ILogicExecutor e, BehaviorEntityClassConfig config)->{
            LogicDebug.debug("BehaviorEntityClass action4() - appendix(%s)", config);
            return LogicResult.FALSE;
        };

    };
}
