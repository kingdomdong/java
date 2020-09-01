package main.java.com.java7developer.chaper4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithDrawbackMicroBlogNode implements SimpleMicroBlogNode {

    private final String identifier;
    private final Lock lock = new ReentrantLock();

    public TryLockWithDrawbackMicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void propagateUpdate(Update update, SimpleMicroBlogNode secondBlogNode) {
        boolean acquired = false;
        while (!acquired) {
            try {
                int wait = (int) (Math.random() * 10);
                acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
                if (acquired) {
                    DeadLockMicroBlogNode.printBlogUpdate(update, identifier);
                    secondBlogNode.confirmUpdate(this, update);
                } else {
                    Thread.sleep(wait);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (acquired) {
                    lock.unlock();
                }
            }
        }
    }

    @Override
    public boolean confirmUpdate(SimpleMicroBlogNode secondBlogNode, Update update) {
        boolean acquired = false;
        try {
            int wait = (int) (Math.random() * 10);
            acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if (acquired) {
                DeadLockMicroBlogNode.printBlogConfirm(secondBlogNode, update, identifier);
            } else {
                Thread.sleep(wait);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (acquired) {
                lock.unlock();
            }
        }
        return true;
    }

}
