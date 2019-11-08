package algorithm.treeProblem;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/1 10:53
 */
public class TreeNode {
    protected int val;
    protected TreeNode left;
    protected TreeNode right;
    TreeNode(int x){
        this.val = x;
    }

    public static TreeNode getExampleTree(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        return t1;
    }
}
