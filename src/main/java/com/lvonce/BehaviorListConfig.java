package com.lvonce;

import com.lvonce.interfaces.IBehaviorConfig;

/**
 * Created by WangWei on 2017/3/13.
 */

public class BehaviorListConfig implements IBehaviorConfig {
    public enum INDEX {LEVEL, LENGTH};
    private Object[] configs = new Object[INDEX.LENGTH.ordinal()];

    @Override
    public void set(int index, Object config) {
        if (index >= 0 && index < INDEX.LENGTH.ordinal()) {
            this.configs[index] = config;
        }
    }

    @Override
    public Object get(int index) {
        return configs[index];
    }
}
