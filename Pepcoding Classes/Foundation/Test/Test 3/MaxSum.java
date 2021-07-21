import java.io.*;
import java.util.*;

public class MaxSum {
    public static Scanner scn = new Scanner(System.in);

    public static int maxSum(int[] arr, int idx, boolean[] vis, int ssf, int k, int[][] dp){
        if(idx >= arr.length || k == 0){
            System.out.println(ssf);
            return dp[idx][k] = 0;
        }


        if(dp[idx][k] != -1){
            return dp[idx][k];
        }

        int sI = 0, sE = 0;
        if(!vis[idx]){
            vis[idx] = true;
            sI = maxSum(arr, idx + 2, vis, ssf+ arr[idx], k - 1, dp) + arr[idx];
            vis[idx] = false;
        }

        sE = maxSum(arr, idx + 1, vis, ssf, k, dp);

        return dp[idx][k] = Math.max(sI, sE);
    }
    public static void display(int[][] dp) {
        for (int[] d : dp) {
            for (int  ele : d) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i= 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int[][] dp = new int[arr.length + 2][k + 1];
        for(int[] d : dp){
                Arrays.fill(d, -1);
        }

        boolean[] vis = new boolean[n];

        int sum = 0;
        sum = maxSum(arr, 0, vis, 0, k, dp);
        // display(dp);
        System.out.println(sum);
    }
}