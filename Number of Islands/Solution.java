// Question : https://leetcode.com/problems/number-of-islands/submissions/



class Solution {
    private void exploreIsland(int i,int j,int row,int col,char grid[][]){
        if(i<0 || j<0 || i==row || j==col || grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        exploreIsland(i+1,j,row,col,grid);
        exploreIsland(i,j+1,row,col,grid);
        exploreIsland(i-1,j,row,col,grid);
        exploreIsland(i,j-1,row,col,grid);
    }
    public int numIslands(char[][] grid) {
        int row=grid.length,col=grid[0].length,cnt=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    exploreIsland(i,j,row,col,grid);
                }
            }
        }
        return cnt;
    }
}