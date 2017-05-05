package com.lvonce.executors;

import com.lvonce.BehaviorDebug;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorFunction;

public class BehaviorExecutor implements IBehaviorExecutor {

    private final IBehaviorEntity entity;
    private final IBehaviorNode behavior;
    private IBehaviorFunction work;
    private Object config;
    private STATUS status;

    void recursiveBehaviorId(IBehaviorNode behavior) {
        if (!behavior.hasChildren()) {
            BehaviorDebug.debug("bevaior %s id:%d", behavior, behavior.getId());
            return;
        }
        IBehaviorNode[] children = behavior.getChildren();
        for (IBehaviorNode child : children) {
            recursiveBehaviorId(child);
        }
        BehaviorDebug.debug("bevaior %s id:%d",behavior, behavior.getId());
    }

    public BehaviorExecutor(IBehaviorEntity entity, IBehaviorNode behavior) {
        this.entity = entity;
        this.behavior = behavior;
        this.work = null;
        this.config = null;
        this.status = STATUS.IDLE;

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

    @Override
    public void run() {
        BehaviorDebug.debug("----------- executor run()");
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

    @Override
    public void clear() {
        work = null;
        status = STATUS.IDLE;
        behavior.clear();
    }
}
