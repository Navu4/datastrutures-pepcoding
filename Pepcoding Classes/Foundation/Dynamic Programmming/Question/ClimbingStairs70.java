public class ClimbingStairs70 {
    public int climbStairs(int n, int[] dp) {
        if(n <= 1)
           return dp[n] = 1;
        if(dp[n] != 0)
            return dp[n];
        
        int steps = climbStairs(n - 1, dp) + climbStairs(n -2, dp);
        dp[n] = steps;
        
        return dp[n];
    }
    
    public int climbStairs(int N, int[] dp) {
        for(int n = 0; n <= N; n++){
            if(n <= 1){
                dp[n] = 1;
                continue;
            }
            
            int steps = dp[n - 1] + dp[n - 2];
            dp[n] = steps;
        }        

        return dp[N];
    }
    
    public int climbStairs_opti(int n){
        int a = 1, b = 1;
        for(int i = 0; i < n; i++){
            int sum = a + b;
            a = b;
            b = sum;
        }
        
        return a;
    }
    
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        // int ans = climbStairs(n, dp);
        
        
        // return ans;
        return climbStairs_opti(n);
    }
}
