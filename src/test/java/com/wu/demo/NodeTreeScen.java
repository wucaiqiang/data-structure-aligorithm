package com.wu.demo;

import org.junit.Test;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/24
 **/
public class NodeTreeScen {
    private Node root;

    @Test
    public void test() {
        System.out.println(Math.abs(-8));
        System.out.println(Math.abs(8));
        int i = 5;
        System.out.println(i++);
        System.out.println(++i);
    }

    public void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        }
        Node parent = root, current = root;
        while (true) {
            if (value == current.value) {
                System.out.println("已经存在");
                return;
            } else if (value < current.value) {
                parent = current;
                current = current.left;
                if (current == null) {
                    parent.left = node;
                    return;
                }
            } else {
                parent = current;
                current = current.right;
                if (current == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    /**
     * 二叉搜索树的第k大节点
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
     *
     * @param
     * @param
     * @return
     */
    private int result = 0, k;

    public int kthLargest(Node root, int k) {
        this.k = k;
        recursive(root);
        return result;
    }

    public int recursive(Node node) {
        if (node == null) {
            return 0;
        }
        int rt = recursive(node.right);
        if (rt == -1) {
            return -1;
        }
        if ((k = k - 1) == 0) {
            result = node.value;
            return -1;
        }
        int rt1 = recursive(node.left);
        if (rt1 == -1) {
            return -1;
        }
        return 1;
    }

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        NodeTreeScen nodeListScen = new NodeTreeScen();
        nodeListScen.add(5);
        nodeListScen.add(3);
        nodeListScen.add(6);
        nodeListScen.add(2);
        nodeListScen.add(4);
        nodeListScen.add(1);
        System.out.println(nodeListScen.kthLargest(nodeListScen.root, 3));
    }
}
