public class questionIMPORTANT {
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

    // Zig Zag Path in a Binary Tree 
    // Leetcode 1372. Longest ZigZag Path in a Binary Tree

    // Consider Slope : Two Type - 1. Forward Slope  "/" , 2. Backward Slope "\"
    // IMPORTANT 
    // Faith for left: Apne left subtree ko bolunga ki apna BACKWARD slope se jo zigZag Path bnta hai voh laa ke de
    //           aur sth me max. length of zigZag so far voh laake de
    // Faith for right: Apne right subtree ko bolunga ki apna FORWARD slope se jo zigZag Path bnta hai voh laa ke de 
    //           aur sth me max. length of zigZag so far voh laake de
    // Work for Self : Me khudko include krke for left/right jo max. length of ZigZig bnega for return krunga 


    // [forward, backward, max length so far]
	public int[] longestZigZag_(TreeNode root) {
		if(root == null)
			return new int[]{-1, -1, -1};

		// if(root.left == null && root.right == null){
		// 	return new int[]{0,0,0}
		// }

		int[] lr = longestZigZag_(root.left);
		int[] rr = longestZigZag_(root.right);

		int[] myAns = new int[3];
		myAns[0] = lr[1] + 1;
		myAns[1] = rr[0] + 1;

		myAns[3] = maxValue(lr[3], rr[3], myAns[0], myAns[1]);
		return myAns;
	}

	public int maxValue(int... arr){
		int maxEle = arr[0];
		for(int ele : arr){
			maxEle = Math.max(maxEle, ele);
		}

		return maxEle;
	}

	public int longestZigZag(TreeNode root) {
		int[] ans = longestZigZag_(root);
		return ans[3];
	}

	// ============================================================


	// Leetcode 297. Serialize and Deserialize Binary Tree
	// Serialize and Deserilize 
	// Given Tree => String => Tree
	// 2 Approach of Encoding and Decoding


	// 1st Approach 
	// Using PreOrder Traversal

    // Encodes a tree to a single string.
    public void serialize(TreeNode root, String[] str){
        if(root == null){
            str[0] += "# ";
            return;
        }
        
        str[0] += (root.val + " ");

        serialize(root.left, str);
        serialize(root.right, str);
    }
    
    public String serialize(TreeNode root) {
        
        String[] str = new String[1];
        str[0] = "";
        serialize(root, str);

        return str[0];
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String[] str, int[] idx){
        if(str[idx[0]].equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str[idx[0]]));
        idx[0]++;
        root.left = deserialize(str, idx);
        idx[0]++;
        root.right = deserialize(str, idx);

        return root;
    }

    public TreeNode deserialize(String data) {
        
        String[] str = data.split(" ");
        
        int[] idx = new int[1];
        idx[0] = 0;
        
        return deserialize(str, idx);
    }


    // 2nd Approach 
    // Level Order Traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();

		LinkedList<TreeNode> que = new LinkedList<>();
		que.addLast(root);

		while(que.size() != 0){
			int size = que.size();

			while(size-- > 0){
				TreeNode node = que.removeFirst();
				sb.append(node != null ? node.val + " " : "# ");

				if(node != null){
					que.addLast(node.left);
					que.addLast(node.right);					
				}

			}
		}    
		return sb.toString();    
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] str = data.split(" ");
        if(str.length == 0 || str[0].equals("#")){
            return null;
        }
        
        LinkedList<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        que.addLast(root);

        int i = 1, n = str.length;
        while (i < n) {
            TreeNode rnode = que.removeFirst();
            if (i < n && !str[i].equals("#")) {
                TreeNode lci = new TreeNode(Integer.parseInt(str[i]));
                rnode.left = lci;
                que.addLast(lci);
            }
            i++;

            if (i < n && !str[i].equals("#")) {
                TreeNode rci = new TreeNode(Integer.parseInt(str[i]));
                rnode.right = rci;
                que.addLast(rci);
            }
            i++;
        }

        return root;
    }

    // Serialize and Deserialize BST 
    // Encodes a tree to a single string.
    public void serialize(TreeNode root, String[] str) {
	        if(root == null){
	            return;
	        }
	        
	        str[0] += (root.val + " ");
	        
	        serialize(root.left, str);
	        serialize(root.right, str);
	    }

	    public String serialize(TreeNode root) {
	        String[] str = new String[1];
	        str[0] = "";
	        
	        serialize(root, str);
	        return str[0];
	    }

	    
	    // Construct BST using PreOrder Traversal
	    // Decodes your encoded data to tree.
	    public TreeNode bstFromPreorder(String[] preorder, int lr, int rr) {
	        if(idx == preorder.length || Integer.parseInt(preorder[idx]) < lr || Integer.parseInt(preorder[idx]) > rr)
	            return null;
	        
	        TreeNode node = new TreeNode(Integer.parseInt(preorder[idx++]));
	        
	        node.left = bstFromPreorder(preorder, lr, node.val);
	        node.right = bstFromPreorder(preorder, node.val, rr);
	        
	        return node;
	    }

	    
	    int idx;
	    public TreeNode deserialize(String data) {
	        if(data.length() == 0)
	            return null;
	        
	        String[] str = data.split(" ");
	        idx = 0;
	        return bstFromPreorder(str, -(int)1e9, (int)1e9);
	    }
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


	// Flatten a Binary Tree into a LinkedList
	// Leetcode 114. Flatten Binary Tree to Linked List
	public TreeNode rightMostNode(TreeNode curr){
        while(curr.right != null)
            curr = curr.right;
        
        return curr;
    }
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        
        if(root.left != null){
            flatten(root.left);

            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode tailOfLeft = rightMostNode(root.left);

            tailOfLeft.right = temp;

            root.left = null;
        }
        
        flatten(root.right);
    }

    // =====================================================================================

    // IMPORTANT : LONGEST CONSECUTIVE SEQUENCE

    // Leetcode 298. Binary Tree Longest Consecutive Sequence
        //    1                               
        //  /   \                          
        // 2     3   
    	// Output: 2
    	// Explanation : Longest sequence is 1, 2.

    public void findLongestConsecutiveSequence(Node root, int count, int target, int[] max){
        if(root == null){
            return;
        }
            
        if(root.data == target)
            count++;
        else 
            count = 1;
            
        max[0] = Math.max(count, max[0]);
        findLongestConsecutiveSequence(root.left, count, root.data + 1, max);
        findLongestConsecutiveSequence(root.right, count, root.data + 1, max);
    }
	public int longestConsecutive(Node root){
	    int[] max = new int[1];

        findLongestConsecutiveSequence(root, 0, 0 , max);
	    return max[0] == 1 ? -1 : max[0];
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