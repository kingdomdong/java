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
public class Listing_4_1_ExampleTimingNode implements Listing_4_1_1_SimpleMicroBlogNode {

    private final String identifier;
    private Map<Listing_4_3_Update, Long> arrivalTime = new HashMap<>();

    public Listing_4_1_ExampleTimingNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public synchronized String getIdentifier() {
        return identifier;
    }

    @Override
    public synchronized void propagateUpdate(Listing_4_3_Update update, Listing_4_1_1_SimpleMicroBlogNode simpleMicroBlogNode) {
        long currentTimeMillis = System.currentTimeMillis();
        arrivalTime.put(update, currentTimeMillis);
    }

    @Override
    public synchronized boolean confirmUpdate(Listing_4_1_1_SimpleMicroBlogNode simpleMicroBlogNode, Listing_4_3_Update update) {
        Long timeMillis = arrivalTime.get(update);
        System.out.println("Receive confirm: " + update.getUpdateText() + "from " + simpleMicroBlogNode.getIdentifier());
        return true;
    }

}
