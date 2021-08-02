import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class algos {

	public class Edge {
		int u;
		int v;
		int w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	public void addEdge(int u, int v, int w) {
		graph[u].add(new Edge(v, w));
		graph[v].add(new Edge(u, w));
	}

	public void display(ArrayList<Edge>[] graph){
		int n = graph.length;
		for(int i = 0; i < n; i++){
			System.out.print(i + " -> ");
			for(Edge e : graph[i]){
				System.out.print("( " + e.v + "," + e.w + " ) ")
			}
			System.out.println();
		}
	}

	public int findPar(int u) {
		return par[u] == u ? u : (par[u] = findPar(par[u]));
	}

	public void union(int p1, int p2) {
		if (size[p1] <= size[p2]) {
			par[p1] = par[p2];
			size[p2] += size[p1];
		} else {
			par[p2] = par[p1];
			size[p1] += size[p2];
		}
	}

	int[] par, size;

	public void findUnion(int[][] edges, ArrayList<Edge>[] graph) {
		int n = edges.length;
		par = new int[n];
		size = new int[n];

		for (int i = 0; i < n; i++) {
			par[i] = i;
			size[i] = 1;
		}

		for (int[] e : edges) {
			int u = e[0], v = e[1], w = e[2];

			int p1 = findPar(u);
			int p2 = findPar(v);

			if (p1 != p2) {
				union(p1, p2);
			}
		}
	}

	// Kruskal's Algorithm
	public void kurskalAlgo(int[][] edges){
    	Arrays.sort(edges, (a,b)=>{
    		return a[2] - b[2];
    	});


    	int n = edges.length;
    	ArrayList<Edge>[] graph = new ArrayList[n];
    	for(int i = 0; i < n; i++)
    		graph[i] = new ArrayList<>();


    	findUnion(edges, graph);
    }

	// ==========================================================================

	// Articulation Point

	// disc : discovery time of that particular vertex
	// low : lowest time to reach that particular vertex
	int[] disc, low;
	boolean[] vis, articulation;
	int rootCalls = 0, time = 0;

	public static void dfs(ArrayList<Edge>[] graph, int src, int par) {
		disc[src] = low[src] = time++;
		vis[src] = true;
		for (Edge e : graph[src]) {
			if (!vis[e.v]) {
				if (par == -1) // For articulation point the rootCalls is import
					rootCalls++;// Calls is more than one then it can b considered as an articulation point
								// otherwise not

				dfs(graph, e.v, src);

				if (disc[src] <= low[e.v])
					articulation[src] = true;

				low[src] = Math.min(low[src], low[e.v]);
			} else if (e.v != par) {
				low[src] = Math.min(low[src], disc[e.v]);
			}
		}
	}

	public static void articulationPointAndBridges(ArrayList<Edge>[] graph) {
		int N = graph.length;
		low = new int[N];
		disc = new int[N];
		articulation = new boolean[N];
		vis = new boolean[N];

		for (int i = 0; i < N; i++) {
			if (!vis[i]) {
				dfs(graph, i, -1);
			}
		}

	}

	// Critical Edge
	// Leetcode 1192. Critical Connections in a Network
	int[] low, disc;
	boolean[] vis;
	int time = 0;

	public void dfs(ArrayList<Integer>[] graph, int src, int par, List<List<Integer>> ans) {
		low[src] = disc[src] = time++;
		vis[src] = true;

		for (int v : graph[src]) {
			if (!vis[v]) {
				dfs(graph, v, src, ans);

				if (disc[src] < low[v]) {
					List<Integer> base = new ArrayList<>();
					base.add(src);
					base.add(v);
					ans.add(base);
				}

				low[src] = Math.min(low[src], low[v]);
			} else if (v != par) {
				low[src] = Math.min(low[src], disc[v]);
			}
		}

	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> ans = new ArrayList<>();
		low = new int[n];
		disc = new int[n];
		vis = new boolean[n];

		ArrayList<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (List<Integer> a : connections) {
			graph[a.get(0)].add(a.get(1));
			graph[a.get(1)].add(a.get(0));
		}

		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				dfs(graph, i, -1, ans);
			}
		}
		return ans;
	}

	// Dijkstra Algorithm
	// Approach 1

	public static class Pair {
		int vtx;
		int par;
		int w;
		int wsf;

		Pair() {
		}

		Pair(int vtx, int wsf) {
			this.vtx = vtx;
			this.wsf = wsf;
		}

		Pair(int vtx, int par, int w, int wsf) {
			this.vtx = vtx;
			this.par = par;
			this.w = w;
			this.wsf = wsf;
		}

	}

	public static void addEdge_(ArrayList<Edge>[] graph_, int u, int v, int w) {
		graph[u].add(new Edge(u, v, w));
		graph[v].add(new Edge(v, u, w));
	}

	public static void dijkstraAlgo(ArrayList<Edge>[] graph, int src) {
		int n = graph.length;
		ArrayList<Edge>[] graph_ = new ArrayList[N];
		for (int i = 0; i < n; i++) {
			graph_[i] = new ArrayList<>();
		}
		boolean[] vis = new boolean[N];
		PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> {
			return a.wsf - b.wsf;
		});

		que.add(new Pair(src, -1, 0, 0));

		while (que.size() != 0) {
			Pair rp = que.remove();

			if (vis[rp.vtx]) {
				continue;
			}

			if (rp.par == -1)
				addEdge_(graph_, rp.vtx, rp.par, rp.w);

			vis[rp.vtx] = true;
			for (Edge e : graph_[rp.vtx]) {
				if (!vis[e.v]) {
					que.add(new Pair(e.v, rp.vtx, e.w, rp.wsf + e.w));
				}
			}
		}
	}

	// Approach 2
	// Dis and par array
	public static void dijkstraAlgo_02(ArrayList<Edge>[] graph_, int src) {
		int N = graph_.length;
		int[] dis = new int[N];
		int[] par = new int[N];
		PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> {
			return a.wsf - b.wsf;
		});
        Arrays.fill(dis, (int)1e9);
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
	}


	// Prims Algorithm
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
        // System.out.println("--------------------------------");
        // display(ngraph);
    }

}
