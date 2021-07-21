import java.util.Stack;
import java.util.LinkedList;

public class BinaryTreeConstructor {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {

                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node node) {
        if (node == null)
            return;
        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";

        System.out.println(str);

        display(node.left);
        display(node.right);
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

				if(rNode.left != null)
					que.addLast(rNode.left);
				if(rNode.right != null)
					que.addLast(rNode.right);
			}

			System.out.println();
			level++;
		}
	}
    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        BSF(root);
        // display(root);
    }
}
