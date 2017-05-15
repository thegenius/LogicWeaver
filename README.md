# LogicWeaver
[![](https://travis-ci.org/thegenius/LogicWeaver.svg?branch=master)](https://travis-ci.org/thegenius/LogicWeaver)
[![codecov](https://codecov.io/gh/thegenius/LogicWeaver/branch/master/graph/badge.svg)](https://codecov.io/gh/thegenius/LogicWeaver)


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


## Basic API

## Examples
Create a action config class
```java
/*****************************************************************************************
We strongly recommend that you set all the config attributes to final, and never change it.
If you wanna something that will change, store it in entity attributes.
 *****************************************************************************************/
public final class PersonConfig {
    public final int x;
    public final String y;

    public PersonConfig(int x, String y) {
        this.x = x;
        this.y = y;
    }
}
```

Create a entity with some actions
```java
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorAction;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.annotations.BehaviorActionNode;

public class Person {

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

    static {
        action1 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            System.out.println("this is action1");
            return BehaviorResult.TRUE;
        };

        action2 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            System.out.println("this is action2");
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
```

create logic definition class
```java
import com.lvonce.interfaces.IBehaviorNode;
import static com.lvonce.builders.BehaviorBuilder.*;
/*****************************************************
*                          sequence
*                sequence            parallel
*                1  2  3             4  5  6
*****************************************************/
public final class PersonLogic {
    public static final IBehaviorNode logic = defineStart(Person.class)
        .genSequenceFalse(
                genSequenceTrue(
                        genNode(Person.action1, new PersonConfig(1, "config1")),
                        genNode(Person.action2, new PersonConfig(1, "config1")),
                        genNode(Person.action3, new PersonConfig(1, "config1"))
                ),
                genParallelAnd(
                        genNode(Person.action3Appendix, new PersonConfig(1, "config1")),
                        genNode(Person.action4, new PersonConfig(1, "config1")),
                        genNode(Person.action4Appendix, new PersonConfig(1, "config1"))
                )
        ).defineFinish();
}
```

create an executor to run the logic definition
```java

public class Main {
    public static void main(String[] args) {
        Person entity = new Person();
        BehaviorExecutor executor = new BehaviorExecutor(entity, PersonLogic.logic);
        executor.run();
    }
}
```
