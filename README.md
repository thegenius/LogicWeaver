# LogicWeaver
[![](https://travis-ci.org/thegenius/LogicWeaver.svg?branch=master)](https://travis-ci.org/thegenius/LogicWeaver)

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
![](http://github.com/thegenius/LogicWeaver/master/doc/status.svg)

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
public final class PersonLogic {
    private static final IBehaviorNode logic;

    static {
        /*
        *                          sequence
        *                sequence            parallel
        *                1  2  3             4  5  6
        *
        */
        IBehaviorNode node1 = IBehaviorEntity.Builder.genNode(Person.class, Person.action1, new PersonConfig(1, "config1"));
        IBehaviorNode node2 = IBehaviorEntity.Builder.genNode(Person.class, Person.action2, new PersonConfig(2, "config2"));
        IBehaviorNode node3 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3, new PersonConfig(3, "config3"));
        IBehaviorNode node4 = IBehaviorEntity.Builder.genNode(Person.class, Person.action3Appendix, new PersonConfig(4, "config4"));
        IBehaviorNode node5 = IBehaviorEntity.Builder.genNode(Person.class, Person.action4, new PersonConfig(5, "config5"));
        IBehaviorNode node6 = IBehaviorEntity.Builder.genNode(Person.class, Person.action4Appendix, new PersonConfig(6, "config6"));

        IBehaviorNode[] list1 = {node1, node2, node3};
        IBehaviorNode sequence = IBehaviorEntity.Builder.genSequence(Person.class, list1, IBehaviorNode.RESULT.TRUE.value);

        IBehaviorNode[] list2 = new IBehaviorNode[]{ node4, node5, node6};
        IBehaviorNode parallel = IBehaviorEntity.Builder.genSequence(Person.class, list2, 0);

        IBehaviorNode[] list3 = new IBehaviorNode[] {sequence, parallel};
        IBehaviorNode root = IBehaviorEntity.Builder.genSequence(Person.class, list3, IBehaviorNode.RESULT.FALSE.value);

        boolean success = root.defineCompleted();
        logic = root;
    }

    public static final IBehaviorNode getLogic() {
        return logic;
    }
}
```

create an executor to run the logic definition
```java

public class Main {
    public static void main(String[] args) {
        IBehaviorEntity entity = new Person();
        IBehaviorNode logic = PersonLogic.getLogic();
        BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
        executor.run();
    }
}
```
