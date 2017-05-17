package com.lvonce.logicweaver.executors;

import com.lvonce.logicweaver.LogicDebug;
import com.lvonce.logicweaver.concepts.LogicList;
import com.lvonce.logicweaver.concepts.LogicResult;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicFunction;

import java.util.ArrayList;
import java.util.HashMap;

public class LogicExecutor implements ILogicExecutor {

    private final Object entity;
    private final ILogicNode behavior;
    private ILogicFunction work;
    private Object config;
    private STATUS status;
    private ArrayList commandList; // for debug and test

    void recursiveBehaviorId(ILogicNode behavior) {
        if (!behavior.hasChildren()) {
            LogicDebug.debug("visit id[%s]", behavior.getId());
            return;
        }
        ILogicNode[] children = behavior.getChildren();
        for (ILogicNode child : children) {
            recursiveBehaviorId(child);
        }
        LogicDebug.debug("visit id[%s]", behavior.getId());
    }

    int findParent(ILogicNode parent, ILogicNode node, HashMap parentMap) {
        if (!node.hasChildren()) {
            parentMap.put(node, parent);
            return 1;
        }
        int leafNum = 0;
        ILogicNode[] children = node.getChildren();
        for (ILogicNode child : children) {
            leafNum += findParent(node, child, parentMap);
        }
        parentMap.put(node, parent);
        return leafNum;
    }

    ILogicNode[] findReturnPath(HashMap<ILogicNode, ILogicNode> parentMap, ILogicNode nodeFrom, ILogicNode nodeTo) {
        ArrayList<ILogicNode> nodeFromParent = new ArrayList<>();
        ILogicNode parent = parentMap.getOrDefault(nodeFrom, null);
        while ( parent != null) {
            nodeFromParent.add(parent);
            parent = parentMap.getOrDefault(parent, null);
        }

        ArrayList<ILogicNode> nodeToParent = new ArrayList<>();
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
        HashMap<ILogicNode, ILogicNode> parentMap = new HashMap<>();
        int leafNum = findParent(null, this.behavior, parentMap);
        for (int i=0; i<leafNum; ++i) {

        }
    }

    public LogicExecutor(Object entity, ILogicNode behavior) {
        this.entity = entity;
        this.behavior = behavior;
        this.work = null;
        this.config = null;
        this.status = STATUS.IDLE;
        this.commandList = new ArrayList<Integer>();
        //recursiveBehaviorId(behavior);
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
        ILogicFunction command = this.work;
        if (command == null) {
            int index = behavior.now(this);
            command = LogicList.getInstance(entity.getClass()).get(index);;
            commandList.add(index);
        } else {
            this.work = null;
            int index = LogicList.getInstance(entity.getClass()).get(command);
            commandList.add(index);
        }

        Object result = command.apply(entity, this, this.config);
        while (result instanceof LogicResult) {
            int index = behavior.next(this, RESULT.map((LogicResult) result).value);
            if (ILogicNode.RESULT.isCommand(index)){
                command = LogicList.getInstance(entity.getClass()).get(index);;
                result = command.apply(entity, this, this.config);
                commandList.add(index);
            } else {
                status = STATUS.FINISHED;
                return ((ArrayList<Integer>)commandList.clone());
            }
        }
        work = (ILogicFunction) result;
        return ((ArrayList<Integer>)commandList.clone());
    }


    @Override
    public void run() {
        this.status = STATUS.WORKING;
        ILogicFunction command = this.work;
        if (command == null) {
            int index = behavior.now(this);
            command = LogicList.getInstance(entity.getClass()).get(index);
        } else {
            this.work = null;
        }

        Object result = command.apply(entity, this, this.config);
        while (result instanceof LogicResult) {
            int index = behavior.next(this, RESULT.map((LogicResult) result).value);
            if (ILogicNode.RESULT.isCommand(index)){
                command = LogicList.getInstance(entity.getClass()).get(index);;
                result = command.apply(entity, this, this.config);
            } else {
                status = STATUS.FINISHED;
                return;
            }
        }
        work = (ILogicFunction) result;
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
