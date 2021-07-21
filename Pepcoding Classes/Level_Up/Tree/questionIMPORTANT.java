public class question {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


	// IMPORTANT QUESTION
	// Leetcode 124. Binary Tree Maximum Path Sum

	public static class Pair{
		int NTNMaxSum = -(int)1e9;
		int LTNMaxSum = -(int)1e9;

		Pair(){}

		Pair(int a, int b){
			this.NTNMaxSum = a;
			this.LTNMaxSum = b;
		}
	}

	public static int maxValue(int... arr){
		int maxEle = arr[0];
		for(int ele : arr){
			maxEle = Math.max(ele, maxEle);
		}

		return maxEle;
	}

	public static Pair maxPathSum_(TreeNode root) {
        if(root == null){
        	return new Pair();
        }


        if(root.left == null && root.right == null){
        	return new Pair(root.val, root.val);
        }

        Pair lp = maxPathSum_(root.left);
        Pair rp = maxPathSum_(root.right);
    	
    	Pair myAns = new Pair();
    	int leafToNodeMaxSum = maxValue(lp.LTNMaxSum, rp.LTNMaxSum) + root.val;
    	myAns.NTNMaxSum = maxValue(root.val, lp.NTNMaxSum , rp.NTNMaxSum,
    							 root.val + lp.LTNMaxSum + rp.LTNMaxSum, leafToNodeMaxSum);

    	myAns.LTNMaxSum = maxValue(root.val, leafToNodeMaxSum);
    	return myAns;
    }

	public static int maxPathSum(TreeNode root) {
        Pair ans = maxPathSum_(root);
        return ans.NTNMaxSum;
    }

    // ============================================================




    // IMPORTANT QUESTION 
    // Leetcode 968. Binary Tree Cameras

    // 3 States
    // -1 : Camera Required
    // 0 : Already Covered
    // 1 : I'm a Camera

	public int minCameraCover(TreeNode root, int[] cameraCount) {
    	if(root == null)
    		return 0;	    

    	int lr = minCameraCover(root.left, cameraCount);
    	int rr = minCameraCover( root.right, cameraCount);


    	if(lr == -1 || rr == -1){
    		cameraCount[0]++;
    		return 1;
    	}

    	if(lr == 1 || rr == 1)
    		return 0;

    	return -1;
    }

    public int minCameraCover(TreeNode root) {
    	if(root == null)
    		return 0;

    	int[] cameraCount = new int[]{0};
    	int ans = minCameraCover(root, cameraCount);
    	if(ans == -1)
    		cameraCount[0]++;

    	return cameraCount[0];	    
    }


	// ============================================================




    // Leetcode 337. House Robber III
    // {with robbery, without robbery}
    public int[] rob_(TreeNode root) {
        if(root == null)
        	return new int[2];


        int[] lr = rob_(root.left);
        int[] rr = rob_(root.right);

        int[] myAns = new int[2];
        myAns[0] = lr[1] + rr[1] + root.val;
        myAns[1] = Math.max(lr[0], lr[1]) + Math.max(rr[0], rr[1]);

        return myAns;
    }

    public int rob(TreeNode root) {
    	int[] ans = rob_(root);
        return Math.max(ans[0], ans[1]);
    }


	// ============================================================


	// MOST IMPORTANT QUESTION 
	// Count number of Binary Search Tree present in a Binary Tree
	// https://www.geeksforgeeks.org/count-the-number-of-binary-search-trees-present-in-a-binary-tree/
	
	public static class isBST {
		int min = -(int) 1e9;
		int max = (int) 1e9;

		int bstCount = 0;
		boolean isBst = true;

		isBST() {
		}

		isBST(int min, int max, int bstCount, boolean isBst) {
			this.min = min;
			this.max = max;
			this.bstCount = bstCount;
			this.isBst = isBst;
		}
	}

	public static isBST countBSTinBinaryTree(TreeNode root) {
		if (root == null) {
			return new isBST((int) 1e9, -(int) 1e9, 0, true);
		}

		if (root.left == null && root.right == null) {
			return new isBST(root.val, root.val, 1, true);
		}

		isBST Left = countBSTinBinaryTree(root.left);
		isBST Right = countBSTinBinaryTree(root.right);

		isBST myAns = new isBST();
		myAns.min = Math.min(root.val, Math.min(Left.min, Right.min));
		myAns.max = Math.max(root.val, Math.max(Left.max, Right.max));

		if (Left.isBst && Right.isBst && root.val > Left.max && root.val < Right.min) {
			myAns.isBst = true;
			myAns.bstCount = 1 + Left.bstCount + Right.bstCount;
		} else {
			myAns.isBst = false;
			myAns.bstCount = Left.bstCount + Right.bstCount;
		}

		return myAns;
	}

	public static int numberOfBSTinBinaryTree(TreeNode root) {

		isBST ans = countBSTinBinaryTree(root);
		return ans.bstCount;
	}

	// =====================================================================================



	// Display Binary Tree 
	public static void display(TreeNode root) {
		if(root == null)
			return;
		StringBuilder sb = new StringBuilder();

		sb.append((root.left != null ? root.left.val : "."));
		sb.append(" -> " + root.val + " <- ");
		sb.append((root.right != null ? root.right.val : "."));

		System.out.println(sb.toString());
		display(root.left);
		display(root.right);
	}

	public static void main(String[] args) {

		// Sample Test Case
		TreeNode root = new TreeNode(-8);
		root.left = new TreeNode(5);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(11);
		root.left.right = new TreeNode(-7);

		// display(root);

		System.out.println(numberOfBSTinBinaryTree(root));
		System.out.println(maxPathSum(root));
	}
}