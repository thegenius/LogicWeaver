package com.lvonce.logicweaver.interfaces;

import org.junit.Test;
import com.lvonce.logicweaver.concepts.LogicResult;
import static org.junit.Assert.assertEquals;

public class ILogicExecutorTest {
    @Test
    public void testResultMap() {
        assertEquals(ILogicNode.RESULT.TRUE, ILogicExecutor.RESULT.map(LogicResult.TRUE));
        assertEquals(ILogicNode.RESULT.FALSE, ILogicExecutor.RESULT.map(LogicResult.FALSE));
        assertEquals(ILogicNode.RESULT.DISCARD, ILogicExecutor.RESULT.map(LogicResult.DISCARD));

        assertEquals(ILogicNode.RESULT.NULL, ILogicExecutor.RESULT.map(null));
        assertEquals(ILogicNode.RESULT.NULL, ILogicExecutor.RESULT.map(LogicResult.NULL));
    }
}
