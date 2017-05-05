package com.lvonce;

import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorAction;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorFunction;
import com.lvonce.annotations.BehaviorActionNode;


public class Person implements IBehaviorEntity {
    public class PersonConfig {
        public int x = 23;
        public String y = "hello config";
        public void build(Object ...args) {
            x = ((int)args[0]);
            y = ((String)args[1]);
        }
    }
    @BehaviorActionNode(index=1)
    public static IBehaviorAction<Person, PersonConfig> action1;

    @BehaviorActionNode(index=2)
    public static IBehaviorAction<Person, PersonConfig> action2;

    @BehaviorActionNode(index=3)
    public static IBehaviorAction<Person, PersonConfig> action3;

    @BehaviorActionNode(index=4)
    public static IBehaviorAction<Person, PersonConfig> action3Appendix;

    @BehaviorActionNode(index=5)
    public static IBehaviorAction<Person, PersonConfig> action4;

    @BehaviorActionNode(index=6)
    public static IBehaviorAction<Person, PersonConfig> action4Appendix;


    private void print() {
        System.out.println("this is print");
    }

    static {
        action1 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("Person action1(%s)", config);
            person.print();
            BehaviorDebug.debug("action1 config:%s, %s", config.x, config.y);
            return BehaviorResult.TRUE;
        };

        action2 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("Person action2(%s)", config);
            return BehaviorResult.FALSE;
        };

        action3 =  (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("Person action3(%s)", config);
            String somethingPass = "something pass";
            int x = 0;
            IBehaviorAction<Person, PersonConfig> result = (Person person2, IBehaviorExecutor e2, PersonConfig config2) -> {
                BehaviorDebug.debug("result action3() - appendix(%s)", config2);
                BehaviorDebug.debug("pass:%s", somethingPass);
                return BehaviorResult.TRUE;
            };
            return result;
        };

        action3Appendix = (Person person, IBehaviorExecutor e, PersonConfig config) -> {
            BehaviorDebug.debug("Person action3() - appendix(%s)", config);
            return BehaviorResult.TRUE;
        };

        action4 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("Person action4(%s)", config);
            return action4Appendix;
        };

        action4Appendix = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("Person action4() - appendix(%s)", config);
            return BehaviorResult.FALSE;
        };

    };
}
