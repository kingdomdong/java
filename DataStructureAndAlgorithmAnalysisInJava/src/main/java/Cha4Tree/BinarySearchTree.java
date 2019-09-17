package Cha4Tree;

import java.util.Comparator;

public class BinarySearchTree<AnyType> {

    private BinaryNode<AnyType> root;

    private Comparator<AnyType> cmp;

    public BinarySearchTree(Comparator<AnyType> c) {
        this.cmp = c;
    }

    private Integer myCompare(AnyType lhs, AnyType rhs) {
        //FIXME null
        return cmp.compare(lhs, rhs);
    }

    public void makeEmpty() {
        root = null;
    };

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        return findMin(root);
    }

    public AnyType findMax() {
        return findMax(root);
    }

    public void insert(AnyType x) {
        insert(x, root);
    }

    public void remove(AnyType x) {
        remove(x, root);
    }

    public void printTree() {

    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (myCompare(x, t.element) > 0) {
            return contains(x, t.right);
        } else if (myCompare(x, t.element) < 0) {
            return contains(x, t.left);
        } else {
            return true;
        }
    }

    private AnyType findMin(BinaryNode<AnyType> t) {
        BinaryNode<AnyType> tRoot = t;
        AnyType min = tRoot.element;
        while ((tRoot = tRoot.left) != null) {
            min = tRoot.element;
        }

        return min;
    }

    private AnyType findMax(BinaryNode<AnyType> t) {
        BinaryNode<AnyType> tRoot = t;
        AnyType max = tRoot.element;
        while (tRoot.right != null) {
            max = tRoot.element;
        }

        return max;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t);

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t);

    private void printTree(BinaryNode<AnyType> t);

}
