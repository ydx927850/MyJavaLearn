package algorithm.treeProblem;
import java.util.*;

import sun.reflect.generics.tree.Tree;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/6 15:52
 */
public class Traverse {
    public static void main(String[] args) {
        TreeNode exampleTree = TreeNode.getExampleTree();
        System.out.println("前序遍历:");
        frontTraverse(exampleTree);
        System.out.println();
        frontTraverse2(exampleTree);
        System.out.println();
        frontTraverse3(exampleTree);
        System.out.println();
        System.out.println("中序遍历:");
        midTraverse(exampleTree);
        System.out.println();
        midTraverse2(exampleTree);
        System.out.println();
        System.out.println("后续遍历:");
        backTraverse(exampleTree);
        System.out.println();
        backTravers(exampleTree);
        System.out.println();
        System.out.println("层次遍历:");
        levelTraverse(exampleTree);

    }

    /**
     * 前序遍历
     */
    public static void frontTraverse(TreeNode node) {
        if (node != null) {
            System.out.print(node.val);
            frontTraverse(node.left);
            frontTraverse(node.right);
        }
    }

    /**
     * 前序遍历
     */
    public static void frontTraverse2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 前序遍历
     */
    public static void frontTraverse3(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     */
    public static void midTraverse(TreeNode node) {
        if (node != null) {
            midTraverse(node.left);
            System.out.print(node.val);
            midTraverse(node.right);
        }
    }

    public static void midTraverse2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public static void backTraverse(TreeNode node) {
        if (node != null) {
            backTraverse(node.left);
            backTraverse(node.right);
            System.out.print(node.val);
        }
    }

    public static void backTravers(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        TreeNode pre = null;
        TreeNode cur = null;
        while(!stack.isEmpty()){
            cur = stack.peek();
            if((cur.left == null && cur.right == null) || (pre!=null && cur.right == pre)){
                System.out.print(cur.val);
                stack.pop();
                pre = cur;
            }else{
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void levelTraverse(TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.val);
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }
        }
    }

    public static List<List<Integer>> levelTraverse2(TreeNode treeNode){
        List<List<Integer>> res = new ArrayList<>();
        if(treeNode==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }


}
