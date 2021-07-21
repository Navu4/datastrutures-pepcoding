public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)    
            return 0;
        if(root.left == null && root.right == null)   
            return 0;
    }

    public int sumTotal(TreeNode root){
        if (node == null)
            return null;
        if (node.left == null && node.right == null)
            return null;

        node.left = sumTotal(node.left);
        node.right = sumTotal(node.right);
        return node;
    }
}
