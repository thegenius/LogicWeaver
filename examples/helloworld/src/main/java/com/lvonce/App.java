package com.lvonce;

import com.lvonce.logicweaver.BehaviorDebug;
import com.lvonce.logicweaver.concepts.BehaviorResult;
import com.lvonce.logicweaver.interfaces.IBehaviorNode;
import com.lvonce.logicweaver.interfaces.IBehaviorAction;
import com.lvonce.logicweaver.interfaces.IBehaviorExecutor;
import com.lvonce.logicweaver.executors.BehaviorExecutor;
import com.lvonce.logicweaver.annotations.BehaviorActionNode;
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

    	@BehaviorActionNode(index=1)
    	public static IBehaviorAction<Person, PersonConfig> action1;

    	@BehaviorActionNode(index=2)
    	public static IBehaviorAction<Person, PersonConfig> action2;

    	static {
        	action1 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
        	    BehaviorDebug.debug("action1(%s, %s)", config.x, config.y);
            	return BehaviorResult.TRUE;
        	};

        	action2 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            	BehaviorDebug.debug("action2(%s, %s)", config.x, config.y);
            	return BehaviorResult.FALSE;
        	};
		}
	}
	
	static final IBehaviorNode logic = defineStart(Person.class)
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
