import java.util.LinkedList;

public class l005_TreeConstructor {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // BST Construction
    // BST has a special Range for each element
    // This range will always helf us to construct BST

    // InOrder Construction of BST
    public static TreeNode constructFromInOrder(int[] inOrder, int i, int j) {
        if (i > j) // IMPORTANT BASE CASE : Yadh rkhna jruri hai
            return null;

        int mid = (i + j) / 2;
        TreeNode root = new TreeNode(inOrder[mid]);

        root.left = constructFromInOrder(inOrder, i, mid - 1);
        root.right = constructFromInOrder(inOrder, mid + 1, j);

        return root;
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {

        int i = 0;
        int j = inOrder.length - 1;
        return constructFromInOrder(inOrder, i, j);

    }

    // PreOrder Constructor in Binary Tree
    public static int idx = 0;

    public static TreeNode bstFromPreorder(int[] preorder, int leftRange, int rightRange) {
        if (idx == preorder.length || preorder[idx] < leftRange || preorder[idx] > rightRange)
            return null;

        TreeNode root = new TreeNode(preorder[idx++]);

        root.left = bstFromPreorder(preorder, leftRange, root.val);
        root.right = bstFromPreorder(preorder, root.val, rightRange);

        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, -(int) 1e9, (int) 1e9);
    }

    // PostOrder Constructor in Binary Tree
    public static int idx = 0;

    public static TreeNode bstFromPostorder(int[] preorder, int leftRange, int rightRange) {
        if (idx == -1 || preorder[idx] < leftRange || preorder[idx] > rightRange)
            return null;

        TreeNode root = new TreeNode(preorder[idx--]);

        root.right = bstFromPostorder(preorder, root.val, rightRange);
        root.left = bstFromPostorder(preorder, leftRange, root.val);

        return root;
    }

    public static TreeNode bstFromPostorder(int[] preorder) {
        idx = preorder.length - 1;
        return bstFromPostorder(preorder, -(int) 1e9, (int) 1e9);
    }

    // BST using Level Order Traversal
    public static class bstLPair {
        TreeNode par = null;
        int lr = 0;
        int rr = 0;

        bstLPair(TreeNode par, int lr, int rr) {
            this.par = par;
            this.lr = lr;
            this.rr = rr;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        if (LevelOrder.length == 0)
            return null;

        LinkedList<bstPair> que = new LinkedList<>();

        TreeNode root = new TreeNode(LevelOrder[0]);
        int idx = 1;

        que.addLast(new bstPair(root, -(int) 1e9, root.val));
        que.addLast(new bstPair(root, root.val, (int) 1e9));

        while (idx != LevelOrder.length) {
            bstPair rp = que.removeFirst();
            int lr = rp.lr, rr = rp.rr;
            
            if (LevelOrder[idx] < lr || LevelOrder[idx] > rr)
                continue;

            TreeNode node = new TreeNode(LevelOrder[idx++]);
            if (node.val < rp.par.val)
                rp.par.left = node;
            else
                rp.par.right = node;

            que.addLast(new bstPair(node, rp.lr, node.val));
            que.addLast(new bstPair(node, node.val, rp.rr));

        }
        return root;
    }

    // ==============================================================

    // Binary Tree Construction

    // Pre and In order
    public static TreeNode preOrIn(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei || isi > iei)
            return null;

        int idx = psi;
        while (inorder[idx] != preorder[psi])
            idx++;

        int tel = idx - isi;
        TreeNode root = new TreeNode(preorder[psi]);

        root.left = preOrIn(preorder, psi + 1, psi + tel, inorder, isi, idx - 1);
        root.left = preOrIn(preorder, psi + tel + 1, pei, inorder, idx + 1, iei);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length - 1;
        return preOrIn(preorder, 0, n, inorder, 0, n);
    }

    // Post and In Order
    public static TreeNode postOrIn(int[] post, int psi, int pei, int[] in, int isi, int iei) {
        if (isi > iei)
            return null;
        int idx = isi;
        while (in[idx] != post[pei])
            idx++;

        int tel = idx - isi;
        TreeNode root = new TreeNode(post[pei]);

        root.left = postOrIn(post, psi, psi + tel - 1, in, isi, idx - 1);
        root.right = postOrIn(post, psi + tel, pei - 1, in, idx + 1, iei);

        return root;
    }

    // Pre and Post Order
    public static TreeNode preOrPost(int[] pre, int psi, int pei, int[] post, int osi, int oei) {
        if (psi > pei)
            return null;

        TreeNode root = new TreeNode(pre[psi]);
        if (psi == pei)
            return root;

        int idx = osi;
        while (post[idx] != pre[psi + 1])
            idx++;

        int tel = idx - osi;

        root.left = preOrPost(pre, psi + 1, psi + tel + 1, post, osi, idx);
        root.right = preOrPost(pre, psi + tel + 2, pei, post, idx + 1, oei - 1);

        return root;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length - 1;
        return preOrPost(pre, 0, n, post, 0, n);
    }


    public TreeNode constructFromPrePost(int[] pre, int psi, int pei, int[] post, int ppsi, int ppei) {
        if (psi > pei)
            return null;

        TreeNode root = new TreeNode(pre[psi]);
        if (psi == pei)
            return root;

        int idx = ppsi;
        while (post[idx] != pre[psi + 1])
            idx++;

        int tnel = idx - ppsi + 1;

        root.left = constructFromPrePost(pre, psi + 1, psi + tnel, post, ppsi, idx);
        root.right = constructFromPrePost(pre, psi + tnel + 1, pei, post, idx + 1, ppei - 1);

        return root;
    }

    // Construct Binary Tree from Level Order and InOrder Traversal
    // https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1
     Node buildTree(int inord[], int isi, int iei, int level[], int lsi, int lei){
        if(isi > iei)
            return null;

        Node root = new Node(level[lsi]);
        if(isi == iei)   // Special Check for Single Element 
            return root;
            
        int idx = isi;
        while(root.data != inord[idx])
            idx++;

        HashSet<Integer> setLeft = new HashSet<>();        
        HashSet<Integer> setRight = new HashSet<>();

        for(int i = isi; i <= iei; i++){
            if(i < idx){
                setLeft.add(inord[i]);
            } else if(i > idx){
                setRight.add(inord[i]);
            }
        }

        int[] leftLevel = new int[setLeft.size()];
        int[] rightLevel = new int[setRight.size()];
        int j = 0;
        int k = 0;

        for(int i = lsi + 1; i <= lei; i++){
            if(setLeft.contains(level[i])){
                leftLevel[j++] = level[i];
            } else {
                rightLevel[k++] = level[i];
            }   
        }

        root.left = buildTree(inord, isi, idx - 1, leftLevel, 0, leftLevel.length - 1);
        root.right = buildTree(inord, idx + 1, iei, rightLevel, 0, rightLevel.length - 1);

        return root;
    }

    Node buildTree(int inord[], int level[]){
        return buildTree(inord, 0, inord.length - 1, level, 0 , level.length - 1);
    }


}
