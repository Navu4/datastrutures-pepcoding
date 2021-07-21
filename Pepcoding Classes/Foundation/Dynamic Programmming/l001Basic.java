import java.util.*;

public class l001Basic {
    public static Scanner scn = new Scanner(System.in);

    public static void print(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] a : arr) {
            print(a);
        }

        System.out.println();
    }

    public static void print2DString(String[][] dp){
        for (String[] s : dp) {
            for (String str : s) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    // Fibonaccie
    // Using memoization
    public static int fib_memo(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }

        if (dp[n] != 0)
            return dp[n];

        int ans = fib_memo(n - 1, dp) + fib_memo(n - 2, dp); // dp[n -1] + dp[n - 2]
        dp[n] = ans;
        return ans;
    }

    // Using DP
    public static void fibo_dp(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];
            dp[n] = ans;
        }
    }

    // Optimized
    public static void fibo_Opti(int n) {
        int a = 0, b = 1;
        for (int i = 0; i <= n; i++) {
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

    // --------------------------------------------------------

    // 70. Climbing Stairs
    public int climbStairs(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }

        if (dp[n] != 0)
            return dp[n];

        int steps = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        return dp[n] = steps;
    }

    public int climbStairs_DP(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int steps = dp[n - 1] + dp[n - 2];// climbStairs(n-1,dp) + climbStairs(n-2,dp);
            dp[n] = steps;
        }

        return dp[N];
    }

    public int climbStairs_Opti(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return a;

    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // int ans = climbStairs(n,dp);
        // int ans = climbStairs_DP(n,dp);
        int ans = climbStairs_Opti(n);

        return ans;
    }

    // --------------------------------------------------------

    // leetcode 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost, int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }
        if (dp[n] != 0)
            return dp[n];

        int minCostOfOneStep = minCostClimbingStairs(cost, n - 1, dp);
        int minCostOfTwoStep = minCostClimbingStairs(cost, n - 2, dp);

        int ans = Math.min(minCostOfOneStep, minCostOfTwoStep) + (n != cost.length ? cost[n] : 0);

        return dp[n] = ans;
    }

    public int minCostClimbingStairs_DP(int[] cost, int N, int[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }

            int minCostOfOneStep = dp[n - 1];// minCostClimbingStairs(cost, n - 1, dp);
            int minCostOfTwoStep = dp[n - 2];// minCostClimbingStairs(cost, n - 2, dp);

            int ans = Math.min(minCostOfOneStep, minCostOfTwoStep) + (n != cost.length ? cost[n] : 0);

            dp[n] = ans;
        }

        return dp[N];
    }

    public int minCostClimbingStairs_Opti(int[] cost, int N) {

        int a = cost[0], b = cost[1];
        for (int i = 2; i <= N; i++) {
            int minVal = Math.min(a, b) + (i != cost.length ? cost[i] : 0);
            a = b;
            b = minVal;
        }
        return b;
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        int ans = minCostClimbingStairs(cost, n, dp);
        return ans;

    }

    // --------------------------------------------------------

    // PATH OF BOARD
    // Recursive
    public static ArrayList<String> pathOfLadder(int st, int dest, int jump) {
        if (st == dest) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int move = 1; move + st <= dest; move++) {
            ArrayList<String> smallAns = pathOfLadder(st + move, dest, jump);
            for (String s : smallAns) {
                ans.add(move + s);
            }
        }

        return ans;
    }

    // Memoization
    public static int boardPath_memo(int n, int[] DP) {
        if (n == 0) {
            return DP[n] = 1;
        }

        if (DP[n] != 0)
            return DP[n];

        int count = 0;
        for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
            count += boardPath_memo(n - dice, DP);
        }

        DP[n] = count;
        return count;
    }

    public static int boardPath_DP(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n == 0) {
                dp[n] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
                count += dp[n - dice];
            }

            dp[n] = count;
        }
        return dp[N];
    }

    public static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static int boardPath_opti(int n) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addLast(1);
        ll.addLast(1);
        for (int i = 2; i <= n; i++) {
            if (ll.size() <= 6)
                ll.addLast(ll.getLast() * 2);
            else
                ll.addLast(ll.getLast() * 2 - ll.removeFirst());
        }

        return ll.removeLast();
    }

    // My Code
    public static int boardPath_optimization(int N) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        int val = 1;
        int n = 1;
        for (n = 1; n < 7; n++) {
            ll.addLast(val);

            val = val * 2;
        }

        while (n <= N) {
            int rdata = ll.removeFirst();
            val = val - rdata;

            ll.addLast(val);
            val = val * 2;
            n++;
        }
        return ll.removeLast();
    }

    public static void boardPath() {
        int n = 10;
        int[] dp = new int[n + 1];

        // System.out.println(boardPath_DP(n, dp));
        System.out.println(boardPath_opti(n));
        // print(dp);
    }
    // --------------------------------------------------------

    // Maze Path
    // Memoization
    public static int mazePath_HDV_memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += mazePath_HDV_memo(r, c, er, ec, dir, dp);
            }

        }

        return dp[sr][sc] = count;
    }

    // Tabular/DP
    public static int mazePath_HDV_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                        count += dp[r][c]; // mazePath_HDV_DP(r, c, er, ec, dir, dp);
                    }

                }

                dp[sr][sc] = count;

            }
        }

        return dp[SR][SC];
    }

    // Maze Path with multiple jumps
    // Memoization
    public static int mazePath_MultiJumps_HDV_memo(int sr, int sc, int er, int ec, int[][] dir, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    count += mazePath_MultiJumps_HDV_memo(r, c, er, ec, dir, dp);
                } else {
                    break;
                }

            }

        }

        return dp[sr][sc] = count;
    }

    // Tabular/DP
    public static int mazePath_MultiJumps_HDV_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                        int r = sr + rad * dir[d][0];
                        int c = sc + rad * dir[d][1];

                        if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                            count += dp[r][c]; // mazePath_MultiJumps_HDV_DP(r, c, er, ec, dir, dp);
                        } else {
                            break;
                        }

                    }

                }

                dp[sr][sc] = count;

            }
        }

        return dp[SR][SC];
    }

    public static void mazePath() {
        int n = 7;
        int m = 5;

        int[][] dp = new int[n][m];
        int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };

        // System.out.println(mazePath_HDV(0, 0, n - 1, m - 1, dir, dp));
        // System.out.println(mazePath_HDV_DP(0, 0, n - 1, m - 1, dir, dp));
        // System.out.println(mazePath_MultiJumps_HDV_memo(0, 0, n - 1, m - 1, dir,
        // dp));
        System.out.println(mazePath_MultiJumps_HDV_DP(0, 0, n - 1, m - 1, dir, dp));

        print2D(dp);
    }

    // --------------------------------------------------------

    public static int friendsPairing_memo(int n, int[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int single = friendsPairing_memo(n - 1, dp);
        int pair = friendsPairing_memo(n - 2, dp) * (n - 1);

        return dp[n] = single + pair;
    }

    public static int friendsPairing_DP(int N, int[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            int single = dp[n - 1]; // friendsPairing_memo(n - 1, dp);
            int pair = dp[n - 2] * (n - 1); // friendsPairing_memo(n - 2, dp) * (n -1);

            dp[n] = single + pair;
        }
        return dp[N];
    }

    public static int friendsPairing_Optimized(int N) {
        int a = 1;
        int b = 1;
        System.out.print(a + " " + b + " ");

        for (int n = 2; n <= N; n++) {
            int val = (a * (n - 1)) + b;
            System.out.print(val + " ");
            a = b;
            b = val;
        }
        System.out.println();
        return b;
    }

    public static void friendsPairing() {
        int n = 15;
        int[] dp = new int[n + 1];

        // System.out.println(friendsPairing_memo(n, dp));
        // System.out.println(friendsPairing_DP(n, dp));
        System.out.println(friendsPairing_Optimized(n));
        // print(dp);
    }

    // --------------------------------------------------------

    public static int goldMine_memo(int[][] arr, int sr, int sc, int[][] dir, int[][] dp) {
        if (sc == arr[0].length - 1) {
            return dp[sr][sc] = arr[sr][sc];
        }

        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        int maxGold = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length) {

                maxGold = Math.max(maxGold, goldMine_memo(arr, r, c, dir, dp) + arr[r][c]);
            }
        }
        return dp[sr][sc] = maxGold;
    }

    public static int goldMine_dp(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };

        int[][] dp = new int[n][m];
        for (int c = arr[0].length - 1; c >= 0; c--) {
            for (int r = arr.length - 1; r >= 0; r--) {
                if (c == arr[0].length - 1) {
                    dp[r][c] = arr[r][c];
                    continue;
                }

                int maxGold = 0;
                for (int d = 0; d < dir.length; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length)
                        maxGold = Math.max(maxGold, dp[x][y] + arr[r][c]);
                }
                dp[r][c] = maxGold;
            }
        }

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        print2D(dp);
        return maxGold;

    }

    public static void goldMine(int[][] arr) {
        int maxGold = 0;
        int n = arr.length;
        int m = arr[0].length;

        int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
        int[][] dp = new int[n][m];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, goldMine_memo(arr, i, 0, dir, dp));
        }
        System.out.println(maxGold);
        print2D(dp);
    }

    // 0 1 4 2 8 2
    // 4 3 6 5 0 4
    // 1 2 4 1 4 6
    // 2 0 7 3 2 2
    // 3 1 5 9 2 4
    // 2 7 0 8 5 1
    public static void goldMine() {
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        goldMine(arr);
        // System.out.println(goldMine_dp(arr));
    }
    // --------------------------------------------------------

    // min Cost path.======================================
    public static int minCostPath(int[][] arr, int r, int c, int[][] dp, int[][] dir) {
        int n = arr.length, m = arr[0].length;
        if (r == n - 1 && c == m - 1) {
            return dp[r][c] = arr[r][c];
        }

        if (dp[r][c] != (int) 1e9)
            return dp[r][c];
        int minCost = (int) 1e9;
        for (int d = 0; d < dir.length; d++) {
            int x = r + dir[d][0];
            int y = c + dir[d][1];

            if (x >= 0 && y >= 0 && x < n && y < m)
                minCost = Math.min(minCost, minCostPath(arr, x, y, dp, dir) + arr[r][c]);
        }

        return dp[r][c] = minCost;
    }

    public static int minCostPath_dp(int[][] arr, int R, int C, int[][] dp, int[][] dir) {

        int n = arr.length, m = arr[0].length;
        for (int r = n - 1; r >= 0; r--) {
            for (int c = m - 1; c >= 0; c--) {

                if (r == n - 1 && c == m - 1) {
                    dp[r][c] = arr[r][c];
                    continue;
                }

                int minCost = (int) 1e9;
                for (int d = 0; d < dir.length; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];

                    if (x >= 0 && y >= 0 && x < n && y < m)
                        minCost = Math.min(minCost, dp[x][y] + arr[r][c]);
                }

                dp[r][c] = minCost;
            }
        }

        return dp[R][C];
    }

    public static void minCost() {
        int[][] arr = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };

        int n = arr.length, m = arr[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

        int[][] dp = new int[n][m];
        int[][] DP = new int[n][m];

        for (int[] d : dp)
            Arrays.fill(d, (int) 1e9);

        for (int[] d : DP)
            Arrays.fill(d, (int) 1e9);

        System.out.println(minCostPath(arr, 0, 0, dp, dir));

        System.out.println("---------------------------");
        print2D(arr);
        System.out.println("---------------------------");
        print2D(dp);
        System.out.println("---------------------------");
        System.out.println(minCostPath_dp(arr, 0, 0, DP, dir));

        print2D(DP);
    }

    // --------------------------------------------------------

    // Longest Palindromic SUBSEQUENCE
    // using Recursion
    public static int longestPalindromicSubSequence(String str, int i, int j) {
        if (i == j) {
            return 1;
        }

        if (i > j) {
            return 0;
        }

        int stringLen = 0;
        if (str.charAt(i) == str.charAt(j)) {
            stringLen = ma(str, i + 1, j - 1) + 2;
        } else {
            stringLen = Math.max(longestPalindromicSubSequence(str, i + 1, j),
            longestPalindromicSubSequence(str, i, j - 1));
        }

        return stringLen;
    }

    // Memoization
    public static int longestPalindromicSubSequence_memo(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return dp[i][j] = (i == j ? 1 : 0);
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (str.charAt(i) == str.charAt(j)) {
            dp[i][j] = longestPalindromicSubSequence_memo(str, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(longestPalindromicSubSequence_memo(str, i + 1, j, dp), longestPalindromicSubSequence_memo(str, i, j - 1, dp));
        }

        return dp[i][j];
    }

    // DP / Tabular
    public static int LPSS_DP(String str, int I, int J, int[][] dp){
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++){
                if(i >= j){
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if(str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else 
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[I][J];
    }

    // String of Longest Palindromic Subsequence 
    public static String LPSS_StringDP(String str) {
        int n = str.length();
        String[][] dp = new String[n][n];
        for (String[] d : dp)
            Arrays.fill(d, "");

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? str.charAt(i) + "" : "";
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = str.charAt(i) + dp[i + 1][j - 1] + str.charAt(j);
                else
                    dp[i][j] = dp[i + 1][j].length() > dp[i][j - 1].length() ? dp[i + 1][j] : dp[i][j - 1];
            }
        }
        print2DString(dp);
        return dp[0][n - 1];
    }

    public static void longestPalindromicSubSequence() {

        String str = "ekfek";
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        // System.out.println( longestPalindromicSubString(str, 0, str.length() - 1));
        // System.out.println(longestPalindromicSubSequence_memo(str, 0, str.length() - 1, dp));
        LPSS_StringDP(str);
        // print2D(dp);
    }

    // --------------------------------------------------------


    // Longest Palindromic SUBSTRING
    // DO IT ONLY USING DP/TABULAR 

    // DP of Boolean => true/false
    public static void longestPalindromicSubString_booleanDP(String str, boolean[][] dp){
        int n = str.length();
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){

                if(gap == 0) 
                    dp[i][j] = true;
                else if(gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                else 
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];
            }
        }

        // print DP
    }


    // Count no. of palindrome present in the String 
    // Longest palindromic String Length
    public static int longestPalindromicSubString_LengthCount(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        int maxLen = 0;
        int count = 0;

        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){

                if(gap == 0) 
                    dp[i][j] = 1;
                else if(gap == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 0;
                else if(str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;

                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                }
                
                if(dp[i][j] != 0)
                    count++;
            }
        }

        return maxLen;
    }

    // Longest palindromic String using making string DP 
    public String longestPalindromeSubString(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int maxLen = 0;
        int sp = 0, ep = 0;
        
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++, j++){
                if(gap == 0){
                    dp[i][j] = 1;
                } else if(gap == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 0;
                } else if(str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    sp = i;
                    ep = j;
                }

            }
        }
        return str.substring(sp, ep + 1);
    }
    // --------------------------------------------------------

    // Longest Common Subsequence
    // Recursion 
    // LCSS => Longest Common Subsequence
    public static int LCSS_recursion(String str1, String str2, int i, int j){
        if(i == -1 || j == -1)
            return 0;

        if(str1.charAt(i) == str2.charAt(j))
            return LCSS_recursion(str1, str2, i - 1 , j - 1) + 1;
        else 
            return Math.max(LCSS_recursion(str1, str2, i - 1, j), LCSS_recursion(str1, str2, i, j - 1));
    } 

    // Memoization 
    public static int LCSS_memo(String str1, String str2, int n, int m, int[][] dp){
        if(n == 0 || m == 0)
            return dp[n][m] = 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];

        
        if(str1.charAt(n - 1) == str2.charAt(m - 1))
            return dp[n][m] = LCSS_memo(str1, str2, n - 1 , m - 1, dp) + 1;
        else 
            return dp[n][m] = Math.max(LCSS_memo(str1, str2, n - 1, m, dp), LCSS_memo(str1, str2, n, m - 1, dp));

    }

    // DP / TABULAR 
    public static int LCSS_DP(String str1, String str2, int N, int M, int[][] dp){

        for (int n = 0; n <= N; n++) {
            for(int m = 0; m <= M; m++){
                if(n == 0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }
                
                if(str1.charAt(n - 1) == str2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1; // LCSS_memo(str1, str2, n - 1 , m - 1, dp) + 1;
                else 
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);

            }
        }

        return dp[N][M];
    }

    public static void longestCommonSubSequence(){
        String str1 = "abcde";
        String str2 = "ace";

        int n = str1.length(), m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);


        // System.out.println(LCSS_recursion(str1, str2, str1.length() - 1, str2.length() - 1));
        // System.out.println(LCSS_memo(str1, str2, n, m, dp));
        System.out.println(LCSS_DP(str1, str2, n, m, dp));
        print2D(dp);
    }

    // --------------------------------------------------------

    public static void main(String[] args) {
        // fibo();
        // boardPath();
        // mazePath();
        // friendsPairing();
        // goldMine();
        // minCost();
        // longestPalindromicSubSequence();
        longestCommonSubSequence();
    }
}
