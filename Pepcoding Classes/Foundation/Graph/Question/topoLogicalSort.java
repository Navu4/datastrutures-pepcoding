import java.io.*;
import java.util.*;

public class topoLogicalSort {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      boolean[] vis = new boolean[vtces];
      ArrayList<Integer> ans = new ArrayList<>();
      for(int v = 0; v < vtces; v++){
          if(!vis[v]){
              dfs_topo(graph, v, vis, ans);
          }
      }
      
      for(int i = ans.size() - 1; i >= 0; i--){
          System.out.println(ans.get(i));
      }
   }
   
   public static void dfs_topo(ArrayList<Edge>[] graph, int src, boolean[] vis, ArrayList<Integer> ans){
       vis[src] = true;
       
       for(Edge e : graph[src]){
           if(!vis[e.nbr]){
               dfs_topo(graph, e.nbr, vis, ans);
           }
       }
       
       ans.add(src);
   }

}



















