package com.lvonce;

import com.lvonce.concepts.BehaviorResult;
import com.lvonce.interfaces.IBehaviorNode;
import com.lvonce.interfaces.IBehaviorStatus;
import com.lvonce.containers.BehaviorSequence;

/**
 * Created by WangWei on 2017/3/13.
 */
public class PersonBehaviorDef {
    
    /*
    * sequence : {
    *   sequence : {
    *       supplier1,
    *       supplier3,
    *       supplier4
    *   },
    *   selector : {
    *       supplier2,
    *       supplier4,
    *       supplier3
    *   },
    *   supplier1,
    *   supplier2,
    *   supplier3,
    *   supplier4
    * }
    * */
    public static IBehaviorNode generate(Person person) {

//        IBehaviorUnit unit1 = new BehaviorUnit(person.supplier1, null);
//        IBehaviorUnit unit2 = new BehaviorUnit(person.supplier2, null);
//        IBehaviorUnit unit3 = new BehaviorUnit(person.supplier3, null);
//        IBehaviorUnit unit4 = new BehaviorUnit(person.supplier4, null);
//
//        IBehaviorUnit[] behaviorList1  = {unit1, unit3, unit3};
//        IBehaviorUnit listUnit1 = new BehaviorSequence(behaviorList1, BehaviorResult.TRUE);
//
//        IBehaviorUnit[] behaviorList2  = {unit2, unit4, unit4};
//        IBehaviorUnit listUnit2 = new BehaviorSequence(behaviorList2, BehaviorResult.FALSE);
//
//        IBehaviorUnit[] list  = {listUnit1, unit1, unit3, listUnit2};
//        BehaviorSequence behavior = new BehaviorSequence(list, BehaviorResult.TRUE);
//        return behavior;
        return null;
    }



}
























