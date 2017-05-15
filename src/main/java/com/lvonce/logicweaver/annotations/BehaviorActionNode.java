package com.lvonce.logicweaver.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BehaviorActionNode {
    int index();
}
