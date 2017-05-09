package com.lvonce.examples;

import com.lvonce.BehaviorDebug;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorAction;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.annotations.BehaviorActionNode;


public class Person implements IBehaviorEntity {

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
            BehaviorDebug.debug("action1(%s, %s)", config.x, config.y);
            return BehaviorResult.TRUE;
        };

        action2 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("action2(%s, %s)", config.x, config.y);
            return BehaviorResult.FALSE;
        };

        action3 =  (Person person, IBehaviorExecutor e, PersonConfig config)->{
            BehaviorDebug.debug("Person action3(%s, %s)", config.x, config.y);
            String somethingPass = "something pass";
            e.setConfig(new PersonConfig(3, "action3 pass to action3Appendix"));
            return action3Appendix;
        };

        action3Appendix = (Person person, IBehaviorExecutor e, PersonConfig config) -> {
            BehaviorDebug.debug("Person action3() - appendix(%s, %s)", config.x, config.y);
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
