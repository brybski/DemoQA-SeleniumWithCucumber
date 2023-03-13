package Utilities;

import Enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    /*
    Scenario Context is a class that holds the test data information specifically. It actually uses the Test Context to travel the information between various steps.
    Within this ScenarioContext class, you can create any number of fields to store any form of data.
    It stores the information in the key-value pair and again, value can be of any type. It can store String, Boolean, Integer or maybe a Class.
    Also, the important point here is that the information which we store in the Scenario Context is generated run time.
    Means during the run if you wish to store some information, you will use Scenario Context.
     */

    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}