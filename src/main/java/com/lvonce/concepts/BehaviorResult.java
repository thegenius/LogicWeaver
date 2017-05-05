package com.lvonce.concepts;

import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorExecutor;
import com.lvonce.interfaces.IBehaviorResult;
import com.lvonce.interfaces.IBehaviorFunction;

public class BehaviorResult<R,T,U,S> implements IBehaviorResult<R,T,U,S> {
    public static final BehaviorResult NULL = new BehaviorResult(STATUS.NULL);
    public static final BehaviorResult TRUE = new BehaviorResult(STATUS.TRUE);
    public static final BehaviorResult FALSE = new BehaviorResult(STATUS.FALSE);
    public static final BehaviorResult DISCARD = new BehaviorResult(STATUS.DICARD);

    public final STATUS value;

    private BehaviorResult(STATUS status) {
        value = status;
    }

    @Override
    public boolean isInit() {
        return value == STATUS.INIT;
    }

    @Override
    public boolean isWaiting() { return false; }

    @Override
    public boolean isNull() { return false; }

    @Override
    public boolean isDiscard() {
        return value == STATUS.DICARD;
    }

    @Override
    public boolean isTrue() {
        return value == STATUS.TRUE;
    }

    @Override
    public boolean isFalse() {
        return value == STATUS.FALSE;
    }

    @Override
    public R apply (T entity, U executor, S config) {
        return ((R) this);
    }
}
