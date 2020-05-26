package main.java.com.java7developer.chaper4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Listing_4_5_TryLockWithDrawbackMicroBlogNode implements Listing_4_1_1_SimpleMicroBlogNode {

    private final String identifier;
    private final Lock lock = new ReentrantLock();

    public Listing_4_5_TryLockWithDrawbackMicroBlogNode(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void propagateUpdate(Listing_4_3_Update update, Listing_4_1_1_SimpleMicroBlogNode secondBlogNode) {
        boolean acquired = false;
        while (!acquired) {
            try {
                int wait = (int) (Math.random() * 10);
                acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
                if (acquired) {
                    Listing_4_2_DeadLockMicroBlogNode.printBlogUpdate(update, identifier);
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
    public boolean confirmUpdate(Listing_4_1_1_SimpleMicroBlogNode secondBlogNode, Listing_4_3_Update update) {
        boolean acquired = false;
        try {
            int wait = (int) (Math.random() * 10);
            acquired = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if (acquired) {
                Listing_4_2_DeadLockMicroBlogNode.printBlogConfirm(secondBlogNode, update, identifier);
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
