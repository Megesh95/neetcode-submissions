class Solution {
    static int f(int i,int j,String s1,String s2,int [][] dp){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(dp[i][j]!=-1)return dp[i][j];
        int p=0;
        if(s1.charAt(i)==s2.charAt(j)){
             dp[i][j]=f(i-1,j-1,s1,s2,dp);
        }
        else{
        int insert=f(i-1,j,s1,s2,dp);
        int delete=f(i,j-1,s1,s2,dp);
        int replace=f(i-1,j-1,s1,s2,dp);
        dp[i][j]=1+Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int []k:dp){
            Arrays.fill(k,-1);
        }
        int lcs=f(word1.length()-1,word2.length()-1,word1,word2,dp);
        return lcs;
    }
}
