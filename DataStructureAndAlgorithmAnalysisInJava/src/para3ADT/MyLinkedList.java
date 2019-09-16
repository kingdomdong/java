package para3ADT;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        beginMaker = new Node<AnyType>(null, null, null);
        endMaker = new Node<AnyType>(null, beginMaker, null);
        beginMaker.next = endMaker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(AnyType x) {
        add(size(), x);

        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        Node<AnyType> node = getNode(idx);
        AnyType oldVal = node.data;
        node.data = newVal;

        return oldVal;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }

    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher.
     *
     * @param p Node to add before
     * @param x any object
     * @throws IndexOutOfBoundsException if idx is not between 0 and size().
     */
    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;

        theSize++;
        modCount++;
    }

    /**
     * Removes the object contained in Node p.
     *
     * @param p the Node containing the object
     * @return the item was removed from the collection.
     */
    private AnyType remove(Node<AnyType> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;

        theSize--;
        modCount++;

        return p.data;
    }

    /**
     * Gets the Node at position idx, which must range from 0 to size() - 1.
     *
     * @param idx index to search at.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size() - 1, inclusive.
     */
    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the node at position idx, which must range from lower to upper.
     *
     * @param idx   index to search at
     * @param lower lowest valid index.
     * @param upper upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not between lower and upper, inclusive.
     */
    private Node<AnyType> getNode(int idx, int lower, int upper) {
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException("getNode(int) method");
        }
        Node<AnyType> cursor;
        if (idx < size() / 2) {
            cursor = beginMaker.next;
            for (int i = 0; i < idx; i++) {
                cursor = cursor.next;
            }
        } else {
            cursor = endMaker;
            for (int i = size(); i > idx; i--) {
                cursor = cursor.prev;
            }
        }

        return cursor;
    }

    public void print() {
        Iterator<AnyType> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.remove();
            System.out.print(iterator.next() + " ");
        }

        System.out.println("End");
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<AnyType> {

        public AnyType data;
        public Node prev;
        public Node next;

        public Node(AnyType d, Node p, Node n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private class LinkedListIterator implements Iterator<AnyType> {

        private Node<AnyType> current = beginMaker.next;

        private int expectedModCount = modCount;

        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMaker;
        }

        @Override
        public AnyType next() {
            if (expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException("LinkedListIterator::next() method");
            } else if (!hasNext()) {
                throw new java.util.NoSuchElementException("LinkedListIterator::next() method");
            }

            AnyType nextItem = current.data;
            okToRemove = true;
            current = current.next;

            return nextItem;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new java.util.ConcurrentModificationException("LinkedListIterator::remove()");
            } else if (!okToRemove) { // base on next() node
                throw new IllegalStateException("LinkedListIterator::remove()");
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

/*    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
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
    }*/

}
