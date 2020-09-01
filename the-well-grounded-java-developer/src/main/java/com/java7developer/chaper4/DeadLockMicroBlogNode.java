package main.java.com.java7developer.chaper4;

public class DeadLockMicroBlogNode implements SimpleMicroBlogNode {

    private final String identifier;

    public DeadLockMicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public synchronized void propagateUpdate(Update update, SimpleMicroBlogNode microBlogNode) {
        printBlogUpdate(update, identifier);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        microBlogNode.confirmUpdate(this, update);
    }

    @Override
    public synchronized boolean confirmUpdate(SimpleMicroBlogNode microBlogNode, Update update) {
        printBlogConfirm(microBlogNode, update, identifier);
        return true;
    }

    public static void printBlogUpdate(Update update, String identifier) {
        System.out.println(identifier + ": UPDATE: " + update.getUpdateText() + "调用成功");
    }

    public static void printBlogConfirm(SimpleMicroBlogNode microBlogNode, Update update, String identifier) {
        System.out.println(identifier + ": CONFIRM: " + update.getUpdateText() + " from " + microBlogNode.getIdentifier() + "调用成功");
    }

}
