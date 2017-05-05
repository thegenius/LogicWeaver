package com.lvonce.interfaces;

public interface IBehaviorContext {
    int current();
    int next();
    void clear();
    Object getResult();
    void setResult(Object result);
}
