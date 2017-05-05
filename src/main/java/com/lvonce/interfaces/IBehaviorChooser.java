package com.lvonce.interfaces;

public interface IBehaviorChooser {
    int next();
    int current();
    int count();
    int limit();
    void clear();
    default boolean finished() {
        return count() > limit();
    }
}
