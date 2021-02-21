package com.wu.demo;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/07
 * 参考文档地址：https://juejin.cn/post/6844903584027377677
 **/
public class NodeListSolution {
    private Node head = new Node();

    public void addNode(Integer value) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(value);
    }

    public void addNode(Integer value, Integer index) {
        Node temp = head;
        if (index < 1) {
            new RuntimeException("index过小");
        }
        boolean isFind = false;
        int curIndex = 0;
        while (temp.next != null) {
            curIndex++;
            if (curIndex == index) {
                Node oldNext = temp.next;
                Node newNode = new Node(value);
                temp.next = newNode;
                newNode.next = oldNext;
                isFind = true;
                break;
            }
            temp = temp.next;
        }
        if (!isFind && (curIndex + 1) == index) {
            temp.next = new Node(value);
        } else if (!isFind && (curIndex + 1) < index) {
            throw new RuntimeException("index过大");
        }

    }

    public void remove(Integer index) {
        Node temp = head;
        if (index < 1) {
            new RuntimeException("index过小");
        }
        int curIndex = 0;
        while (temp.next != null) {
            curIndex++;
            if (curIndex == index) {
                Node oldNext = temp.next;
                temp.next = oldNext.next;
                oldNext = null;
                break;
            }
            temp = temp.next;
        }
    }

    public Node reverse(Node head) {
        Node pNode = head.next;
        Node target = new Node(-1);
        while (pNode != null) {
            Node pNext = pNode.next;
            pNode.next = target.next;
            target.next = pNode;
            pNode = pNext;
        }
        return target;
    }

    public void getAll(Node node) {
        if (node.next != null) {
            Node next = node.next;
            getAll(next);
        }
        System.out.println("====" + node.value);
    }

    public void get(Integer index) {
        if (index < 1) {
            new RuntimeException("index过小");
        }
        Node temp = head;
        int curIndex = 0;
        while (temp.next != null) {
            curIndex++;
            if (curIndex == index) {
                Node node = temp.next;
                System.out.println("====" + node.value);
                break;
            }
            temp = temp.next;
        }
    }

    public void getLength() {
        Node temp = head;
        int curIndex = 0;
        while (temp.next != null) {
            curIndex++;
            temp = temp.next;
        }
        System.out.println(curIndex);
    }

    static class Node {
        private Integer value;
        private Node next;

        public Node() {
        }

        public Node(Integer value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        NodeListSolution nodeListSolution = new NodeListSolution();
        nodeListSolution.addNode(1);
        nodeListSolution.addNode(2);
        nodeListSolution.addNode(3);
        nodeListSolution.addNode(5, 4);
        nodeListSolution.addNode(6, 5);
        nodeListSolution.getAll(nodeListSolution.head.next);
        nodeListSolution.getLength();
      /*  nodeListSolution.remove(2);
        nodeListSolution.getAll(nodeListSolution.head.next);
        nodeListSolution.getLength();*/
        Node reverseNode = nodeListSolution.reverse(nodeListSolution.head);
        while (reverseNode.next != null) {
            Node next = reverseNode.next;
            System.out.println(next.value);
            reverseNode = next;
        }
    }
}
