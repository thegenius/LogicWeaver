package com.lvonce.logicweaver.concepts;

import static org.junit.Assert.assertEquals;

/**
 * Created by WangWei on 2017/3/24.
 */
public class LogicMapTest {
//    @Test
//    public void hasInstanceTest() {
//        class Actor implements IBehaviorEntity {
//        }
//        Actor actor = new Actor();
//        assertEquals(false, BehaviorMap.hasInstance(actor));
//    }
//
//    @Test
//    public void getInstanceTest() {
//        class Actor implements IBehaviorEntity {
//        }
//        Actor actor = new Actor();
//        assertEquals(false, BehaviorMap.hasInstance(actor));
//        BehaviorMap.getInstance(actor);
//        assertEquals(true, BehaviorMap.hasInstance(actor));
//    }
//
//    @Test
//    public void getBehaviorNameInnerTest() {
//        class Actor implements IBehaviorEntity {
//            IBehaviorFunction action1 = (IBehaviorEntity entity, Object config) -> {return null;};
//            public  IBehaviorFunction action2 = (IBehaviorEntity entity, Object config) -> {return null;};
//            private IBehaviorFunction action3 = (IBehaviorEntity entity, Object config) -> {return null;};
//            protected IBehaviorFunction action4 = (IBehaviorEntity entity, Object config) -> {return null;};
//
//            final IBehaviorFunction action5 = (IBehaviorEntity entity, Object config) -> {return null;};
//            final public  IBehaviorFunction action6 = (IBehaviorEntity entity, Object config) -> {return null;};
//            final private IBehaviorFunction action7 = (IBehaviorEntity entity, Object config) -> {return null;};
//            final protected IBehaviorFunction action8 = (IBehaviorEntity entity, Object config) -> {return null;};
//
//        }
//        Actor actor = new Actor();
//
//        assertEquals("action1", BehaviorMap.getInstance(actor).getName(actor.action1));
//        assertEquals("action2", BehaviorMap.getInstance(actor).getName(actor.action2));
//        assertEquals("action3", BehaviorMap.getInstance(actor).getName(actor.action3));
//        assertEquals("action4", BehaviorMap.getInstance(actor).getName(actor.action4));
//        assertEquals("action5", BehaviorMap.getInstance(actor).getName(actor.action5));
//        assertEquals("action6", BehaviorMap.getInstance(actor).getName(actor.action6));
//        assertEquals("action7", BehaviorMap.getInstance(actor).getName(actor.action7));
//        assertEquals("action8", BehaviorMap.getInstance(actor).getName(actor.action8));
//    }
//
//    @Test
//    public void getBehaviorNameOuterTest() {
//        BehaviorEntityClass actor = new BehaviorEntityClass();
//
//        assertEquals("action1", BehaviorMap.getInstance(actor).getName(actor.action1));
//        assertEquals("action2", BehaviorMap.getInstance(actor).getName(actor.action2));
//        //assertEquals("action3", BehaviorMap.getInstance(actor).getName(actor.action3));
//        assertEquals("action4", BehaviorMap.getInstance(actor).getName(actor.action4));
//        assertEquals("action5", BehaviorMap.getInstance(actor).getName(actor.action5));
//        assertEquals("action6", BehaviorMap.getInstance(actor).getName(actor.action6));
//        //assertEquals("action7", BehaviorMap.getInstance(actor).getName(actor.action7));
//        assertEquals("action8", BehaviorMap.getInstance(actor).getName(actor.action8));
//
//        assertEquals("action9", BehaviorMap.getInstance(actor).getName(actor.action9));
//        assertEquals("action10", BehaviorMap.getInstance(actor).getName(actor.action10));
//        //assertEquals("action11", BehaviorMap.getInstance(actor).getName(actor.action11));
//        assertEquals("action12", BehaviorMap.getInstance(actor).getName(actor.action12));
//        assertEquals("action13", BehaviorMap.getInstance(actor).getName(actor.action13));
//        assertEquals("action14", BehaviorMap.getInstance(actor).getName(actor.action14));
//        //assertEquals("action15", BehaviorMap.getInstance(actor).getName(actor.action15));
//        assertEquals("action16", BehaviorMap.getInstance(actor).getName(actor.action16));
//        assertEquals("action17", BehaviorMap.getInstance(actor).getName(actor.action17));
//        assertEquals("action18", BehaviorMap.getInstance(actor).getName(actor.action18));
//        //assertEquals("action19", BehaviorMap.getInstance(actor).getName(actor.action19));
//        assertEquals("action20", BehaviorMap.getInstance(actor).getName(actor.action20));
//
//        IBehaviorFunction action3 = BehaviorMap.getInstance(actor).getFunc("action3");
//        assertEquals(LogicResult.TRUE, action3.apply(null, null));
//        assertEquals("action3", BehaviorMap.getInstance(actor).getName(action3));
//
//        IBehaviorFunction action7 = BehaviorMap.getInstance(actor).getFunc("action7");
//        assertEquals(LogicResult.FALSE, action7.apply(null, null));
//        assertEquals("action7", BehaviorMap.getInstance(actor).getName(action7));
//
//        IBehaviorFunction action11 = BehaviorMap.getInstance(actor).getFunc("action11");
//        assertEquals(null, action11.apply(null, null));
//        assertEquals("action11", BehaviorMap.getInstance(actor).getName(action11));
//
//        IBehaviorFunction action15 = BehaviorMap.getInstance(actor).getFunc("action15");
//        IBehaviorFunction func = action15.apply(null, null);
//        assertEquals(true, func instanceof IBehaviorFunction);
//        assertEquals(false, func instanceof LogicResult);
//        assertEquals(LogicResult.DISCARD, func.apply(null, null));
//        assertEquals("action15", BehaviorMap.getInstance(actor).getName(action15));
//
//        IBehaviorFunction action19 = BehaviorMap.getInstance(actor).getFunc("action19");
//        assertEquals(LogicResult.DISCARD, action19.apply(null, null));
//        assertEquals("action19", BehaviorMap.getInstance(actor).getName(action19));
//    }
//
//    @Test
//    public void getBehaviorFuncInnerTest() {
//        class Actor implements IBehaviorEntity {
//            IBehaviorFunction action1 = (IBehaviorEntity entity, Object config) -> {return null;};
//            public  IBehaviorFunction action2 = (IBehaviorEntity entity, Object config) -> {return null;};
//            private IBehaviorFunction action3 = (IBehaviorEntity entity, Object config) -> {return null;};
//            protected IBehaviorFunction action4 = (IBehaviorEntity entity, Object config) -> {return null;};
//
//            final IBehaviorFunction action5 = (IBehaviorEntity entity, Object config) -> {return null;};
//            final public  IBehaviorFunction action6 = (IBehaviorEntity entity, Object config) -> {return null;};
//            final private IBehaviorFunction action7 = (IBehaviorEntity entity, Object config) -> {return null;};
//            final protected IBehaviorFunction action8 = (IBehaviorEntity entity, Object config) -> {return null;};
//
//        }
//        Actor actor = new Actor();
//
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action1"), actor.action1);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action2"), actor.action2);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action3"), actor.action3);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action4"), actor.action4);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action5"), actor.action5);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action6"), actor.action6);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action7"), actor.action7);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action8"), actor.action8);
//
//    }
//
//    @Test
//    public void getBehaviorFuncOuterTest() {
//        BehaviorEntityClass actor = new BehaviorEntityClass();
//
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action1"), actor.action1);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action2"), actor.action2);
//        //assertEquals(BehaviorMap.getInstance(actor).getFunc("action3"), actor.action3);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action4"), actor.action4);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action5"), actor.action5);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action6"), actor.action6);
//        //assertEquals(BehaviorMap.getInstance(actor).getFunc("action7"), actor.action7);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action8"), actor.action8);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action9"), actor.action9);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action10"), actor.action10);
//        //assertEquals(BehaviorMap.getInstance(actor).getFunc("action11"), actor.action11);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action12"), actor.action12);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action13"), actor.action13);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action14"), actor.action14);
//        //assertEquals(BehaviorMap.getInstance(actor).getFunc("action15"), actor.action15);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action16"), actor.action16);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action17"), actor.action17);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action18"), actor.action18);
//        //assertEquals(BehaviorMap.getInstance(actor).getFunc("action19"), actor.action19);
//        assertEquals(BehaviorMap.getInstance(actor).getFunc("action20"), actor.action20);
//
//    }

}
