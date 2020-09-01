package main.java.com.java7developer.chaper4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentLockMicroBlogNode implements SimpleMicroBlogNode {
    private final String identifier;
    private final Lock lock = new ReentrantLock();

    public RentLockMicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void propagateUpdate(Update update, SimpleMicroBlogNode secondBlogNode) {
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
    public boolean confirmUpdate(SimpleMicroBlogNode secondBlogNode, Update update) {
        lock.lock();
        try {
            System.out.println(identifier + ": received confirm: " + update.getUpdateText() + " from " + secondBlogNode.getIdentifier());
        } finally {
            lock.unlock();
        }
        return true;
    }

}
