public class isGraphCyclic {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      boolean[] vis = new boolean[vtces];
      for(int v = 0; v < vtces; v++){
          if(!vis[v]){
              boolean cycle = isCyclic(graph, v, vis);
              if(cycle){
                  System.out.println(true);
                  return;
              }
          }
      }
      
      System.out.println(false);
   }
   
   public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] vis){
       LinkedList<Integer> que = new LinkedList<>();
       que.addLast(src);
       
       while(que.size() != 0){
           int rVtx = que.removeFirst();
           
           if(vis[rVtx]){
               return true;
           }
           
           vis[rVtx] = true;
           for(Edge e : graph[rVtx]){
               if(!vis[e.nbr]){
                   que.addLast(e.nbr);
               }
           }
       }
       
       return false;
   }

}