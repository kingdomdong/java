package main.java.com.java7developer.chaper4;

/**
 * client for lock
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2020-05-15 14:46:09
 */
public class DeadLockClient {

    public static void main(String[] args) {
        final Listing_4_1_1_SimpleMicroBlogNode localBlogNode = new Listing_4_6_RepairTryLockMicroBlogNode("server-local");
        final Listing_4_1_1_SimpleMicroBlogNode otherBlogNode = new Listing_4_6_RepairTryLockMicroBlogNode("server-remote");
        final Listing_4_3_Update firstUpdate = new Listing_4_3_Update.Builder().author(new Author("Tom")).updateText("Tom Update").build();
        final Listing_4_3_Update secondUpdate = new Listing_4_3_Update.Builder().author(new Author("Jerry")).updateText("Jerry Update").build();
        new Thread(() ->
                localBlogNode.propagateUpdate(firstUpdate, otherBlogNode)
        ).start();
        new Thread(() ->
                otherBlogNode.propagateUpdate(secondUpdate, localBlogNode)
        ).start();
    }

}
