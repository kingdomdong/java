package main.java.com.java7developer.chaper4;

import java.util.HashMap;
import java.util.Map;

/**
 * complete synchronous class
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-15 13:50:08
 */
public class ExampleTimingNode implements SimpleMicroBlogNode {

    private final String identifier;
    private Map<Update, Long> arrivalTime = new HashMap<>();

    public ExampleTimingNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public synchronized String getIdentifier() {
        return identifier;
    }

    @Override
    public synchronized void propagateUpdate(Update update, SimpleMicroBlogNode simpleMicroBlogNode) {
        long currentTimeMillis = System.currentTimeMillis();
        arrivalTime.put(update, currentTimeMillis);
    }

    @Override
    public synchronized boolean confirmUpdate(SimpleMicroBlogNode simpleMicroBlogNode, Update update) {
        Long timeMillis = arrivalTime.get(update);
        System.out.println("Receive confirm: " + update.getUpdateText() + "from " + simpleMicroBlogNode.getIdentifier());
        return true;
    }

}
