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
![](http://github.com/thegenius/LogicWeaver/blob/master/doc/status.jpg)

## Basic API

## Examples
Create a entity with some actions
```java
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

    static {
        action1 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            System.out.println("this is action1");
            return BehaviorResult.TRUE;
        };

        action2 = (Person person, IBehaviorExecutor e, PersonConfig config)->{
            System.out.println("this is action2");
            return BehaviorResult.FALSE;
        };
    };
}
```
