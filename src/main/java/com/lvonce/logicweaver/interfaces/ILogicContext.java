package com.lvonce.logicweaver.interfaces;

public interface ILogicContext {
    int current();
    int next();
    void clear();
    Object getResult();
    void setResult(Object result);
}
