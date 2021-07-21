public class l002RecursionTrees {

    // Problem Statement : Target Sum problem
    // Permutation and Combination

    // Question 1. Permutation with Infinite Coins
    public static int permutationWithInfi(int[] arr, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int ele : arr) {
            if (tar - ele >= 0) {
                count += permutationWithInfi(arr, tar - ele, ans + ele);
            }
        }
        return count;
    }

    // Question 2. Combination with Infinite Coins
    public static int combinationWithInfi(int[] arr, int tar, int idx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combinationWithInfi(arr, tar - arr[i], i, ans + arr[i]);
            }
        }
        return count;
    }

    // Question 3. Combination with Single Coins
    public static int combinationWithSingleCoins(int[] arr, int tar, int idx, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                count += combinationWithSingleCoins(arr, tar - arr[i], i + 1, ans + arr[i] + " ");
            }
        }
        return count;
    }

    // Question 4. Permutation with Single Coins
    public static int permutationWithSingleCoin(int[] arr, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && tar - arr[i] >= 0) {
                int val = arr[i];

                arr[i] = -arr[i];
                count += permutationWithSingleCoin(arr, tar - val, ans + val);
                arr[i] = -arr[i];
            }
        }

        return count;
    }

    // Using Visited
    public static int permutationWithSingleCoins(int[] arr, int tar, String ans, boolean[] vis) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i] && tar - arr[i] >= 0) {
                vis[i] = true;
                count += permutationWithSingleCoins(arr, tar - arr[i], ans + arr[i] + " ", vis);
                vis[i] = false;
            }
        }
        return count;
    }

    // ===================================================================================

    // Solving Using Subsequence Method
    // Combination with Single Coin
    // Using SubSequence
    public static int combinationWithSingle_SubSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0)
            count += combinationWithSingle_SubSeq(arr, tar - arr[idx], idx + 1, ans + arr[idx]);
        count += combinationWithSingle_SubSeq(arr, tar, idx + 1, ans);
        return count;
    }

    // Combination with Infinite Coin
    // Using SubSequence
    public static int combinationWithInfi_SubSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0)
            count += combinationWithInfi_SubSeq(arr, tar - arr[idx], idx, ans + arr[idx]);
        count += combinationWithInfi_SubSeq(arr, tar, idx + 1, ans);
        return count;
    }

    // Permutation with Infinite Coin
    // Using SubSequence
    public static int permutationWithInfi_SubSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (arr[idx] > 0 && tar - arr[idx] >= 0) {
            count += permutationWithInfi_SubSeq(arr, tar - arr[idx], 0, ans + arr[idx]);
        }
        count += permutationWithInfi_SubSeq(arr, tar, idx + 1, ans);
        return count;
    }

    // Permutation with Single Coin
    // Using SubSequence
    public static int permutationWithSingle_SubSeq(int[] arr, int tar, int idx, String ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                System.out.println(ans);
                return 1;
            }

            return 0;
        }
        int count = 0;
        if (arr[idx] > 0 && tar - arr[idx] >= 0) {
            int val = arr[idx];

            arr[idx] = -arr[idx];
            count += permutationWithSingle_SubSeq(arr, tar - val, 0, ans + val);
            arr[idx] = -arr[idx];
        }
        count += permutationWithSingle_SubSeq(arr, tar, idx + 1, ans);
        return count;
    }

    public static void permutationAndCombination() {
        int[] arr = { 2, 3, 5, 7 };
        int n = arr.length;
        int tar = 10;

        boolean[] vis = new boolean[n];

        // System.out.println(permutationWithInfi(arr, tar, ""));
        // System.out.println(combinationWithInfi(arr, tar, 0, ""));
        // System.out.println(combinationWithSingleCoins(arr, tar, 0, ""));
        // System.out.println(permutationWithSingleCoins(arr, tar, "", vis));

        // Subsequence
        // System.out.println(combinationWithSingle_SubSeq(arr, tar, 0, ""));
        // System.out.println(combinationWithInfi_SubSeq(arr, tar, 0, ""));
        // System.out.println(permutationWithInfi_SubSeq(arr, tar, 0, ""));
        // System.out.println(permutationWithSingle_SubSeq(arr, tar, 0, ""));
    }
    // =====================================================

    // 1D_Queen_Set==================================================================

    // 1D Queen Problem

    // Combination q0 > q1 > q2 > q3
    public static int queenCombination_01(int[] arr, int tar, int idx, String ans) {

        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++) {
            count += queenCombination_01(arr, tar - arr[i], i + 1, ans + "q" + i + " ");
        }
        return count;
    }

    // tboxes = total boxes, tqn = total queens, qpsf = Queen placed so far, bn =
    // box_no.
    public static int queenCombination_02(int tboxes, int tqn, int qpsf, int bn, String ans) {

        if (qpsf == tqn) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = bn; i < tboxes; i++) {
            count += queenCombination_02(tboxes, tqn, qpsf + 1, i + 1, ans + "b" + i + "q" + qpsf + " ");
        }
        return count;
    }

    // Permutation
    public static int queenPermutation(boolean[] tboxes, int tqn, int qpsf, int bn, String ans) {

        if (qpsf == tqn) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = bn; i < tboxes.length; i++) {
            if (!tboxes[i]) {
                tboxes[i] = true;
                count += queenPermutation(tboxes, tqn, qpsf + 1, 0, ans + "b" + i + "q" + qpsf + " ");
                tboxes[i] = false;
            }
        }
        return count;
    }

    public static void queen1D() {
        // int[] arr = {1, 1, 1, 1, 1, 1};
        // System.out.println(queen
        
        Combination(arr, 4, 0, ""));
        // System.out.println(queenCombination_02(6, 4, 0, 0, ""));

        boolean[] tboxes = new boolean[6];
        System.out.println(queenPermutation(tboxes, 4, 0, 0, ""));
    }

    // =====================================================================================

    // 2D Queen
    // =====================================================================================

    // Combination
    public static int queen2DCombination(boolean[][] tboxes, int tqn, int bn, String ans) {
        if (tqn == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tboxes.length, m = tboxes[0].length;
        for (int i = bn; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            count += queen2DCombination(tboxes, tqn - 1, i + 1, ans + "(" + r + ", " + c + ")");
        }
        return count;
    }

    public static int queen2DPermutation(boolean[][] tboxes, int tqn, int bn, String ans) {
        if (tqn == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tboxes.length, m = tboxes[0].length;
        for (int i = bn; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (!tboxes[r][c]) {
                tboxes[r][c] = true;
                count += queen2DPermutation(tboxes, tqn - 1, 0, ans + "(" + r + ", " + c + ")");
                tboxes[r][c] = false;
            }

        }
        return count;
    }

    public static void queen2D() {

        boolean[][] tboxes = new boolean[4][4];
        // System.out.println(queen2DCombination(tboxes, 4, 0, ""));
        System.out.println(queen2DPermutation(tboxes, 4, 0, ""));
    }
    // =====================================================================================




    // N Queen Problem


    // Complexity => ((n + m)(m * n))^q
    // q == no of queens , Tree height will depend omn no. of Queens 
    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
        int[][] dir = { {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };  // Combination
        // int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };// Permutation

        int n = boxes.length, m = boxes[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad < n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (boxes[x][y])
                        return false;
                } else {
                    break;
                }
            }
        }

        return true;
    }
    // Combination using boolean MATRIX of N * M 
    public static int NqueenProblem_Combination01(boolean[][] boxes, int tqn, int bn, String ans) {
        if (tqn == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = boxes.length, m = boxes[0].length;
        for (int i = bn; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += NqueenProblem_Combination01(boxes, tqn - 1, i + 1, ans + "(" + r + ", " + c + ")");
                boxes[r][c] = false;
            }
        }
        return count;
    }

        // Permutation using boolean MATRIX of N * M 
    public static int NqueenProblem_Permutation01(boolean[][] boxes, int tqn, int idx, String ans) {
        if (tqn == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = boxes.length, m = boxes[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (!boxes[r][c] && isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += NqueenProblem_Permutation01(boxes, tqn - 1, 0, ans + "(" + r + ", " + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }


    // Using Subsequence Method 
    public static int NqueenProblem_Combination02(boolean[][] boxes, int tqn, int idx, String ans) {
        int n = boxes.length, m = boxes[0].length;
        if (tqn == 0 || idx >= n * m) {  // Total matrix size n * m 
            if (tqn == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        int r = idx / m;
        int c = idx % m;
        if (!boxes[r][c] && isSafeToPlaceQueen(boxes, r, c)) {
            boxes[r][c] = true;
            count += NqueenProblem_Combination02(boxes, tqn - 1, idx + 1, ans + "(" + r + ", " + c + ") ");
            boxes[r][c] = false;
        }
        count += NqueenProblem_Combination02(boxes, tqn, idx + 1, ans);  // Not selected Call 

        return count;
    }


    // Using boolean arrays to Check rows cols and diagonals If queen present or Not 
    // Optimized Helper Function 
    
    // Complexity => ((m * n))^q
    // q == no of queens , Tree height will depend omn no. of Queens
    static boolean[] rows;
    static boolean[] cols;
    static boolean[] diag;
    static boolean[] adiag;


    // Combination 
    public static int NqueenProblem_Combination03(int n, int m, int tqn, int idx, String ans){
        if(tqn == 0 || idx >= n * m){
            if(tqn == 0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count = 0;
        for(int i = idx; i < n * m; i++){
            int r = i / m;
            int c = i % m;

            if(!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += NqueenProblem_Combination03(n, m, tqn - 1, i + 1, ans + "(" + r + ", " + c + ") ");
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }

    public static int NqueenProblem_Permutation03(int n, int m, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += NqueenProblem_Permutation03(n, m, tnq - 1, 0, ans + "(" + r + ", " + c + ") ");
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    public static void NQueen() {
        boolean[][] boxes = new boolean[4][4];

        // System.out.println(NqueenProblem_Combination01(boxes, 4, 0, ""));
        // System.out.println(NqueenProblem_Permutation01(boxes, 4, 0, ""));
        // System.out.println(NqueenProblem_Combination02(boxes, 4, 0, ""));

        int n = 4, m = 4, q = 4;
        rows = new boolean[n];
        cols = new boolean[m];
        diag = new boolean[n + m - 1];
        adiag = new boolean[n + m - 1];

        // System.out.println(NqueenProblem_Combination03(n, m, q, 0, ""));
        System.out.println(NqueenProblem_Permutation03(n, m, q, 0, ""));
    }
    // ==================================================================================

    // N Queen More Optimized Code
    // Each row of Matrix is considered as a FLOOR -> Only one queen can stay on each floor
    // Each col of MAtrix is considered as a ROOM -> combination is used here for room on each floor
    
    // Complexity => (n)^q
    // q == no of queens , Tree height will depend omn no. of Queens
    
    // Combination
    public static int nQueen_Combination04(int floor, int tnq, int m, String ans){
        if(tnq == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        for(int room = 0; room < m; room++){
            int r = floor, c = room;
            if (!cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_Combination04(floor + 1, tnq - 1, m, ans + "(" + r + ", " + c + ") ");
                cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }
    
    // Permutation
    public static int nQueen_Permutation04(int floor, int n, int tnq, int m, String ans){
        if (tnq == 0 || floor >= m) {
            if (tnq == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        
        int count = 0;
        for(int room = 0; room < m; room++){
            int r = floor, c = room;
            if (!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                rows[r]  = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_Permutation04(0 , n, tnq - 1, m, ans + "(" + r + ", " + c + ") ");
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }

    public static void nQueen_finalOptimized() {
        int n = 4, m = 4, q = 4;
        rows = new boolean[n];
        cols = new boolean[m];
        diag = new boolean[n + m - 1];
        adiag = new boolean[n + m - 1];

        System.out.println(nQueen_Combination04(0, q, m, ""));
    }
    

    // =====================================================================================

    public static void main(String[] args) {
        // permutationAndCombination();
        // queen1D();
        // queen2D();
        // NQueen();
        nQueen_finalOptimized();
    }
}
