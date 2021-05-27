import java.util.*;

public class TreeConstructionAndOperation{
	public static Scanner scn = new Scanner(System.in);

	// Node class 
	// Contains Data, left and right pointer
	public stati class Node{
		Integer data;
		Node left, right;


		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}


	// Pair : Node and state of particular node
	// 1 : Left Node
	// 2 : Right Node
	// 3 : Pop from stack
	public static class Pair{
		Node node;
		int state;

		Pair(Node node,int state){
			this.node = node;
			this.state = state;
		}
	}

	// Binary Tree Construction 
	// Using Stack 
	// PreOrder Construction
	public static Node binaryTreeContruction_preOrder(int[] arr){
		Node root = new Node(arr[0]);
		Pair rootNode = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rootNode);

		int idx = 0;
		while(st.size() != 0){
			Pair top = st.peek();
			if(top.state == 1){

				idx++;   // Array ka pointer => Idx
				
				if(arr[idx] != null){
					top.node.left = new Node(arr[idx]);
					Pair left = new Pair(top.node.left, 1);
					st.push(left);
				} else {
					top.node.left =  null;
				}

				top.state++;
			} else if(top.state == 2){
				idx++;   // Array ka pointer => Idx
				
				if(arr[idx] != null){
					top.node.right = new Node(arr[idx]);
					Pair right = new Pair(top.node.right, 1);
					st.push(right);
				} else {
					top.node.right =  null;
				}

				top.state++;
			} else {
				st.pop();
			}

		}

		return root;
	}


	// Height of Tree 
	// Hieght by Edge
	public static int heightByEdge(Node root){
		if(root == null){
			return -1;
		}

		int leftHeight = heightByEdge(root.left);
		int rightHeight = heightByEdge(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Height by Node
	public static int heightByNode(Node root){
		if(root == null){
			return 0;
		}

		int leftHeight = heightByEdge(root.left);
		int rightHeight = heightByEdge(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}


	// Size of Tree => No. of Nodes in Tree
  	public static int sizeofTree(Node root){
  		if(root == null)
  			return 1;

  		int left = sizeofTree(root.left);
  		int right = sizeofTree(root.right);


  		return left +  right + 1;
  	}

	// PreOrder Traversal
	public static void preOrderTraversal(Node root){
		if(root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	// InOrder Traversal 
	public static void inOrderTraversal(Node root){
		if(root == null)
			return;

		
		preOrderTraversal(root.left);
		System.out.print(root.data + " ");
		preOrderTraversal(root.right);
	}
	// PostOrder Traversal
	public static void inOrderTraversal(Node root){
		if(root == null)
			return;

		
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	// Minmum and Maximum Value 
	public static maximumValue(Node root){
		if(root == null)
			return -(int)1e9;

		int leftValue = maximumValue(root.left);
		int rightValue = maximumValue(root.right);

		return Math.max(Math.max(leftValue, rightValue), root.data);
	}

	public static minimumValue(Node root){
		if(root == null)
			return (int)1e9;

		int leftValue = maximumValue(root.left);
		int rightValue = maximumValue(root.right);

		return Math.min(Math.min(leftValue, rightValue), root.data);
	}


	// find value in Tree
	public static boolean findValue(Node root, int data){
		if(root == null)
			return false;

		boolean res = root.data == data;

		return res || rootToNode(root.left, data) || rootToNode(root.right, data);
	}

	// Root to Node Path  With Return Type
	public static boolean rootToNode(Node root, int data, ArrayList<Node> ans){
		if(root == null)
			return false;

		boolean res = (root.data == data) || rootToNode(root.left, data, ans) || rootToNode(root.right, data, ans);

		if(res)
			ans.add(root);

		return res;
	}

    // Print the K th Node in the depth in Binary Tree
    public static void printAtKthDepth(Node root, int k, ArrayList<Integer> ans) {
        if (root == null || k < 0)
            return;

        if (k == 0) {
            ans.add(root.data);
            return;
        }

        printAtKthDepth(root.left, k - 1, ans);
        printAtKthDepth(root.right, k - 1, ans);
    }


	// BFS => Level Order Traversal
	public static void BSF(Node root){
		int level = 0;

		LinkedList<Node> que = new LinkedList<>();
		que.add(root);

		while(que.size() != 0){
			int size = que.size();
			System.out.print(level + "->" );

			while(size-- > 0){
				Node rNode = que.removeFirst();
				System.out.print(rNode.data + " ");

				Node left = rNode.left;
				Node right = rNode.right;
				if(left != null)
					que.addLast(left);
				if(right != null)
					que.addLast(right);
			}

			System.out.println();
			level++;
		}
	}



	public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        display(root);
    }

} 