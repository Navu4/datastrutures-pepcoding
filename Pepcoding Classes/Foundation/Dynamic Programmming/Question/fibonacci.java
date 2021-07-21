import java.util.*;
public class fibonacci {

    public static Scanner scn = new Scanner(System.in);

    public static void print(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static int fib_memo(int n, int[] dp) {
        if(n <= 1){
            dp[n] = n;
            return dp[n];          
        }

        if(dp[n] != 0)
            return dp[n];

        int ans = fib_memo(n - 1, dp) + fib_memo(n - 2, dp);  //dp[n -1] + dp[n - 2]
        dp[n] = ans;
        return ans;
    }

    public static void fibo_dp(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if(n <= 1){
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
    }

    public static void fibo_Opti(int n) {
        int a = 0, b = 1;
        for(int i = 0; i <= n; i++){
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }

    public static void fibo() {
        int n = 6;
        int[] dp = new int[n + 1];
        // fib_memo(n, dp);
        fibo_dp(n, dp);
        // fibo_Opti(n);
        // System.out.println();

        print(dp);
    }

    public static void main(String[] args) {
        fibo();
    }
}
