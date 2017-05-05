package com.lvonce.concepts;

import java.util.HashMap;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorFunction;

public class BehaviorList {
    private static final HashMap<String, BehaviorList> globalMap = new HashMap<>();
    private final HashMap<Integer, IBehaviorFunction> indexFuncMap;
    private final HashMap<IBehaviorFunction, Integer> funcIndexMap;

    public static BehaviorList getInstance(IBehaviorEntity obj) {
        String scope = obj.getClass().getName();
        if (!globalMap.containsKey(scope)){
            globalMap.put(scope, new BehaviorList());
            obj.registerBehaviorFunctionList();
        }
        return globalMap.get(scope);
    }

    public static BehaviorList getInstance(Class clazz) {
        String scope = clazz.getName();
        if (!globalMap.containsKey(scope)){
            globalMap.put(scope, new BehaviorList());
        }
        return globalMap.get(scope);
    }

    public static boolean hasInstance(Class clazz) {
        String scope = clazz.getName();
        return globalMap.containsKey(scope);
    }

    private BehaviorList(){
        indexFuncMap = new HashMap();
        funcIndexMap = new HashMap();
    };

    public void register(Integer index, IBehaviorFunction function) {
        indexFuncMap.put(index, function);
        funcIndexMap.put(function, index);
    }

    public boolean has(Integer index) {
        return indexFuncMap.containsKey(index);
    }

    public boolean has(IBehaviorFunction func) {
        return funcIndexMap.containsKey(func);
    }

    public IBehaviorFunction get(Integer index) {
        return indexFuncMap.get(index);
    }

    public Integer get(IBehaviorFunction func) {
        return funcIndexMap.get(func);
    }
}
