package com.lvonce.interfaces;

import com.lvonce.BehaviorDebug;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Supplier;

public interface IBehaviorNode {

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
        public HashSet nodeSet = new HashSet<IBehaviorNode>();
    };
    default boolean defineCompleted(IBehaviorNode behavior, Carrier carrier) {

        if (!behavior.hasChildren()) {
            if (carrier.nodeSet.contains(behavior)) {
                BehaviorDebug.warning("Duplicate behavior node id[%s] with id[%s] !", behavior.getId(), carrier.leafId);
                return false;
            }
            behavior.setId(carrier.leafId);
            ++carrier.leafId;
            carrier.nodeSet.add(behavior);
            return true;
        }

        if (carrier.nodeSet.contains(behavior)) {
            BehaviorDebug.warning("Duplicate behavior node id[%s] with id[%s] !", behavior.getId(), carrier.branchId);
            return false;
        }

        IBehaviorNode[] children = behavior.getChildren();
        for (IBehaviorNode child : children) {
            boolean success = defineCompleted(child, carrier);
            if (!success) {
                return false;
            }
        }
        behavior.setId(carrier.branchId);
        --carrier.branchId;
        return true;
    }

    default boolean defineCompleted() {
        Carrier carrier = new Carrier();
        return defineCompleted(this, carrier);
    }

    boolean hasChildren();
    IBehaviorNode[] getChildren();

    default boolean hasId() {return this.getId() >= 0;}
    int getId();
    void setId(int id);

    TYPE getType();
    int now(IBehaviorExecutor executor);
    int next(IBehaviorExecutor executor, int result);
    default void clear(){};

    default IBehaviorContext genContext() {return null;};
}
