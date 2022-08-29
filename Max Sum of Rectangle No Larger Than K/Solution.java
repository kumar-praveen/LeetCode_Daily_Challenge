// Question : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/


class Solution {
    public void preprocessMatrix(int [][] mat){
        int row=mat.length,col=mat[0].length;
        for(int j=1;j<col;j++){
            mat[0][j]+=mat[0][j-1];
        }
        for(int i=1;i<row;i++){
            mat[i][0]+=mat[i-1][0];
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                mat[i][j]+=mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
            }
        }
        return;
    }
    
    public int maxSumSubmatrix(int[][] mat, int mini) {
        int row=mat.length,col=mat[0].length;
        preprocessMatrix(mat);
        
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<col;k++){
                    int sum=mat[i][k];
                    if(j>1) sum-=mat[i][j-1];
                    if(sum<=mini){
                        ans=Math.max(ans,sum);
                    }
                }
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int row=5,col=8;
        int mat[][]=new int[row][col];
        System.out.print("[");
        for(int i=0;i<row;i++){
            System.out.print("[");
            for(int j=0;j<col;j++){
                int val=Math.toIntExact(Math.round(Math.random()*50));
                mat[i][j]=val;
                if(j!=col-1)
                    System.out.print(val+",");
                else
                    System.out.print(val);
            }
            if(i==row-1)
                System.out.print("]");
            else
                System.out.print("],");
        }
        System.out.println("]");

        System.out.println("Answer is "+solution.maxSumSubmatrix(mat, 8));
    }
}