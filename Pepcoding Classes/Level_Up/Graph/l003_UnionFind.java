import java.util.ArrayList;
public class l003_UnionFind{
	    public static class Edge {
        int v = 0, w = 0;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public void addEdge(int u, int v, int w){
    	graph[u].add(new Edge(v, w));
    	graph[v].add(new Edge(u, w));
    }

    // O(2E)
    public static void display(ArrayList<Edge>[] graph) {
        int N = graph.length;
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }

    // This Function is Inverse Ackermann function.  => INVERSE ACKERMANN FUNCTION
    // Time Complexity : O(4) or 0(1) (Amortized O(1))
    // Method is called Path Compression 

    // PATH COMPRESSION IS THE MOST IMPORTANT PART OF FIND AND UNION
    // Reduce the Height of the tree
    // Best operation to reduce complexity

    // Worst Case : O(log(N))
    public int findPar(int u){
    	if(par[u] == u)
    		return par[u];

    	return par[u] = findPar(par[u]);
    }

    public void union(int p1, int p2){
    	int size1 = size[p1], size2 = size[p2];
    	if(size1 >= size2){
    		par[p2] = p1;
    		size[p1] += size[p2];
    	} else {
    		par[p1] = p2;
    		size[p2] += size[p1];
    	}
    }

    int[] par, size;

    // {{u1,v1,w1},{u2,v2,w2}...}
	public void unionFind(int[][] Edges){
		int N = Edges.length;
		ArrayList<Edge>[] graph = new ArrayList[N]; 
		for(int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		par = new int[N];
		size = new int[N];

		for(int i = 0; i < N; i++){
			par[i] = i;
			size[i] = 1;
		}

		for(int[] a : Edges){
			int u = a[0], v = a[1], w = a[2];

			int par1 = findPar(u);
			int par2 = findPar(v);

			if(par1 != par2){
				union(p1, p2);
				addEdge(u, v, w);
			}
		}
	}
}
