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
        final SimpleMicroBlogNode localBlogNode = new RepairTryLockMicroBlogNode("server-local");
        final SimpleMicroBlogNode otherBlogNode = new RepairTryLockMicroBlogNode("server-remote");
        final Update firstUpdate = new Update.Builder().author(new Author("Tom")).updateText("Tom Update").build();
        final Update secondUpdate = new Update.Builder().author(new Author("Jerry")).updateText("Jerry Update").build();
        new Thread(() ->
                localBlogNode.propagateUpdate(firstUpdate, otherBlogNode)
        ).start();
        new Thread(() ->
                otherBlogNode.propagateUpdate(secondUpdate, localBlogNode)
        ).start();
    }

}
