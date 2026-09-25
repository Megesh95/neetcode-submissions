class Solution {
    static int f(int idx,int target,int[] coins,int[][] dp){
        if(idx<0||target<0)return 0;
        if(target==0)return 1;
        if(dp[idx][target]!=-1)return dp[idx][target];
        int p=f(idx,target-coins[idx],coins,dp);
        int np=f(idx-1,target,coins,dp);
        dp[idx][target]=p+np;
        return dp[idx][target];
        
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        for(int[] k:dp){
            Arrays.fill(k,-1);
        }
        return f(coins.length-1,amount,coins,dp);
    }
}
