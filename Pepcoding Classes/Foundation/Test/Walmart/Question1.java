import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Question1 {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scn.nextInt();
        int C = scn.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scn.nextInt();
        }

        frogJump(arr, 0, N - 1, C, 0);

        System.out.println(totalCost);
    }

    public static int totalCost = (int) 1e9;

    public static int cost(int i, int j, int C) {
        return (((i - j) * (i - j)) + C);
    }

    public static void frogJump(int[] arr, int st, int dest, int C, int cost) {
        if (st == dest) {
            totalCost = Math.min(totalCost, cost);
            return;
        }

        for (int i = st + 1; i <= dest; i++) {
            int hi = arr[st];
            int hj = arr[i];
            int val = cost(hj, hi, C) + cost;
            System.out.println(hi + " " + hj + " " + val);
            frogJump(arr, i, dest, C, cost + val);
        }
    }

    public static void findFloorCeil(Node root, int key, Result resultObj)
    {
        while (root != null)
        {
            // if a node with the desired value is found, both floor and ceil is equal
            // to the current node
            if (root.value == key)
            {
                resultObj.floorValue = root.value;
                break;
            }
 
            // if the given key is less than the root node, visit the left subtree
            else if (key < root.data)
            {
                // update ceil to the current node before visiting the left subtree
                resultObj.setCeil(root);
                root = root.left;
            }
 
            // if the given key is more than the root node, visit the right subtree
            else {
                // update floor to the current node before visiting the right subtree
                resultObj.setFloor(root);
                root = root.right;
            }
        }

        
        private TreeNode makeMirrorTree(TreeNode root){
            if(root == null)
                return;

            if(root.left != null){
                makeMirrorTree(root.left);
            }

            if(root.right != null){
                makeMirrorTree(root.right);
            }


            int temp = root.left;
        }


    }

    private Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr; // move
            curr = forw;
        }

        return prev;
    }

    private Node mid(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node updateLinkedList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = mid(head);
        Node nHead = mid.next;
        mid.next = null;

        nHead = reverse(nHead);

        Node c1 = head, c2 = nHead;
        while (c1 != null && c2 != null) {
            int sum = c1.value + c2.value;
            c1.value = c2.value = sum;

            c1 = c1.next;
            c2 = c2.next;
        }

        nHead = reverse(nHead);
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = nHead;

        return head;
    }

    private static (List<Integer> arr, int i, int j){
        if(i == j)
            return -1;

        int mid = i + (j - i) / 2;
        if(mid == 0 && arr.get(mid) > arr.get(mid + 1))
            return arr.get(mid);

        if(arr.get(i) > arr.get(mid))
            return findMax(arr, i, mid - 1);
        else    
            return findMax(arr, mid + 1, j);     
    }

    private static int findMaxElementIndex(List<Integer> arr, int arrLength) {
        int i = 0;
        int j = arr.size() - 1;

        return findMax(arr, i, j);
    }

}
