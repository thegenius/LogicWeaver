package com.lvonce.logicweaver.interfaces;

import java.util.function.BiFunction;

@FunctionalInterface
public interface IBehaviorFunction<R, T, U, S> {
    R apply(T t, U u, S s);
}
