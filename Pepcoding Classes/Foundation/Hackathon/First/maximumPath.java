import java.util.ArrayList;
import java.util.Scanner;

public class question2 {
    // Binary Tree Class
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static Scanner scn = new Scanner(System.in);

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root == null)
            return false;
        boolean res = (root.data == data) || rootToNodePath(root.left, data, ans)
                || rootToNodePath(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }
    public static void main(String[] args) {
        int n = scn.nextInt();
        int q = scn.nextInt();

        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            arr.add(new Node(scn.nextInt()));
        }
 
        for(int i = 0; i < n -1 ; i++){
            int v1 = scn.nextInt() - 1;
            int v2 = scn.nextInt() - 1;

            if(arr.get(v1).left == null)
                arr.get(v1).left = arr.get(v2);
            else 
                arr.get(v1).right = arr.get(v2);
        }

        for(int i = 0; i < q; i++){
            int v1 = scn.nextInt() - 1;
            int v2 = scn.nextInt() - 1;
            int maxEle = -(int)1e9;

            ArrayList<Node> myAns = new ArrayList<>();
            
            rootToNodePath(arr.get(0), arr.get(v1).data, myAns);
            rootToNodePath(arr.get(0), arr.get(v2).data, myAns);

            for(Node node : myAns){
                if(node.data > maxEle)
                    maxEle = node.data;
            }

            System.out.println(maxEle);
        }
    }
}
