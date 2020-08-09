package com.lostsheep.technology.learning.binary.tree;

import java.util.Stack;

/**
 * <b><code>BinaryTree</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/30 18:07.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
public class BinaryTree {

    public static void main(String[] args) {
        Node a = Node.builder().value("A").build();
        Node b = Node.builder().value("B").build();
        Node c = Node.builder().value("C").build();
        Node d = Node.builder().value("D").build();
        Node e = Node.builder().value("E").build();
        Node f = Node.builder().value("F").build();
        Node g = Node.builder().value("G").build();
        
        a.setLeft(b);
        a.setRight(c);
        
        b.setLeft(d);
        b.setRight(e);
        
        c.setRight(f);
        
        e.setLeft(g);
        
        preOrder(a);
        System.out.println();
        
        midOrder(a);
        System.out.println();
        
        postOrder(a);
        System.out.println();
        
        stackOrder(a);
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static void midOrder(Node root) {
        if (root == null) {
            return;
        }
        
        midOrder(root.getLeft());
        System.out.print(root.getValue());
        midOrder(root.getRight());
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        
        postOrder(root.getLeft());
        postOrder(root.getRight());

        System.out.print(root.getValue());
    }

    private static void stackOrder(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            System.out.print(node.getValue());

            if (node.getRight() != null) {
                nodeStack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                nodeStack.push(node.getLeft());
            }
        }
    }
}
