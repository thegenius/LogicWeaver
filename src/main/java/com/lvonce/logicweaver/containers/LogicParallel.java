package com.lvonce.logicweaver.containers;


import java.util.Arrays;

import com.lvonce.logicweaver.composites.LogicRandomChooser;
import com.lvonce.logicweaver.composites.LogicSerialChooser;
import com.lvonce.logicweaver.interfaces.ILogicChooser;
import com.lvonce.logicweaver.interfaces.ILogicContext;
import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;


public class LogicParallel implements ILogicNode {
    private static RESULT_PRIORITY[] PRIORITY_MAP = {
            RESULT_PRIORITY.AND_PRIORITY,
            RESULT_PRIORITY.OR_PRIORITY
    };

    private int id;
    private int result;
    public final ILogicNode[] list;
    public final RESULT_PRIORITY resultPriority;
    private final ILogicChooser chooser;

    public LogicParallel(ILogicNode[] nodes, int priorityIndex) {
        assert priorityIndex >= 0 && priorityIndex < PRIORITY_MAP.length;
        result = RESULT.NULL.value;
        list = Arrays.copyOf(nodes, nodes.length);
        resultPriority = PRIORITY_MAP[priorityIndex];
        chooser = new LogicSerialChooser(nodes.length);
    }

    public LogicParallel(ILogicNode[] nodes, int priorityIndex, float[] weights, int chooseCount) {
        assert priorityIndex >= 0 && priorityIndex < PRIORITY_MAP.length;
        result = RESULT.NULL.value;
        list = Arrays.copyOf(nodes, nodes.length);
        resultPriority = PRIORITY_MAP[priorityIndex];
        chooser = new LogicRandomChooser(weights, chooseCount);
    }

    public LogicParallel(ILogicNode[] nodes, int priorityIndex, ILogicChooser chooser) {
        assert priorityIndex >= 0 && priorityIndex < PRIORITY_MAP.length;
        result = RESULT.NULL.value;
        list = Arrays.copyOf(nodes, nodes.length);
        resultPriority = PRIORITY_MAP[priorityIndex];
        this.chooser = chooser;
    }

    @Override
    public TYPE getType() {
        return TYPE.PARALLEL;
    }

    @Override
    public boolean hasChildren() {
        return true;
    }

    @Override
    public ILogicNode[] getChildren() {
        return this.list;
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
    public int now(ILogicExecutor executor) {
        return list[chooser.current()].now(executor);
    }

    @Override
    public void clear() {
        list[chooser.current()].clear();
        this.chooser.clear();
        this.result = RESULT.NULL.value;
    }

    @Override
    public ILogicContext genContext() {
        return null;
    }

    @Override
    public int next(ILogicExecutor executor, int result) {
        int nextResult = list[chooser.current()].next(executor, result);

        while (true) {
            if (RESULT.isCommand(nextResult)) {
                return nextResult;
            }

            if (nextResult == RESULT.DISCARD.value) {
                this.chooser.clear();
                this.result = RESULT.NULL.value;
                executor.setConfig(null);
                return nextResult;
            }

            chooser.next();
            if (chooser.finished()) {
                nextResult = this.result;
                this.chooser.clear();
                this.result = RESULT.NULL.value;
                executor.setConfig(null);
                return nextResult;
            } else {
                this.result = resultPriority.choose(this.result, nextResult);
                nextResult = list[chooser.current()].now(executor);
            }
        }
    }
}
