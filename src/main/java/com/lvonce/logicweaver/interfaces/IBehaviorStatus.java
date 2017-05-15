package com.lvonce.logicweaver.interfaces;

public interface IBehaviorStatus  {
    enum STATUS {INIT, WAITING, TRUE, FALSE, NULL, DICARD};
    boolean isInit();
    boolean isWaiting();
    boolean isTrue();
    boolean isFalse();
    boolean isNull();
    boolean isDiscard();
}
