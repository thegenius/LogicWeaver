package com.lvonce.logicweaver.containers;

import com.lvonce.logicweaver.interfaces.IBehaviorExecutor;
import com.lvonce.logicweaver.interfaces.IBehaviorNode;

public class BehaviorNode implements IBehaviorNode {

    public final Object config;
    private final int command;
    private int id;

    public BehaviorNode(int command) {
        this.id = -1;
        this.config = null;
        this.command = command;
    }

    public BehaviorNode(int command, Object config) {
        this.id = -1;
        this.config = config;
        this.command = command;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public IBehaviorNode[] getChildren() {
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public TYPE getType() {
        return TYPE.UNIT;
    }

    @Override
    public int now(IBehaviorExecutor executor) {
        executor.setConfig(config);
        return command;
    }

    @Override
    public int next(IBehaviorExecutor executor, int result) {
        return result;
    }

}
