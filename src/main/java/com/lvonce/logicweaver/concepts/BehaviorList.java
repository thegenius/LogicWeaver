package com.lvonce.logicweaver.concepts;

import java.util.HashMap;

import com.lvonce.logicweaver.interfaces.IBehaviorFunction;

public class BehaviorList {
    private static final HashMap<String, BehaviorList> globalMap = new HashMap<>();
    private static final HashMap<IBehaviorFunction, Class> globalFuncClassMap = new HashMap<>();
    private final HashMap<Integer, IBehaviorFunction> indexFuncMap;
    private final HashMap<IBehaviorFunction, Integer> funcIndexMap;

    public static BehaviorList getInstance(Object obj) {
        String scope = obj.getClass().getName();
        return getInstance(scope);
    }

    public static BehaviorList getInstance(Class clazz) {
        String scope = clazz.getName();
        return getInstance(scope);
    }

    public static BehaviorList getInstance(String className) {
        String scope = className;
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

    public void register(Class clazz, IBehaviorFunction function, Integer index) {
        globalFuncClassMap.put(function, clazz);
        indexFuncMap.put(index, function);
        funcIndexMap.put(function, index);
    }

    public static Class getFuncOwnerClass(IBehaviorFunction function) {
        return globalFuncClassMap.get(function);
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
