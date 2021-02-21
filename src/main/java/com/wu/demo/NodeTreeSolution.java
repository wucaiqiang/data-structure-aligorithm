package com.wu.demo;

/**
 * description:TODO
 *
 * @author simpson
 * @create 2021/02/08
 **/
public class NodeTreeSolution {
    private Node root = null;

    public void add(Integer value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            if (current.value == value) {
                System.out.println("value 已经存在。value=" + value);
                return;
            } else if (value < current.value) {
                parent = current;
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = node;
                    return;
                }
            } else if (value > current.value) {
                parent = current;
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = node;
                    return;
                }
            }
        }
    }

    public Node get(Integer value) {
        Node result = null;
        Node current = root;
        while (true) {
            if (current.value == value) {
                result = current;
                break;
            } else if (value < current.value) {
                current = current.leftChild;
                if (current == null) {
                    break;
                }
            } else if (value > current.value) {
                current = current.rightChild;
                if (current == null) {
                    break;
                }
            }
        }
        if (result == null) {
            throw new RuntimeException("未找到");
        }
        return result;
    }

    public void headIterator(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        headIterator(node.leftChild);
        headIterator(node.rightChild);
    }

    public void midIterator(Node node) {
        if (node == null) {
            return;
        }
        midIterator(node.leftChild);
        System.out.println(node.value);
        midIterator(node.rightChild);
    }

    public void tailIterator(Node node) {
        if (node == null) {
            return;
        }
        tailIterator(node.leftChild);
        tailIterator(node.rightChild);
        System.out.println(node.value);
    }

    public void delete(int value) {
        boolean isFind = false;
        boolean isLeft = true;
        Node current = root;
        Node parent = null;
        while (true) {
            if (current.value == value) {
                isFind = true;
                break;
            } else if (value < current.value) {
                parent = current;
                current = current.leftChild;
                isLeft = true;
                if (current == null) {
                    break;
                }
            } else {
                parent = current;
                current = current.rightChild;
                isLeft = false;
                if (current == null) {
                    break;
                }
            }
        }
        if (!isFind) {
            throw new RuntimeException("节点不存在");
        }
       /* if (current == root) {
            root = null;
        }*/
        if (current.leftChild == null && current.rightChild == null) {
            if (isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.leftChild == null) {
            if (isLeft) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.rightChild == null) {
            if (isLeft) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else {
            Node succer = getSuccerNode(current);
            if (parent == null) {
                root = succer;
                return;
            }
            if (isLeft) {
                parent.leftChild = succer;
            } else {
                parent.rightChild = succer;
            }
        }
    }

    public Node getSuccerNode(Node node) {
        Node current = node.rightChild;
        Node parent = null;
        while (true) {
            if (current.leftChild == null) {
                break;
            }
            parent = current;
            current = current.leftChild;
        }
        if (current.rightChild != null) {
            parent.leftChild = current.rightChild;
        } else {
            parent.leftChild = null;
        }
        current.rightChild = node.rightChild;
        current.leftChild = node.leftChild;
        return current;
    }

    static class Node {
        private Integer value;
        private Node leftChild;
        private Node rightChild;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        NodeTreeSolution nodeTreeSolution = new NodeTreeSolution();
        nodeTreeSolution.add(10);
        nodeTreeSolution.add(8);
        nodeTreeSolution.add(15);
        nodeTreeSolution.add(5);
        nodeTreeSolution.add(3);
        nodeTreeSolution.add(6);
        nodeTreeSolution.add(1);
        nodeTreeSolution.add(4);
        nodeTreeSolution.add(2);
        nodeTreeSolution.add(7);
        nodeTreeSolution.add(9);
        nodeTreeSolution.add(13);
        nodeTreeSolution.add(11);
        nodeTreeSolution.add(12);
        nodeTreeSolution.add(14);
        nodeTreeSolution.add(17);
        nodeTreeSolution.add(16);
        nodeTreeSolution.add(18);

//        nodeTreeSolution.midIterator(nodeTreeSolution.root);
//        nodeTreeSolution.headIterator(nodeTreeSolution.root);
//        nodeTreeSolution.tailIterator(nodeTreeSolution.root);
//        Node node = nodeTreeSolution.get(17);
//        System.out.println(node.value);
//        nodeTreeSolution.delete(2);
//        nodeTreeSolution.delete(10);
        nodeTreeSolution.delete(15);
        nodeTreeSolution.midIterator(nodeTreeSolution.root);
    }
}
