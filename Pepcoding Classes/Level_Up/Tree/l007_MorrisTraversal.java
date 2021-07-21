public class l007_MorrisTraversal{
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	public static class Node {
	    int val = 0;
	    Node left = null;
	    Node right = null;

	    Node(int val) {
	      this.val = val;
	    }
	}

	// Morris InOrder Traversal 
	// Time Complexity : O(n)
	// Space Complexity : O(1)   <=== IMPORTANT & SPECIAL IN MORRIS TRAVERSAL
	public static ArrayList<Integer> morrisInOrderTraversal(TreeNode root) {
		TreeNode curr = root;
		ArrayList<Integer> ans = new ArrayList<>();

		while(curr != null){
			TreeNode left = curr.left;
			if(left == null){
				ans.add(left.val);
				curr = curr.right;
			} else {
				TreeNode rightMostNode = getRightMostNode(left, curr);
				if(rightMostNode.right == null){
					rightMostNode.right = curr;

					curr = curr.left;
				} else {
					rightMostNode.right = null;
					
					ans.add(curr.val);
					curr = curr.right;	
				}
			}
		}

		return ans;
	}

	public static TreeNode getRightMostNode(TreeNode node, TreeNode curr){
		while(node.right != null && node.right != curr)
			node = node.right;

		return node;
	}


	// PreOrder Morris Traversal
	public static ArrayList<Integer> morrisPreOrderTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode curr = root;

		while(curr != null){
			TreeNode left = curr.left;
			if(left == null){
				ans.add(curr.val);
	
				curr = curr.right;
			} else {
				TreeNode rightMostNode = getRightMostNode(left, curr);
				if(rightMostNode.right == null){
					rightMostNode.right = curr;

					// Changes : Yeh ArrayList me Add krne ki position
					ans.add(curr.val);   // Pre Order me hi add krvange 
					curr = curr.left;
				} else {
					rightMostNode.right = null;

					curr = curr.right;
				}
			}
		}
		return ans;
	}

    // validate BST==============================================
	// 3 Ways to do this question

	// 1. Using Recursion
	// 2. Using Stack
	// 3. Morris Traversal

	// Using Recursion
    public boolean isValidBST(TreeNode root, TreeNode[] prev) {
        if(root == null)
            return true;
        
        if(!isValidBST(root.left, prev))
            return false;
        
        if(prev[0] != null && prev[0].val >= root.val)
            return false;
        prev[0] = root;
        
        
        if(!isValidBST(root.right, prev))
            return false;
        
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];     
        return isValidBST(root, prev);
    }

    // Using Stack 
  
    public static boolean isValidBST_02(TreeNode root) {
    	if(root == null)
    		return true;

    	LinkedList<TreeNode> st = new LinkedList<>();
    	TreeNode curr = root;
    	st.addFirst(root);
    	while(st.size() != 0){

    	}


    }

    // Morris Traversal
    public static boolean isValidBST_03(TreeNode root){
    	long prev = -(long)1e13;
    	TreeNode curr = root;
    	while(curr != null){
    		TreeNode left = curr.left;
    		if(left == null){
    			if(prev >= curr.val)
    				return false;

    			prev = curr.val;
    			curr = curr.right;
    		} else {
    			TreeNode rightMostNode = getRightMostNode(left, curr);
    			if(rightMostNode.right == null){
    				rightMostNode.right = curr;

    				curr = curr.left;
    			} else {
    				rightMostNode.right = null;

    				if(prev >= curr.val)
    					return false;

    				prev = curr.val;
    				curr = curr.right;
    			}
    		}
    	}
    	return true;

    }


    // BST Iterator
    // Using Morris Iterator
    public static class BSTIterator {
    
	    static root = null;
	    static curr = null;
	    
	    public BSTIterator(TreeNode root) {
	    	this.root = root;
	    	this.curr = curr;
	    }

	    public int next() {

	    	while(curr != null){
	    		TreeNode left = curr.left;
	    		if(left == null){
	    			int val  = curr.val;
	    			curr = curr.right;

	    			return val;
	    		} else {
	    			TreeNode rightMostNode = getRightMostNode(left, curr);
	    			if(rightMostNode.right == null){
	    				rightMostNode = curr;
	    				curr = curr.left;
	    			} else {
	    				rightMostNode.right = null;

	    				int val  = curr.val;
	    				curr = curr.right;
	    			
	    				return val;
	    			}
	    		}
	    	}
	    	return -1;
   	    }

	    public boolean hasNext() {
	    	return curr != null;
	    }
	}



     public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                if(--k == 0)
                    return curr.val;

                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;

                    curr = curr.left;
                } else {
                    rightMostNode.right = null;

                    if(--k == 0)
                        return curr.val;

                    curr = curr.right;
                }
            }
        }
        return -1;
    }

	public TreeNode getLeftMostNode(TreeNode node, TreeNode curr){
        while(node.left != null && node.left != curr)
            node = node.left;
        return node;
    }

    public int kthLargest(TreeNode root,int k){
    	TreeNode curr = root;

    	while(curr != null){
    		TreeNode right = curr.right;
    		if(right == null){
    			if(--k == 0)
    				return curr.val;

    			curr = curr.left;
    		} else {
    			TreeNode leftMostNode = getLeftMostNode(right, curr);
    			if(leftMostNode.left == null){
    				leftMostNode.left = curr;

    				curr = curr.right;
    			} else {
    				leftMostNode.right = null;

    				if(--k == 0)
    					return curr.val;

    				curr = curr.left;
    			}
    		}
    	}
    	return -1;
    }

    public static getRightMostNode(Node node, Node curr){
    	while(node.right != null && node.right != curr){
    		node = node.right;
    	}

    	retur node;
    }

    // Convert BST to Doubly LinkedList using Morris Traversal
    public static Node bToDLL(Node root) {
    	Node curr = root;
    	Node dummy =  new Node(-1);
    	Node prev = dummy;

    	while(curr != null){
    		Node left = curr.left;
    		if(left == null){
    			prev.right = curr;
    			curr.left = prev;

    			prev = prev.right;
    			curr = curr.right;
    		} else {
    			Node rightMostNode = getRightMostNode(left, curr);
    			if(rightMostNode.right == null){
    				rightMostNode.right = curr;

    				curr = curr.left;
    			} else {
    				getRightMostNode.right = null;

					prev.right = curr;
	    			curr.left = prev;

	    			prev = prev.right;
	    			curr = curr.right;    				
    			}
    		}
    	}

    	Node head = dummy.right;
    	head.left = dummy.right = null;

    	// Circular LinkedList 
    	// head.prev = prev;
    	// prev.next = head;
    	
    	return head;
  	}

	public static void main(String[] args) {

	}
}