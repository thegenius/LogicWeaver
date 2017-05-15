package com.lvonce.logicweaver.interfaces;

public interface IBehaviorContext {
    int current();
    int next();
    void clear();
    Object getResult();
    void setResult(Object result);
}
