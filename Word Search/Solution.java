class Solution {
    public boolean findWord(char matrix[][],int i,int j,int idx,String word){
        if(idx==word.length()) return true;
        if(i<0 || j<0 || i==matrix.length || j==matrix[0].length) return false;
        if(matrix[i][j]!=word.charAt(idx) || matrix[i][j]=='$') return false;
        char ch = matrix[i][j];
        matrix[i][j]='$';
        
        boolean found = false;
        if(findWord(matrix,i+1,j,idx+1,word) || findWord(matrix,i,j+1,idx+1,word) 
           || findWord(matrix,i-1,j,idx+1,word) || findWord(matrix,i,j-1,idx+1,word)){
            found=true;
        }
        
        matrix[i][j]=ch;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int row=board.length,col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(word.charAt(0)==board[i][j]){
                    if(findWord(board,i,j,0,word)) return true;
                }
            }
        }
        return false;
    }
}