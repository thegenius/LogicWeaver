package com.lvonce.executors;

import com.lvonce.BehaviorDebug;
import com.lvonce.builders.BehaviorBuilder;
import com.lvonce.concepts.BehaviorList;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorFunction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BehaviorExecutor implements IBehaviorExecutor {

    private final Object entity;
    private final IBehaviorNode behavior;
    private IBehaviorFunction work;
    private Object config;
    private STATUS status;
    private ArrayList commandList; // for debug and test

    void recursiveBehaviorId(IBehaviorNode behavior) {
        if (!behavior.hasChildren()) {
            BehaviorDebug.debug("visit id[%s]", behavior.getId());
            return;
        }
        IBehaviorNode[] children = behavior.getChildren();
        for (IBehaviorNode child : children) {
            recursiveBehaviorId(child);
        }
        BehaviorDebug.debug("visit id[%s]", behavior.getId());
    }

    int findParent(IBehaviorNode parent, IBehaviorNode node, HashMap parentMap) {
        if (!node.hasChildren()) {
            parentMap.put(node, parent);
            return 1;
        }
        int leafNum = 0;
        IBehaviorNode[] children = node.getChildren();
        for (IBehaviorNode child : children) {
            leafNum += findParent(node, child, parentMap);
        }
        parentMap.put(node, parent);
        return leafNum;
    }

    IBehaviorNode[] findReturnPath(HashMap<IBehaviorNode, IBehaviorNode> parentMap, IBehaviorNode nodeFrom, IBehaviorNode nodeTo) {
        ArrayList<IBehaviorNode> nodeFromParent = new ArrayList<>();
        IBehaviorNode parent = parentMap.getOrDefault(nodeFrom, null);
        while ( parent != null) {
            nodeFromParent.add(parent);
            parent = parentMap.getOrDefault(parent, null);
        }

        ArrayList<IBehaviorNode> nodeToParent = new ArrayList<>();
        parent = parentMap.getOrDefault(nodeTo, null);
        while ( parent != null) {
            nodeToParent.add(parent);
            parent = parentMap.getOrDefault(parent, null);
        }

        int cmpLen = Math.min(nodeFromParent.size(), nodeToParent.size());
        int commonPos = 0;
        for (int i=1; i<cmpLen; ++i) {
            if (nodeFromParent.get(i) == nodeToParent.get(i)) {
                commonPos = i;
            } else {
                break;
            }
        }
        return null;
    }

    void buildTransferPath() {
        HashMap<IBehaviorNode, IBehaviorNode> parentMap = new HashMap<>();
        int leafNum = findParent(null, this.behavior, parentMap);
        for (int i=0; i<leafNum; ++i) {

        }
    }

    public BehaviorExecutor(Object entity, IBehaviorNode behavior) {
        this.entity = entity;
        this.behavior = behavior;
        this.work = null;
        this.config = null;
        this.status = STATUS.IDLE;
        this.commandList = new ArrayList<Integer>();
        recursiveBehaviorId(behavior);
        buildTransferPath();
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
            command = BehaviorList.getInstance(entity.getClass()).get(index);;
            commandList.add(index);
        } else {
            this.work = null;
            int index = BehaviorList.getInstance(entity.getClass()).get(command);
            commandList.add(index);
        }

        Object result = command.apply(entity, this, this.config);
        while (result instanceof BehaviorResult) {
            int index = behavior.next(this, RESULT.map((BehaviorResult) result).value);
            if (IBehaviorNode.RESULT.isCommand(index)){
                command = BehaviorList.getInstance(entity.getClass()).get(index);;
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
            command = BehaviorList.getInstance(entity.getClass()).get(index);
        } else {
            this.work = null;
        }

        Object result = command.apply(entity, this, this.config);
        while (result instanceof BehaviorResult) {
            int index = behavior.next(this, RESULT.map((BehaviorResult) result).value);
            if (IBehaviorNode.RESULT.isCommand(index)){
                command = BehaviorList.getInstance(entity.getClass()).get(index);;
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
