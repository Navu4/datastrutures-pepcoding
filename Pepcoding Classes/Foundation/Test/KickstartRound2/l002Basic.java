import java.util.*;

public class l002Basic {
    public static Scanner scn = new Scanner(System.in);

    public static void print(int[] dp) {
        for (int j = 1; j < dp.length - 1; j++) {
            System.out.print(dp[j] + " ");
        }

        System.out.println();
    }
    // 9 7 5 3
    public static class Pair{
        int len;
        int idx;

        Pair(int len, int idx){
            this.len = len;
            this.idx = idx;
        }
    }

    public static int solve(int N, int[] nums, int[] dp) {
        if(arr.length <= 2){
            return 2;
        }

        int[] arr = nums;
 
        int len = 1;
        int diff = -(int)1e9;
        int changeIdx = -1;
        int n = 1;

        for(; n < N; n++){
            int d = arr[n -1] - arr[n];

            if(diff == -(int)1e9)
                diff = d;
            else if(diff == d)
                len++;
            else if(diff != d && changeIdx == -1){
                len++;
                changeIdx = n;
                arr[n] += d; 
            }
            
        }

        return -1;
    }

    public static void main(String[] args) {
        int T = scn.nextInt();

        ArrayList<Integer> ans = new ArrayList<>();

        while (T-- > 0) {
            int N = scn.nextInt();

            // String str = scn.next();

            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }

            int[] dp = new int[N + 1];
            int val = solve(N, arr, dp);

            ans.add(val);
        }
        int idx1 = 1;
        for (int ele : ans) {
            System.out.println("Case #" + idx1 + ": " + ele);
            idx1++;
        }
    }
}
