package para3ADT;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int modCount = 0;
    private int theSize; // valid item size
    private AnyType[] theItems; // current items

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        modCount++;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException("get() method called");
        }

        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        AnyType oldVal = get(idx);
        theItems[idx] = newVal;

        return oldVal;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) {
            return;
        }
        AnyType[] oldItems = theItems;
        theItems = (AnyType[]) new Object[newCapacity]; // need to grasp
        for (int i = 0; i < size(); i++) {
            theItems[i] = oldItems[i];
        }
    }

    public boolean add(AnyType x) {
        add(size(), x);

        return true;
    }

    public void add(int idx, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size(); i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;

        theSize++;
        modCount++;
    }

    public AnyType remove(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException("remove(int) method called");
        }
        AnyType oldVal = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        modCount++;

        return oldVal;
    }

    public void print() {
        Iterator<AnyType> iterator = iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("End");
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType> {

        private int current = 0;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            if (current < size()) {
                return true;
            }

            return false;
        }

        @Override
        public AnyType next() {
            if (expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException("ArrayListIterator::next()");
            } else if (!hasNext()) {
                throw new java.util.NoSuchElementException("ArrayListIterator::next() method");
            }
            okToRemove = true;

            return theItems[current++];
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException("ArrayListIterator::remove()");
            } else if (!okToRemove) {
                throw new IllegalStateException("ArrayListIterator::remove()");
            }

            MyArrayList.this.remove(--current);

            okToRemove = false;
        }

    }

    public static void main(String[] args) {
        MyArrayList<Integer> myLinkedList = new MyArrayList<>();
        myLinkedList.add(8);
        myLinkedList.add(5);
        myLinkedList.add(3);
        myLinkedList.add(9);
        myLinkedList.add(0);
        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(6);
        myLinkedList.add(3);
        myLinkedList.add(1);

        myLinkedList.print();

        myLinkedList.remove(2);
        myLinkedList.print();
        myLinkedList.add(2, -1);
        myLinkedList.print();
    }
}
