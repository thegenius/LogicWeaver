package com.lvonce.logicweaver.builders;

import com.lvonce.logicweaver.LogicDebug;
import com.lvonce.logicweaver.annotations.LogicAction;
import com.lvonce.logicweaver.composites.LogicCountDecorator;
import com.lvonce.logicweaver.composites.LogicNegtiveDecorator;
import com.lvonce.logicweaver.composites.LogicRandomChooser;
import com.lvonce.logicweaver.concepts.LogicList;
import com.lvonce.logicweaver.concepts.LogicResult;
import com.lvonce.logicweaver.containers.LogicNode;
import com.lvonce.logicweaver.containers.LogicParallel;
import com.lvonce.logicweaver.containers.LogicSequence;
import com.lvonce.logicweaver.interfaces.ILogicChooser;
import com.lvonce.logicweaver.interfaces.ILogicFunction;
import com.lvonce.logicweaver.interfaces.ILogicNode;

import java.lang.reflect.Field;

public class LogicWeaver {

    public static void register(Class clazz) {
        if (LogicList.hasInstance(clazz)) {
            return;
        }
        try {
            Field[] fields = clazz.getDeclaredFields();
            LogicList list = LogicList.getInstance(clazz);
            for (int i=0; i<fields.length; ++i) {
                Field field = fields[i];
                if (field.isAnnotationPresent(LogicAction.class)) {
                    LogicAction filedAnnotation = field.getAnnotation(LogicAction.class);
                    int index = filedAnnotation.index();
                    if (list.has(index)) {
                        LogicDebug.warning("duplicate index of behavior action[%d], old action will be override, now is %s", index, field.getName());
                    }
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    Object func = field.get(null);
                    if (func instanceof ILogicFunction) {
                        list.register(clazz, (ILogicFunction)func, index);
                    }
                    field.setAccessible(accessible);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LogicWeaver defineStart(Class entityClass) {
        register(entityClass);
        return new LogicWeaver();
    }

    public static ILogicChooser genRandomChooser(float[] weights, int chooseCount) {
        return new LogicRandomChooser(weights, chooseCount);
    }

    public static ILogicNode genCountNode(ILogicNode node, int countLimit, LogicResult finished) {
        return new LogicCountDecorator(node, countLimit, finished);
    }

    public static ILogicNode genNegtiveNode(ILogicNode node) {
        return new LogicNegtiveDecorator(node);
    }

    public static <C>ILogicNode genNode(ILogicFunction func, C config) {
        func.getClass().getAnnotations();
        Class clazz = LogicList.getFuncOwnerClass(func);
        return new LogicNode(LogicList.getInstance(clazz).get(func), config);
    }

    public static ILogicNode genSequence(ILogicNode[] nodes, int continueResult) {
        return new LogicSequence(nodes, continueResult);
    }
    public static  ILogicNode genSequence(ILogicNode[] nodes, int continueResult, float[] weights, int chooseCount) {
        return new LogicSequence(nodes, continueResult, weights, chooseCount);
    }

    public static ILogicNode genSequenceTrue(ILogicNode ...nodes) {
        return new LogicSequence(nodes, ILogicNode.RESULT.TRUE.value);
    }

    public static ILogicNode genSequenceTrue(ILogicChooser chooser, ILogicNode...nodes) {
        return new LogicSequence(nodes, ILogicNode.RESULT.TRUE.value, chooser);
    }

    public static ILogicNode genSequenceFalse(ILogicNode ...nodes) {
        return new LogicSequence(nodes, ILogicNode.RESULT.FALSE.value);
    }

    public static ILogicNode genSequenceFalse(ILogicChooser chooser, ILogicNode...nodes) {
        return new LogicSequence(nodes, ILogicNode.RESULT.FALSE.value, chooser);
    }

    public static  ILogicNode genParallel(ILogicNode[] nodes, int priorityIndex) {
        return new LogicParallel(nodes, priorityIndex);
    }

    public static  ILogicNode genParallel(ILogicNode[] nodes, int priorityIndex, float[] weights, int chooseCount) {
        return new LogicParallel(nodes, priorityIndex, weights, chooseCount);
    }

    public static  ILogicNode genParallelAnd(ILogicNode ...nodes) {
        return new LogicParallel(nodes, 0);
    }

    public static  ILogicNode genParallelAnd(ILogicChooser chooser, ILogicNode ...nodes) {
        return new LogicParallel(nodes, 0, chooser);
    }

    public static  ILogicNode genParallelOr(ILogicNode ...nodes) {
        return new LogicParallel(nodes, 1);
    }

    public static  ILogicNode genParallelOr(ILogicChooser chooser, ILogicNode ...nodes) {
        return new LogicParallel(nodes, 1, chooser);
    }
}
