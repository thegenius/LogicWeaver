package com.lvonce.logicweaver.interfaces;

import org.junit.Test;
import com.lvonce.logicweaver.concepts.BehaviorResult;
import static org.junit.Assert.assertEquals;

public class IBehaviorExecutorTest {
    @Test
    public void testResultMap() {
        assertEquals(IBehaviorNode.RESULT.TRUE, IBehaviorExecutor.RESULT.map(BehaviorResult.TRUE));
        assertEquals(IBehaviorNode.RESULT.FALSE, IBehaviorExecutor.RESULT.map(BehaviorResult.FALSE));
        assertEquals(IBehaviorNode.RESULT.DISCARD, IBehaviorExecutor.RESULT.map(BehaviorResult.DISCARD));

        assertEquals(IBehaviorNode.RESULT.NULL, IBehaviorExecutor.RESULT.map(null));
        assertEquals(IBehaviorNode.RESULT.NULL, IBehaviorExecutor.RESULT.map(BehaviorResult.NULL));
    }
}
