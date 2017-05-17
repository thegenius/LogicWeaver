# LogicWeaver
[![travis-ci](https://travis-ci.org/thegenius/LogicWeaver.svg?branch=master)](https://travis-ci.org/thegenius/LogicWeaver)
[![codecov](https://codecov.io/gh/thegenius/LogicWeaver/branch/master/graph/badge.svg)](https://codecov.io/gh/thegenius/LogicWeaver)
[![maven-central](https://img.shields.io/badge/maven-1.0.0-green.svg)](http://search.maven.org/#search%7Cga%7C1%7Clogicweaver)
[![apache-license](https://img.shields.io/badge/license-Apache--2.0-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)

## Inspiration
INSPIRED BY   BEHAVIOR  TREE.  
USED     AS   BEHAVIOR  TREE.  
MORE     THAN BEHAVIOR  TREE.  
AND      MAKE EVERYBODY HAPPY.  

  
The most tedious part of software development must be the implementation of bussiness logic. Engineers used to waste a lot of time on those if-else logic. There must be a new way to accomplish those task. This framework aims at providing a visual and editable way to write those logic code. I call it "logic weaver".

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
#### config -> action -> logic -> executor

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
  
You can run this simple example under examples directory:
```bash
cd examples/helloworld
mvn packge
java -jar target/helloworld-1.0-SNAPSHOT-jar-with-dependencies.jar
```


## Design Concepts
![containers](https://raw.githubusercontent.com/thegenius/LogicWeaver/master/docs/containers.png)

## Node Status
|Status|Description|
|------|-----------|
|Init   |with no result|
|Waiting|result is a task, run the task will get the actual result|
|Null   |result is meaningless, just ignore it|
|True   |resutl is success|
|False  |result is fail|
|Discard|result is fatal error, discard and restart|  

![status](https://raw.githubusercontent.com/thegenius/LogicWeaver/master/docs/status.jpg)


## Basic API
