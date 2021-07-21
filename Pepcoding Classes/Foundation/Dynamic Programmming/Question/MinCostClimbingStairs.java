public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int n, int[] cost, int[] dp){
        if(n <= 1){
            return dp[n] = cost[n];
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int ans = Math.min(minCostClimbingStairs(n - 1, cost, dp) , minCostClimbingStairs(n - 2, cost, dp));
        
        if(n < cost.length)
            ans += cost[n];
        return dp[n] = ans;
    }
    
    public int minCostClimbingStairs(int N, int[] cost, int[] dp){
        for(int n = 0; n < N; n++){
            if(n <= 1){
                dp[n] = cost[n];
                continue;
            }
            
            dp[n] = cost[n] + Math.min(dp[n - 1] , dp[n - 2]);
        }
        return Math.min(dp[N - 1] , dp[N - 2]);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        return minCostClimbingStairs(n, cost, dp);
    }
}
