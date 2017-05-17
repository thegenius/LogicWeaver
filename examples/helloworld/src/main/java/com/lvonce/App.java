package com.lvonce;

import com.lvonce.logicweaver.LogicDebug;
import com.lvonce.logicweaver.concepts.LogicResult;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.interfaces.ILogicAction;
import com.lvonce.logicweaver.interfaces.IBehaviorExecutor;
import com.lvonce.logicweaver.executors.BehaviorExecutor;
import com.lvonce.logicweaver.annotations.LogicAction;
import static com.lvonce.logicweaver.builders.BehaviorBuilder.*;

public class App {

	static class PersonConfig {
		public final int x;
    	public final String y;
    	public PersonConfig(int x, String y) {
        	this.x = x;
        	this.y = y;
		}
    }

	static class Person {

    	@LogicAction(index=1)
    	public static ILogicAction<Person, PersonConfig> action1;

    	@LogicAction(index=2)
    	public static ILogicAction<Person, PersonConfig> action2;

    	static {
        	action1 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
        	    LogicDebug.debug("action1(%s, %s)", config.x, config.y);
            	return LogicResult.TRUE;
        	};

        	action2 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            	LogicDebug.debug("action2(%s, %s)", config.x, config.y);
            	return LogicResult.FALSE;
        	};
		}
	}
	
	static final ILogicNode logic = defineStart(Person.class)
        .genSequenceFalse(
                genSequenceTrue(
                        genNode(Person.action1, new PersonConfig(1, "config1")),
                        genNode(Person.action2, new PersonConfig(1, "config1")),
                        genNode(Person.action1, new PersonConfig(1, "config1"))
                ),
                genParallelAnd(
                        genNode(Person.action1, new PersonConfig(1, "config1")),
                        genNode(Person.action2, new PersonConfig(1, "config1")),
                        genNode(Person.action1, new PersonConfig(1, "config1"))
                )
        ).defineFinish();

    public static void main( String[] args ) {
			Person person = new Person();
            BehaviorExecutor executor = new BehaviorExecutor(person, logic);
            executor.run();
    }
}
