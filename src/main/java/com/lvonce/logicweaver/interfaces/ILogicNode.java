package com.lvonce.logicweaver.interfaces;

import com.lvonce.logicweaver.LogicDebug;

import java.util.HashSet;

public interface ILogicNode {

    enum TYPE {
        UNKNOWN,
        UNIT,
        SEQUENCE,
        PARALLEL
    };

    enum RESULT {
        NULL(-1),
        DISCARD(-2),
        TRUE(-3),
        FALSE(-4);
        public final int value;

        RESULT(int value) {
            this.value = value;
        }

        public static RESULT build(int value) {
            switch (value) {
                case -2: return DISCARD;
                case -3: return TRUE;
                case -4: return FALSE;
                default: return NULL;
            }
        }

        public static boolean isCommand(int value) {
            return value > NULL.value;
        }
    };

    enum RESULT_PRIORITY {
        AND_PRIORITY(new int[]{0,1,4,2,3}),
        OR_PRIORITY(new int[]{0,1,4,3,2});

        private final int[] rank;

        RESULT_PRIORITY(int[] rank) {
            this.rank = new int[rank.length];
            System.arraycopy(rank, 0, this.rank, 0, rank.length);
        }

        public int choose(int a, int b) {
            if (rank[-a] > rank[-b]) {
                return a;
            } else {
                return b;
            }
        }
    }

    class Carrier {
        public int leafId = 0;
        public int branchId = -1;
        public HashSet nodeSet = new HashSet<ILogicNode>();
    };
    default boolean defineCompleted(ILogicNode behavior, Carrier carrier) {

        if (!behavior.hasChildren()) {
            if (carrier.nodeSet.contains(behavior)) {
                LogicDebug.warning("Duplicate behavior node id[%s] with id[%s] !", behavior.getId(), carrier.leafId);
                return false;
            }
            behavior.setId(carrier.leafId);
            ++carrier.leafId;
            carrier.nodeSet.add(behavior);
            return true;
        }

        if (carrier.nodeSet.contains(behavior)) {
            LogicDebug.warning("Duplicate behavior node id[%s] with id[%s] !", behavior.getId(), carrier.branchId);
            return false;
        }

        ILogicNode[] children = behavior.getChildren();
        for (ILogicNode child : children) {
            boolean success = defineCompleted(child, carrier);
            if (!success) {
                return false;
            }
        }
        behavior.setId(carrier.branchId);
        --carrier.branchId;
        return true;
    }

    default ILogicNode defineFinish() {
        Carrier carrier = new Carrier();
        boolean success = defineCompleted(this, carrier);
        if (success) {
            return this;
        } else {
            return null;
        }
    }

    boolean hasChildren();
    ILogicNode[] getChildren();

    default boolean hasId() {return this.getId() >= 0;}
    int getId();
    void setId(int id);

    TYPE getType();
    int now(ILogicExecutor executor);
    int next(ILogicExecutor executor, int result);
    default void clear(){};

    default ILogicContext genContext() {return null;};
    default ILogicNode getOriginNode() {return this;}
}
