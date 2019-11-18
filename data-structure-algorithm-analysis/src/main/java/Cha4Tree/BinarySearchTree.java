package Cha4Tree;

import auxiliary.UnderflowException;

import java.util.Comparator;

public class BinarySearchTree<AnyType> {

    private BinaryNode<AnyType> root;

    private Comparator<AnyType> cmp;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<AnyType> c) {
        root = null;
        this.cmp = c;
    }

    private Integer myCompare(AnyType lhs, AnyType rhs) {
        if (cmp != null) {
            return cmp.compare(lhs, rhs);
        }

        return ((Comparable) lhs).compareTo(rhs);
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty()) {
            throw new UnderflowException("tree is empty");
        }

        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty()) {
            throw new UnderflowException("tree is empty");
        }

        return findMax(root).element;
    }

    public void insert(AnyType x) {
        insert(x, root);
    }

    public void remove(AnyType x) {
        remove(x, root);
    }

    public void printTree() {
        printTree(root);
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is the item to search for.
     * @param t the node that roots the subtree.
     * @return true if the item is found; false otherwise.S
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
//        if (t == null) {
//            return false;
//        }
//
//        if (myCompare(x, t.element) > 0) {
//            return contains(x, t.right);
//        } else if (myCompare(x, t.element) < 0) {
//            return contains(x, t.left);
//        } else {
//            return true;
//        }

        while (t != null) {
            if (myCompare(x, t.element) > 0) {
                t = t.right;
            } else if (myCompare(x, t.element) < 0) {
                t = t.left;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }

        while (t.left != null) {
            t = t.left;
        }

        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }

        while (t.right != null) {
            t = t.right;
        }

        return t;
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<AnyType>(x, null, null);
        }
        while (t != null) {
            if (cmp.compare(t.element, x) > 0) {
                t = t.left;
            } else if (cmp.compare(t.element, x) < 0) {
                t = t.right;
            } else {
                break;
            }
        }
        if (t != null) {
            BinaryNode<AnyType> newNode = new BinaryNode<>(x, null, t.right);
            t.right = newNode;
        } else {
            t = new BinaryNode<AnyType>(x, null, null);
        }

        return t;
    }

    private BinaryNode<AnyType> recurseInsert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }

        Integer cmpResult = cmp.compare(x, t.element);

        if (cmpResult > 0) {
            t.right = insert(x, t.right);   //  t.right just for return
        } else if (cmpResult < 0) {
            t.left = insert(x, t.left);
        } else {
            ;   //  Duplicate; do nothing
        }

        return t; // t.left, t.right work
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        BinaryNode<AnyType> tRoot = t;
        while (tRoot != null) {
            if (cmp.compare(tRoot.element, x) > 0) {
                tRoot = tRoot.left;
            } else if (cmp.compare(tRoot.element, x) < 0) {
                tRoot = tRoot.right;
            } else {
                if (tRoot.right == null) {
                    tRoot = tRoot.left;
                } else {
                    tRoot = tRoot.right;
                }
            }
        }

        return t;
    }

    private void printTree(BinaryNode<AnyType> t) {
        // in order print
        while (t != null) {
            printTree(t.left);
            System.out.print(" " + t.element + " ");
            printTree(t.right);
        }
    }

}
