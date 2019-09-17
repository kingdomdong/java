package Cha4Tree;

import Cha3ADT.MyArrayList;
import org.jetbrains.annotations.NotNull;

public class BuildPostfixTree {

    private static final String operatorPattern = "+*";

    private static MyArrayList<BinaryNode<Character>> stackList = new MyArrayList<>();

    private static BinaryNode<String> binaryNode;

    public BuildPostfixTree() {
        stackList = new MyArrayList<>();
    }

    public static BinaryNode<Character> build(@NotNull String ops) {
        for (int i = 0; i < ops.length(); i++) {
            Character c = ops.charAt(i);
            BinaryNode<Character> newNode = new BinaryNode<Character>(c);
            if (operatorPattern.contains(c.toString())) {
                newNode.left = stackList.get(stackList.size() - 2);
                newNode.right = stackList.get(stackList.size() - 1);
                stackList.set(stackList.size() - 2, newNode);
                stackList.remove(stackList.size() - 1);
            } else {
                stackList.add(newNode);
            }
        }

        return stackList.get(0);
    }

    public static void main(String[] args) {
        BinaryNode node = build("ab+cde+**");
        inorderPrint(node);
    }

    private static void inorderPrint(BinaryNode<?> node) {
        if (node == null) {
            return;
        }
        if (node.left != null)
            System.out.print("(");
        inorderPrint(node.left);
        System.out.print(" " + node.element + " ");
        inorderPrint(node.right);
        if (node.right != null)
            System.out.print(")");
    }

}
