import java.util.Scanner;

public class MazePath {
    public static Scanner scn = new Scanner(System.in);

    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void print2D(int[][] arr){
        for (int[] a : arr) {
            print(a);
        }
        System.out.println();
    }

    public static int mazePath_recursive(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath_recursive(r, c, er, ec, dir, dp);
            }
        }
        return count;
    }

    public static int mazePath_memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath_memo(r, c, er, ec, dir, dp);
            }
        }
        return count;
    }

    public static void mazePath(int n, int m) {
        int[][] dp = new int[n][m];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

        System.out.println(mazePath_recursive(0, 0, n - 1, m - 1, dir, dp));

        print2D(dp);
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();

        mazePath(n, m);
    }
}
