package com.lvonce.logicweaver.containers;

import java.util.Arrays;

import com.lvonce.logicweaver.interfaces.ILogicExecutor;
import com.lvonce.logicweaver.interfaces.ILogicNode;
import com.lvonce.logicweaver.interfaces.ILogicChooser;
import com.lvonce.logicweaver.composites.LogicSerialChooser;
import com.lvonce.logicweaver.composites.LogicRandomChooser;


public class LogicSequence implements ILogicNode {
    private int id;
    public final int continueResult;
    public final ILogicNode[] list;
    private final ILogicChooser chooser;

    public LogicSequence(ILogicNode[] nodes, int continueResult) {
        this.chooser = new LogicSerialChooser(nodes.length);
        this.continueResult = continueResult;
        this.list = Arrays.copyOf(nodes, nodes.length);
    }

    public LogicSequence(ILogicNode[] nodes, int continueResult, float[] weights, int chooseCount) {
        this.chooser = new LogicRandomChooser(weights, chooseCount);
        this.continueResult = continueResult;
        this.list = Arrays.copyOf(nodes, nodes.length);
    }

    public LogicSequence(ILogicNode[] nodes, int continueResult, ILogicChooser chooser) {
        this.chooser = chooser;
        this.continueResult = continueResult;
        this.list = Arrays.copyOf(nodes, nodes.length);
    }


    @Override
    public TYPE getType() {
        return TYPE.SEQUENCE;
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
    }

    @Override
    public int next(ILogicExecutor executor, int result) {
        int nextResult = list[chooser.current()].next(executor, result);

        while (true) {

            if (RESULT.isCommand(nextResult)) {
                return nextResult;
            }

            if (nextResult != RESULT.NULL.value && nextResult != continueResult) {
                chooser.clear();
                executor.setConfig(null);
                return nextResult;
            }

            chooser.next();
            if (chooser.finished()) {
                chooser.clear();
                executor.setConfig(null);
                return nextResult;
            } else {
                nextResult = list[chooser.current()].now(executor);
            }
        }
    }
}
