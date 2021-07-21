import java.util.HashSet;
public class dfs_question {

    // Leetcode 695 : https://leetcode.com/problems/number-of-islands/ 
    public void dfs_NumIsland(char[][] grid, int i, int j, int[][] dir) {
        grid[i][j] = '2';
        int n = grid.length, m = grid[0].length;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == '1')
                dfs_NumIsland(grid, r, c, dir);
        }

    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, componentCount = 0;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs_NumIsland(grid, i, j, dir);
                    componentCount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
        }

        return componentCount;
    }

    // ==========================================================


    // 695. Max Area of Island
    public int dfs_areaIsland(int[][] grid, int[][] dir, int i, int j) {
        grid[i][j] = 0;
        int n = grid.length, m = grid[0].length;

        int size = 0;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1)
                size += dfs_areaIsland(grid, dir, r, c);
        }

        return size + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, maxSize = 0;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int s = dfs_areaIsland(grid, dir, i, j);
                    maxSize = Math.max(maxSize, s);
                }
            }
        }
        return maxSize;
    }

    // ==========================================================



    // Leetcode 463. Island Perimeter
    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        int onceCount = 0, nbrCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 2; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];

                        if (r < n && c < m && grid[r][c] == 1)
                            nbrCount++;
                    }
                }
            }
        }
        return 4 * onceCount - 2 * nbrCount;
    }

    // ==========================================================



    // Leetcode 130. Surrounded Regions
    public void surrounded_DFS(char[][] grid, int i, int j, int[][] dir) {
        grid[i][j] = '$';
        int n = grid.length, m = grid[0].length;
        for (int d = 0; d < 4; d++) {
              int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 'O')
                surrounded_DFS(grid, r, c, dir);
        }
    }

    public void surroiunded(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 'O') {
                    surrounded_DFS(grid, i, j, dir);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '$')
                    grid[i][j] = 'O';
                else
                    grid[i][j] = 'X';
            }
        }
    }

    // ==========================================================



    // Leetcode 694. Number of Distinct Islands
    // Input:

    // {{1, 1, 0, 0, 0},
    // 1, 1, 0, 0, 0},
    // 0, 0, 0, 1, 1},
    // 0, 0, 0, 1, 1}}

    // Output: 1
    // Island 1, 1 at the top left corner is same as island 1, 1 at the bottom right corner

    int[][] dir = { { 1, 0 }, 
                    { -1, 0 }, 
                    { 0, 1 }, 
                    { 0, -1 } };

    String[] dirS = { "D", "U", "R", "L" };

    StringBuilder sb;
    int n, m;

    public void numDistinctIslands(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                sb.append(dirS[d]);
                numDistinctIslands(grid, r, c);
                sb.append("b");
            }
        }
    }

    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sb = new StringBuilder();
                    numDistinctIslands(grid, i, j);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }
    // leetcode 1905. Count Sub Islands
    // https://leetcode.com/problems/count-sub-islands/

    // We will always traverse on Grid2 
    // DFS will go on till all neighbour are traverse so that we can mark them as 0
    // After traversal we will check if the island is sub Island w.r.t grid1

    int[][] dir = { {0,1}, {0, -1}, {1, 0}, {-1, 0} };
    int n, m;
    
    public boolean countSubIslands(int[][] grid1, int[][] grid2, int i, int j) {
        grid2[i][j] = 0;
        boolean res = true;
        for(int d = 0; d < dir.length; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < n && c < m && grid2[r][c] == 1){
                res = countSubIslands(grid1, grid2, r, c) && res;   // IMPORTANT POINT:  && res is done after call so that dfs goes on
            }
        }
        
        return res && grid1[i][j] == 1;  // COMPLUSORY CHECK : Comparing the presence of Island in Grid1 if not return false;
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    count += countSubIslands(grid1, grid2, i, j) ? 1 : 0;
                }
            }
        }
        
        return count;
    }

}
