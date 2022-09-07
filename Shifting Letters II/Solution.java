
// Question : https://leetcode.com/problems/shifting-letters-ii/


class Solution {
    public char getShiftedCharacter(char ch,int pos){
        pos%=26;
        int num=(int)ch+pos;
        //122 is acii code of 'z'
        //97 is ascii code 'a'
        if(pos>=0){
            if(num<=122){
                return (char)num;
            }
            return (char)(num-122+96);
        }else{
            if(num>=97){
                return (char)num;
            }
            return (char)(122-96+num);
        }
        
    }
    public String shiftingLetters(String str, int[][] shifts) {
        int n=str.length(),m=shifts.length;
        int pos[]=new int[n+1];
        for(int i=0;i<m;i++){
            int lb=shifts[i][0];
            int ub=shifts[i][1];
            int d=shifts[i][2];
            
            if(d==1){
                pos[lb]+=1;
                pos[ub+1]-=1;
            }else{
                pos[lb]-=1;
                pos[ub+1]+=1;
            }
        }
        
        for(int i=1;i<=n;i++){
            pos[i]+=pos[i-1];
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++){
            builder.append(getShiftedCharacter(str.charAt(i),pos[i]));
        }
        return builder.toString();
    }
}