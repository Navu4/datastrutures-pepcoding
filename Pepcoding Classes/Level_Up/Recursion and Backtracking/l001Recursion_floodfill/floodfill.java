import java.util.Scanner;

public class floodfill {
    public static Scanner scn = new Scanner(System.in);

    public static int floodfill_PrintPathAndReturnCount( int sr, int sc, int er, int ec, int[][] dir, String[] ds, boolean[][] vis, String psf) {

        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if (x >= 0 && y >= 0 && x < vis.length && y < vis[0].length && !vis[x][y]) {
                count += floodfill_PrintPathAndReturnCount(x, y, er, ec, dir, ds, vis, psf + ds[d]);
            }
        }
        vis[sr][sc] = false;

        return count;
    }

    public static class Pair{
        int dsf;
        String psf;
        Pair(String psf, int dsf){
            this.psf = psf;
            this.dsf = dsf;
        }
    }
    public static void floodfill_( int sr, int sc, int er, int ec, int[][] dir, String[] ds, boolean[][] vis, String psf, int dsf, Pair maxPath, Pair minPath) {

        if (sr == er && sc == ec) {
            if(dsf > maxPath.dsf){
                maxPath.dsf = dsf;
                maxPath.psf = psf;
            } else if(dsf < minPath.dsf){
                minPath.dsf = dsf;
                minPath.psf = psf;
            }
            return;
        }

        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];

            if (x >= 0 && y >= 0 && x < vis.length && y < vis[0].length && !vis[x][y]) {
                floodfill_(x, y, er, ec, dir, ds, vis, psf + ds[d], dsf + 1, maxPath, minPath);
            }
        }
        vis[sr][sc] = false;
    }

    public static void floodfill_() {
        int n = scn.nextInt();
        int m = scn.nextInt();
        boolean[][] vis = new boolean[n][m];

        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        String[] ds = { "T", "E", "L", "S", "D", "W", "R", "N" };

        Pair maxPath = new Pair("", -(int)1e9);
        Pair minPath = new Pair("", (int)1e9);
        // System.out.println(floodfill_PrintPathAndReturnCount( 0, 0, n - 1, m - 1, dir, ds, vis, ""));
        floodfill_(0, 0, n - 1, m - 1, dir, ds, vis, "", 0, maxPath, minPath);

        System.out.println("Maximum Path : " + maxPath.psf);
        System.out.println("Minimum Path : " + minPath.psf);
    }

    public static void main(String[] args) {
        floodfill_();
    }
}
