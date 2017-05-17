package com.lvonce.logicweaver.containers;

import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;

public class LogicNode implements ILogicNode {

    public final Object config;
    private final int command;
    private int id;

    public LogicNode(int command) {
        this.id = -1;
        this.config = null;
        this.command = command;
    }

    public LogicNode(int command, Object config) {
        this.id = -1;
        this.config = config;
        this.command = command;
    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public ILogicNode[] getChildren() {
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
    public int now(ILogicExecutor executor) {
        executor.setConfig(config);
        return command;
    }

    @Override
    public int next(ILogicExecutor executor, int result) {
        return result;
    }

}
