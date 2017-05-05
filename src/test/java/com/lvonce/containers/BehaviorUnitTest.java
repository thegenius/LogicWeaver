package com.lvonce.containers;

import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorFunction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by wwn2162 on 2017/3/24.
 */
public class BehaviorUnitTest {
    @Test
    public void applyTest() {
        IBehaviorFunction func1 = (IBehaviorEntity entity, Object config) -> {return BehaviorResult.FALSE;};
//        BehaviorUnit unit1 = new BehaviorUnit(func1, null);
//        assertEquals(BehaviorResult.FALSE, unit1.apply(null));
//
//        IBehaviorFunction func2 = (IBehaviorEntity entity, Object config) -> {return BehaviorResult.TRUE;};
//        BehaviorUnit unit2 = new BehaviorUnit(func2, null);
//        assertEquals(BehaviorResult.TRUE, unit2.apply(null));
//
//        IBehaviorFunction func3 = (IBehaviorEntity entity, Object config) -> {return BehaviorResult.DISCARD;};
//        BehaviorUnit unit3 = new BehaviorUnit(func3, null);
//        assertEquals(BehaviorResult.DISCARD, unit3.apply(null));
//
//        IBehaviorFunction func4 = (IBehaviorEntity entity, Object config) -> {return null;};
//        BehaviorUnit unit4 = new BehaviorUnit(func4, null);
//        assertEquals(null, unit4.apply(null));
//
//        IBehaviorFunction func5 = (IBehaviorEntity entity, Object config) -> {return (IBehaviorEntity entity, Object config2)->{return null;};};
//        BehaviorUnit unit5 = new BehaviorUnit(func5, null);
//        IBehaviorFunction result = unit5.apply(null);
//        assertEquals(true, result instanceof IBehaviorFunction);
//        assertEquals(false, result instanceof BehaviorResult);
//        assertEquals(null, result.apply(null));

    }
}
