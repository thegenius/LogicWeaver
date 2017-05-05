package com.lvonce.interfaces;

public interface IBehaviorConfig {
    default Object get(int index) {return null;};
    default void  set(int index, Object config) {};
}
