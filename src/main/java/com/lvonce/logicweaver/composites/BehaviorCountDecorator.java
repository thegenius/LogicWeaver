package com.lvonce.logicweaver.composites;

import com.lvonce.logicweaver.concepts.BehaviorResult;
import com.lvonce.logicweaver.interfaces.IBehaviorExecutor;
import com.lvonce.logicweaver.interfaces.IBehaviorNode;
import com.lvonce.logicweaver.interfaces.IBehaviorFunction;


public class BehaviorCountDecorator implements IBehaviorNode {
    private int count;
    private final IBehaviorNode unit;
    private final IBehaviorFunction finished;

    public BehaviorCountDecorator(IBehaviorNode unit, int countLimit, BehaviorResult finished) {
        this.unit = unit;
        this.count = countLimit;
        this.finished = finished;
    }

    @Override
    public int now(IBehaviorExecutor executor) {
        return 0;
    }

    @Override
    public int next(IBehaviorExecutor executor, int result) {
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
    public IBehaviorNode[] getChildren() {
        return unit.getChildren();
    }

    @Override
    public IBehaviorNode getOriginNode() {
        return unit;
    }

    public TYPE getType() {
        return unit.getType();
    }
}
