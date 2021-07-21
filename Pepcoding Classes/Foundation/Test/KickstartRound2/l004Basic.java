import java.util.*;

public class l004Basic {
    public static Scanner scn = new Scanner(System.in);

    public static class Edge {
        long u;
        long v;
        long allowedWeight;
        long tollPrice;

        Edge(Long u, Long v, Long allowedWeight, Long tollPrice) {
            this.u = u;
            this.v = v;
            this.allowedWeight = allowedWeight;
            this.tollPrice = tollPrice;
        }
    }

    public static ArrayList<Edge>[] constructGraph(int N) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            long uVtx = scn.nextLong();
            long vVtx = scn.nextLong();
            long wVtx = scn.nextLong();
            long tollOfVtx = scn.nextLong();

            graph[(int)uVtx].add(new Edge(uVtx, vVtx, wVtx, tollOfVtx));
            graph[(int)vVtx].add(new Edge(vVtx, uVtx, wVtx, tollOfVtx));
        }

        return graph;
    }

    public static void display(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print(e.v + " ");
            }
            System.out.println();
        }
    }


    public static boolean dfs_toll(long src, long dest, ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Long> ans, Long weight) {
        if(src == dest){
            return true;
        }

        vis[(int)src] = true;
        boolean res = false;
        for (Edge e : graph[(int)src]) {
            if(!vis[(int)e.v]) {
                res = dfs_toll((long)e.v, (long)dest, graph, vis, ans, weight);
                if(res){
                    // System.out.println(e.u + " -> " + e.v + " @ " + e.allowedWeight + ", " + e.tollPrice);
                    if(e.allowedWeight <= weight){
                        ans.add((long)e.tollPrice);
                    }
                    return res;
                }
            }

        } 

        return res;
    }

    // Function to return gcd of a and b
    public static long gcd(Long a, Long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
 
    // Function to find gcd of array of
    // numbers
    public static long findGCD(ArrayList<Long> arr)
    {   
        long result = 0;
        for (long element: arr){
            result = gcd(result, element);
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }

    public static void solve(int caseNo) {
        int Edges = scn.nextInt();
        int queries = scn.nextInt();

        ArrayList<Edge>[] graph = constructGraph(Edges);
        // display(graph);


        ArrayList<Long> ans = new ArrayList<>();
        for (long i = 0; i < queries; i++) {
            long src = scn.nextInt();
            long weight = scn.nextInt();
            ArrayList<Long> arr = new ArrayList<>();
            boolean[] vis = new boolean[(int)(Edges + 1)];

            dfs_toll(src, (long)1, graph, vis, arr, weight);
            // System.out.println(arr);

            ans.add((long)findGCD(arr));
        }

        System.out.print("Case #" + caseNo + ": ");
        for (long ele : ans) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int T = scn.nextInt();

        int idx = 1;
        while (T-- > 0) {
            solve(idx++);
        }
    }
}
