package algorithm.treeProblem;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/11/4 8:56
 */
public class CalTreeDepth {
    public static int calDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftLength = calDepth(treeNode.left);
            int rightLength = calDepth(treeNode.right);
            return Math.max(leftLength, rightLength) + 1;
        }
    }
}
