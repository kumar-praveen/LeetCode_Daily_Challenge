// Question : https://leetcode.com/problems/pacific-atlantic-water-flow/

import java.util.*;

class Solution {
    int dx[]={1,0,-1,0};
    int dy[]={0,1,0,-1};
    public void exploreWaterFlow(int i,int j,int row,int col,int mat[][],int height[][]){
        if(mat[i][j]!=0){
            return;
        }
        mat[i][j]=2;
        for(int d=0;d<4;d++){
            int newi=i+dx[d];
            int newj=j+dy[d];
            if(newi>=0 && newj>=0 && newi<row && newj<col && height[newi][newj]>=height[i][j]){
                exploreWaterFlow(newi,newj,row,col,mat,height);
            }
        }
        mat[i][j]=1;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length,col=heights[0].length;
        
        int pacific[][]=new int[row][col];
        int atlantic[][]=new int[row][col];
        
        for(int i=0;i<row;i++){
            exploreWaterFlow(i,0,row,col,pacific,heights);
            exploreWaterFlow(i,col-1,row,col,atlantic,heights);
        }
        for(int j=0;j<col;j++){
            exploreWaterFlow(0,j,row,col,pacific,heights);
            exploreWaterFlow(row-1,j,row,col,atlantic,heights);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);temp.add(j);
                    ans.add(temp);
                }
            }
        }
        
        return ans;
    }
}