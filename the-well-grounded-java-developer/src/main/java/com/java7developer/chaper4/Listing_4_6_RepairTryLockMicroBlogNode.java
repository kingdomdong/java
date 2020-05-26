package main.java.com.java7developer.chaper4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * repair try lock node
 * @author kingdomdong
 * @since 2020-05-18 10:45:39
 * @version 1.0
 */
public class Listing_4_6_RepairTryLockMicroBlogNode implements Listing_4_1_1_SimpleMicroBlogNode {
    private final String identifier;
    private final Lock lock;
    private boolean done;

    public Listing_4_6_RepairTryLockMicroBlogNode(String identifier) {
        this.identifier = identifier;
        lock = new ReentrantLock();
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void propagateUpdate(Listing_4_3_Update update, Listing_4_1_1_SimpleMicroBlogNode blogNode) {
        boolean acquire = false;
        while (!done) {
            int wait = (int) (Math.random() * 10);
            try {
                acquire = lock.tryLock(wait, TimeUnit.MICROSECONDS);
                if (acquire) {
                    Listing_4_2_DeadLockMicroBlogNode.printBlogUpdate(update, identifier);
                    done = blogNode.confirmUpdate(this, update);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (acquire) {
                    lock.unlock();
                }
            }
            if (!done) {
                try {
                    Thread.sleep(wait); // let other threads interfere with this object's lock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean confirmUpdate(Listing_4_1_1_SimpleMicroBlogNode blogNode, Listing_4_3_Update update) {
        boolean acquire = false;
        int wait = (int) (Math.random() * 10);
        try {
            acquire = lock.tryLock(wait, TimeUnit.MILLISECONDS);
            if (acquire) {
                Listing_4_2_DeadLockMicroBlogNode.printBlogConfirm(blogNode, update, identifier);
                return true;
            } else {
                System.out.println(identifier + " CONFIRM() " + "确认更新的动作发生失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (acquire) {
                lock.unlock();
            }
        }
        return false;
    }

}
