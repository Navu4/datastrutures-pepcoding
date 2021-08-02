public class bfs_questions{

    // IMPORTANT QUESTION 
    // Intuitive and help for solving other questions 
    
    public int orangesRotting(int[][] grid) {
        LinkedList<Integer> que = new LinkedList<>();
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int freshOranges = 0, time = 0, n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                else if (grid[i][j] == 2) {
                    que.addLast(i * m + j);
                    // grid[i][j] = 2; // mark them visited
                }
            }
        }

        if (freshOranges == 0)
            return 0;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rottedOrangeIDX = que.removeFirst();
                int sr = rottedOrangeIDX / m, sc = rottedOrangeIDX % m;
                for (int d = 0; d < 4; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                        if (--freshOranges == 0)
                            return time + 1;
                        grid[r][c] = 2;
                        que.addLast(r * m + c);
                    }
                }
            }
            time++;
        }

        return -1;
    }


	// Leetcode  1091. Shortest Path in Binary Matrix
	 public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        
            int[][] dir = { { 1, 0 }, 
                    { -1, 0 }, 
                    { 0, 1 }, 
                    { 0, -1 },
                    { 1, 1 }, 
                    { -1, -1 }, 
                    { -1, 1 }, 
                    { 1, -1 }};
        int n = grid.length, m = grid[0].length;
                       
        int shortestPath = 1;
        LinkedList<Integer> que = new LinkedList<>();        
        que.addLast(0);
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int idx = que.removeFirst();
                
                int i = idx / m , j = idx % m; 
                if(i == n - 1 && j == m - 1){
                    return shortestPath;
                }             
                for(int d = 0; d < dir.length; d++){
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    
                    if(r >=0 && c >= 0 && r < n && c < m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        que.addLast(r * m + c);
                    }
                }
            }
            
            shortestPath++;
        }
                       
        return -1;
    }


   	// Leetcode 542. 01 Matrix
   	// 2 Approaches 

   	// Update the distance from end to starting point 
   	// BFS call from 0 rather than from 1

   	// Actuall bfs will help if we start the call from 0 blocks
   	// With Space : Space Complexity : O(n*m) 
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        
        boolean[][] vis = new boolean[n][m];
        
        int[][] dir = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    que.addLast(i * m + j);
                }
            }
        }
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int idx = que.removeFirst();  
                
                int sr = idx / m , sc = idx % m;
                for(int d = 0; d < dir.length; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]){
                        vis[r][c] = true;
                        mat[r][c] = mat[sr][sc] + 1;
                        que.addLast(r * m + c);
                    }
                }
            }
        }
        
        return mat;
    }

    // Approach 2
    // change the value of distance by Negative(-ve) of that value and it will help
    // Space Complexity : O(1)
    // Time Complexity : 2*n*m => O(n*m)
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        
        
        int[][] dir = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    que.addLast(i * m + j);
                }
            }
        }
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int idx = que.removeFirst();  
                
                int sr = idx / m , sc = idx % m;
                for(int d = 0; d < dir.length; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && mat[r][c] > 0) {   // mat[r][c] > 0 for negative value it will not call 
                        mat[r][c] = -(-mat[sr][sc] + 1); // Converting the negative dist to +ve and then again -ve
                        que.addLast(r * m + c);
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] < 0){
                    mat[i][j] = - mat[i][j];
                }
            }
        }
        
        return mat;
    }

    // Leetcode 785. Is Graph Bipartite?
    // Using BFS and COMPARING THE LEVEL 
    public class Pair{
        int v = 0;
        int level = 0;
        
        Pair(int v, int level){
            this.v = v;
            this.level = level;
        }
    }
    

    // In vis
    // -1 : undefined Level
    // Otherwise defined level 
    public boolean isBipartite(int[][] graph, int src, int[] vis) {
        
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(src,  0));
        
        
        while(que.size() != 0){
            int size = que.size();
            
            while(size-- > 0){
                Pair rVtx = que.removeFirst();
                 
                if(vis[rVtx.v] != -1){ // if not undefined 
                    if(rVtx.level != vis[rVtx.v])  // If vertex donot occur at same level again i.e. Odd length Cycle
                        return false;
                } else {
                    vis[rVtx.v] = rVtx.level;   // Set Level 
                }
                
                
                for(int ele : graph[rVtx.v]){
                    if(vis[ele] == -1){
                        que.addLast(new Pair(ele, rVtx.level + 1));
                    }
                }
            }
        }
        
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        
        int[] vis = new int[graph.length];   // Array for Level 
        Arrays.fill(vis, -1);
        
        for(int v = 0; v < graph.length; v++){
            if(vis[v] == -1){
                if(!isBipartite(graph, v, vis)){
                   return false;
                }   
            }
        }
        
        return true;
    }

    // Using Color Approach and view 
	// Colors
	// -1 : Undefined
	// 0 : Red
    // 1 : Green

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


    // Leetcode 886. Possible Bipartition

    // Bipartite technique using BFS and COMPARING THE LEVEL 
    // It can also 
     public class Edge {
        int u = 0;
        int v = 0;
        
        Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    
    public class Pair{
        int v = 0;
        int level = 0;
        
        Pair(int v, int level){
            this.v = v;
            this.level = level;
        }
    }
    
    public boolean bipartite(ArrayList<Edge>[] graph, int src, int[] vis){
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(src, 0));
        
        while(que.size() != 0){
            int size = que.size();
            
            while(size-- > 0){
                Pair rVtx = que.removeFirst();
                
                if(vis[rVtx.v] != -1){
                     if(vis[rVtx.v] != rVtx.level)
                         return false;
                } else {
                    vis[rVtx.v] = rVtx.level;
                }
                
                
                for(Edge e : graph[rVtx.v]){
                    if(vis[e.v] == -1){
                        que.addLast(new Pair(e.v, rVtx.level + 1));
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean bipartite(ArrayList<Edge>[] graph){
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        
        for(int v = 0; v < graph.length; v++){
            if(vis[v] == -1){
                if(!bipartite(graph, v, vis)){
                   return false;
                }   
            }
        }
        
        return true;
    }
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
            
        }
        
        for(int i = 0; i < dislikes.length; i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            
            graph[u].add(new Edge(u,v));
            graph[v].add(new Edge(v,u));
        }
        
        return bipartite(graph);
    }
    


	// leetcode 663 · Walls and Gates
	// Question Link : https://www.lintcode.com/problem/663/
	
	public void wallsAndGates(int[][] rooms) {
            
        int n = rooms.length, m = rooms[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        
        int[][] dir = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0){
                    que.addLast(i * m + j);
                }
            }
        }
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                int idx = que.removeFirst();  
                
                int sr = idx / m , sc = idx % m;
                for(int d = 0; d < dir.length; d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m &&  rooms[r][c] == 2147483647){
                        rooms[r][c] = rooms[sr][sc] + 1;
                        que.addLast(r * m + c);
                    }
                }
            }
        }
        
    }


}