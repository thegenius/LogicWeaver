package com.lvonce.interfaces;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IBehaviorNodeTest {
    @Test
    public void testStatus() {
        assertEquals(-1, IBehaviorNode.RESULT.NULL.value);
        assertEquals(-2, IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(-3, IBehaviorNode.RESULT.TRUE.value);
        assertEquals(-4, IBehaviorNode.RESULT.FALSE.value);

        assertEquals(IBehaviorNode.RESULT.NULL, IBehaviorNode.RESULT.build(-1));
        assertEquals(IBehaviorNode.RESULT.DISCARD, IBehaviorNode.RESULT.build(-2));
        assertEquals(IBehaviorNode.RESULT.TRUE, IBehaviorNode.RESULT.build(-3));
        assertEquals(IBehaviorNode.RESULT.FALSE, IBehaviorNode.RESULT.build(-4));
    }

    @Test
    public void testAndRank() {
    
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.NULL.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);

        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);

        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);

        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.AND_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);
    }

    @Test
    public void testOrRank() {

        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.NULL.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.NULL.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);

        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.TRUE.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);

        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.TRUE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.FALSE.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.FALSE.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);

        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.TRUE.value), IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.FALSE.value), IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.NULL.value), IBehaviorNode.RESULT.DISCARD.value);
        assertEquals(IBehaviorNode.RESULT_PRIORITY.OR_PRIORITY.choose(IBehaviorNode.RESULT.DISCARD.value, IBehaviorNode.RESULT.DISCARD.value), IBehaviorNode.RESULT.DISCARD.value);
    }
}
