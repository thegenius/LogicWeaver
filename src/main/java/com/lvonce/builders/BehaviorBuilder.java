package com.lvonce.builders;

import com.lvonce.BehaviorDebug;
import com.lvonce.annotations.BehaviorActionNode;
import com.lvonce.composites.BehaviorCountDecorator;
import com.lvonce.composites.BehaviorNegtiveDecorator;
import com.lvonce.composites.BehaviorRandomChooser;
import com.lvonce.concepts.BehaviorList;
import com.lvonce.concepts.BehaviorResult;
import com.lvonce.containers.BehaviorNode;
import com.lvonce.containers.BehaviorParallel;
import com.lvonce.containers.BehaviorSequence;
import com.lvonce.interfaces.IBehaviorChooser;
import com.lvonce.interfaces.IBehaviorFunction;
import com.lvonce.interfaces.IBehaviorNode;

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
