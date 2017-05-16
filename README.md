# LogicWeaver
[![travis-ci](https://travis-ci.org/thegenius/LogicWeaver.svg?branch=master)](https://travis-ci.org/thegenius/LogicWeaver)
[![codecov](https://codecov.io/gh/thegenius/LogicWeaver/branch/master/graph/badge.svg)](https://codecov.io/gh/thegenius/LogicWeaver)
[![maven-central](https://img.shields.io/badge/maven-1.0.0-green.svg)](http://search.maven.org/#search%7Cga%7C1%7Clogicweaver)

## Setup with maven
```xml
<dependencies>
	<dependency>
		<groupId>com.lvonce</groupId>
		<artifactId>logicweaver</artifactId>
		<version>1.0.0</version>
	</dependency>
</dependencies>
```

## Examples
### Step 1. create action config 
### Step 2. create entity action
### Step 3. create entity logic
### Step 4. create executor and run
```java
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
```

## Basic API
## Basic Concepts
|Concepts|Description|
|---------|-----------|
|Container| A list that contains many child nodes.|
|Sequnce  | A container which will run child nodes in sequence. It continues to run next child node when encounters continue result.|
|Parallel | A container which will run all child nodes no matter what result got from child node.|

## Basic Status
|Status|Description|
|------|-----------|
|Init   |-|
|Null   |-|
|True   |-|
|False  |-|
|Discard|-|  


