package com.kevin.datastructure.test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜素数,三种遍历方式
 * @author kevin
 * @version 1.0
 * @date 2021-03-04 11:24
 */
public class MyBst {

    //TreeNode
    private class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    //前序遍历
    public void preOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public void inOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    public void postOrderTraverl(TreeNode node){
        if (node == null){
            return;
        }
        postOrderTraverl(node.leftChild);
        postOrderTraverl(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 构建二叉树
     * @return
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树的非递归前序遍历
     */
    public void prevOrderTraveWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || stack.isEmpty()){
            //迭代访问左节点并且入栈
            while (treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果左边没有元素,就弹出节点,访问右孩子
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.leftChild != null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null){
                queue.offer(node.rightChild);
            }
        }
    }
}
