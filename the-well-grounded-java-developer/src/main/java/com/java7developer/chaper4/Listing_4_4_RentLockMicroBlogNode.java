package main.java.com.java7developer.chaper4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Listing_4_4_RentLockMicroBlogNode implements Listing_4_1_1_SimpleMicroBlogNode {
    private final String identifier;
    private final Lock lock = new ReentrantLock();

    public Listing_4_4_RentLockMicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void propagateUpdate(Listing_4_3_Update update, Listing_4_1_1_SimpleMicroBlogNode secondBlogNode) {
        lock.lock();
        try {
            // break point here will lead to dead lock
            System.out.println(identifier + ": received: " + update.getUpdateText() + ", simpleMicroBlogNode identifier: " + secondBlogNode.getIdentifier());
            secondBlogNode.confirmUpdate(this, update);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean confirmUpdate(Listing_4_1_1_SimpleMicroBlogNode secondBlogNode, Listing_4_3_Update update) {
        lock.lock();
        try {
            System.out.println(identifier + ": received confirm: " + update.getUpdateText() + " from " + secondBlogNode.getIdentifier());
        } finally {
            lock.unlock();
        }
        return true;
    }

}
