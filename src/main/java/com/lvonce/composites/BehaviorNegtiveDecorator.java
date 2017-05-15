package com.lvonce.composites;

import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorFunction;

public class BehaviorNegtiveDecorator implements IBehaviorNode {
    private final IBehaviorNode unit;

    public BehaviorNegtiveDecorator(IBehaviorNode unit) {
        this.unit = unit;
    }


    public IBehaviorFunction apply(Object entity, Object config) {
//        IBehaviorFunction result = unit.apply(entity, config);
//        if (result instanceof BehaviorResult) {
//            if (((BehaviorResult) result).isTrue()) {
//                return BehaviorResult.FALSE;
//            }
//            if (((BehaviorResult) result).isFalse()) {
//                return BehaviorResult.TRUE;
//            }
//        }
//        return result;
        return null;
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
    public int getId() {
        return unit.getId();
    }

    @Override
    public void setId(int id) {
        unit.setId(id);
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
    public IBehaviorNode getOriginNode() {
        return unit;
    }

    @Override
    public TYPE getType() {
        return unit.getType();
    }
}
