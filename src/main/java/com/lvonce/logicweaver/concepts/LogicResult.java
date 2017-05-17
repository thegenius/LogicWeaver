package com.lvonce.logicweaver.concepts;

import com.lvonce.logicweaver.interfaces.ILogicResult;

public class LogicResult<R,T,U,S> implements ILogicResult<R,T,U,S> {
    public static final LogicResult NULL = new LogicResult(STATUS.NULL);
    public static final LogicResult TRUE = new LogicResult(STATUS.TRUE);
    public static final LogicResult FALSE = new LogicResult(STATUS.FALSE);
    public static final LogicResult DISCARD = new LogicResult(STATUS.DICARD);

    public final STATUS value;

    private LogicResult(STATUS status) {
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
