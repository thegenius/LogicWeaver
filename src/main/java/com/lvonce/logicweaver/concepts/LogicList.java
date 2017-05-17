package com.lvonce.logicweaver.concepts;

import java.util.HashMap;

import com.lvonce.logicweaver.interfaces.ILogicFunction;

public class LogicList {
    private static final HashMap<String, LogicList> globalMap = new HashMap<>();
    private static final HashMap<ILogicFunction, Class> globalFuncClassMap = new HashMap<>();
    private final HashMap<Integer, ILogicFunction> indexFuncMap;
    private final HashMap<ILogicFunction, Integer> funcIndexMap;

    public static LogicList getInstance(Object obj) {
        String scope = obj.getClass().getName();
        return getInstance(scope);
    }

    public static LogicList getInstance(Class clazz) {
        String scope = clazz.getName();
        return getInstance(scope);
    }

    public static LogicList getInstance(String className) {
        String scope = className;
        if (!globalMap.containsKey(scope)){
            globalMap.put(scope, new LogicList());
        }
        return globalMap.get(scope);
    }

    public static boolean hasInstance(Class clazz) {
        String scope = clazz.getName();
        return globalMap.containsKey(scope);
    }

    private LogicList(){
        indexFuncMap = new HashMap();
        funcIndexMap = new HashMap();
    };

    public void register(Class clazz, ILogicFunction function, Integer index) {
        globalFuncClassMap.put(function, clazz);
        indexFuncMap.put(index, function);
        funcIndexMap.put(function, index);
    }

    public static Class getFuncOwnerClass(ILogicFunction function) {
        return globalFuncClassMap.get(function);
    }
    public boolean has(Integer index) {
        return indexFuncMap.containsKey(index);
    }

    public boolean has(ILogicFunction func) {
        return funcIndexMap.containsKey(func);
    }

    public ILogicFunction get(Integer index) {
        return indexFuncMap.get(index);
    }

    public Integer get(ILogicFunction func) {
        return funcIndexMap.get(func);
    }
}
