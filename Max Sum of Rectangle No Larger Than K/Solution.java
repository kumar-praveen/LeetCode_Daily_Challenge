// Question : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/

import java.util.*;;

class Solution {
    private int findMaxLessThanK(int arr[],int n,int k){
        int ans=Integer.MIN_VALUE,csum=0;
        
        TreeSet<Integer> sumValues = new TreeSet<Integer>();
        sumValues.add(0);
        
        for(int i=0;i<n;i++){
            csum+=arr[i];
            if(sumValues.ceiling(csum-k)!=null){
                int req = sumValues.ceiling(csum-k);
                if(sumValues.contains(req)){
                    ans=Math.max(ans,csum-req);
                }
            }
            sumValues.add(csum);
        }
        return ans;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row=matrix.length,col=matrix[0].length;
        
        for(int j=0;j<col;j++){
            for(int i=1;i<row;i++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
        
        int ans=Integer.MIN_VALUE;
        for(int r1=0;r1<row;r1++){
            for(int r2=r1;r2<row;r2++){
                int arr[]=new int[col];
                for(int c=0;c<col;c++){
                    arr[c]=matrix[r2][c];
                    if(r1>0) arr[c]-=matrix[r1-1][c];
                }
                int temp = findMaxLessThanK(arr,col,k);
                ans=Math.max(ans,temp);
            }
        }
        
        return ans;
    }
}