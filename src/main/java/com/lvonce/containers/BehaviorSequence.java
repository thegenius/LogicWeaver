package com.lvonce.containers;

import java.util.Arrays;
import com.lvonce.BehaviorDebug;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorChooser;
import com.lvonce.composites.BehaviorSerialChooser;
import com.lvonce.composites.BehaviorRandomChooser;


public class BehaviorSequence implements IBehaviorNode {
    private int id;
    public final int continueResult;
    public final IBehaviorNode[] list;
    private final IBehaviorChooser chooser;

    public BehaviorSequence(IBehaviorNode[] nodes, int continueResult) {
        this.chooser = new BehaviorSerialChooser(nodes.length);
        this.continueResult = continueResult;
        this.list = Arrays.copyOf(nodes, nodes.length);
    }

    public BehaviorSequence(IBehaviorNode[] nodes, int continueResult, float[] weights, int chooseCount) {
        this.chooser = new BehaviorRandomChooser(weights, chooseCount);
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
    public IBehaviorNode[] getChildren() {
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
    public int now(IBehaviorExecutor executor) {
        return list[chooser.current()].now(executor);
    }

    @Override
    public void clear() {
        list[chooser.current()].clear();
        this.chooser.clear();
    }

    @Override
    public int next(IBehaviorExecutor executor, int result) {
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
