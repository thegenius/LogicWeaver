package com.lvonce.logicweaver.composites;

import com.lvonce.logicweaver.interfaces.IBehaviorChooser;

public class BehaviorSerialChooser implements IBehaviorChooser {
    private int index;
    private final int limit;

    public BehaviorSerialChooser(int countLimit) {
        assert countLimit > 0;
        index = 0;
        limit = countLimit;
    }

    @Override
    public int next() {
        if (index >= limit) {
            index = 0;
            return 0;
        } else {
            return ++index;
        }
    }

    @Override
    public void clear() {
        index = 0;
    }

    @Override
    public int current() {
        return index;
    }

    @Override
    public int count() {
        return index + 1;
    }

    public int limit() {
        return limit;
    }

}
