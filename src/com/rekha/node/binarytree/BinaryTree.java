package com.rekha.node.binarytree;

import com.rekha.node.Node;

public class BinaryTree {

    public int printElementsAtKDistance(Node node, Node targetNode, int k) {
        if (node == null || targetNode == null || k < 0) {
            return -1;
        }

        return printElementsAtKDistanceUtil(node, targetNode, k);
    }

    public int printElementsAtKDistanceUtil(Node node, Node targetNode, int k) {
        if(node == null) {
            return -1;
        }

        if(node == targetNode) {
            printNodesAtKDistanceFromParent(node, k);
            return 0;
        }

        int leftDist = printElementsAtKDistanceUtil(node.left, targetNode, k);

        if(leftDist != -1) {
            if(leftDist + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                printNodesAtKDistanceFromParent(node.right, k - 2 - leftDist);
            }

            return leftDist + 1;
        }

        int rightDist = printElementsAtKDistanceUtil(node.right, targetNode, k);

        if(rightDist != -1) {
            if(rightDist + 1 == k) {
                System.out.print(node.data + " ");
            } else {
                printNodesAtKDistanceFromParent(node.left, k - 2 - rightDist);
            }

            return rightDist + 1;
        }

        return -1;
    }

    public void printNodesAtKDistanceFromParent(Node node, int k) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.print(node.data + " ");
        }

        printNodesAtKDistanceFromParent(node.left, k - 1);
        printNodesAtKDistanceFromParent(node.right, k - 1);
    }

    public Node createNewNode(int val) {
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
}
