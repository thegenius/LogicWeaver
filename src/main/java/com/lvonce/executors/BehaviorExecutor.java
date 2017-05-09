package com.lvonce.executors;

import com.lvonce.BehaviorDebug;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorFunction;

import java.util.ArrayList;

public class BehaviorExecutor implements IBehaviorExecutor {

    private final IBehaviorEntity entity;
    private final IBehaviorNode behavior;
    private IBehaviorFunction work;
    private Object config;
    private STATUS status;
    private ArrayList commandList; // for debug and test

    void recursiveBehaviorId(IBehaviorNode behavior) {
        if (!behavior.hasChildren()) {
            return;
        }
        IBehaviorNode[] children = behavior.getChildren();
        for (IBehaviorNode child : children) {
            recursiveBehaviorId(child);
        }
    }

    public BehaviorExecutor(IBehaviorEntity entity, IBehaviorNode behavior) {
        this.entity = entity;
        this.behavior = behavior;
        this.work = null;
        this.config = null;
        this.status = STATUS.IDLE;
        this.commandList = new ArrayList<Integer>();
        recursiveBehaviorId(behavior);
    }

    @Override
    public STATUS getStatus() {
        return status;
    }

    @Override
    public Object getConfig() {
        return config;
    }

    @Override
    public void setConfig(Object config) {
        this.config = config;
    }

    public ArrayList<Integer> runDebug() {
        commandList.clear();
        this.status = STATUS.WORKING;
        IBehaviorFunction command = this.work;
        if (command == null) {
            int index = behavior.now(this);
            command = entity.getBehaviorFunc(index);
            commandList.add(index);
        } else {
            this.work = null;
            int index = entity.getBehaviorIndex(command);
            commandList.add(index);
        }

        Object result = command.apply(entity, this, this.config);
        while (result instanceof BehaviorResult) {
            int index = behavior.next(this, RESULT.map((BehaviorResult) result).value);
            if (IBehaviorNode.RESULT.isCommand(index)){
                command = entity.getBehaviorFunc(index);
                result = command.apply(entity, this, this.config);
                commandList.add(index);
            } else {
                status = STATUS.FINISHED;
                return ((ArrayList<Integer>)commandList.clone());
            }
        }
        work = (IBehaviorFunction) result;
        return ((ArrayList<Integer>)commandList.clone());
    }


    @Override
    public void run() {
        this.status = STATUS.WORKING;
        IBehaviorFunction command = this.work;
        if (command == null) {
            int index = behavior.now(this);
            command = entity.getBehaviorFunc(index);
        } else {
            this.work = null;
        }

        Object result = command.apply(entity, this, this.config);
        while (result instanceof BehaviorResult) {
            int index = behavior.next(this, RESULT.map((BehaviorResult) result).value);
            if (IBehaviorNode.RESULT.isCommand(index)){
                command = entity.getBehaviorFunc(index);
                result = command.apply(entity, this, this.config);
            } else {
                status = STATUS.FINISHED;
                return;
            }
        }
        work = (IBehaviorFunction) result;
    }

    public ArrayList getCommandList() {
        return commandList;
    }

    @Override
    public void clear() {
        work = null;
        status = STATUS.IDLE;
        behavior.clear();
        commandList.clear();
    }
}
