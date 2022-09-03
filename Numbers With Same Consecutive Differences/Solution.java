// Question : https://leetcode.com/problems/numbers-with-same-consecutive-differences/


import java.util.*;

class Solution {
    HashSet<Integer> ans ;
    private void helper(int pos,int tpos,int cnum,int ldigit,int diff){
        if(pos==tpos){
            ans.add(cnum);
            return;
        }
        if(ldigit+diff<10){
            helper(pos+1,tpos,cnum*10+ldigit+diff,ldigit+diff,diff);
        }
        if(ldigit-diff>=0){
            helper(pos+1,tpos,cnum*10+ldigit-diff,ldigit-diff,diff);
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        ans=new HashSet<Integer>();
        for(int i=1;i<=9;i++){
            helper(1,n,i,i,k);
        }
        int i=0;
        int arr[]=new int[ans.size()];
        for(int val:ans){
            arr[i++]=val;
        }
        return arr;
    }
}