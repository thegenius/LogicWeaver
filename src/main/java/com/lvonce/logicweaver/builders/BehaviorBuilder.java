package com.lvonce.logicweaver.builders;

import com.lvonce.logicweaver.BehaviorDebug;
import com.lvonce.logicweaver.annotations.BehaviorActionNode;
import com.lvonce.logicweaver.composites.BehaviorCountDecorator;
import com.lvonce.logicweaver.composites.BehaviorNegtiveDecorator;
import com.lvonce.logicweaver.composites.BehaviorRandomChooser;
import com.lvonce.logicweaver.concepts.BehaviorList;
import com.lvonce.logicweaver.concepts.BehaviorResult;
import com.lvonce.logicweaver.containers.BehaviorNode;
import com.lvonce.logicweaver.containers.BehaviorParallel;
import com.lvonce.logicweaver.containers.BehaviorSequence;
import com.lvonce.logicweaver.interfaces.IBehaviorChooser;
import com.lvonce.logicweaver.interfaces.IBehaviorFunction;
import com.lvonce.logicweaver.interfaces.IBehaviorNode;

import java.lang.reflect.Field;

public class BehaviorBuilder {

    public static void register(Class clazz) {
        if (BehaviorList.hasInstance(clazz)) {
            return;
        }
        try {
            Field[] fields = clazz.getDeclaredFields();
            BehaviorList list = BehaviorList.getInstance(clazz);
            for (int i=0; i<fields.length; ++i) {
                Field field = fields[i];
                if (field.isAnnotationPresent(BehaviorActionNode.class)) {
                    BehaviorActionNode filedAnnotation = field.getAnnotation(BehaviorActionNode.class);
                    int index = filedAnnotation.index();
                    if (list.has(index)) {
                        BehaviorDebug.warning("duplicate index of behavior action[%d], old action will be override, now is %s", index, field.getName());
                    }
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    Object func = field.get(null);
                    if (func instanceof IBehaviorFunction) {
                        list.register(clazz, (IBehaviorFunction)func, index);
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

    public static BehaviorBuilder defineStart(Class entityClass) {
        register(entityClass);
        return new BehaviorBuilder();
    }

    public static IBehaviorChooser genRandomChooser(float[] weights, int chooseCount) {
        return new BehaviorRandomChooser(weights, chooseCount);
    }

    public static IBehaviorNode genCountNode(IBehaviorNode node, int countLimit, BehaviorResult finished) {
        return new BehaviorCountDecorator(node, countLimit, finished);
    }

    public static IBehaviorNode genNegtiveNode(IBehaviorNode node) {
        return new BehaviorNegtiveDecorator(node);
    }

    public static <C>IBehaviorNode genNode(IBehaviorFunction func, C config) {
        func.getClass().getAnnotations();
        Class clazz = BehaviorList.getFuncOwnerClass(func);
        return new BehaviorNode(BehaviorList.getInstance(clazz).get(func), config);
    }

    public static IBehaviorNode genSequence(IBehaviorNode[] nodes, int continueResult) {
        return new BehaviorSequence(nodes, continueResult);
    }
    public static  IBehaviorNode genSequence(IBehaviorNode[] nodes, int continueResult, float[] weights, int chooseCount) {
        return new BehaviorSequence(nodes, continueResult, weights, chooseCount);
    }

    public static IBehaviorNode genSequenceTrue(IBehaviorNode ...nodes) {
        return new BehaviorSequence(nodes, IBehaviorNode.RESULT.TRUE.value);
    }

    public static IBehaviorNode genSequenceTrue(IBehaviorChooser chooser, IBehaviorNode...nodes) {
        return new BehaviorSequence(nodes, IBehaviorNode.RESULT.TRUE.value, chooser);
    }

    public static IBehaviorNode genSequenceFalse(IBehaviorNode ...nodes) {
        return new BehaviorSequence(nodes, IBehaviorNode.RESULT.FALSE.value);
    }

    public static IBehaviorNode genSequenceFalse(IBehaviorChooser chooser, IBehaviorNode...nodes) {
        return new BehaviorSequence(nodes, IBehaviorNode.RESULT.FALSE.value, chooser);
    }

    public static  IBehaviorNode genParallel(IBehaviorNode[] nodes, int priorityIndex) {
        return new BehaviorParallel(nodes, priorityIndex);
    }

    public static  IBehaviorNode genParallel(IBehaviorNode[] nodes, int priorityIndex, float[] weights, int chooseCount) {
        return new BehaviorParallel(nodes, priorityIndex, weights, chooseCount);
    }

    public static  IBehaviorNode genParallelAnd(IBehaviorNode ...nodes) {
        return new BehaviorParallel(nodes, 0);
    }

    public static  IBehaviorNode genParallelAnd(IBehaviorChooser chooser, IBehaviorNode ...nodes) {
        return new BehaviorParallel(nodes, 0, chooser);
    }

    public static  IBehaviorNode genParallelOr(IBehaviorNode ...nodes) {
        return new BehaviorParallel(nodes, 1);
    }

    public static  IBehaviorNode genParallelOr(IBehaviorChooser chooser, IBehaviorNode ...nodes) {
        return new BehaviorParallel(nodes, 1, chooser);
    }
}
