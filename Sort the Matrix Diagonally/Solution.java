// Question : https://leetcode.com/problems/sort-the-matrix-diagonally/submissions/


import java.util.*;

class Solution {
    
    public int[][] diagonalSort(int[][] mat) {
        int row=mat.length,col=mat[0].length;
        for(int c=0;c<col;c++){
            int i=0,j=c,idx=0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(i<row && j<col){
                arr.add(mat[i][j]);
                i++;j++;
            }
            i=0;j=c;
            Collections.sort(arr);
            while(i<row && j<col){
                mat[i][j]=arr.get(idx);
                i++;j++;idx++;
            }
        }
        
        for(int r=1;r<row;r++){
            int i=r,j=0,idx=0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(i<row && j<col){
                arr.add(mat[i][j]);
                i++;j++;
            }
            i=r;j=0;
            Collections.sort(arr);
            while(i<row && j<col){
                mat[i][j]=arr.get(idx);
                i++;j++;idx++;
            }
        }
        return mat;
    }
}