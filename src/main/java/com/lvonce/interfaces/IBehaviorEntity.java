package com.lvonce.interfaces;

import java.lang.reflect.Field;
import com.lvonce.BehaviorDebug;
import com.lvonce.concepts.BehaviorList;
import com.lvonce.annotations.BehaviorActionNode;
import com.lvonce.containers.BehaviorNode;
import com.lvonce.containers.BehaviorParallel;
import com.lvonce.containers.BehaviorSequence;

public interface IBehaviorEntity {
    enum Builder {
        ;
        public static<C> IBehaviorNode genNode(Class entityClass, IBehaviorFunction func, C config) {
            Mapper.register(entityClass);
            return new BehaviorNode( BehaviorList.getInstance(entityClass).get(func), config);
        }
        public static IBehaviorNode genSequence(Class entityClass, IBehaviorNode[] nodes, int continueResult) {
            Mapper.register(entityClass);
            return new BehaviorSequence(nodes, continueResult);
        }
        public static IBehaviorNode genSequence(Class entityClass, IBehaviorNode[] nodes, int continueResult, float[] weights, int chooseCount) {
            Mapper.register(entityClass);
            return new BehaviorSequence(nodes, continueResult, weights, chooseCount);
        }
        public static IBehaviorNode genParallel(Class entityClass, IBehaviorNode[] nodes, int priorityIndex) {
            Mapper.register(entityClass);
            return new BehaviorParallel(nodes, priorityIndex);
        }
        public static IBehaviorNode genParallel(Class entityClass, IBehaviorNode[] nodes, int priorityIndex, float[] weights, int chooseCount) {
            Mapper.register(entityClass);
            return new BehaviorParallel(nodes, priorityIndex, weights, chooseCount);
        }
    }

    enum Mapper {
        ;
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
                            list.register(index, (IBehaviorFunction)func);
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
    }

    default IBehaviorNode genNode(IBehaviorFunction func, Object config) {
        return new BehaviorNode(this.getBehaviorIndex(func), config);
    }

    default IBehaviorNode genSequence(IBehaviorNode[] nodeList, int continueResult) {
        return new BehaviorSequence(nodeList, continueResult);
    }

    default IBehaviorNode genParallel(IBehaviorNode[] nodeList, int priorityIndex) {
        return new BehaviorParallel(nodeList, priorityIndex);
    }

    default IBehaviorFunction getBehaviorFunc(Integer index) {
        return BehaviorList.getInstance(this).get(index);
    }

    default Integer getBehaviorIndex(IBehaviorFunction func) {
        return BehaviorList.getInstance(this).get(func);
    }

    default void registerBehaviorFunctionList() {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            BehaviorList list = BehaviorList.getInstance(this);
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
                    Object func = field.get(this);
                    if (func instanceof IBehaviorFunction) {
                        list.register(index, (IBehaviorFunction)func);
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
}
