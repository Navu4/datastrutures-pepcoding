import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class l001_basic {

    public static class Edge {
        int v = 0;
        int w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "(" + this.v + ", " + this.w + ") ";

        }
    }

    public static int N = 7;
    public static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static void display() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    // Find Edge Present in the Graph or not
    public static int findEdge(int u, int v) {
        for (int i = 0; i < graph[u].size(); i++) {
            Edge e = graph[u].get(i);
            if (e.v == v)
                return i;
        }

        return -1;
    }
    // ----------------------------------------------------------

    // Remove the edge if present
    public static void removeEdge(int u, int v) {
        int idx1 = findEdge(u, v);
        int idx2 = findEdge(v, u);

        // if (idx1 == -1 || idx2 == -1)
        // return;

        graph[u].remove(idx1);
        graph[v].remove(idx2);
    }

    // ----------------------------------------------------------

    // Remove Vertex
    public static void removeVtx(int u) {

        while (graph[u].size() != 0) {
            int n = graph[u].size();
            Edge e = graph[u].get(n - 1);
            removeEdge(u, e.v);
        }
    }
    // ----------------------------------------------------------

    // Does path from src to dest exists
    public static boolean hasPath(int src, int dest, boolean[] vis) {
        if (src == dest) {
            return true;
        }

        boolean res = false;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                res = res || hasPath(e.v, dest, vis);
        }

        return res;
    }
    // ----------------------------------------------------------

    // All path from src to dest
    public static int allPath(int src, int dest, boolean[] vis, String ans) {
        if (src == dest) {
            System.out.println(ans + dest);
            return 1;
        }

        int count = 0;
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                count += allPath(e.v, dest, vis, ans + src);
        }

        vis[src] = false;
        return count;
    }

    // ----------------------------------------------------------

    // PreOrder Traversal in a Graph
    public static void printPreOrder(int src, boolean[] vis, String ans, int wsf) {
        System.out.println(src + " -> " + ans + src + " @ " + wsf);
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                printPreOrder(e.v, vis, ans + src, wsf + e.w);
        }

        vis[src] = false;
    }

    // ----------------------------------------------------------

    // Post Order Traversal in a Graph
    public static void printPostOrder(int src, boolean[] vis, String ans, int wsf) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                printPostOrder(e.v, vis, ans + src, wsf + e.w);
        }

        System.out.println(src + " -> " + ans + src + " @ " + wsf);
        vis[src] = false;
    }

    // ----------------------------------------------------------

    public static class pair {
        int largestWeight = -(int) 1e9;
        String largestPath = "";
        int smallestWeight = (int) 1e9;
        String smallestPath = "";

        int ceil = (int) 1e9;
        String ceilPath = "";
        int floor = -(int) 1e9;
        String floorPath = "";

    }

    public static class pqPair {
        int wsf = 0;
        String psf = "";

        pqPair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }
    }

    static PriorityQueue<pqPair> pq = new PriorityQueue<>((a, b) -> {
        return a.wsf - b.wsf;
    });

    // All Solution
    // Ceil and Floor Value
    // Path from src to dest with largest and smallest weight
    // Kth largest weight path using Priority Queue
    public static void allSolution(int src, int dest, boolean[] vis, pair p, String psf, int wsf, int givenWeight,
            int k) {

        if (src == dest) {
            if (wsf > p.largestWeight) {
                p.largestWeight = wsf;
                p.largestPath = psf + dest;
            }

            if (wsf < p.smallestWeight) {
                p.smallestWeight = wsf;
                p.smallestPath = psf + dest;
            }

            if (wsf < givenWeight)
                if (wsf > p.floor) {
                    p.floor = wsf;
                    p.floorPath = psf + dest;
                }
            if (wsf > givenWeight)
                if (wsf < p.ceil) {
                    p.ceil = wsf;
                    p.ceilPath = psf + dest;
                }

            pq.add(new pqPair(wsf, psf + dest));
            if (pq.size() > k)
                pq.remove();

            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                allSolution(e.v, dest, vis, p, psf + src, wsf + e.w, givenWeight, k);
        }

        vis[src] = false;
    }

    // ----------------------------------------------------------

    // Basic Depth first search
    public static void dfs(int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src])
            if (!vis[e.v])
                dfs(e.v, vis);
    }

    // GCC is used to calculate the Number of Components in a Graph
    public static int gcc() {
        boolean[] vis = new boolean[N];
        int components = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, vis);
            }
        }
        return components;

    }

    // ----------------------------------------------------------

    // Graph is connected
    public static void dfs(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                dfs(graph, e.v, vis);
            }
        }
    }

    public static boolean isConnected(ArrayList<Edge>[] graph) {
        int N = graph.length;
        boolean[] vis = new boolean[N];
        int components = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                components++;
                dfs(graph, i, vis);
            }
        }

        return components == 1;
    }

    // ----------------------------------------------------------

    // Island
    // Calcuate the number of Island present in the Matrix
    public static void dfs_island(int[][] mat, int[][] dir, int i, int j) {
        mat[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 1) {
                dfs_island(mat, dir, r, c);
            }
        }
    }

    public static int countIsland(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int components = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    components++;
                    dfs_island(mat, dir, i, j);
                }
            }
        }

        return components;
    }

    // ----------------------------------------------------------

    // Hamiltonian Path And Cycle
    public static void hamintonian_dfs(int src, int osrc, boolean[] vis, int NoOfEdges, String psf) {
        if (NoOfEdges == N - 1) {
            System.out.print(psf + src);
            int idx = findEdge(src, osrc);
            if (idx != -1)
                System.out.print("*");

            System.out.println();
            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                hamintonian_dfs(e.v, osrc, vis, NoOfEdges + 1, psf + src);
        }

        vis[src] = false;
    }

    public static void hamintonianPath() {
        boolean[] vis = new boolean[N];
        hamintonian_dfs(0, 0, vis, 0, "");
    }

    // ----------------------------------------------------------

    // Breadth First Search
    // WITH CYCLE
    // Level Order Traversal
    public static void BFS(int src, boolean[] vis) {
        int level = 0, cycleCount = 0;

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        while (que.size() != 0) {
            int size = que.size();
            System.out.print(level + " -> ");

            while (size-- > 0) {
                int rVtx = que.removeFirst();
                if (vis[rVtx]) {
                    cycleCount++;
                    continue;
                }

                System.out.print(rVtx + " ");

                vis[rVtx] = true;
                for (Edge e : graph[rVtx]) {
                    if (!vis[e.v]) {
                        que.addLast(e.v);
                    }
                }
            }

            System.out.println();
            level++;
        }
        System.out.println(cycleCount);
    }

    // Breadth First Search
    // WITHOUT CYCLE
    // Level order traversal
    public static void BFS_02(int src, boolean[] vis) {
        int level = 0;

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        vis[src] = true;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print(level + " -> ");

            while (size-- > 0) {
                int rVtx = que.removeFirst();

                System.out.print(rVtx + " ");
                for (Edge e : graph[rVtx]) {
                    if (!vis[e.v]) {
                        que.addLast(e.v);
                        vis[e.v] = true;
                    }
                }
            }

            System.out.println();
            level++;
        }
    }
    // ----------------------------------------------------------

    // Normal Breadth First Search Display
    // 2@2
    // 1@21
    // 3@23
    // 0@210
    // 4@234
    // 5@2345
    // 6@2346
    public static void breadthFirstSearch(ArrayList<Edge>[] graph, int src, boolean[] vis){
       
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(src, src + ""));
        
        vis[src] = true;
        
        while(que.size() != 0){
            
            Pair rVtx = que.removeFirst();
            System.out.println(rVtx);
            
            for(Edge e : graph[rVtx.v]){
                if(!vis[e.nbr]){
                    que.addLast(new Pair(e.nbr, rVtx.psf + e.nbr));
                    vis[e.nbr] = true;
                }
            }
            
        }
    }
    // ----------------------------------------------------------

    // Is Cycle present in the Graph, If yes return true
    public static boolean isCyclic(int src, boolean[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        while (que.size() != 0) {
            int rVtx = que.removeFirst();

            if (vis[rVtx]) {
                return true;
            }

            vis[rVtx] = true;
            for (Edge e : graph[rVtx]) {
                if (!vis[e.v]) {
                    que.addLast(e.v);
                }
            }
        }
        return false;
    }

    public static void isGraphCyclic() {

        boolean[] vis = new boolean[N];
        for (int v = 0; v < vis.length; v++) {
            if (!vis[v]) {
                boolean cycle = isCyclic(v, vis);
                if (cycle) {
                    System.out.println(true);
                    return;
                }
            }
        }

        System.out.println(false);
    }

    // If Cycle present in the Graph, return Cycle count
    // Count Number of Cycle present in the Graph
    // Count Number of Component in the Graph
    // Check is Graph is a TREE OR FOREST 
    public static int cycleOfGraph(int src, boolean[] vis) {
        int cycleCount = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        while (que.size() != 0) {
            int rVtx = que.removeFirst();

            if (vis[rVtx]) {
                cycleCount++;
                continue;
            }

            vis[rVtx] = true;
            for (Edge e : graph[rVtx]) {
                if (!vis[e.v]) {
                    que.addLast(e.v);
                }
            }
        }

        return cycleCount;
    }

    public static void cycleCountOfGraph() {

        boolean[] vis = new boolean[N];
        int cycleCount = 0;
        int components = 0;
        for (int v = 0; v < vis.length; v++) {
            int cycle = 0;
            if (!vis[v]) {
                components++;
                cycle = cycleOfGraph(v, vis);
            }

            if (cycle != 0) {
                cycleCount += cycle;
            }
        }
        System.out.println("Number of Cycles : " + cycleCount);
        System.out.println("Number of Components : " + components);
        if (cycleCount == 0 && components == 1)
            System.out.println("Its a Tree");
        else if (cycleCount == 0 && components > 1)
            System.out.println("Its a Forest");
    }

    // ----------------------------------------------------------


    //  Bipartite 
    //  Approach 
    // 1. Even Cycle -> Bipartite
    //    Odd Cycle -> Not Bipartite
    //    Use BFS to calculate the cycle
    //    use level to identify if the Vertex reoccured again it should be in same level
    //    if not in same level Graph is not bipartite
    public static class levelPair{
        int v;
        int level;
        String psf;

        public levelPair(int v, String psf, int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    public static boolean isCompBipartite(int src, int[] vis) {
        LinkedList<levelPair> que = new LinkedList<>();
        que.add(new levelPair(src, src + "", 0));

        while (que.size() != 0) {
            levelPair rVtx = que.removeFirst();
            if(vis[rVtx.v] != -1){
                if(rVtx.level != vis[rVtx.v]){
                    return false;
                }
            } else {
                vis[rVtx.v] = rVtx.level;
            }

            for (Edge e : graph[rVtx.v]) {
                if(vis[e.v] == -1){
                    que.addLast(new levelPair(e.v, rVtx.psf + e.v, rVtx.level + 1));
                }
            }
        }

        return true;
    }

    public static void isBipartite(){
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        for (int v = 0; v < vis.length; v++) {
            if(vis[v] == -1){
                boolean bipartite = isCompBipartite(v, vis);
                if(!bipartite){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
    // ------------------------------------------------------------

    // 2. Color approach 
    //    Mark 
    // -1 -> undefine, 0 -> red, 1 -> green.
    public static boolean isBipartite(int src){
        LinkedList<Integer> que = new LinkedList<>();
        int[] vis = new int[N];
        Arrays.fill(vis,-1);

        que.addLast(src);
        int color = 0;

        // -1 -> undefine, 0 -> red, 1 -> green.
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int rvtx = que.removeFirst();
                if(vis[rvtx] != -1){
                    if(vis[rvtx] != color)  // conflict
                      return false;
                    
                    continue;
                }

                vis[rvtx] = color;
                for(Edge e : graph[rvtx]){
                    if(vis[e.v] == -1){
                        que.addLast(e.v);
                    }
                }
            }

            color = (color + 1) % 2;
        }

        return true;
    }
    public static void main(String[] args) {
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        addEdge(0, 1, 10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(4, 5, 3);
        addEdge(4, 6, 8);
        addEdge(5, 6, 3);
        addEdge(2, 5, 5);

        // display();
        boolean[] vis = new boolean[N];
        // System.out.println(hasPath(0, 6, vis));
        // printPostOrder(0, vis, "", 0);
        // pair p = new pair();
        // allSolution(0, 6, vis, p, "", 0, 30, 4);
        // System.out.println("Smallest Path =" + p.smallestPath + "@" +
        // p.smallestWeight);
        // System.out.println("Largest Path =" + p.largestPath + "@" + p.largestWeight);
        // System.out.println("Ceil of 30 =" + +p.ceil);
        // System.out.println("Floor of 30 =" + +p.floor);
        // System.out.println("Kth Largest Path =" + pq.peek().psf + "@" +
        // pq.peek().wsf);
        // BFS(0, vis);
        // isGraphCyclic();
        // cycleCountOfGraph();
        isBipartite();
    }

}