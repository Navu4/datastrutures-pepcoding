import java.util.ArrayList;
import java.util.LinkedList;


public class l003_ViewQuestion {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Level Order Traversal
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print(level + " -> ");

            ArrayList<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                TreeNode rNode = que.removeFirst();

                smallAns.add(rNode.val);
                System.out.println(rNode.val + " ");

                if (rNode.left != null)
                    que.addLast(rNode.left);

                if (rNode.right != null)
                    que.addLast(rNode.right);
            }

            ans.add(smallAns);
            level++;
        }

        return ans;
    }

    // Left View of Binary Tree
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            ans.add(que.getFirst().val);
            while (size-- > 0) {
                TreeNode rNode = que.removeFirst();

                if (rNode.left != null)
                    que.addLast(rNode.left);

                if (rNode.right != null)
                    que.addLast(rNode.right);
            }
        }

        return ans;
    }

    // Right View of Binary Tree
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            ans.add(que.getFirst().val);
            while (size-- > 0) {
                TreeNode rNode = que.removeFirst();

                if (rNode.right != null)
                    que.addLast(rNode.right);

                if (rNode.left != null)
                    que.addLast(rNode.left);
            }
        }

        return ans;
    }

    // ===========================================================================================


    // Vertical Order Set 

    // Width of a Binary Tree 
    public static void widthOfShadow(TreeNode root, int vl, int[] minMax){
        if(root == null)
            return;
            
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        
        
        widthOfShadow(root.left, vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);
    }

    public static int width(TreeNode root) {
        if(root == null )
            return 0;
       int[] minMax = new int[2];
       
       widthOfShadow(root, 0, minMax);
       int width = minMax[1] - minMax[0] + 1;
       return width;
    }


    public static class vPair{
        int vl; // vertical level
        TreeNode node;

        vPair(TreeNode node, int vl){
            this.vl = vl;
            this.node = node;
        }
    }

    // Vertical Order Traversal
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        int[] minMax = new int[2];

        widthOfShadow(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        for(int i = 0; i < len; i++){
            ans.add(new ArrayList<>());
        }

        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, Math.abs(minMax[0])));

        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                vPair rp = que.removeFirst();
                int vl = rp.vl;
                TreeNode node = rp.node;

                ans.get(vl).add(node.val);

                if(node.left != null)
                    que.addLast(new vPair(node.left, vl - 1));
                
                if(node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
                
            }
        }

        return ans;
    }


    // Bottom View 
    public static ArrayList<Integer> bottomView(TreeNode root) {
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

                ans.set(vl, node.val);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1))  ;
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;
    }

    // Top View 
    public static ArrayList<Integer> topView(TreeNode root) {
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

                if (ans.get(vl) == null)
                    ans.set(vl, node.val);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;
    }


    // Top View GFG
    // https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    static class vPair{
        int vl; // vertical level
        Node node;

        vPair(Node node, int vl){
            this.vl = vl;
            this.node = node;
        }
    }
    
    // Width of a Binary Tree 
    static void widthOfShadow(Node root, int vl, int[] minMax){
        if(root == null)
            return;
            
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        
        
        widthOfShadow(root.left, vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root){
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
                Node node = rp.node;

                if (ans.get(vl) == null)
                    ans.set(vl, node.data);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;
    }

    // Bottom View 
    // https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
    public class vPair{
        int vl; // vertical level
        Node node;

        vPair(Node node, int vl){
            this.vl = vl;
            this.node = node;
        }
    }
    
    // Width of a Binary Tree 
    public void widthOfShadow(Node root, int vl, int[] minMax){
        if(root == null)
            return;
            
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        
        
        widthOfShadow(root.left, vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);
    }
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root){
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
                Node node = rp.node;

                ans.set(vl, node.data);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1))  ;
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;
    }


    

    
    // ================================================================================


    // Diagonal Order Traversal
    public static ArrayList<ArrayList<Integer>> diagonalOrderTraversal(TreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        LinkedList<TreeNode> que = new LinkedList<>();

        que.addLast(root);
        while(que.size() != 0){
            int size = que.size();
            ArrayList<Ingeter> smallAns = new ArrayList<>();
            while(size-- > 0){                          // Diagonal
                TreeNode node = que.removeFirst();
                while(node != null){            // Cluster of diagonal
                    smallAns.add(node.val);
                    if(node.left != null)
                        que.addLast(node.left);
                    node = node.right;
                }
            }

            ans.add(smallAns);
        }

        return ans;
    }


    // https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1#
    public ArrayList<Integer> diagonal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        LinkedList<Node> que = new LinkedList<>();

        que.addLast(root);
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){    // Diagonal
                Node node = que.removeFirst();
                while(node != null){
                    ans.add(node.data);
                    if(node.left != null)
                        que.addLast(node.left);
                    node = node.right;
                }
            }

        }

        return ans;
    }


    // Anti-Diagonal Order Traversal
    public static ArrayList<ArrayList<Integer>> antiDiagonalOrder(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        que.addLast(root);

        while (que.size() != 0) {
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) { // diagonal
                TreeNode node = que.removeFirst();
                while (node != null) { // clusters of diagonal
                    smallAns.add(node.val);
                    if (node.right != null)
                        que.addLast(node.right);
                    node = node.left;
                }
            }

            ans.add(smallAns);
        }

        return ans;
    }




}
