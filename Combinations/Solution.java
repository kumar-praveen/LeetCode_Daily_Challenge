
// Question : https://leetcode.com/problems/combinations/

import java.util.*;

class Solution {
    List<List<Integer>> ans;
    public void helper(int n,int k,ArrayList<Integer> temp){
        if(k==0){
            ans.add(temp);
            return;
        }
        if(n==0){
            return;
        }
        helper(n-1,k,temp);
        ArrayList<Integer> newTemp = new ArrayList<Integer>(temp);
        newTemp.add(n);
        helper(n-1,k-1,newTemp);
    }
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<List<Integer>>();
        helper(n,k,new ArrayList<Integer>());
        return ans;
    }
}