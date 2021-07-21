// import java.io.*;
// import java.util.*;

import java.util.Scanner;
import java.util.ArrayList;

public class l001backtracking{
    public static Scanner scn = new Scanner(System.in);


    // Print Path of Maze 
    // Input N & M 
    //  Starting from 0,0 to N,M

    public static void PathsInMaze(int sr, int sc, int dr, int dc, int[][] vis, int[][] dir, String[] dirS, String ans){
        if( sr == dr && sc == dc ){
            System.out.println(ans);
            return ;
        }

        vis[sr][sc] = 1;
        int count = 0;
        int n = vis.length ;
        int m = vis[0].length;

        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && ( vis[r][c] == 0 ) ){
                PathsInMaze(r, c, dr, dc, vis, dir, dirS, ans + dirS[d]);
            }
        }
    
        vis[sr][sc] = 0;
        return;
    }

    // ---------------------------------------------------------------------------------


    // Count and Print Number of Paths and Path in Maze
    // Input N & M 
    //  Starting from 0,0 to N,M

    public static int countPathsInMaze(int sr, int sc, int dr, int dc, int[][] vis, int[][] dir, String[] dirS, String ans){
        if( sr == dr && sc == dc ){
            System.out.println(ans);
            return 1;
        }

        vis[sr][sc] = 1;
        int count = 0;
        int n = vis.length ;
        int m = vis[0].length;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && ( vis[r][c] == 0 ) ){
                count += countPathsInMaze(r, c, dr, dc, vis, dir, dirS, ans +dirS[d]);
            }
        }
    
        vis[sr][sc] = 0;
        return count;
    }

    // -----------------------------------------------------------------------------

    // Count and Print Number of Paths and Path in Maze With Jumps
    // Jumps are allowed
    // Input N & M 
    //  Starting from 0,0 to N,M

    public static int floodFillJump(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS,
            String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        vis[sr][sc] = true;

        int n = vis.length;
        int m = vis[0].length;

        int count = 0;
        for (int rad = 1; rad <= Math.max(n, m); rad++)
            for (int d = 0; d < dir.length; d++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                // check r and c with in boundary
                if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c]) {
                    count += floodFillJump(r, c, er, ec, vis, dir, dirS, ans + dirS[d] + rad);
                }
            }

        vis[sr][sc] = false;
        return count;
    }

    // ---------------------------------------------------------------------------------
    
    // ReturnType Path in a Maze 
    public static ArrayList<String> returnPathsInMaze(int sr, int sc, int dr, int dc, int[][] vis, int[][] dir, String[] dirS){
        if( sr == dr && sc == dc ){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        vis[sr][sc] = 0;
        
        // int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
        // String[] dirS = {"D", "L", "R","U" };
        
        ArrayList<String> ans = new ArrayList<>();

        int n = vis.length ;
        int m = vis[0].length;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && ( vis[r][c] == 1 ) ){
                
                ArrayList<String> smallAns = returnPathsInMaze(r, c, dr, dc, vis, dir, dirS);
                for(String s : smallAns){
                    ans.add(dirS[d] + s)  ;  
                }
            }
        }
    
        vis[sr][sc] = 1;
        return ans;
    }
    
    
    
    // ---------------------------------------------------------------------------------
    
    
    
    // ---------------------------------------------------------------------------------

    // Rat in a Maze Problem - I
    // https://www.geeksforgeeks.org/rat-in-a-maze-backtracking-2/
    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
    public static ArrayList<String> PathsInMaze(int sr, int sc, int dr, int dc, int[][] vis, int[][] dir, String[] dirS){
        if( sr == dr && sc == dc ){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        vis[sr][sc] = 0;
        
        ArrayList<String> ans = new ArrayList<>();

        int n = vis.length ;
        int m = vis[0].length;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < n && c < m && ( vis[r][c] == 1 ) ){
                
                ArrayList<String> smallAns = PathsInMaze(r, c, dr, dc, vis, dir, dirS);
                for(String s : smallAns){
                    ans.add(dirS[d] + s)  ;  
                }
            }
        }
    
        vis[sr][sc] = 1;
        return ans;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
        String[] dirS = {"D", "L", "R","U" };
        
        if(m[0][0] == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("-1");
            return base;
        }
        
        ArrayList<String> myAns = PathsInMaze(0,0,n-1,n-1,m,dir,dirS);
        
        int len = myAns.size();
        if(len == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("-1");
            return base;
        } 
        else{
            return myAns;
        }    
    }
    
    // ---------------------------------------------------------------------------------
            
    // Special Matrix
    // https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/

    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1#
    public static int countOfPathInMaze(int sr, int sc, int dr, int dc, boolean[][] vis, int[][] dir, String[] dirS){

        if(sr == dr && sc == dc){
            return 1;
        }
        
        vis[sr][sc] = true;

        int n = vis.length;
        int m = vis[0].length;
        int count = 0;

        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r < n && c < m && r >= 0 && c >= 0 && !vis[r][c] ){
                count += countOfPathInMaze(r, c, dr, dc, vis, dir, dirS);
            }
        }


        vis[sr][sc] = false;
        return count;
    }
 
    public static int specialMatrix(int n, int m, int[][] bc){
        


        int[][] dir = {{0,1},{1,0}};
        String[] dirS = { "R" , "D" };

        boolean[][] vis = new boolean[n][m];

        for(int b = 0; b < bc.length; b++)+
            int c = bc[b][1] -1 ;

            vis[r][c] = true; 
        }

        if(vis[0][0] == true){
            return 0;
        }
        return countOfPathInMaze(0, 0, n-1, m-1, vis, dir, dirS);
    }


