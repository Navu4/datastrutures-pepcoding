public class l003_ViewSum {
	public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

	
	// SUM ==================================================================

    // Vertical Order Sum 
    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        LinkedList<vPair> que = new LinkedList<>();
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        que.addLast(new vPair(root, Math.abs(minMax[0])));

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++)
            ans.add(null);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                vPair rp = que.removeFirst();
                int vl = rp.vl;
                TreeNode node = rp.node;

                ans.set(vl, ans.get(vl) + node.val);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;
    }

    // Vertical Sum
    // Using LinkedList 
    // Interview Impress Type of Question
    // Vertical Sum of a Binary Tree Using LinkedList 
    public static class Node{
        int val;
        Node prev, next;

        Node(int data){
            this.data = data;
            this.next = this.prev = null;
        }
    }

    public static void verticalSum(TreeNode root, Node node){
        if(root == null)
            return;
        
        node.val += root.val;
        if(root.left != null && node.prev == null)
            node.prev = new Node(0);
        verticalSum(root.left, node.prev);

        if(root.right != null && node.next == null)
            node.next = new Node(0);
        verticalSum(root.right, node.next);
    }

    public static ArrayList<Integer> verticalSum(TreeNode root){
        if(root == null )
            return new ArrayList<>();

        Node node = new Node(0);
        
        verticalSum(root, node);
        
        while(node.prev != null)
            node = node.prev;
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(node != null){
            ans.add(node.val);
            node = node.next;
        }
        
        return ans;
    }


    // Diagonal Order Sum 
    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        que.addLast(root);

        while (que.size() != 0) {
            int size = que.size();
            int sum = 0;
            while (size-- > 0) { // diagonal
                TreeNode node = que.removeFirst();
                while (node != null) { // clusters of diagonal
                    sum += node.val;
                    if (node.left != null)
                        que.addLast(node.left);
                    node = node.right;
                }
            }

            ans.add(sum);
        }

        return ans;
    }


    // Optimized and Impressive Approach 
    public static void diagonalOrderSum(TreeNode root, ListNode node) {
        node.data += root.val;
        if (root.left != null) {
            if (node.prev == null) {
                ListNode nnode = new ListNode(0);
                nnode.next = node;
                node.prev = nnode;
            }
            diagonalOrderSum(root.left, node.prev);
        }

        if (root.right != null) {
            diagonalOrderSum(root.right, node);
        }
    }

    public static void diagonalOrderSum(TreeNode node) {
        ListNode curr = new ListNode(0);
        diagonalOrderSum(node, curr);
    }
}