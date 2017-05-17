package com.lvonce.logicweaver.composites;

import com.lvonce.logicweaver.concepts.LogicResult;
import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.interfaces.ILogicFunction;


public class LogicCountDecorator implements ILogicNode {
    private int count;
    private final ILogicNode unit;
    private final ILogicFunction finished;

    public LogicCountDecorator(ILogicNode unit, int countLimit, LogicResult finished) {
        this.unit = unit;
        this.count = countLimit;
        this.finished = finished;
    }

    @Override
    public int now(ILogicExecutor executor) {
        return 0;
    }

    @Override
    public int next(ILogicExecutor executor, int result) {
        return 0;
    }

    @Override
    public int getId() {
        return unit.getId();
    }

    @Override
    public void setId(int id) {
        unit.setId(id);
    }

    @Override
    public boolean hasChildren() {
        return unit.hasChildren();
    }

    @Override
    public ILogicNode[] getChildren() {
        return unit.getChildren();
    }

    @Override
    public ILogicNode getOriginNode() {
        return unit;
    }

    public TYPE getType() {
        return unit.getType();
    }
}
