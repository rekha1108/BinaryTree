package com.rekha.node.binarytreeapp;

import com.rekha.node.Node;
import com.rekha.node.binarytree.BinaryTree;

public class BinaryTreeApp {


    public static void main(String[] args) {

        BinaryTree a = new BinaryTree();

        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(9);
        root.right.right = a.createNewNode(3);
        root.left.left = a.createNewNode(10);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);

        int elements = a.printElementsAtKDistance(root, root.left, 2);

        if(elements == -1) {
            System.out.println("No elements found");
        }
    }
}
