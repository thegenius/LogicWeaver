package com.lvonce.persistent;

import com.lvonce.BehaviorDebug;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorFunction;
import com.lvonce.interfaces.IBehaviorNode;

/**
 * Created by WangWei on 2017/3/16.
 */
public class BehaviorDumper {
    public static String dump(IBehaviorEntity entity, IBehaviorNode unit) {
        /*
        IBehaviorUnit.TYPE type = unit.getType();
        BehaviorDebug.incLevel();
        String dumpString = "";
        switch (type) {
            case UNIT:
                IBehaviorFunction func = ((BehaviorUnit)unit).getFunc();
                dumpString = String.format("{\"type\":\"unit\", \"func\":\"%s\", \"config\":%s}", entity.getBehaviorName(func), "null");
                break;
            case SELECTOR:
                dumpString = "{ \"type\":\"selector\", \"list\":[";
                break;
            case SEQUENCE:
                dumpString = "{ \"type\":\"sequence\", \"list\":[";
                break;
            case PARALLEL_SELECTOR:
                BehaviorDebug.debug("PARALLEL_SELECTOR");
                break;
            case PARALLEL_SEQUENCE:
                BehaviorDebug.debug("PARALLEL_SEQUENCE");
                break;
            case PROBABILITY:
                BehaviorDebug.debug("PROBABILITY");
                break;
        }

        if (type != IBehaviorUnit.TYPE.UNIT) {
            BehaviorList list = (BehaviorList)unit;
            for (int i=0; i<list.list.length; ++i) {
                IBehaviorUnit u = list.list[i];
                if (i!=0) {
                    dumpString = dumpString.concat(",");
                }
                dumpString = dumpString.concat(dump(entity, u));
            }
        }

        if (type != IBehaviorUnit.TYPE.UNIT) {
            dumpString = dumpString.concat("]}");
        }

        return dumpString;
        */
        return null;
    }
}
