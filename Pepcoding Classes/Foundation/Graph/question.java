import java.util.Arrays;

public class question {
    public boolean isBipartite(int[][] graph, int src, int[] vis) {
        LinkedList<Integer> que = new LinkedList<>();

        que.add(src);
        int color = 0;

        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {
                    if (vis[rvtx] != color) // conflict
                        return false;

                    continue;
                }

                vis[rvtx] = color;
                for (int v : graph[rvtx]) {
                    if (vis[v] == -1) {
                        que.addLast(v);
                    }
                }
            }

            color = (color + 1) % 2;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == -1) {
                if (!isBipartite(graph, i, vis)) {
                    return false;
                }
            }
        }

        return true;
    }
}
