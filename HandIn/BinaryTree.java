package com.company;

class BinaryTree {
    private Node root;
    private int StringCounter;
    //adding an element
    void add(String value) {
        root = addRecursive(root, value);
    }
    private Node addRecursive(Node current, String value) {
        if (current == null) {
            return new Node(value);
        }
        if (value.compareToIgnoreCase(current.value) <= 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareToIgnoreCase(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }
    //searching for an element
    int countNode(String value){
        StringCounter = 0;
        countNodeRecursive(root,value);
        return StringCounter;
    }
    private void countNodeRecursive(Node current, String value) {
        if (current != null) {
            if (value.compareToIgnoreCase(current.value)>0){
                countNodeRecursive(current.right, value);
            } else {
                if (value.compareToIgnoreCase(current.value)==0){
                    StringCounter++;
                }
                countNodeRecursive(current.left, value);
            }
        }
    }
    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
}
class Node {
    String value;
    Node left;
    Node right;

    Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }
}