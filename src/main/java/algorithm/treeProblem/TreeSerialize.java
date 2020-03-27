package algorithm.treeProblem;

import util.MyUtil;

public class TreeSerialize {
    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#!");
            return sb.toString();
        }
        sb.append(root.val).append("!");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.substring(0,sb.length());
    }

    static int index = -1;
    static TreeNode deserialize(String str) {
        index++;
        String[] split = str.split("!");
        TreeNode node = null;
        if(!split[index].equals("#")){
            node = new TreeNode(Integer.parseInt(split[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        String serialize = serialize(TreeNode.getExampleTree());
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        Traverse.frontTraverse(deserialize);
    }
}
