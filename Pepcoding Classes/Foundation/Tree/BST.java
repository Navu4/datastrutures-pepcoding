import java.util.*;

public class BST{

    public class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    public static Node constructTree(int[] arr, int si, int ei){
        if(si > ei){
            return null;
        }

        int mid = (si + ei) / 2;
        Node node =  new Node(arr[mid]);

        node.left = constructTree(arr, si, mid -1);
        node.right = constructTree(arr, mid + 1, ei);

        return node;
    }

    public static Node constructTreeBST(int[] arr){
        return constructTree(arr, 0, arr.length - 1);
    }


    // Size
    public static int size(Node node){
        return (node == null)? 0 : size(node.left) + size(node.right) + 1); 
    }   

    // OR 
//   public static int size(Node node) {
//     if(node == null)    return 0;
    
//     int left = size(node.left);
//     int right = size(node.right);
    
//     return left + right + 1;
//   }
    

    // Height of a Tree 
    public static int height(Node node) {
        return node == null ? -1 : Math.max(height(node.left), height(node.right));
    }

    public static int sum(Node node){

    }   

    // OR 
  public static int sum(Node node) {
    if(node == null)    return 0;
    
    int left = sum(node.left);
    int right = sum(node.right);
    
    return left + right + node.data;
  }

    public static int maximum(Node node){
        Node curr = node;
        while(curr.right != null){
            curr =  curr.right;
        }

        return curr.data;
    }

    // OR 
//   public static int max(Node node) {
//     if(node == null)    return 0;
//     if(node.right == null)    return node.data;
    
//     int maxEle = max(node.right);
    
//     return maxEle;
//   }
    

    // Minimum value in the tree
    public static int minimum(Node node){
       Node curr = node;
        while(curr.left != null){
            curr =  curr.left;
        }
 
        return curr.data;
    }

    // OR

//   public static int min(Node node) {
//     if(node == null)    return 0;
//     if(node.left == null)    return node.data;
    
//     int minEle = min(node.left);
    
//     return minEle;
//   }

    // Find a data 
   public static boolean find(Node node, int data){
       Node curr = node;

       while(curr != null){
            if(curr.data == data)
                return true
            else if(curr.data < data)
                curr = curr.right;    
            else 
                curr = curr.left;    
       }
       
       return false;
    }

    // OR
//   public static boolean find(Node node, int data){
//     if(node == null)    return false;
    
//     boolean res = false;
    
//     if(node.data == data)   
//         return true;
//     else if(node.data > data){
//         res = find(node.left, data);
//     } else {
//         res = find(node.right, data);
//     }
    
//     return res;
//   } 


    // ADD Node in BST
    // Recursive Approach
    public static Node addData(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (node.data < data)
            node.right = addData(node.right, data);
        else
            node.left = addData(node.left, data);

        return node;
    }


    // OR

    // Iterative Method
    //   public static Node add(Node node, int data) {
    //    if(node == null)    return new Node(data, null, null);
        
    //     Node curr = node;
        
    //    while(true){
    //         if(curr.data == data){
    //             break;
    //         }
    //         else if(curr.data <= data){
    //             if(curr.right != null){
    //                 curr = curr.right;
    //             }
    //             else{ 
    //                 curr.right = new Node(data, null, null);
    //                 break;
    //             }
    //         }
    //         else{ 
    //             if(curr.left != null){
    //                 curr = curr.left;
    //             }
    //             else {
    //                 curr.left = new Node(data, null, null);
    //                 break;
    //             }
    //         }                
    //    }
        
    //     return node;
    // }



    // Lowest Comman Ancestor of BST
    // Binary Search Tree
    public static Node LCA(Node node, int p, int q) {
        Node curr = node;
        while (curr != null) {
            if (curr.data < p && curr.data < q)
                curr = curr.right;
            else if (curr.data > p && curr.data > q)
                curr = curr.left;
            else
                return (find(curr, p) && find(curr, q)) ? curr : null;
        }
        return null;
    }
    
    // Binary Tree
        public boolean rootToNodePath(TreeNode root, TreeNode p, ArrayList<TreeNode> ans){
        if(root == null)
            return false;
        
        boolean res = (root == p) || rootToNodePath(root.left, p, ans) || rootToNodePath(root.right, p, ans);            
        if(res)
            ans.add(root);
        
        return res;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP = new ArrayList<>();
        ArrayList<TreeNode> pathQ = new ArrayList<>();
        
        rootToNodePath(root, p , pathP);
        rootToNodePath(root, q , pathQ);
        
        int i = pathP.size() - 1; 
        int j = pathQ.size() - 1;

        
        TreeNode ans = null;
        while(i >= 0 && j >= 0){
            if(pathP.get(i) == pathQ.get(j)){
                ans = pathP.get(i);
                i--;
                j--;
            }
            else 
                break;
        }
        
        return ans;
        
    }

    public static Node removeNode(Node node, int data){
        if(node == null)    
            return null;

        if(node.data < data)
            node.right = removeNode(node.right, data);
        else if(node.data > data)  
            node.left = removeNode(node.right, data);
        else {
            if(node.left == null || node.right == null)
                return node.left != null ? node.left : node.right;
            
            int mindata = minimum(node.right);
            node.data = mindata;
            node.right = removeNode(node.right, mindata);
        }

        return node;
    }

    public static void inOrder(Node node, ArrayList<Integer> list) {
        if (node == null)
            return;

        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);

    }

    public static void targetSum(Node node, int tar) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(node, list);

        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum < tar)
                i++;
            else if (sum > tar)
                j--;
            else {
                System.out.println(list.get(i) + " " + list.get(j));
                i++;
                j--;
            }
        }

    }
}