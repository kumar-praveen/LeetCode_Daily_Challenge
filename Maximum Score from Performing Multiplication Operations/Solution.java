
// Question : https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

import java.util.*;;

class Solution {
    int dp[][];
    private int getMaxScore(int i,int n,int idx,int m,int nums[],int arr[]){
        if(idx==m){
            return 0;
        }
        if(dp[idx][i]!=-Integer.MIN_VALUE) return dp[idx][i];
        int v1 = getMaxScore(i+1,n,idx+1,m,nums,arr)+nums[i]*arr[idx];
        int v2 = getMaxScore(i,n,idx+1,m,nums,arr)+nums[n+i-1-idx]*arr[idx];
        
        
        return dp[idx][i]=Math.max(v1,v2);
    }
    public int maximumScore(int[] nums, int[] arr) {
        int n=nums.length,m=arr.length;
        dp = new int[m+1][m+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        return getMaxScore(0,n,0,m,nums,arr);
    }
}