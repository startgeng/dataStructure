package com.kevin.datastructure.chapter10;

/**
 * 二分搜索树
 * @author kevin
 * @version 1.0
 * @date 2021-02-09 16:27
 */
public class BST <E extends Comparable> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;
    public int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

//    public void add(E e){
//        if (root == null){
//            root = new Node(e);
//        }else {
//            add(root,e);
//        }
//    }

    //以node为根的为二分搜索树添加元素
//    private void add(Node root, E e) {
//        //如果节点相等
//        if (e.equals(root.e)){
//            return;
//        }
//        //如果左边的节点大
//        else if (e.compareTo(root.e) < 0 && root.left == null){
//            root.left = new Node(e);
//            size++;
//            return;
//        }else if (e.compareTo(root.e) > 0 && root.right == null){
//            root.right = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(root.e) < 0){
//            add(root.left,e);
//        }else if (e.compareTo(root.e) > 0){
//            add(root.right,e);
//        }
//    }
    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
}
