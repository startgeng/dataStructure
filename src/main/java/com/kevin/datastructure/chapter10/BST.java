package com.kevin.datastructure.chapter10;


import java.util.Stack;

/**
 * 二分搜索树
 * @author kevin  吹你吹过的晚风,那我们是不是算相拥
 * @version 1.0
 * @date 2021-02-09 16:27
 */
public class BST <E extends Comparable> {

    private class Node{
        public Node right,left;
        public E e;

        public Node(E e){
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    public Node root;
    public int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    //是否包含元素
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if (node == null){
            return false;
        }
        if (node.e.compareTo(e) == 0){
            return true;
        }else if (node.e.compareTo(e) < 0){
            return contains(node.left,e);
        }else if (node.e.compareTo(e) > 0){
            return contains(node.right,e);
        }
        return false;
    }

    /**
     *
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后续遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索数的非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is Empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E maxnum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is EMPTY");
        }
        return maxnum(root).e;
    }

    private Node maxnum(Node node) {
        if (node.right == null){
            return node;
        }
        return minimum(node.right);
    }
}
