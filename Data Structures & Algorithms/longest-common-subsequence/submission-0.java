class Solution {
    static int f(int i,int j,String s1,String s2,int[][] dp){
       // if(i==0&&j==0)return 1;
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int p=0;
        if(s1.charAt(i)==s2.charAt(j)){
            p=1+f(i-1,j-1,s1,s2,dp);
        }
        int np=Math.max(f(i-1,j,s1,s2,dp),f(i,j-1,s1,s2,dp));
        dp[i][j]=Math.max(p,np);
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] k:dp){
            Arrays.fill(k,-1);
        }
        return f(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}
