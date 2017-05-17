package com.lvonce.logicweaver;


import com.lvonce.logicweaver.builders.LogicWeaver;
import com.lvonce.logicweaver.examples.Person;
import com.lvonce.logicweaver.examples.PersonConfig;
import com.lvonce.logicweaver.examples.PersonLogic;

import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.executors.LogicExecutor;

public class Main {

    public static void main(String[] args) {
        Person entity = new Person();
        try {
            ILogicNode logic = PersonLogic.logic;
            if (logic != null){
                LogicExecutor executor = new LogicExecutor(entity, logic);
                executor.run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
