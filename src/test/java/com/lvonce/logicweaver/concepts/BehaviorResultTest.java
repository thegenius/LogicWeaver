package com.lvonce.logicweaver.concepts;

import com.lvonce.logicweaver.interfaces.IBehaviorStatus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BehaviorResultTest {

	@Test
	public void falseTest() {
		BehaviorResult result = BehaviorResult.FALSE;
		assertEquals(result.isFalse(), true);
		Assert.assertEquals(result.value, IBehaviorStatus.STATUS.FALSE);
	}

	@Test
	public void trueTest() {
		BehaviorResult result = BehaviorResult.TRUE;
		assertEquals(result.isTrue(), true);
		Assert.assertEquals(result.value, IBehaviorStatus.STATUS.TRUE);
	}

	@Test
	public void discardTest() {
		BehaviorResult result = BehaviorResult.DISCARD;
		assertEquals(result.isDiscard(), true);
		Assert.assertEquals(result.value, IBehaviorStatus.STATUS.DICARD);
	}

	@Test
	public void instanceofTest() {
		assertEquals(null instanceof BehaviorResult, false);
		assertEquals(BehaviorResult.TRUE instanceof BehaviorResult, true);
		assertEquals(BehaviorResult.FALSE instanceof BehaviorResult, true);
		assertEquals(BehaviorResult.DISCARD instanceof BehaviorResult, true);

		//IBehaviorFunction func = (IBehaviorEntity entity, java.lang.Object config)->{  return null;};
		//assertEquals(func instanceof BehaviorResult, false);

		//class BehaviorActor {
		//	public IBehaviorFunction actionFunc = (IBehaviorEntity entity, java.lang.Object config) -> {return null;};
		//}
		//BehaviorActor actor = new BehaviorActor();
		//assertEquals(actor.actionFunc instanceof BehaviorResult, false);
	}

    @Test
	public void castTest() {
		//IBehaviorFunction func = (IBehaviorEntity entity, java.lang.Object config)->{  return null;};
		//BehaviorResult result = (BehaviorResult)func;
	}

}
