public class l006_avl {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        int height = 0;
        int bal = 0;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // =========================================================

    // Updating the height and balance factor of the Node/Tree
    public static void updateHeightBalance(TreeNode root) {
        int lh = root.left != null ? root.left.height : -1; // if left == null then height is -1 => why -1? bcoz height
                                                            // is calculated in terms of edges
        int rh = root.right != null ? root.right.height : -1;

        root.height = Math.max(lh, rh) + 1;
        root.bal = lh - rh;
    }

    // Right-Right Rotation
    public static TreeNode rightRotation(TreeNode A) {
        TreeNode B = A.left;
        TreeNode BKaRight = B.right;

        B.right = A;
        A.left = BKaRight;

        updateHeightBalance(A);
        updateHeightBalance(B);

        return B;
    }

    // Left-Left Rotation
    public static TreeNode leftRotation(TreeNode A) {
        TreeNode B = A.right;
        TreeNode BKaLeft = B.left;

        B.left = A;
        A.right = BKaLeft;

        updateHeightBalance(A);
        updateHeightBalance(B);

        return B;
    }

    public static TreeNode getRotated(TreeNode root) {
        updateHeightBalance(root);

        if (root.bal == 2) { // ll , lr
            if (root.left.bal == 1) { // ll
                // Right-Right rotation
                return rightRotation(root);  

            } else { // lr-rotation

                root.left = leftRotation(root.left);
                return rightRotation(root);

            }

        } else if (root.bal == -2) { // rr , rl
            if (root.right.bal == -1) { // rr tree 
                // Left-left rotation
                return leftRotation(root);

            } else { // rl-rotation

                root.right = rightRotation(root.right);   // right-rotation
                return leftRotation(root);   // left rotation

            }
        }

        return root;
    }

    // =========================================================

    // Add/Insert Node In BST
    public static TreeNode add(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val < val)
            root.right = add(root.right, val);
        else
            root.left = add(root.left, val);

        root = getRotated(root);
        return root;
    }

    public int maximum(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.val;
    }

    // Delete Node in BST
    public TreeNode removeNode(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val < val)
            root.right = removeNode(root.right, val);
        else if (root.val > val)
            root.left = removeNode(root.left, val);
        else {
            if (root.left == null || root.right == null)
                return root.left != null ? root.left : root.right;

            int maxData = maximum(root.left);
            root.val = maxData;
            root.left = removeNode(root.left, maxData);
        }

        root = getRotated(root);
        return root;
    }

    // =========================================================

    // O(n)
    public static void display(TreeNode node) {
        if (node == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }


}
