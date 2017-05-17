package com.lvonce.logicweaver.composites;

import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.interfaces.ILogicFunction;

public class LogicNegtiveDecorator implements ILogicNode {
    private final ILogicNode unit;

    public LogicNegtiveDecorator(ILogicNode unit) {
        this.unit = unit;
    }


    public ILogicFunction apply(Object entity, Object config) {
//        IBehaviorFunction result = unit.apply(entity, config);
//        if (result instanceof LogicResult) {
//            if (((LogicResult) result).isTrue()) {
//                return LogicResult.FALSE;
//            }
//            if (((LogicResult) result).isFalse()) {
//                return LogicResult.TRUE;
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
    public ILogicNode[] getChildren() {
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
    public int now(ILogicExecutor executor) {
        return 0;
    }

    @Override
    public int next(ILogicExecutor executor, int result) {
        return 0;
    }

    @Override
    public ILogicNode getOriginNode() {
        return unit;
    }

    @Override
    public TYPE getType() {
        return unit.getType();
    }
}
