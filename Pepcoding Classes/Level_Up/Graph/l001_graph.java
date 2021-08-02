import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class l001_graph {

    public static class Edge {
        int v = 0, w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    // Add Edge in the Graph
    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        // If directional : Only Edge of v,w will be created with u
        // If Bi-directional : v,w with u and u,w with v will be created
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));

    }

    // Time Complexity : O(E)
    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.v == v)
                return i;
        }
        return -1;

    }

    // Time Complexity : O(E)
    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {
        int idx = findEdge(graph, u, v);
        graph[u].remove(idx);

        idx = findEdge(graph, v, u);
        graph[v].remove(idx);
    }

    // HasPath
    // O(E), where E is total no of edges in that particular component.
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;

        vis[src] = true;
        boolean res = false;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                res = res || hasPath(graph, e.v, dest, vis);
            }
        }

        return res;
    }

    // Print all path from source to destination
    public static int printAllPath(ArrayList<Edge>[] graph, int src, int dest, String psf, int wsf, boolean[] vis) {
        if (src == dest) {
            System.out.println(psf + dest + " @ " + wsf);
            return 1;
        }

        vis[src] = true;
        int count = 0;
        for (Edge e : graph[src]) {
            if (!vis[e.v])
                count += printAllPath(graph, e.v, dest, psf + src, wsf + e.w, vis);
        }
        vis[src] = false;

        return count;
    }

    public static void gcc_dfs(ArrayList<Edge>[] graph, int src, boolean[] vis) {

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                gcc_dfs(graph, e.v, vis);
            }
        }
    }

    // No. of components in a Graph

    // GCC
    // Time Complexity : O(E + V)
    public static int getConnetedComponent(ArrayList<Edge>[] graph) {

        int components = 0;
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                components++;
                gcc_dfs(graph, i, vis);
            }
        }
        return components;
    }

    // O(E)
    public static void BFS_forCycle(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        int level = 0;
        boolean iscycle = false;

        que.add(src);
        while (que.size() != 0) {
            int size = que.size();
            System.out.print("Min No Edges: " + level + " -> ");
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                if (vis[rvtx]) {
                    iscycle = true;
                    continue;
                }

                System.out.print(rvtx + ", ");
                vis[rvtx] = true;
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.v])
                        que.addLast(e.v);
                }
            }
            System.out.println();
            level++;
        }
    }

    // O(v)
    public static void BFS_withoutCycle(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        int level = 0;

        que.add(src);
        vis[src] = true;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print("Min No Edges: " + level + " -> ");
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                System.out.print(rvtx + ", ");
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.v]) {
                        vis[e.v] = true;
                        que.addLast(e.v);
                    }
                }
            }
            System.out.println();
            level++;
        }
    }

    // IMPORTANT TO UNDERSTAND
    public static boolean isBipartite(ArrayList<Edge>[] graph, int src, int[] vis) {
        LinkedList<Integer> que = new LinkedList<>();
        int color = 0; // 0 : red, 1 : green

        que.add(src);
        boolean isCycle = false, isBipartite = true;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {
                    isCycle = true;
                    if (vis[rvtx] != color) {
                        isBipartite = false;
                        break;
                    }

                    continue;
                }

                vis[rvtx] = color;
                for (Edge e : graph[rvtx]) {
                    if (vis[e.v] == -1) {
                        que.addLast(e.v);
                    }
                }
            }
            color = (color + 1) % 2;
            if (!isBipartite)
                break;
        }

        if (isCycle) {
            if (isBipartite)
                System.out.println("Graph is Bi-Partite it means it has even length cycle");
            else
                System.out.println("Graph is Non Bi-Partite it means it has odd length cycle");

        } else {
            System.out.println("Graph is Bi-Partite");
        }

        return isBipartite;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        boolean res = true;
        for (int i = 0; i < N; i++)
            if (vis[i] == -1)
                res = res && isBipartite(graph, i, vis);

        return res;
    }

    public static class Pair {
        int vtx;
        int wsf;

        Pair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }

    public static void dijkstraAlgo_02(ArrayList<Edge>[] graph_, int src) {
        int N = graph_.length;
        int[] dis = new int[N];
        int[] par = new int[N];
        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });
        Arrays.fill(dis, (int) 1e9);
        Arrays.fill(par, -1);

        dis[src] = 0;
        que.add(new Pair(src, 0));

        while (que.size() != 0) {
            Pair rp = que.remove();
            if (rp.wsf > dis[rp.vtx]) { // If the weight of wsf is greater than distance array then continue to next
                                        // iteration
                continue;
            }

            for (Edge e : graph_[rp.vtx]) {
                if (rp.wsf + e.w < dis[e.v]) { // IMP CHECK: wsf + e.w is only less then distance mention in distance
                                               // array then only put put pair in priority queue
                    dis[e.v] = rp.wsf + e.w;
                    par[e.v] = rp.vtx;
                    que.add(new Pair(e.v, rp.wsf + e.w));
                }
            }
        }

        displayArray(dis);
        displayArray(par);

    }

    public static class primsPair {
        int vtx, w;

        primsPair(int vtx, int w) {
            this.vtx = vtx;
            this.w = w;
        }
    }

    public static void prims(ArrayList<Edge>[] graph, int src) {
        int N = graph.length;
        PriorityQueue<primsPair> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });

        int[] dis = new int[N];
        int[] par = new int[N];
        boolean[] vis = new boolean[N];
        Arrays.fill(dis, (int) 1e9);
        Arrays.fill(par, -1);

        ArrayList<Edge>[] ngraph = new ArrayList[N];
		for(int i = 0 ; i < N ; i++){
			ngraph[i] = new ArrayList<>();
		}

        dis[src] = 0;

        pq.add(new primsPair(src, 0));
        while (pq.size() != 0) {
            primsPair p = pq.remove();

            if (vis[p.vtx])
                continue;

            if (par[p.vtx] != -1)
                addEdge(ngraph, p.vtx, par[p.vtx], p.w);

            vis[p.vtx] = true;
            for (Edge e : graph[p.vtx]) {
                if (!vis[e.v] && e.w < dis[e.v]) {
                    dis[e.v] = e.w;
                    par[e.v] = p.vtx;
                    pq.add(new primsPair(e.v, e.w));
                }
            }
        }
        // displayArray(dis);
        // displayArray(par);
        System.out.println("--------------------------------");
        display(ngraph);
    }

    public static void displayArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void constructGraph() {
        int N = 9;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 4);
        addEdge(graph, 1, 2, 8);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 3, 4, 9);
        addEdge(graph, 4, 5, 10);
        addEdge(graph, 5, 6, 2);
        addEdge(graph, 6, 7, 1);
        addEdge(graph, 7, 0, 8);
        addEdge(graph, 1, 7, 11);
        addEdge(graph, 2, 8, 2);
        addEdge(graph, 7, 8, 7);
        addEdge(graph, 6, 8, 6);
        addEdge(graph, 2, 5, 4);
        addEdge(graph, 3, 5, 14);

        // addEdge(graph, 0, 1, 10);
        // addEdge(graph, 1, 2, 10);
        // addEdge(graph, 2, 3, 10);
        // addEdge(graph, 3, 0, 40);
        // addEdge(graph, 3, 4, 2);
        // addEdge(graph, 4, 5, 2);
        // addEdge(graph, 5, 6, 3);
        // addEdge(graph, 6, 4, 8);

        display(graph);
        boolean[] vis = new boolean[N];
        // System.out.println(dfs_findPath(graph, 0, 6, vis));
        // System.out.println(printAllPath(graph, 0, 6, "", 0, vis));
        // dijkstraAlgo_02(graph, 0);
        prims(graph, 8);
    }

    // Time Complexity : O(2E)
    public static void display(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");

            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        constructGraph();
    }
}