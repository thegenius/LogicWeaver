package com.lvonce.logicweaver.interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ILogicNodeTest {
    @Test
    public void testStatus() {
        assertEquals(-1, ILogicNode.RESULT.NULL.value);
        assertEquals(-2, ILogicNode.RESULT.DISCARD.value);
        assertEquals(-3, ILogicNode.RESULT.TRUE.value);
        assertEquals(-4, ILogicNode.RESULT.FALSE.value);
    }

    @Test
    public void testBuild() {
        assertEquals(ILogicNode.RESULT.NULL, ILogicNode.RESULT.build(-1));
        assertEquals(ILogicNode.RESULT.DISCARD, ILogicNode.RESULT.build(-2));
        assertEquals(ILogicNode.RESULT.TRUE, ILogicNode.RESULT.build(-3));
        assertEquals(ILogicNode.RESULT.FALSE, ILogicNode.RESULT.build(-4));
    }


    @Test
    public void testAndRank() {

        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.NULL.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);

        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);

        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);

        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.DISCARD.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.DISCARD.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.DISCARD.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.AND_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);
    }

    @Test
    public void testOrRank() {

        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.NULL.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.NULL.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);

        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.TRUE.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);

        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.TRUE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.FALSE.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.FALSE.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);

        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.TRUE.value), ILogicNode.RESULT.DISCARD.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.FALSE.value), ILogicNode.RESULT.DISCARD.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.NULL.value), ILogicNode.RESULT.DISCARD.value);
        assertEquals(ILogicNode.RESULT_PRIORITY.OR_PRIORITY.choose(ILogicNode.RESULT.DISCARD.value, ILogicNode.RESULT.DISCARD.value), ILogicNode.RESULT.DISCARD.value);
    }
}
