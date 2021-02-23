package com.wu.demo;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/23
 **/
public class NodeListScen {
    private Node root;

    public void add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node next = root.next;
        if (next == null) {
            root.next = node;
            return;
        }
        while (next != null) {
            if (next.next == null) {
                next.next = node;
                break;
            }
            next = next.next;
        }
    }

    public Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node result = new Node(-1);
        while (node != null) {
            Node newNode = new Node(node.value);
            newNode.next = result.next;
            result.next = newNode;
            node = node.next;
        }
        return result;
    }

    /**
     * 旋转链表
     * https://leetcode-cn.com/problems/rotate-list/submissions/
     *
     * @param head
     * @param k
     * @return
     */
    public Node rotateRight(Node head, int k) {
        Node old_head = head;
        Node tail = head;
        int n = 1;
        for (; tail.next != null; n++) {
            tail = tail.next;
        }
        tail.next = head;
        Node target = old_head;
        for (int i = 0; i < n - k % n - 1; i++) {
            target = target.next;
        }
        Node newHead = target.next;
        target.next = null;
        return newHead;
    }

    /**
     * 返回倒数第 k 个节点
     * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
     *
     * @param node
     * @param k
     */
    public void kthToLast(Node node, int k) {
        if (node == null || k == 0) {
            return;
        }
        Node first = node;
        Node secode = node;
        int left = 0;
        int right = left + k - 1;
        while ((k = k - 1) > 0) {
            System.out.println("k=" + k);
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            secode = secode.next;
        }
        System.out.println("第k个结果为：" + secode.value);
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        NodeListScen nodeListScen = new NodeListScen();
        nodeListScen.add(1);
        nodeListScen.add(2);
        nodeListScen.add(3);
        nodeListScen.add(4);
        /*nodeListScen.add(5);
        nodeListScen.add(6);
        nodeListScen.add(7);
        nodeListScen.add(8);
        nodeListScen.add(9);
        nodeListScen.add(10);*/
//        nodeListScen.kthToLast(nodeListScen.root, 4);
//        Node newNode = nodeListScen.reverse(nodeListScen.root);
        Node newNode = nodeListScen.rotateRight(nodeListScen.root, 2);
        System.out.println(newNode.value);
    }
}
