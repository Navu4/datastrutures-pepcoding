import java.util.*;

public class spreadOfInfection {
    public static int infectedCount(int[][] graph, int src, boolean[] vis, int timeLimit){
        int infectedCounts = 0, time = 0;
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);

        vis[src] = true;
        infectedCounts++;
        time++;

        while(que.size() != 0){
            int size = que.size();

            while (size-- > 0)  {
                int rVtx = que.removeFirst();

                for (Integer e  : graph[rVtx]) {
                    if(!vis[e]){
                        que.addLast(e);
                        vis[e] = true;

                        if(time + 1 <= timeLimit){
                            infectedCounts++;
                        } else {
                            return infectedCounts;
                        }
                    }
                }
            }
            

            time++;
        }
        return infectedCounts;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2, 4}, {3, 5, 6}, {4, 6}, {4, 5}};

        boolean[] vis = new boolean[graph.length];
        System.out.println(infectedCount(graph, 6, vis, 3));    
    }    
}
