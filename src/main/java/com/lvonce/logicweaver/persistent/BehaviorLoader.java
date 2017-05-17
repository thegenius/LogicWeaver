package com.lvonce.logicweaver.persistent;

import com.lvonce.logicweaver.interfaces.ILogicNode;

/**
 * Created by WangWei on 2017/3/15.
 */
public class BehaviorLoader {
    public static class UnexpectedBehaviorType extends Exception {
        public UnexpectedBehaviorType(String type) {
            System.out.printf("- Behavior Load Error: unknown type %s -\n", type);
        }
        public UnexpectedBehaviorType(String expectedType, String found) {
            System.out.printf("- Behavior Load Error: expect type %s, but found %s -\n", expectedType, found);
        }
    }

    public static ILogicNode load(Object entity, String jsonString) {
//        try {
//            JsonLoader.JsonValue value = JsonLoader.load(jsonString);
//            return load(entity, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
        return null;
    }

    public static ILogicNode load (Object entity, JsonLoader.JsonValue jsonValue) throws JsonLoader.UnknownTypeException, UnexpectedBehaviorType {
        return null;
//        if (jsonValue.type != JsonLoader.JsonValue.TYPE.OBJECT) {
//            throw new UnexpectedBehaviorType("OBJECT", jsonValue.type.toString());
//        }
//
//        // temp variable to store
//        JsonLoader.JsonPair[] pairs = (JsonLoader.JsonPair[]) jsonValue.list;
//        JsonLoader.JsonObject jsonObj = (JsonLoader.JsonObject) jsonValue.value;
//        ILogicNode.TYPE type = ILogicNode.TYPE.UNKNOWN;
//        String func = "";
//        Object[] list = null;
//        Object config = null;
//
//        JsonLoader.JsonValue result;
//        for (JsonLoader.JsonPair pair : pairs) {
//            LogicDebug.debug("pair %s :%s", pair.key, pair.value);
//            if (pair.key.equals("type")) {
//                LogicDebug.debug("pair %s :%s", pair.key, pair.value.value);
//                /*
//                switch ((String)pair.value.value) {
//                    case "unit": type = IBehaviorUnit.TYPE.UNIT; break;
//                        case "sequence": type = IBehaviorUnit.TYPE.SEQUENCE; break;
//                        case "selector": type = IBehaviorUnit.TYPE.SELECTOR; break;
//                        case "parallel_sequence": type =  IBehaviorUnit.TYPE.PARALLEL_SEQUENCE; break;
//                        case "parallel_selector": type =  IBehaviorUnit.TYPE.PARALLEL_SELECTOR; break;
//                        case "probability": type =  IBehaviorUnit.TYPE.PROBABILITY; break;
//                        default:throw new UnexpectedBehaviorType((String)pair.value.value);
//                    }
//                    */
//            }
//            if (pair.key.equals("func")) {
//                func = ((String) pair.value.value);
//            }
//            if (pair.key.equals("list")) {
//                list = pair.value.list;
//            }
//            if (pair.key.equals("config")) {
//                config = pair.value;
//            }
//        }
//
//        // unit process
//        if (type == ILogicNode.TYPE.UNIT) {
//            IBehaviorFunction behaviorfunc = entity.getBehaviorFunc(func);
//            if (!(behaviorfunc instanceof IBehaviorFunction)) {
//                return null;
//            }
//            return null;
//
//        }
//
//        // list process
//        ArrayList<ILogicNode> behaviorArrayList = new ArrayList<>();
//        for (Object obj : list) {
//            ILogicNode unit = load(entity, (JsonLoader.JsonValue)obj);
//            if (unit == null) {
//                continue;
//            }
//            behaviorArrayList.add(unit);
//        }
//        ILogicNode[] behaviorList = new ILogicNode[][behaviorArrayList.size()];
//        behaviorArrayList.toArray(behaviorList);
//
//        // generate behavior unit according to type
//        switch (type) {
//            /*
//            case SEQUENCE: LogicDebug.debug("return sequence"); return new LogicSequence(behaviorList);
//            case SELECTOR: LogicDebug.debug("return selector"); return new LogicSequence(behaviorList);
//            case PARALLEL_SELECTOR: return new BehaviorParallelSelector(behaviorList);
//            case PARALLEL_SEQUENCE: return new BehaviorParallelSequence(behaviorList);
//            case PROBABILITY: return new BehaviorProbability(behaviorList, new float[behaviorList.length]);
//            default: throw new UnexpectedBehaviorType(type.toString());
//            */
//        }
//        return null;
    }
}
