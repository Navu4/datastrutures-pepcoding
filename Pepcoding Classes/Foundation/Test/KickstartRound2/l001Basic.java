import java.util.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);

    public static void print(int[] dp) {
        for (int j = 0; j < dp.length - 1; j++) {
            System.out.print(dp[j] + " ");
        }

        System.out.println();
    }

    public static void solve(int N, String str, int[] dp) {
        for (int n = 0; n < N; n++) {
            if (n == 0) {
                dp[n] = 1;
                continue;
            }

            if (str.charAt(n) > str.charAt(n - 1)) {
                dp[n] = dp[n - 1] + 1;
            } else {
                dp[n] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int T = scn.nextInt();

        ArrayList<int[]> ans = new ArrayList<>();

        while (T-- > 0) {
            int N = scn.nextInt();

            String str = scn.next();

            int[] dp = new int[N + 1];
            solve(N, str, dp);

            ans.add(dp);
        }
        int idx1 = 1;
        for (int[] ele : ans) {
            System.out.print("Case #" + idx1 + ": ");
            print(ele);
            idx1++;
        }
    }
}
