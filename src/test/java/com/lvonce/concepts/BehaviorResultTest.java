package com.lvonce.concepts;

import com.lvonce.interfaces.IBehaviorEntity;
import org.junit.Test;
import com.lvonce.interfaces.IBehaviorFunction;
import com.lvonce.interfaces.IBehaviorStatus;
import static org.junit.Assert.assertEquals;

public class BehaviorResultTest {

	@Test
	public void falseTest() {
		BehaviorResult result = BehaviorResult.FALSE;
		assertEquals(result.isFalse(), true);
		assertEquals(result.value, IBehaviorStatus.STATUS.FALSE);
	}

	@Test
	public void trueTest() {
		BehaviorResult result = BehaviorResult.TRUE;
		assertEquals(result.isTrue(), true);
		assertEquals(result.value, IBehaviorStatus.STATUS.TRUE);
	}

	@Test
	public void discardTest() {
		BehaviorResult result = BehaviorResult.DISCARD;
		assertEquals(result.isDiscard(), true);
		assertEquals(result.value, IBehaviorStatus.STATUS.DICARD);
	}

	@Test
	public void instanceofTest() {
		assertEquals(null instanceof BehaviorResult, false);
		assertEquals(BehaviorResult.TRUE instanceof BehaviorResult, true);
		assertEquals(BehaviorResult.FALSE instanceof BehaviorResult, true);
		assertEquals(BehaviorResult.DISCARD instanceof BehaviorResult, true);

		IBehaviorFunction func = (IBehaviorEntity entity, java.lang.Object config)->{  return null;};
		assertEquals(func instanceof BehaviorResult, false);

		class BehaviorActor {
			public IBehaviorFunction actionFunc = (IBehaviorEntity entity, java.lang.Object config) -> {return null;};
		}
		BehaviorActor actor = new BehaviorActor();
		assertEquals(actor.actionFunc instanceof BehaviorResult, false);
	}

	@Test(expected = java.lang.ClassCastException.class)
	public void castTest() {
		IBehaviorFunction func = (IBehaviorEntity entity, java.lang.Object config)->{  return null;};
		BehaviorResult result = (BehaviorResult)func;
	}

}
