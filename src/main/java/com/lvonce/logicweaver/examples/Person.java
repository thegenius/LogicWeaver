package com.lvonce.logicweaver.examples;

import com.lvonce.logicweaver.LogicDebug;
import com.lvonce.logicweaver.concepts.LogicResult;
import com.lvonce.logicweaver.interfaces.ILogicAction;
import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.annotations.LogicAction;


public class Person {

    @LogicAction(index=1)
    public static ILogicAction<Person, PersonConfig> action1;

    @LogicAction(index=2)
    public static ILogicAction<Person, PersonConfig> action2;

    @LogicAction(index=3)
    public static ILogicAction<Person, PersonConfig> action3;

    @LogicAction(index=4)
    public static ILogicAction<Person, PersonConfig> action3Appendix;

    @LogicAction(index=5)
    public static ILogicAction<Person, PersonConfig> action4;

    @LogicAction(index=6)
    public static ILogicAction<Person, PersonConfig> action4Appendix;


    private void print() {
        System.out.println("this is print");
    }

    static {
        action1 = (Person person, ILogicExecutor e, PersonConfig config)->{
            return LogicResult.TRUE;
        };

        action2 = (Person person, ILogicExecutor e, PersonConfig config)->{
            return LogicResult.FALSE;
        };

        action3 =  (Person person, ILogicExecutor e, PersonConfig config)->{
            String somethingPass = "something pass";
            e.setConfig(new PersonConfig(3, "action3 pass to action3Appendix"));
            return action3Appendix;
        };

        action3Appendix = (Person person, ILogicExecutor e, PersonConfig config) -> {
            return LogicResult.TRUE;
        };

        action4 = (Person person, ILogicExecutor e, PersonConfig config)->{
            return action4Appendix;
        };

        action4Appendix = (Person person, ILogicExecutor e, PersonConfig config)->{
            return LogicResult.FALSE;
        };
    };
}
