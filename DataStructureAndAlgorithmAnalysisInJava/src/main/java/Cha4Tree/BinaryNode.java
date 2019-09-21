package Cha4Tree;

public class BinaryNode<AnyType> {

    public BinaryNode() {
    }

    public BinaryNode(AnyType element) {
		this(element, null, null);
	}

    BinaryNode(AnyType element, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
    	this.element = element;
    	this.left = lt;
    	this.right = rt;
	}

    // Friendly data;
    // accessible by other package routines
    AnyType element;    // The data in the node
    BinaryNode<AnyType> left;    // Left node
    BinaryNode<AnyType> right;    // Right node

}