import java.io.*;
import java.util.*;

public class BFS_level {
    public static Scanner scn = new Scanner(System.in);
    public static class Edge{
        int u;
        int v;
        
        Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    
    static ArrayList<Edge>[] graph ;
    
    public static void main(String[] args) {
        int N = scn.nextInt();
        int n = N;
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();
        
        while(N-- > 1){
            int u = scn.nextInt();
            int v = scn.nextInt();
            
            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
        // display(graph);
        
        int level = scn.nextInt();
        boolean[] vis = new boolean[n + 1];
        
         System.out.println(bfs(1, vis, level));
    }
    
    public static void display(ArrayList<Edge>[] graph) {
        for (int i = 1; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e.v +  ", " );
            }
            System.out.println();
        }

    }
    
    public static int bfs(int src, boolean[] vis, int lvl) {
        int level = 1;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        vis[src] = true;
        while (que.size() != 0) {
            int size = que.size();
            if(level == lvl){
                return size;
            }
            while (size-- > 0) {
                int rVtx = que.removeFirst();
                for (Edge e : graph[rVtx]) {
                    if (!vis[e.v]) {
                        que.addLast(e.v);
                        vis[e.v] = true;
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
}