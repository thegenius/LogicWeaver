package com.lvonce.logicweaver.concepts;

import com.lvonce.logicweaver.interfaces.ILogicStatus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicResultTest {

	@Test
	public void falseTest() {
		LogicResult result = LogicResult.FALSE;
		assertEquals(result.isFalse(), true);
		Assert.assertEquals(result.value, ILogicStatus.STATUS.FALSE);
	}

	@Test
	public void trueTest() {
		LogicResult result = LogicResult.TRUE;
		assertEquals(result.isTrue(), true);
		Assert.assertEquals(result.value, ILogicStatus.STATUS.TRUE);
	}

	@Test
	public void discardTest() {
		LogicResult result = LogicResult.DISCARD;
		assertEquals(result.isDiscard(), true);
		Assert.assertEquals(result.value, ILogicStatus.STATUS.DICARD);
	}

	@Test
	public void instanceofTest() {
		assertEquals(null instanceof LogicResult, false);
		assertEquals(LogicResult.TRUE instanceof LogicResult, true);
		assertEquals(LogicResult.FALSE instanceof LogicResult, true);
		assertEquals(LogicResult.DISCARD instanceof LogicResult, true);

		//IBehaviorFunction func = (IBehaviorEntity entity, java.lang.Object config)->{  return null;};
		//assertEquals(func instanceof LogicResult, false);

		//class BehaviorActor {
		//	public IBehaviorFunction actionFunc = (IBehaviorEntity entity, java.lang.Object config) -> {return null;};
		//}
		//BehaviorActor actor = new BehaviorActor();
		//assertEquals(actor.actionFunc instanceof LogicResult, false);
	}

    @Test
	public void castTest() {
		//IBehaviorFunction func = (IBehaviorEntity entity, java.lang.Object config)->{  return null;};
		//LogicResult result = (LogicResult)func;
	}

}