// --------------------------------------------------------------------------------------

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // tnc : total no cells
    public static int knightMove(int sr, int sc, int move, int tnc, int[][] vis, int[][] dir) {
        if (move == tnc) {
            vis[sr][sc] = move;
            displayBoard(vis);
            vis[sr][sc] = 0;
            return 1;
        }

        vis[sr][sc] = move;

        int n = vis.length;
        int m = vis[0].length;

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            // check r and c with in boundary
            if (r >= 0 && c >= 0 && r < n && c < m && vis[r][c] == 0) {
                count += knightMove(r, c, move + 1, tnc, vis, dir);
            }
        }

        vis[sr][sc] = 0;
        return count;
    }

    public static void KnightTour() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sr = scn.nextInt();
        int sc = scn.nextInt();
        int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
        int[][] vis = new int[n][n];
        // for(int[] d : vis) Arrays.fill(d,-1);

        knightMove(sr, sc, 1, n * n, vis, dir);

    }

    public static void main(String[] args) {
        int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        // int[][] dir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

        String[] dirS = { "L", "D", "R", "U" };

        int n = 3, m = 3;
        boolean[][] vis = new boolean[n][m];
        System.out.println(floodFillJump(0, 0, n - 1, m - 1, vis, dir, dirS, ""));
    }
// ---------------------------------------------------------------------------------------

    // public static void main(String[] args){
    //     // int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    //     // String[] dirS = {"D", "L", "R","U" };
    
        
    //     // int n = scn.nextInt();
    //     // int m = scn.nextInt();
    //     // int K = scn.nextInt();

    //     // int[][] arr = new int[K][2];

    //     // for(int i = 0; i < K; i++){
    //     //     for(int j = 0; j < 2; j++){
    //     //         arr[i][j] = scn.nextInt();
    //     //     }
    //     // }

    //     // System.out.println(specialMatrix(n,m,arr));

    //     // KnightTour();

    //     // PathsInMaze(0, 0, n-1, m-1, arr, dir, dirS, "");
    //     // System.out.println(countPathsInMaze(0, 0, n-1, m-1, arr, dir, dirS, ""));

    //     // ArrayList<String> myAns = returnPathsInMaze(0, 0 , n-1 , m-1, arr, dir, dirS);

    //     // int len = myAns.size();
    //     // System.out.println(len);
    //     // System.out.println(returnPathsInMaze(0, 0 , n-1 , m-1, arr, dir, dirS));
    // }
}