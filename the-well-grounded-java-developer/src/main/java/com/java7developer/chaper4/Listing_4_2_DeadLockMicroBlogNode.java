package main.java.com.java7developer.chaper4;

public class Listing_4_2_DeadLockMicroBlogNode implements Listing_4_1_1_SimpleMicroBlogNode {

    private final String identifier;

    public Listing_4_2_DeadLockMicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public synchronized void propagateUpdate(Listing_4_3_Update update, Listing_4_1_1_SimpleMicroBlogNode microBlogNode) {
        printBlogUpdate(update, identifier);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        microBlogNode.confirmUpdate(this, update);
    }

    @Override
    public synchronized boolean confirmUpdate(Listing_4_1_1_SimpleMicroBlogNode microBlogNode, Listing_4_3_Update update) {
        printBlogConfirm(microBlogNode, update, identifier);
        return true;
    }

    public static void printBlogUpdate(Listing_4_3_Update update, String identifier) {
        System.out.println(identifier + ": UPDATE: " + update.getUpdateText() + "调用成功");
    }

    public static void printBlogConfirm(Listing_4_1_1_SimpleMicroBlogNode microBlogNode, Listing_4_3_Update update, String identifier) {
        System.out.println(identifier + ": CONFIRM: " + update.getUpdateText() + " from " + microBlogNode.getIdentifier() + "调用成功");
    }

}
