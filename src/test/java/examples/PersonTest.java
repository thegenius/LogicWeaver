package examples;

import com.lvonce.BehaviorDebug;
import org.junit.Test;
import com.lvonce.examples.Person;
import com.lvonce.examples.PersonLogic;
import com.lvonce.executors.BehaviorExecutor;
import com.lvonce.interfaces.IBehaviorEntity;
import com.lvonce.interfaces.IBehaviorNode;

import java.util.ArrayList;

public class PersonTest {
    @Test
    public void test() {
        IBehaviorEntity entity = new Person();
        IBehaviorNode logic = PersonLogic.getLogic();
        if (logic != null){
            BehaviorExecutor executor = new BehaviorExecutor(entity, logic);
            ArrayList<Integer> commandList = executor.runDebug();
            BehaviorDebug.debug("command list:%s", commandList.toString());
            commandList = executor.runDebug();
            BehaviorDebug.debug("command list:%s", commandList.toString());
        }
    }
}
