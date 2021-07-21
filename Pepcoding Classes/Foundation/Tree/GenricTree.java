import java.util.ArrayList;

public class l003GT {
    public static class Node {
        int data = 0;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
        }
    }

    public static int size(Node node) {
        int sz = 0;
        for (Node child : node.childs) {
            sz += size(child);
        }

        return sz + 1;
    }

    public static int height(Node node) {
        int h = 0;
        for (Node child : node.childs) {
            h = Math.max(h, height(child));
        }

        return h + 1;
    }

    public static int max(Node node) {
        int maxEle = -(int) 1e9;

        for (Node child : node.children) {
            int m = max(child);

            maxEle = Math.max(maxEle, m);
            // System.out.println(maxEle);
        }

        return Math.max(maxEle, node.data);
    }

    public static int minimum(Node node) {

    }

    // Find data in genric tree
    public static int find(Node node, int data) {
        boolean res = node.data == data;
        for (Node child : node.childs) {
            res = res || find(child, data);
        }

        return res;
    }

    // Root to Node path;
    public static boolean Path(Node node, int data, ArrayList<Integer> list) {
        boolean res = node.data == data;
        for (Node child : node.children) {
            res = res || Path(child, data, list);
        }

        if (res)
            list.add(node.data);

        return res;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        ArrayList<Integer> ans = new ArrayList<>();
        Path(node, data, ans);

        return ans;
    }

    // Using recursion
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    // Distance between two nodes in genric tree
    // d1 + d2 - 2(LCA_distance) + 1
    public static void LCANode(Node node, int d1, int d2){
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        
        rootToNodePath(node, d1, list1);
        rootToNodePath(node, d2, list2);

        int LCADistance = 0;

        while(i >= 0 && j >= 0){
            if(list1.get(i)  != get(j))
                break;
            
            LCADistance++;
            i--;
            j--;
        }

        int dis = (list1.size() + list2.size() - 2 * LCADistance + 1) // Distance in terms of No. of Node 

        // int dis = (list1.size() + list2.size() - 2 * (LCADistance) + 1 - 1);
        // distance in terms of No of Edges

        return dis;

    }

    // Linearize the generic tree
    // getTail specifically for linearize tree
    public static Node getTail(Node node) {
        Node curr = node;
        while (curr.children.size() != 0) {
            curr = curr.children.get(0);
        }

        return curr;
    }

    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        for (int i = node.children.size() - 2; i >= 0; i--) {
            Node tail = getTail(node.children.get(i));
            tail.children.add(node.children.get(i + 1));
            node.children.remove(i + 1);
        }
    }

    linearize_btr(Node node){
        if(node.children.size() == 0)   return node;

        int n = node.children.size();
        Node gTail = linearize_btr(node.children.get(n -1));
        for(int i = n - 2; i >= 0; i-- ){
            Node tail = linearize_btr(node.children.get(i));
            tail.children.add(node.children.get(i + 1))
        }
    }

    // Remove Leave Node
    public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }

    }

    // ceil and floor
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    public static void ceilAndFloor(Node node, int data) {
    if(node.data > data) 
        ceil = Math.min(ceil, node.data);
    if(node.data < data) 
        floor = Math.max(floor, node.data);
        
        
    for(Node child : node.children){
        ceilAndFloor(child, data);
    }

    // Are Similar
    public static boolean areSimilar(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size())
            return false;

        int n = n1.children.size();
        for (int i = 0; i < n; i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if (!areSimilar(c1, c2)) {
                return false;
            }
        }

        return true;
    }

    // Are Mirror
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size())
            return false;

        int n = n1.children.size();
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);

            if (!areMirror(c1, c2)) {
                return false;
            }
        }

        return true;
    }

    // Symmetrical 
    public static boolean areSimilar_(Node n1, Node n2) {
        if(n1.children.size()  != n2.children.size())
            return false;
            
        int n = n1.children.size();
        for(int i = 0, j = n - 1; i < n && j >= 0; i++, j--){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            
            if(!areSimilar_(c1, c2)){
                return false;
            }
        }
    
        return true;
      }
      public static boolean IsSymmetric(Node node) {
        return areSimilar_(node, node);
      }


     
}
}