// Question : https://leetcode.com/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        reverseMatrix(matrix);
        transposeMatrix(matrix);
    }
    public void reverseMatrix(int matrix[][]){
        int row=matrix.length,col=matrix[0].length;
        int i=0,j=row-1;
        while(i<j){
            for(int k=0;k<col;k++){
                int t=matrix[i][k];
                matrix[i][k]=matrix[j][k];
                matrix[j][k]=t;
            }
            i++;j--;
        }
    }
    public void transposeMatrix(int matrix[][]){
        int row=matrix.length,col=matrix[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=i;j<col;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }
}